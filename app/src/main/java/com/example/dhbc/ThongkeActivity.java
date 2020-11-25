package com.example.dhbc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class ThongkeActivity extends AppCompatActivity {

    private SQLtien sqLtien;
    TienDAO tienDAO;
    ListView lvList;
    List<Tien>tienList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongke);
        lvList = findViewById(R.id.lvList);
        sqLtien = new SQLtien(ThongkeActivity.this);
        tienDAO = new TienDAO(sqLtien);
        tienList= tienDAO.getAllTien();
        ThongkeAdapter thongkeAdapter = new ThongkeAdapter(tienList,ThongkeActivity.this);
        lvList.setAdapter(thongkeAdapter);
    }

}