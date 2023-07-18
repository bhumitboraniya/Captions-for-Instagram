package com.captions.others;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.captions.R;

import java.util.ArrayList;
import java.util.HashMap;



public class DatabaseAdpater extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    ArrayList<HashMap<String, String>> list;

    public DatabaseAdpater(Context context, ArrayList<HashMap<String, String>> list) {
        this.context = context;
        this.list = list;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = inflater.inflate(R.layout.favorite_list, null);
        TextView fid = (TextView) convertView.findViewById(R.id.textView1);
        TextView college_name = (TextView) convertView.findViewById(R.id.textView2);
        TextView college_hod = (TextView) convertView.findViewById(R.id.textView3);
        college_name.setSelected(true);
        college_name.setSingleLine(true);
        HashMap<String, String> map = list.get(position);
        String favorite_id = map.get("favorite_id");
        String namelist = map.get("nameofdata");
        String listvrt = map.get("listoffavorite");

        fid.setText(favorite_id);
        college_name.setText(namelist);
        college_hod.setText(listvrt);

        return convertView;
    }
}