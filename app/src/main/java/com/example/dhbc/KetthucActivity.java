package com.example.dhbc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class KetthucActivity extends AppCompatActivity {
    private SQLtien sqLtien;
    TienDAO tienDAO;

    TextView tvTien;
    EditText tvName;
    Button btnLuu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ketthuc);

        tvName = findViewById(R.id.ten_Nguoichoi);
        tvTien = findViewById(R.id.tv_Tien);
        tvTien.setText(String.valueOf(MainActivity.tien));
        btnLuu = findViewById(R.id.btnLuu);
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqLtien = new SQLtien(KetthucActivity.this);
                tienDAO = new TienDAO(sqLtien);
                long t= tienDAO.insertTien(new Tien(tvName.getText().toString(),tvTien.getText().toString()));
                if(t >0){
                    Toast.makeText(KetthucActivity.this,"t dc nhan",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(KetthucActivity.this,ThongkeActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(KetthucActivity.this,"Fail",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}