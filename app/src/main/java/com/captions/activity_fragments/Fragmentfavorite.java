package com.captions.activity_fragments;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Advanceable;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import com.captions.R;
import com.captions.others.DatabaseAdpater;

import com.captions.others.SQLDatabaseFavorite;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class Fragmentfavorite extends Fragment {


    ListView lv;
    ArrayList<HashMap<String, String>> list;
    DatabaseAdpater databaseAdpater;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragments_favorite, container, false);
        TextView datas = (TextView) rootView.findViewById(R.id.textView2);

        lv = (ListView) rootView.findViewById(R.id.listviewLV);
        dataload();

//        MobileAds.initialize(getActivity().getApplicationContext(),"ca-app-pub-9477516779433080/6061610386");
//        AdView adViesw;
//        adViesw = (AdView) rootView.findViewById(R.id.adViewbar);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        adViesw.loadAd(adRequest);
        return rootView;
    }

    @Override
    public void onResume() {
        dataload();
        super.onResume();

    }


    public void dataload() {
        SQLDatabaseFavorite dal = new SQLDatabaseFavorite(getActivity().getApplication());
        dal.openDB();
        list = dal.getfavoritedata();
        dal.closeDB();
        databaseAdpater = new DatabaseAdpater(getActivity().getApplication(), list);
        lv.setAdapter(databaseAdpater);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity().getApplication(), FavoriteInfomationActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                HashMap<String, String> map = list.get(position);
                intent.putExtra("favorite_id1", map.get("favorite_id"));
                intent.putExtra("title", map.get("nameofdata"));
                intent.putExtra("favorite_data", map.get("listoffavorite"));
                startActivity(intent);

            }
        });
    }
}
