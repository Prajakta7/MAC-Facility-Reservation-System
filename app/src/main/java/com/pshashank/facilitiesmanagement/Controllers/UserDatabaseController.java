package com.pshashank.facilitiesmanagement.Controllers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.pshashank.facilitiesmanagement.POJO.User;

public class UserDatabaseController extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "FacilityManagement.db";
    public static final String TABLE_USER = "users";
    public static final String COLUMN_TYPE = "user_type";
    public static final String COLUMN_UNAME = "user_uname";
    public static final String COLUMN_PASS = "user_pass";
    public static final String COLUMN_UTAID = "user_id";
    public static final String COLUMN_FNAME = "first_name";
    public static final String COLUMN_LNAME = "last_name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_ADDRESS = "street_address";
    public static final String COLUMN_CITY = "city";
    public static final String COLUMN_STATE = "state";
    public static final String COLUMN_ZIP = "zip_code";


    private static final int DATABASE_VERSION = 2;

    private static final String DATABASE_CREATE = "CREATE TABLE IF NOT EXISTS "
            + TABLE_USER + " ( " +
            COLUMN_TYPE+ " TEXT ,"+
            COLUMN_UTAID+ " TEXT ,"+
            COLUMN_UNAME+ " TEXT ,"+
            COLUMN_PASS+ " TEXT ,"+
            COLUMN_FNAME+ " TEXT ,"+
            COLUMN_LNAME+ " TEXT ,"+
            COLUMN_PHONE+ " TEXT ,"+
            COLUMN_EMAIL+ " TEXT ,"+
            COLUMN_ADDRESS+ " TEXT ,"+
            COLUMN_CITY+ " TEXT ," +
            COLUMN_STATE+ " TEXT , "+
            COLUMN_ZIP+ " TEXT )" ;

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }


    public boolean insertUser(String type, String uname, String pass, User user) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_TYPE, type);
        contentValues.put(COLUMN_UTAID, user.getUTAID());
        contentValues.put(COLUMN_UNAME, uname);
        contentValues.put(COLUMN_PASS, pass);
        contentValues.put(COLUMN_FNAME, user.getFName());
        contentValues.put(COLUMN_LNAME, user.getLName());
        contentValues.put(COLUMN_PHONE, user.getPhone());
        contentValues.put(COLUMN_EMAIL, user.getEmail());
        contentValues.put(COLUMN_ADDRESS, user.getAddress());
        contentValues.put(COLUMN_CITY, user.getCity());
        contentValues.put(COLUMN_STATE, user.getState());
        contentValues.put(COLUMN_ZIP, user.getZip());
        db.insert(TABLE_USER, null, contentValues);
        return true;
    }
    public Cursor getUser(String username, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from '"+TABLE_USER+"' where user_uname = '"+username+"' and user_pass ='"+password+"'", null );
        return res;
    }

    public Cursor searchUser(String lastname){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from '"+TABLE_USER+"' where '"+COLUMN_LNAME+"' = '"+lastname+"'", null );
        return res;
    }

    public Cursor getALlUser(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from '"+TABLE_USER+"'", null );
        return res;
    }

    public UserDatabaseController(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);
    }

    public boolean updateUser (String pass, User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_UTAID, user.getUTAID());
//        contentValues.put(COLUMN_UNAME, uname);
        contentValues.put(COLUMN_PASS, pass);
        contentValues.put(COLUMN_FNAME, user.getFName());
        contentValues.put(COLUMN_LNAME, user.getLName());
        contentValues.put(COLUMN_PHONE, user.getPhone());
        contentValues.put(COLUMN_EMAIL, user.getEmail());
        contentValues.put(COLUMN_ADDRESS, user.getAddress());
        contentValues.put(COLUMN_CITY, user.getCity());
        contentValues.put(COLUMN_STATE, user.getState());
        contentValues.put(COLUMN_ZIP, user.getZip());
        db.update(TABLE_USER, contentValues,COLUMN_UTAID+"="+user.getUTAID(),null);
        return true;
    }

    public Integer deleteUser (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_USER , "id = ? ", new String[] {
                (id) });
    }
    public void dropTable(String tableName){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("drop table "+ tableName);
    }

//    public  Cursor getAllEmployees() {
//
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor res =  db.rawQuery( "select * from employees", null );
//        return res;
//    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        return (int) DatabaseUtils.queryNumEntries(db, "employees");
    }
}