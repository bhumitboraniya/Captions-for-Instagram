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

public class FragmentBestFriends extends Fragment {

    ListView Title_list;
    CardView card_view;
    public static String[] list_name1 = new String[]{
            "God made us best friends because He knew our moms couldn’t handle us as sisters.",
            "When I say I won’t tell anyone, my best friend doesn’t count.",
            "You are my best friend because I wouldn’t dare be this weird with anyone else.",
            "Strangers think I’m quiet, my friends think I’m outgoing, but my best friends know that I’m completely insane.",
            "Friends knock on the door. Best friends walk into your house and start eating.",
            "We all have that one friend who never learned how to whisper.",
            "Only trust someone who can see these three things: the sorrow behind your smile, the love behind your anger, and the reason behind your silence.",
            "You know who your real friends are when you pull away from them and see who wonders why you are pulling away.",
            "Some people talk to you in their free time and some people free their time to talk to you.",
            "It’s not about who’s real to your face, it’s about who stays real behind your back.",
            "You might not always be next to me, but I know you’ll always have my back.",
            "You’ll know the people who feed your soul because you’ll feel good after spending time with them.",
            "As we grow up, we realize it’s less important to have a ton of friends and more important to have real ones.",
            "Hard times will always reveal true friends.",
            "Real isn’t who’s with you at your celebration; real is who’s standing next to you at rock bottom.",
            "The only people I owe my loyalty to are those who never made me question theirs.",
            "You should never have to think twice about who your real friends are.",
            "Fake friends believe in rumors; real friends believe in you.",
            "If someone seriously wants to be part of your life, they will make an effort to be in it. No reasons. No excuses.",
            "Be with those who bring out the best, not the stress, in you.",
            "A friend is someone who can see the truth and pain in you, even when you’re fooling everyone else.",
            "Friends don’t leave their friends for other people.",
            "No matter how big the crowd, I’ll always be able to find you.",
            "Real friends don’t tell you pretty lies. They tell you the ugly truth.",
            "Side by side or miles apart, real friends are always close to the heart.",
            "Nothing makes the earth seem so spacious as to have friends at a distance; they make the latitudes and longitudes.",
            "The most memorable people in life will be the friends who loved you when you weren’t very lovable.",
            "F.R.I.E.N.D.S: Fight for you. Respect you. Include you. Encourage you. Need you. Deserve you. Stand by you.",
            "A friend is one who overlooks your broken fence and admires the flowers in your garden.",
            "We will always be best friends until we are old and senile. Then we can be new friends.",
            "True friends don’t judge each other. They judge other people together.",
            "Best friends don’t care if your house is clean. They care if you have wine.",
            "When my best friend and I first met, we were both like, “You’re really weird.”",
            "I hope we’re friends until we die. Then, I hope we stay ghost friends so we can walk through walls and scare people.",
            "Just remember, if we get caught, you’re deaf and I don’t speak English.",
            "We’ll be the old ladies causing trouble in the nursing home.",
            "Friends come and go like waves of the ocean, but the true ones stick like an octopus on your face.",
            "Friends never ask for food. Best friends are the reason you have no food.",
            "A good friend knows how you take your coffee. A great friend adds booze.",
            "Friendship is finding that special someone you can enjoy being a dumbass with.",
            "If I send you my ugly selfies, our friendship is real.",
            "Life is too short to be serious all the time. So, if you can’t laugh at yourself, call me—I’ll laugh at you.",
            "Never let your friends feel lonely… disturb them all the time.",
            "Real friendship is when your friend comes over to your house just take a nap.",
            "I love that I don’t have to act socially acceptable around you.",
            "If you aren’t somewhat crazy in the head, I’m afraid we can’t be friends.",
            "If you don’t own matching shirts, are you really friends?",
            "Friends ‘till the end.",
            "A true friend is one soul in two bodies.",
            "Your vibe attracts your tribe.",
            "Friends don’t let friends do silly things alone.",
            "I’ll even send you the photos I look bad in.",
            "Besides chocolate, you’re my favorite.",
            "Love is beautiful, friendship is better",
            "Every girl needs a boy best friend.",
            "No friendship is an accident.",
            "I love my crazy best friends.",
            "Life is better with true friends.",
            "Friends become our chosen family!",
            "Live for the moments you can’t put in words.",
            "Good Times + Crazy Friends = Great Memories!",
            "Life was meant for best friends and good adventures!",
            "I don’t know what I did to deserve a best friend like you.",
            "Meet my Partner in Crime!",
            "Forever and Always.",
            "Rain or Shine.",
            "You are my sunshine on a rainy day.",
            "You drive me crazy, but I love it.",
            "Best friend? Nah. She’s my sister.",
            "Life’s too short and so are we.",
            "You’re the Betty to my Veronica.",
            "Always better together.",
            "Victoria’s Secret models, we comin’ for your careers.",
            "We don’t see any competition.",
            "Real queens fix each other’s crowns.",
            "The sunshines of my life.",
            "Pizza and you are all I need.",
            "On our worst behavior.",
            "Let’s wander.",
            "The bags under our eyes are Gucci",
            "Reality called, school’s back, so we hung up.",
            "And so the adventure begins…",
            "You CAN sit with us.",
            "Friends who slay together, stay together.",
            "A girl can survive without a boyfriend, but she can’t survive without a best friend.",
            "One friend can change your whole life. I know (name) did.",
            "When it hurts to look back and you’re afraid to look ahead, you can look beside you and your best friend will be there.",
            "You are my best friend, my human diary, and my other half. You mean the world to me and I love you.",
            "Best friends believe in you when you don’t believe in yourself.",
            "A good friend knows all your stories. A best friend helped you write them.",
            "Best friends are the people in your life that make you laugh louder, smile brighter, and live better.",
            "Sometimes being with your best friend is all the therapy you need.",
            "A best friend is someone who loves you when you forget to love yourself.",
            "Friends come and go. Best friends will always find their way back.",
            "Best friends are the people you can do anything and nothing with and still have the best time.",
            "A best friend is like a four-leafed clover: hard to find and lucky to have.",
            "Friends listen to what you say. Best friends listen to what you don’t say.",
            "Best friends are those who share your problems so you don’t have to go through them alone.",
            "Friends pick us up when we fall down, and if they can’t pick us up they lie down and listen for awhile.",
            "Real friends get respected, treated, and loved like family.",
            "Frankly, I can’t imagine not being around someone as amazing as you.",
            "Best friend: one million memories, ten thousand inside jokes, one hundred shared secrets.",
            "Nothing could ever replace my best friend.",
            "True friendship is not about being inseparable—it is being separated and finding nothing changes.",
            "Time and good friends are two things that become more valuable the older you get.",
            "Good friends show their love in times of trouble, not just in times of happiness.",
            "Friendship isn’t a big thing, it’s a million little things.",
            "Someday, you’ll need some support in your life, and I promise I’ll be right by your side.",
            "Friends until the very end—and then some."
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
                        Intent i = new Intent(getActivity().getApplication(), DetailsBestFriends.class);
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
                        Intent i = new Intent(getActivity().getApplication(), DetailsBestFriends.class);
                        i.putExtra("Pos", pos);
                        startActivity(i);
                    }
                }
            });
            return convertView;
        }
    }
}