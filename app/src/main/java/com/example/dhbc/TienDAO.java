package com.example.dhbc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class TienDAO {
    private SQLtien sqLtien;

    public TienDAO(SQLtien sqLtien) {
        this.sqLtien = sqLtien;
    }

    public List<Tien> getAllTien() {
        List<Tien> tienList = new ArrayList<>();
        String sql = "SELECT * FROM TIEN";
        Cursor cursor = sqLtien.getReadableDatabase().rawQuery(sql, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String name = cursor.getString(0);
                String tien1 = cursor.getString(1);

                Tien tien = new Tien();
                tien.name = name;
                tien.tien = tien1;


                tienList.add(tien);
                cursor.moveToNext();
            }
        }

        return tienList;
    }
    public long insertTien(Tien tien){
        SQLiteDatabase sqLiteDatabase=sqLtien.getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put("name",tien.name);
        contentValues.put("tien",tien.tien);



        long result = sqLiteDatabase.insert("TIEN",null,contentValues );
        sqLiteDatabase.close();
        return result;
    }

}
