package com.pshashank.facilitiesmanagement.Controllers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.pshashank.facilitiesmanagement.POJO.Reservation;

public class ReservationsDatabaseController extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "FacilityManagement.db";
    public static final String TABLE_RESERVATIONS = "reservations";
    public static final String COLUMN_DATE = "reservation_date";
    public static final String COLUMN_TIME = "reservation_time";
    public static final String COLUMN_VENUE = "venue_name";
    public static final String COLUMN_VTYPE = "venue_type";
    public static final String COLUMN_UTAID = "user_id";


    private static final int DATABASE_VERSION = 2;

    private static final String DATABASE_CREATE = "CREATE TABLE IF NOT EXISTS "
            + TABLE_RESERVATIONS + " ( " +
            COLUMN_DATE+ " TEXT ,"+
            COLUMN_TIME+ " TEXT ,"+
            COLUMN_VENUE+ " TEXT ,"+
            COLUMN_VTYPE+ " TEXT ,"+
            COLUMN_UTAID+ " TEXT )";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RESERVATIONS);
        onCreate(db);
    }

    public ReservationsDatabaseController(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public boolean insertReservation(Reservation reservation) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_DATE, reservation.getStartDate());
        contentValues.put(COLUMN_TIME, reservation.getStartTime());
        contentValues.put(COLUMN_VTYPE, reservation.getFacilityType());
        contentValues.put(COLUMN_VENUE, reservation.getFacilityVenue());
        db.insert(TABLE_RESERVATIONS, null, contentValues);
        return true;
    }

    public Cursor getReservation(String utaid){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from '"+TABLE_RESERVATIONS+"' where '"+COLUMN_UTAID+"' = '"+utaid+"'", null );
        return res;
    }

    public Integer deleteReservation (String utaid,String venue, String startdate, String starttime) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_RESERVATIONS , COLUMN_UTAID+" = ? and "+COLUMN_VENUE+"= ? and "+COLUMN_DATE+" = ? and "+COLUMN_TIME+" = ?", new String[] {utaid, venue, startdate, starttime});
    }
}
