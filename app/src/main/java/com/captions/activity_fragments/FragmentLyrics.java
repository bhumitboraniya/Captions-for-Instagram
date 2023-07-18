package com.captions.activity_fragments;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.captions.ConstantFile;
import com.captions.R;

public class FragmentLyrics extends Fragment {

    ListView Title_list;
    CardView card_view;
    public static String[] list_name1 = new String[]{
            "I'm the best thing since sliced bread. I'm a damn sandwich.",
            "Stackin' my money 'til it's in the clouds, I'm a real-life boss man.",
            "I'm from the Midwest so I'm grindin' for mine.",
            "I'm the bad guy, duh!",
            "Laugh now cry later, that's just how I live my life.",
            "If it rains, then party indoors.",
            "My momma don't like you and she likes everyone.",
            "Keep your head up high and your middle finger higher.",
            "Nothin' lasts forever but the memories we make.",
            "Pain is beauty, that's just how I roll.",
            "My name is not important, just know that I'm makin' hits.",
            "Chill out, it's just a party.",
            "I'm so fresh they call me Mr. Clean.",
            "Live for today, 'cause tomorrow ain't guaranteed.",
            "Saying goodbye is never easy, but I know that we'll meet again someday.",
            "My life is a movie and you're just a character.",
            "I'm not tryin' to be perfect, I'm just tryin' to be me.",
            "I don't need your approval, love me or hate me.",
            "Roll! Rolls-Royce! That's how I roll.",
            "I'm not normal, I'm extraordinary.",
            "If you're not first, you're last.",
            "I'm a work in progress.",
            "I don't care what people say, I'mma do me.",
            "You can't keep me down, I'm rising up.",
            "My life is my story and I'm writing it my way.",
            "It's not over until I say it is.",
            "I'm just a simple girl living life one day at a time.",
            "Enjoy the journey, not just the destination.",
            "I'm not afraid to be different.",
            "Life is too short to waste time on things that don't matter.",
            "Saddle up, it's time for a wild ride.",
            "This is my life and I'm living it my way.",
            "Listen to your heart, not what other people tell you.",
            "I'm not perfect, but I'm authentic.",
    };
    private InterstitialAd mInterstitialAd;

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("SEE_YOUR_LOGCAT_TO_GET_YOUR_DEVICE_ID")
                .build();

        mInterstitialAd.loadAd(adRequest);
    }

    int adpos;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main, container, false);
        mInterstitialAd = new InterstitialAd(getActivity().getApplication());

        if (ConstantFile.isActive_adMob == true) {
            try {
                mInterstitialAd = new InterstitialAd(getActivity().getApplication());
                mInterstitialAd.setAdUnitId(getString(R.string.admob_interstitial));
                mInterstitialAd.setAdListener(new com.google.android.gms.ads.AdListener() {
                    @Override
                    public void onAdClosed() {
                        Intent i = new Intent(getActivity().getApplication(), DetailsLyrics.class);
                        i.putExtra("Pos", adpos);
                        startActivity(i);
                        requestNewInterstitial();
                    }

                });
                requestNewInterstitial();
            } catch (Exception e) {
            }
        }
        Title_list = (ListView) rootView.findViewById(R.id.Title_list);
        CustomListTitle adapter = new CustomListTitle(getActivity().getApplication());
        Title_list.setAdapter(adapter);
        return rootView;
    }

    public class CustomListTitle extends BaseAdapter {
        Context mContext;

        public CustomListTitle(Context context) {
            this.mContext = context;
        }

        @Override
        public int getCount() {
            return list_name1.length;
        }

        @Override
        public Object getItem(int position) {
            return list_name1[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public View getView(final int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row_list, parent, false);
            TextView txt_main_title = (TextView) convertView.findViewById(R.id.row_List_TV);
            txt_main_title.setText(list_name1[position]);
            txt_main_title.setTag(position);
            txt_main_title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = Integer.parseInt(v.getTag().toString());
                    adpos = pos;
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    } else {
                        Intent i = new Intent(getActivity().getApplication(), DetailsLyrics.class);
                        i.putExtra("Pos", pos);
                        startActivity(i);
                    }
                }
            });
            return convertView;
        }
    }
}