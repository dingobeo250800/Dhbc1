package com.example.dhbc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLtien  extends SQLiteOpenHelper {



    public SQLtien(Context context) {
        super(context, "mydata0.sql", null, 1);
    }

    // khai bao bang
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String tien_table = "CREATE TABLE TIEN (name char(15) primary key" +
                ",tien char)";
        sqLiteDatabase.execSQL(tien_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
