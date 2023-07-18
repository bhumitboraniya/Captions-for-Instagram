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

public class FragmentCool extends Fragment {

    ListView Title_list;
    CardView card_view;
    public static String[] list_name1 = new String[]{
            "Being cool is being your own self, not doing something that someone else is telling you to do.",
            "I can take it. The tougher it gets, the cooler I get.",
            "I’m a mirror. If you’re cool with me, I’m cool with you, and the exchange starts. What you see is what you reflect. If you don’t like what you see, then you’ve done something. If I’m standoffish, that’s because you are.",
            "Nothing is cooler and more attractive than a big comeback, and that’ll be me.",
            "I’ve never been cool and I don’t really care about being cool. It’s just an awful lot of time and hair gel wasted.",
            "He who keeps his cool best wins.",
            "Just keep your cool and your sense of humor.",
            "Forget the failures. Keep the lessons.",
            "If you can’t change your fate, change your attitude.",
            "Those who think it is not cool to be kind are cold-hearted.",
            "Women are like teabags. We don’t know our true strength until we are in hot water!",
            "Sometimes one day changes everything; sometimes years change nothing.",
            "If you are always trying to be normal, you will never know how amazing you can be.",
            "See the bowtie? I wear it and I don’t care. That’s why it’s cool.",
            "You don’t have to make something that people call art. Living is an artistic activity, there is an art to getting through the day.",
            "Secrets…are the very root of cool.",
            "Passion isn’t cool, it’s hot.",
            "So, here’s a really stupid thing about the world: The trick to looking cool is not caring whether you look cool. So the moment you achieve perfect coolness is simultaneously the moment that you actually, completely don’t care.",
            "So uncool it’s cool again.",
            "People trying too hard to be cool often end up becoming a joke.",
            "Weird is the new cool"
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
                        Intent i = new Intent(getActivity().getApplication(), DetailsCool.class);
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
                        Intent i = new Intent(getActivity().getApplication(), DetailsCool.class);
                        i.putExtra("Pos", pos);
                        startActivity(i);
                    }
                }
            });
            return convertView;
        }
    }
}