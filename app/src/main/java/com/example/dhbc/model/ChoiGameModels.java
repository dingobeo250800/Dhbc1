package com.example.dhbc.model;

import com.example.dhbc.ChoigameActivity;
import com.example.dhbc.object.CauDo;
import com.example.dhbc.object.NguoiDung;

import java.util.ArrayList;
import java.util.Random;

public class ChoiGameModels {
    ChoigameActivity c;
    ArrayList<CauDo> arr;
    int cauSo = -1;

    public NguoiDung nguoiDung;

    public ChoiGameModels(ChoigameActivity c) {
        this.c = c;
        nguoiDung = new NguoiDung();
        taoDaTa();
    }

    private void taoDaTa() {
        arr = new ArrayList<>();
        arr.add(new CauDo("", "baola", "https://lazi.vn/uploads/dhbc/1522660104_j.jpg"));
        arr.add(new CauDo("", "nguao", "https://lazi.vn/uploads/dhbc/1466667821_ngua-o.jpg"));
        arr.add(new CauDo("", "obama", "https://lazi.vn/uploads/dhbc/1514479758_bc2.jpg"));
        arr.add(new CauDo("", "cangua", "https://lazi.vn/uploads/dhbc/1503131884_dhbc.jpg"));
        arr.add(new CauDo("", "binhma", "https://lazi.vn/uploads/dhbc/1466696592_binh-ma.jpg"));
        arr.add(new CauDo("", "cakiem", "https://1.bp.blogspot.com/-3v30s61q28U/VD4alrJHz6I/AAAAAAAAGEc/--EiCP4KsGA/s1600/2014-10-15%2B12.18.51-1.png"));
        arr.add(new CauDo("", "kienthuc", "https://lazi.vn/uploads/dhbc/1508689380_dhbc.jpg"));
        arr.add(new CauDo("", "gokien", "https://lazi.vn/uploads/dhbc/1467199544_go-kien.jpg"));
        arr.add(new CauDo("", "giaothong", "https://lazi.vn/uploads/dhbc/1467199562_giao-thong.jpg"));
        arr.add(new CauDo("", "aulac", "https://lazi.vn/uploads/dhbc/1467595772_au-lac.jpg"));
        arr.add(new CauDo("", "danhgia", "https://lazi.vn/uploads/dhbc/1467199350_danh-gia.jpg"));
        arr.add(new CauDo("", "duongcai", "https://lazi.vn/uploads/dhbc/1467595732_duong-cai.jpg"));
        arr.add(new CauDo("", "dagiac", "https://lazi.vn/uploads/dhbc/1467595669_da-giac.jpg"));
        arr.add(new CauDo("", "banbac", "https://lazi.vn/uploads/dhbc/1467453448_ban-bac.jpg"));
        arr.add(new CauDo("", "camchan", "https://lazi.vn/uploads/dhbc/1467199333_cam-chan.jpg"));
        arr.add(new CauDo("", "canhdong", "https://lazi.vn/uploads/dhbc/1467199307_canh-dong.jpg"));
        arr.add(new CauDo("", "luoile", "https://lazi.vn/uploads/dhbc/1467164346_luoi-le.jpg"));
        arr.add(new CauDo("", "doiso", "https://lazi.vn/uploads/dhbc/1467164294_doi-so.jpg"));
        arr.add(new CauDo("", "caucu", "https://lazi.vn/uploads/dhbc/1467164269_cau-cu.jpg"));
        arr.add(new CauDo("", "thoihan", "https://lazi.vn/uploads/dhbc/1467163968_thoi-han.jpg"));
        arr.add(new CauDo("", "toitam", "https://lazi.vn/uploads/dhbc/1467163926_toi-tam.jpg"));
        arr.add(new CauDo("", "tieuchay", "https://lazi.vn/uploads/dhbc/1467163908_tieu-chay.jpg"));
        arr.add(new CauDo("", "taobon", "https://lazi.vn/uploads/dhbc/1467163885_tao-bon.jpg"));
        arr.add(new CauDo("", "otrong", "https://lazi.vn/uploads/dhbc/1467163798_o-trong.jpg"));
        arr.add(new CauDo("", "epcung", "https://lazi.vn/uploads/dhbc/1467162988_ep-cung.jpg"));


    }

    public CauDo layCauDo() { // randum lay cau so
         cauSo++;
        Random c = new Random();
//        int ngaunhien = c.nextInt(arr.size());
        if (cauSo >= arr.size()) {
            cauSo = arr.size() - 1;
        }
        return arr.get(cauSo);
//        return arr.get(ngaunhien);
        }

    public  void layThongTin(){// lay thong tin cua người dùng
        nguoiDung.getTT(c);//c là truyền cái contex
    }
    public  void luuThongTin(){
        nguoiDung.saveTT(c);
    }
}