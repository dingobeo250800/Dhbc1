package com.example.dhbc.object;

import android.content.Context;
import android.content.SharedPreferences;

public class NguoiDung {
    private String nameData = "appData";
    public int tien;
    public void saveTT (Context ct){ //lưu thong tin
        SharedPreferences sharedPreferences = ct.getSharedPreferences(nameData,0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("tien",tien);
        editor.commit();
    }
    public void getTT(Context ct){ //lay thong tin
        SharedPreferences sharedPreferences = ct.getSharedPreferences(nameData,0);
        tien = sharedPreferences.getInt("tien",0);
    }
}
