package com.pshashank.facilitiesmanagement.Controllers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FacilitiesDatabaseController extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "FacilityManagement.db";
    public static final String TABLE_FACILITIES = "facilities";
    public static final String COLUMN_FACILITY_NAME = "facilitiy_name";
    public static final String COLUMN_FACILITY_TYPE = "facilitiy_type";
    public static final String COLUMN_AVAILABILITY = "facilitiy_availability";
    public static final String COLUMN_DEPOSIT = "deposit";
    public static final String COLUMN_FLOOR = "floor";
    public static final String COLUMN_WING = "wing";
    public static final String COLUMN_STATUS = "status";

    private static final int DATABASE_VERSION = 2;

    private static final String DATABASE_CREATE = "CREATE TABLE IF NOT EXISTS "
            + TABLE_FACILITIES + " ( " +
            COLUMN_FACILITY_NAME+ " TEXT ,"+
            COLUMN_FACILITY_TYPE+ " TEXT ,"+
            COLUMN_AVAILABILITY+ " TEXT ,"+
            COLUMN_DEPOSIT+ " TEXT ,"+
            COLUMN_FLOOR+ " TEXT ,"+
            COLUMN_WING+ " TEXT ,"+
            COLUMN_STATUS+ " TEXT )";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FACILITIES);
        onCreate(db);
    }

    public FacilitiesDatabaseController(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
