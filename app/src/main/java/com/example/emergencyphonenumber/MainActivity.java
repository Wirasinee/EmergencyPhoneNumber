package com.example.emergencyphonenumber;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.emergencyphonenumber.db.PhoneDbHelper;
import com.example.emergencyphonenumber.model.PhoneItem;

import java.util.ArrayList;

//[3]
public class MainActivity extends AppCompatActivity {
    //<1>
    private PhoneDbHelper mHelper;//เข้าถึงdb
    private SQLiteDatabase mDb;//ตัวอ้างอิงdb
    private ArrayList<PhoneItem> mPhoneItemsList = new ArrayList<>();
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //อ่านข้อมูลจากdb ลงโมเดล แสดงในlistView

    //<2>อ้างอิงdb
    mHelper = new PhoneDbHelper(this);
    mDb = mHelper.getReadableDatabase();

    //จะคิวรีข้อมูล ทุกแถว ทุกคอลัม
    Cursor cursor =mDb.query(
            //CTRT+P เอาแบบ3
            PhoneDbHelper.TABLE_NAME,
            null,//เอามาทุกคอลัม
            null,
            null,
            null,
            null,
            null
    );
//วนลูปเอาข้อมูลออกมา
    while (cursor.moveToNext()){
        int id = cursor.getInt(cursor.getColumnIndex(PhoneDbHelper.COL_ID));
        String title = cursor.getString(cursor.getColumnIndex(PhoneDbHelper.COL_TITLE));  //getมาแต่ละคอลัมของแถวนั้นๆ หรือcursor.getString(1); ช่อง1ตือtitle
        String number = cursor.getString(cursor.getColumnIndex(PhoneDbHelper.COL_NUMBER));  //getมาแต่ละคอลัมของแถวนั้นๆ หรือcursor.getString(1); ช่อง1ตือtitle
        String picture = cursor.getString(cursor.getColumnIndex(PhoneDbHelper.COL_PICTURE));  //getมาแต่ละคอลัมของแถวนั้นๆ หรือcursor.getString(1); ช่อง1ตือtitle

        //สร้างโมเดลobj โดยผ่านคอนสตักจอPhoneItem ที่สร้างไว้
        PhoneItem item = new PhoneItem(id,title,number,picture);
        mPhoneItemsList.add(item);//ข้อมูลขากdbมาอยู่ในนี้หมดแล้ว
    }

    //แสดงผล
//adapterเป็นตัวกลางให้เราเอาข้อมูลในลิสมาใส่ในเลเอา
    ArrayAdapter adapter = new ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            mPhoneItemsList
    );

    //อ้างอิงถึงลิสวิว
    ListView listView = findViewById(R.id.list_View);
    listView.setAdapter(adapter);


}
}
