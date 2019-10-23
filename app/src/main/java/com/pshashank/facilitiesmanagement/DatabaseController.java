package com.pshashank.facilitiesmanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseController extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Facillities.db";
    public static final String TABLE_USER = "user";
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


    public boolean insertUser(String type, String utaid, String uname, String pass,String fname,String lname,String phone,String email, String address,String city,
                                 String state,String zip) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("user_type", type);
        contentValues.put("user_id", utaid);
        contentValues.put("user_uname", uname);
        contentValues.put("user_pass", pass);
        contentValues.put("first_name", fname);
        contentValues.put("last_name", lname);
        contentValues.put("phone", phone);
        contentValues.put("email", email);
        contentValues.put("street_address", address);
        contentValues.put("city", city);
        contentValues.put("state", state);
        contentValues.put("zip_code", zip);
        db.insert(TABLE_USER, null, contentValues);
        return true;
    }
    public Cursor getUser(String username, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from '"+TABLE_USER+"' where user_uname = '"+username+"' and user_pass ='"+password+"'", null );
        return res;
    }

    public DatabaseController(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);
    }

    public boolean updateContact (String id,String fname, String mname,String lname,
                                  String gender,String age, String status,String date,String qualification,
                                  String experience,String empid,String branch,String department,String salary,byte[] image) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("first_name", fname);
        contentValues.put("middle_name", mname);
        contentValues.put("last_name", lname);
        contentValues.put("gender", gender);
        contentValues.put("age", age);
        contentValues.put("status", status);
        contentValues.put("date_of_grad", date);
        contentValues.put("qualification", qualification);
        contentValues.put("experience", experience);
        contentValues.put("emp_id", empid);
        contentValues.put("branch", branch);
        contentValues.put("department", department);
        contentValues.put("salary", salary);
        db.update("employees", contentValues, "id = ? ", new String[] { (id) } );
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