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

public class FragmentCouples extends Fragment {

    ListView Title_list;
    CardView card_view;
    public static String[] list_name1 = new String[]{
            "I'm wearing the smile you gave me.",
            "The best things in life are better with you.",
            "You're my favorite hello and my hardest goodbye.",
            "The peanut butter to my jelly.",
            "Together is a wonderful place to be.",
            "I can't live without you, and I don't want to try.",
            "My favorite fairytale is our love story.",
            "Home is wherever I'm with you.",
            "Two heads, one heart.",
            "Every day with you is the best day of my life.",
            "I want to be with you until my last page.",
            "P.S. I love you.",
            "You're the apple of my eye.",
            "You're my lobster.",
            "He's the Jim to my Pam.",
            "We have a forever type of love.",
            "Only a fool for you.",
            "We go together like hot sauce and everything.",
            "Thank you, Tinder.",
            "Here's to being my emergency contact.",
            "A relationship is when one person is always right and the other person is the boyfriend.",
            "I love you more than pizza, and that's saying a lot.",
            "Swiped right, now it's for life.",
            "Even when I want to kill you, I love you.",
            "Thanks for being so good at killing spiders.",
            "I'm happy to be your big/little spoon.",
            "He's not perfect, but at least he's not from my hometown.",
            "I like you even when I'm hungry.",
            "Thanks for putting up with me even though I'm kind of crazy.",
            "It wasn't love at first sight, but we turned out okay.",
            "You're the only person I would share my snacks with.",
            "I love you ALMOST as much as tacos.",
            "Here's our submission for the cutest couple award.",
            "Not McDonald's but he/she's lovin' it.",
            "Keep calm and give me a kiss.",
            "I know I’m a handful, but that’s why you’ve got two hands.",
            "I like my coffee how I like myself: Dark, bitter, and too hot for you.",
            "Together, we’ll put Hershey’s out of business! That’s how sweet the two of us are.",
            "I like you more than pizza and I really like pizza.",
            "I love him a latte.",
            "I love you with all my butt. I would say heart, but my butt is bigger.",
            "You make me smile so much that my face cramps up.",
            "I love you with every pizza my heart!",
            "Kissing burns 6.4 calories per minute. Wanna make out?",
            "Let’s cuddle so I can steal your body heat.",
            "Love is an ocean of emotions entirely surrounded by expenses.",
            "My favorite place is inside your hug.",
            "The first time I texted her, she didn’t reply because she fainted.",
            "We go together like cupcakes and frosting."
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
                        Intent i = new Intent(getActivity().getApplication(), DetailsCouples.class);
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
                        Intent i = new Intent(getActivity().getApplication(), DetailsCouples.class);
                        i.putExtra("Pos", pos);
                        startActivity(i);
                    }
                }
            });
            return convertView;
        }
    }
}