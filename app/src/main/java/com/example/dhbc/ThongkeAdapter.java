package com.example.dhbc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ThongkeAdapter extends BaseAdapter {
    private List<Tien> tienList;
    private Context context;
    private TienDAO tienDAO;
    public ThongkeAdapter(List<Tien> tienList, Context context) {
        this.tienList = tienList;
        this.context = context;

    }

    @Override
    public int getCount() {
        return tienList.size();
    }

    @Override
    public Object getItem(int i) {
        return tienList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        view = LayoutInflater.from(context).inflate(R.layout.tien_item,parent,false);
        TextView tvName = view.findViewById(R.id.tvName);TextView tvTiem = view.findViewById(R.id.tvTien);
        Tien tien= (Tien) getItem(i);
        tvName.setText(tien.name);
        tvTiem.setText(tien.tien);
        return view ;
    }


}
