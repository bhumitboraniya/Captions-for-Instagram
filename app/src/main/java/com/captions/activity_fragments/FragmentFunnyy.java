package com.captions.activity_fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.cardview.widget.CardView;
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


import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class FragmentFunnyy extends Fragment {
    ListView Title_list;
    CardView card_view;
    public static String[] list_name = new String[]{
            "People say nothing is impossible, but I do nothing every day.",
            "If you think nothing is impossible, try slamming a revolving door.",
            "I finally realized that people are prisoners of their phones… that’s why it’s called a “cell” phone.",
            "There are 100 billion nerves in the human body, and there are people who have the ability to irritate all of them.",
            "Your secrets are safe with me… I wasn’t even listening.",
            "You never realize what you have until it’s gone. Toilet paper is a good example.",
            "I don’t think inside the box and I don’t think outside the box… I don’t even know where the box is.",
            "Be careful when you follow the masses. Sometimes the M is silent.",
            "I would like to thank my arms for always being by my side, my legs for always supporting me, and my fingers because I can always count on them.",
            "Don’t be ashamed of who you are. That’s your parents’ job.",
            "It may look like I’m doing nothing, but in my head, I’m quite busy.",
            "When people tell me “You’re going to regret that in the morning,” I sleep in until noon because I’m a problem solver.",
            "Doing nothing is hard, you never know when you’re done.",
            "If you fall, I will be there. Signed: Floor.",
            "You can’t run through a campground. You can only “ran,” because it’s past tents.",
            "Dear autocorrect, that’s not what I was trying to say. I’m getting tired of your shirt.",
            "Out of my mind! Back in five minutes.",
            "To make time fly, throw your watch out the window.",
            "I don’t like violence but I don’t mind if I get hit by luck.",
            "People say “go big or go home” like going home is a bad thing. Heck yeah, I want to go home, and I’ll have a nap when I get there.",
            "He who laughs last didn’t get it.",
            "It sure is strange that after Tuesday the rest of the week spells WTF.",
            "Yes, I know there is a really special place in Hell for me. It is called a throne.",
            "I eat cake because it’s somebody’s birthday somewhere.",
            "My friend thinks he’s smart. He said onions are the only food that makes you cry. So I threw a coconut at his face.",
            "Vodka may not be the answer but it’s worth a shot.",
            "Wine + dinner = winner",
            "I never make the same mistake twice. I make it like five or six times, you know, just to be sure.",
            "Yesterday I really wanted tacos. Now I’m eating tacos. Follow your dreams.",
            "I need a six-month vacation twice a year.",
            "I’m sorry, I don’t take orders. I barely take suggestions.",
            "You just can’t live a full life on an empty stomach.",
            "Reality called, so I hung up.",
            "I followed a diet but it didn’t follow me back, so I unfollowed it.",
            "The fridge is a clear example that what matters is on the inside.",
            "“Never put off till tomorrow what may be done the day after tomorrow just as well.” ― Mark Twain",
            "“A day without sunshine is like, you know, night.” ― Steve Martin",
            "“Some people never go crazy. What truly horrible lives they must lead.” ― Charles Bukowski",
            "“The reason I talk to myself is because I’m the only one whose answers I accept.” ― George Carlin",
            "“I am free of all prejudice. I hate everyone equally. ” ― W.C. Fields",
            "“Two wrongs don’t make a right, but they make a good excuse.” ― Thomas Szasz",
            "“I generally avoid temptation unless I can’t resist it.” ― Mae West",
            "“If I’m not complaining, I’m not having a good time, hah hah!” ― Martin Scorsese",
            "“No man can be wise on an empty stomach.” – George Eliot",
            "”I am thankful for laughter, except when milk comes out of my nose.” – Woody Allen",
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
                        Intent i = new Intent(getActivity().getApplication(), DetailsFunny.class);
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
            return list_name.length;
        }

        @Override
        public Object getItem(int position) {
            return list_name[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public View getView(final int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row_list, parent, false);
            TextView txt_main_title = (TextView) convertView.findViewById(R.id.row_List_TV);
            txt_main_title.setText(list_name[position]);
            txt_main_title.setTag(position);
            txt_main_title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = Integer.parseInt(v.getTag().toString());
                    adpos = pos;
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    } else {
                        Intent i = new Intent(getActivity().getApplication(), DetailsFunny.class);
                        i.putExtra("Pos", pos);
                        startActivity(i);
                    }
                }
            });
            return convertView;
        }
    }
}
