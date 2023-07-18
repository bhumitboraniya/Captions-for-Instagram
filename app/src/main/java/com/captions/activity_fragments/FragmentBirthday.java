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

public class FragmentBirthday extends Fragment {

    ListView Title_list;
    CardView card_view;
    public static String[] list_name1 = new String[]{
            "A year wiser 🤓",
            "Go shawty, it’s my birthday",
            "Happy birthday to me!",
            "Having my cake and eating it too 🎂",
            "Making my birthday wish",
            "I’m officially [age]!",
            "Experience level: [age]",
            "Another year older, wiser, and happier",
            "On this day, a queen was born. Happy birthday to me!",
            "Gonna party like my birthday… oh wait, it is!",
            "Today is my birthday but I'll take gifts whenever.",
            "A star was born today. Where's *my* movie?",
            "You're looking at the best party favor.",
            "Sassy since birth.",
            "I don't get older, I level up.",
            "Today, the world received a gift. It's me and you're welcome.",
            "Don't grow up, it's a trap.",
            "Age is just a hashtag.",
            "I can't help being cute, I was born this way.",
            "May the fork be with you. Let's eat cake.",
            "I'm not getting older. I'm getting better.",
            "Facebook has some exciting news today.",
            "Birthdays are good for me. The more I have, the longer I live.",
            "When the candles cost more than the cake, it’s time to realize you’re getting old.",
            "Another year older, another year wiser? I guess we'll see!",
            "Well, at least I am not as old as I will be next year!",
            "Of course, I don’t know how to act my age. I’ve never been this age before!",
            "The only things getting LIT today are the candles on my cake!",
            "I’m too young to be this old.",
            "New year, same me... because I'm already awesome.",
            "Age is merely the number of years the world has been enjoying me.",
            "I'm just here for the birthday cake.",
            "I can't keep calm, it's my birthday.",
            "Here’s my obligatory birthday selfie!",
            "It’s my favorite holiday…my birthday!",
            "I have a craving for cake…It must be my birthday week.",
            " Just went on my annual birthday shopping spree!",
            "Act my age? No thanks!",
            "Birthdays are good for you. Statistics show that the more you have the longer you live.",
            "On this day a star was born.",
            "Birthdays are the universe's way us of telling us to eat more cake.",
            "Let me be the first one to wish myself a happy birthday!",
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
                        Intent i = new Intent(getActivity().getApplication(), DetailsBirthday.class);
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
                        Intent i = new Intent(getActivity().getApplication(), DetailsBirthday.class);
                        i.putExtra("Pos", pos);
                        startActivity(i);
                    }
                }
            });
            return convertView;
        }
    }
}