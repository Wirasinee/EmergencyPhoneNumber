package com.example.emergencyphonenumber.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Wirasinee on 26-Nov-17.
 */
//[1]  |id|title|number|picture|
public class PhoneDbHelper extends SQLiteOpenHelper{ //SHIFT+F6 เปลียนชื่อ

    private static final String DATABASE_NAME = "phone.db";
    private static final int DATABASE_VERSION = 1;

    //ชื่อฟิล
    public static final String TABLE_NAME = "phone_Number";
    public static final String COL_ID = "_id";
    public static final String COL_TITLE = "title";
    public static final String COL_NUMBER = "number";
    public static final String COL_PICTURE = "picture";

    /*
    CRETE TABLE ชื่อเทเบิล (
      _id INTEGER PRIMARY KEY AUTOINCREMENT,
      title TEXT,
      number TEXT,
      picture TEXT
     );
     */

    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_TITLE + " TEXT,"
            + COL_NUMBER + " TEXT,"
            + COL_PICTURE + " TEXT)";

    //ALT+INS
    public PhoneDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) { //ถ้าฐานข้อมูลยังไม่มีก็จะมาทำตรงนี้
        db.execSQL(CREATE_TABLE); //ไปสร้างตาราง
        insertInitialData(db);//ใส่ข้อมูลลงตาราง
    }

    private void insertInitialData(SQLiteDatabase db) {//idไม่ต้องใส่เพราะเดียวandroidทำให้เอง
//ข้อมูล1
        ContentValues cv = new ContentValues();
        //putค่าต่างๆใส่ลงcv
        cv.put(COL_TITLE,"แจ้งเหตุด่วนเหตุร้าย");//ใส่ฟิลไหน,ค่าที่ใส่
        cv.put(COL_NUMBER,"191");
        cv.put(COL_PICTURE,"number0001.jpg");
        //app->New->Foder->Asset จะได้Fodel asset ไปหารูปมาใส่
        //เอาcv ใส่ลงฐานข้อมูล
        db.insert(TABLE_NAME,null,cv);//ชื่อตาราง,null,cv

//ข้อมูล2
        cv = new ContentValues();
        cv.put(COL_TITLE,"แจ้งเหตุเพลิงไหม้");//ใส่ฟิลไหน,ค่าที่ใส่
        cv.put(COL_NUMBER,"199");
        cv.put(COL_PICTURE,"number0002.jpg");
        db.insert(TABLE_NAME,null,cv);
    }
//คลิก แพคเกจย่อย-> สร้างแพคเกจ model-> สร้าง javaclass PhoneItem [2]

//ไม่ออกข้อสอบ  สมมุติออกแอพไปแล้ว ให้ผู้ใช้ใช้ไปแล้ว พอเราจะทำเวอชันถัดไปแต่เทเบิลไม่พอในเวอชันถัดไป จะมาใช้ตรงนี้
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
