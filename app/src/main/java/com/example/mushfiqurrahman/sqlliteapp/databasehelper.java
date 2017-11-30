package com.example.mushfiqurrahman.sqlliteapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Mushfiqur Rahman on 11/25/2017.
 */

public class databasehelper extends SQLiteOpenHelper {
    public  static final String DATABASE_NAME ="Programmer.db";
    public  static final String TABLE_NAME ="Problem_table";
    public  static final String col_1 ="Number";
    public  static final String col_2 ="type";
    public  static final String col_3 ="Site";
    public  static final String col_4 ="Catagory";
    public static final String TABLE_Registeration ="registeration_table";
    public static final String col_5 ="ID";
    public static final String col_6 ="FirstName";
    public static final String col_7 ="LastName";
    public static final String col_8 ="Password";
    public static final String col_9 ="Email";
    public static final String col_10 ="Phone";



    public databasehelper(Context context) {
        super(context, DATABASE_NAME,null, 2);
        SQLiteDatabase db = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase .execSQL("create table " + TABLE_NAME +" (Number INTEGER ,type TEXT ,Site TEXT,Catagory INTEGER)");
       // sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_Registeration + " (ID INTEGER PRIMARY KEY AUTOINCREMENT ,FirstName TEXT ,LastName TEXT ,Password TEXT ,Email TEXT ,Phone TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_Registeration + " (ID INTEGER PRIMARY KEY AUTOINCREMENT ,FirstName TEXT ,LastName TEXT ,Password TEXT ,Email TEXT ,Phone TEXT)");

        //sqLiteDatabase.execSQL("DROP IF EXISTS "+TABLE_NAME );
        //sqLiteDatabase.execSQL("DROP IF EXISTS "+TABLE_Registeration );
       // onCreate(sqLiteDatabase);
    }
   // public boolean updateData(String name,String type,String site,String catagory) {
       // SQLiteDatabase db = this.getWritableDatabase();
       // ContentValues contentValues = new ContentValues();
       // contentValues.put(col_1,name);
       // contentValues.put(col_2,type);
       // contentValues.put(col_3,site);
       // contentValues.put(col_4,catagory);
       // db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { id });
       // return true;
   // }
//    public boolean insert(String name ,String surname,String marks){
//        SQLiteDatabase sqLiteDatabase =this.getWritableDatabase();
//        ContentValues contentValues =new ContentValues();
//        contentValues.put(col_2,name);
//        contentValues.put(col_3,surname);
//        contentValues.put(col_4,marks);
//       long result= sqLiteDatabase.insert(TABLE_NAME,null, contentValues);
//       if(result==-1){
//          return false;
//
//       }
//       else
//          return true;
//
//    }
//    public Cursor getAllData() {
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
//        return res;
//    }
//    public Integer deleteData (String id) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
//    }
}
