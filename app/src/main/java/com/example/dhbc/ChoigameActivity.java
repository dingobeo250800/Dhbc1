package com.example.dhbc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.dhbc.adapter.DapAnAdapter;
import com.example.dhbc.model.ChoiGameModels;
import com.example.dhbc.object.CauDo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class ChoigameActivity extends AppCompatActivity {
    ChoiGameModels models;
    CauDo cauDo;
    private String dapAn = "yeuot";

    ArrayList<String> arrCautraloi;
    GridView gdvCautraloi;
    int index = 0;//vij tris nayf nham muc dich quy dinh vi tri set chu

    ArrayList<String> arrDapAn;
    GridView gdvDapAn;
    int cauhoi;

    ImageView imgAnhCauDo, imgHome;
    TextView txtTienNguoiDung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choigame);
        init();
        anhXa();
        setOnClick();

        hienCauDo();
        cauhoi=0;

//        bamData(); // cho xuong phan hien thi cau do
//        hienThiCautraloi();
//        hienThiDapAn();

        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChoigameActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void anhXa() {
        gdvCautraloi = findViewById(R.id.gdvCautraloi);
        gdvDapAn = findViewById(R.id.gdvDapAn);
        imgAnhCauDo = findViewById(R.id.imgAnhCauDo);
        txtTienNguoiDung = findViewById(R.id.txtTienNguoiDung);
        imgHome = findViewById(R.id.imgHome);
    }

    private void init() {//add cái câu trả lời
        models = new ChoiGameModels(this); // goi choigamemodels ra
        arrCautraloi = new ArrayList<>();

        arrDapAn = new ArrayList<>();
    }

    //goi cau do ra
    private void hienCauDo() {
        cauDo = models.layCauDo();// lay thang lay cau do ra
        dapAn = cauDo.dapAn;

        bamData();

        hienThiCautraloi();
        hienThiDapAn();

        Glide.with(this) //https://guides.codepath.com/android/Displaying-Images-with-the-Glide-Library Basic Usage
                .load(cauDo.anh)
                .into(imgAnhCauDo);

        //set lai tien cua nguoi dung`
        models.layThongTin();
        txtTienNguoiDung.setText(models.nguoiDung.tien + "$");
    }

    // hien thi dap an va cau tra loi b3
    private void hienThiCautraloi() {// đẩy câu trả lời lên màn hình
        gdvCautraloi.setNumColumns(arrCautraloi.size());
        gdvCautraloi.setAdapter(new DapAnAdapter(this, 0, arrCautraloi));
    }

    private void hienThiDapAn() {// đẩy dap an' lên màn hình dap an la phia duoi co randum
        gdvDapAn.setNumColumns(arrDapAn.size() / 2);
        gdvDapAn.setAdapter(new DapAnAdapter(this, 0, arrDapAn));
    }

    //set su kien click cua chon dap an b5
    private void setOnClick() {
        gdvDapAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {//an vao dap an se hien thi len cau tra loi
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = (String) parent.getItemAtPosition(position);
                if (s.length() != 0 && index < arrCautraloi.size()) {
                    for (int i = 0; i < arrCautraloi.size(); i++) {// o nao dang trong thi no se xet cho o day
                        if (arrCautraloi.get(i).length() == 0) {
                            index = i;
                            break;
                        }
                    }
                    arrDapAn.set(position, "");
                    arrCautraloi.set(index, s);
                    Log.e(position + "", arrDapAn.get(position));
                    index++;
                    hienThiCautraloi();
                    hienThiDapAn();
                    checkWin();//////////////// goi o day
                }
            }
        });
        gdvCautraloi.setOnItemClickListener(new AdapterView.OnItemClickListener() {//khi muon an quay lai vitri ky tu da nham
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = (String) parent.getItemAtPosition(position);
                if (s.length() != 0) {
                    index = position;
                    arrCautraloi.set(position, "");

                    for (int i = 0; i < arrDapAn.size(); i++) {
                        if (arrDapAn.get(i).length() == 0) {
                            arrDapAn.set(i, s);
                            break;
                        }
                    }
                    hienThiCautraloi();
                    hienThiDapAn();
                }
            }
        });

    }

    //do data len man hinh b4
    private void bamData() {
        index = 0;// cho no bang 0 neu khong thi nó sẽ lưu lại đáp án cũ
        arrCautraloi.clear();//cler 2 cai nay thi sang cau sau moi resec ca cau hoi moi dap an
        arrDapAn.clear();// cler 2 cai nay thi sang cau sau moi resec ca cau hoi moi dap an
        Random r = new Random();
        for (int i = 0; i < dapAn.length(); i++) {
            arrCautraloi.add("");// hieenr thij caau tra loi trong

            String s = "" + (char) (r.nextInt(26) + 65);//bang ma ascii randum tu 65 den 90
            arrDapAn.add(s);
            String s1 = "" + (char) (r.nextInt(26) + 65);
            arrDapAn.add(s1);
        }
        for (int i = 0; i < dapAn.length(); i++) {
            String s = "" + dapAn.charAt(i);
            arrDapAn.set(i, s.toUpperCase());
        }
        for (int i = 0; i < arrDapAn.size(); i++) {
            String s = arrDapAn.get(i);
            int vt = r.nextInt(arrDapAn.size());// vong for hien thi randum dap an trong 10 ky tu
            arrDapAn.set(i, arrDapAn.get(vt));//vitri tai i cua phan cau hoi se thay doi. vidu: A B C D
            arrDapAn.set(vt, s);//vidu: C A B D
        }
    }

    private void checkWin() {
        String s = "";
        for (String s1 : arrCautraloi) {
            s = s + s1;
        }
        s = s.toUpperCase();
        if (s.equals(dapAn.toUpperCase())) {
            Toast.makeText(this, "Ban da dung", Toast.LENGTH_SHORT).show();
            if(cauhoi==2){
                Intent intent = new Intent(ChoigameActivity.this, KetthucActivity.class);
                startActivity(intent);
                       //  Toast.makeText(ChoigameActivity.this, "ban da chien thang",Toast.LENGTH_SHORT).show();// thay cai man vao la xong
            }else {
                models.layThongTin();
                models.nguoiDung.tien = models.nguoiDung.tien + 10; //dap an dung tien se tra ve +10
                MainActivity.tien=models.nguoiDung.tien;
                models.luuThongTin();// lưu tien khi cong
                hienCauDo();//goi ham hienCauDo o day vi khi tra loi dung se chuyen tiep cau
                cauhoi++;
            }

        }
    }

    public void moGoiY(View view) {
        models.layThongTin();
        if(models.nguoiDung.tien <5){
            Toast.makeText(this, "Ban da HẾT TIỀN", Toast.LENGTH_SHORT).show();
        }

        int id = -1;
        for (int i = 0; i < arrCautraloi.size(); i++) {
            if (arrCautraloi.get(i).length() == 0) {
                id = i;
                break;
            }
        }
        if (id == -1) {
            for (int i = 0; i < arrCautraloi.size(); i++) {
                String s = dapAn.toUpperCase().charAt(i) + "";
                if (! arrCautraloi.get(i).toLowerCase().equals(s)) {
                    id = i;
                    break;
                }
            }
        }
        for(int i =0; i< arrDapAn.size(); i++){ // cái đáp án khi mình chọn trã trả về đúng ô cũ lúc đầu của nó
            if(arrDapAn.get(i).length() == 0){
                arrDapAn.set(i,arrCautraloi.get(id));
                break;
            }
        }
        String goiY = "" + dapAn.charAt(id);// lay ra cai gi y nguoi dung dang can
        goiY = goiY.toUpperCase();// viet hoa chu len

        for(int i =0; i<arrCautraloi.size(); i ++){ // khi mà ô chọn trùng chữ cái trả lời lập tức nó sẽ xóa chữ cái sai đi
            if(arrCautraloi.get(i).toUpperCase().equals(goiY)){
                arrCautraloi.set(i,"");
                break;
            }
        }

        for (int i = 0; i < arrDapAn.size(); i++) {
            if (goiY.equals(arrDapAn.get(i))) {// lay vi tri cua phan arrDapAn xong nhet len phan ArrCautraloi
                arrDapAn.set(i, "");
                break;
            }
        }
        arrCautraloi.set(id, goiY);
        hienThiCautraloi();
        hienThiDapAn();
        models.layThongTin();
        models.nguoiDung.tien = models.nguoiDung.tien - 5; //dap an dung tien se tra ve +10
        models.luuThongTin();// lưu tien khi cong
        txtTienNguoiDung.setText(models.nguoiDung.tien + "$");
    }

    public void nextCauhoi(View view) { //chuyen cau
        models.layThongTin();
        if(models.nguoiDung.tien < 10){
            Toast.makeText(this, "Ban da HẾT TIỀN", Toast.LENGTH_SHORT).show();
            return;
        }
        models.nguoiDung.tien = models.nguoiDung.tien - 10; //dap an dung tien se tra ve +10
        models.luuThongTin();// lưu tien khi cong
        txtTienNguoiDung.setText(models.nguoiDung.tien + "$");
        hienCauDo();
    }

}