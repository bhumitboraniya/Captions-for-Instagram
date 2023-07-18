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

public class FragmentOneword extends Fragment {

    ListView Title_list;
    CardView card_view;
    public static String[] list_name1 = new String[]{
            "Crazy",
            "Notorious",
            "Karma",
            "Interesting",
            "Cutie",
            "Classy",
            "Sparkle",
            "Sassafrass",
            "Independent",
            "Unbothered",
            "Mood",
            "Lit",
            "Relatable",
            "Eyeroll",
            "Whatever",
            "XOXO",
            "Reckless",
            "Ambitious",
            "Blessed",
            "Yeehaw",
            "Yeet",
            "YOLO",
            "Queen",
            "Shopaholic",
            "Boom",
            "Bad",
            "Boss",
            "Thotty",
            "Sasshole",
            "Unicorn",
            "Sore",
            "Bye",
            "Flawsome",
            "Priorities",
            "Always",
            "BFF",
            "BFF4Ever",
            "Besties",
            "Buddies",
            "Brotherhood",
            "Brothers",
            "Bros",
            "Chillin",
            "Chill",
            "Cheers",
            "Daytrip",
            "Dudes",
            "Dude",
            "Dreamers",
            "Enjoy",
            "Enjoying",
            "Eye-roll",
            "Fashionistas",
            "Fellas",
            "Forever",
            "Friend",
            "Friendship",
            "F.R.I.E.N.D.S.",
            "Fun",
            "Gang",
            "Giggles",
            "Girls",
            "Goofball",
            "Goofballs",
            "Happy",
            "Happiness",
            "Inseparable",
            "Jokers",
            "Laugh",
            "Laughing",
            "LOL",
            "Nostalgic",
            "Remember",
            "Rebels",
            "Roadtrip",
            "ROFL",
            "Sisters",
            "Secrets",
            "Support",
            "Sisterhood",
            "TBT",
            "Together",
            "Us",
            "Weirdos",
            "Angel",
            "Aries",
            "Aquarius",
            "Babe",
            "Bad",
            "Badass",
            "Beauty",
            "Bling",
            "Bold",
            "Bored",
            "Brave",
            "Cancer",
            "Capricorn",
            "Change",
            "Classy",
            "Cool",
            "Coffee",
            "Colorful",
            "Confident",
            "Crazy",
            "Creative",
            "Curls",
            "Cute",
            "Daydreaming",
            "Devil",
            "Dieting",
            "Different",
            "Drama",
            "Dream",
            "Drunk",
            "Engaged",
            "Fashion",
            "Fitness",
            "Fun",
            "Gem",
            "Gemini",
            "Ghosting",
            "Glowing",
            "Good",
            "Happy",
            "Hello",
            "Hi",
            "Home",
            "Hot",
            "Humble",
            "Ideal",
            "Immature",
            "Innocent",
            "Killer",
            "King",
            "Leo",
            "Libra",
            "Makeup",
            "Me",
            "OOPS",
            "Open-minded",
            "Organized",
            "Perfect",
            "Pisces",
            "Proud",
            "Queen",
            "Sagittarius",
            "Stunning",
            "Shh",
            "Sassy",
            "Savage",
            "Scorpio",
            "Single",
            "Smile",
            "Selfie",
            "Survivor",
            "Taurus",
            "TGIF",
            "Thriving",
            "Truth",
            "Unique",
            "Vibes",
            "Virgo",
            "Wide-eyed",
            "Wild",
            "Witty",
            "Wondering",
            "Worried",
            "Workout",
            "Absolutely",
            "Awards",
            "Awarded",
            "Awesome",
            "Awesomeness",
            "Blessed",
            "Celebrate",
            "Celebration",
            "Cheers",
            "Effort",
            "Excellent",
            "Extraordinary",
            "Genius",
            "Goals",
            "Grateful",
            "Great",
            "Hustling",
            "Impressive",
            "Magic",
            "OMG",
            "Rewards",
            "Rewarding",
            "Speechless",
            "Splendid",
            "Star",
            "Success",
            "Terrific",
            "Toast",
            "TOP!",
            "Top-notch",
            "Un.be.livable",
            "Wonderful",
            "Winning",
            "Winner",
            "Wonderful",
            "Yay",
            "Alive",
            "Aloha",
            "B.E.A.C.H.",
            "Beauty",
            "Bucketlist",
            "Blessed",
            "BRB",
            "Break",
            "Breathtaking",
            "Bye",
            "Ciao",
            "Cooling",
            "Daytrip",
            "Desert",
            "Destination",
            "Escape",
            "Enjoy",
            "Exquisite",
            "Extraordinary",
            "Forest",
            "Go",
            "Happiness",
            "Heaven",
            "Horizon",
            "Jungle",
            "Lovely",
            "Mood",
            "Nature",
            "Night",
            "Nocturnal",
            "Ocean",
            "Paradise",
            "Peace",
            "Rainbow",
            "Relax",
            "Roadtrip",
            "Sunshine",
            "Sunset",
            "Sunrise",
            "Shellebrate",
            "Sea",
            "Sky",
            "Travel",
            "Trip",
            "Unforgettable",
            "Unwind",
            "Vacation",
            "Wanderlust",
            "World",
            "YOLO",
            "MOOD",
            "#Facts",
            "Inspo",
            "Vibes",
            "Fri-YAY",
            "Cozy",
            "*Eyeroll*",
            "BOOM.",
            "Adventures",
            "Daydreaming",
            "Goals",
            "Feastmode",
            "TBT",
            "OOO",
            "Exploring"
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
                        Intent i = new Intent(getActivity().getApplication(), DetailsOneword.class);
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
                        Intent i = new Intent(getActivity().getApplication(), DetailsOneword.class);
                        i.putExtra("Pos", pos);
                        startActivity(i);
                    }
                }
            });
            return convertView;
        }
    }
}