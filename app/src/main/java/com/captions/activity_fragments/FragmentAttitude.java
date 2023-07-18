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

public class FragmentAttitude extends Fragment {

    ListView Title_list;
    CardView card_view;
    public static String[] list_name1 = new String[]{
            "If there is no one to hold your hand put your hands in your pocket and continue your walk.",
            "Don’t Judge Yourself With Others Because You Are Different From Them.",
            "If you ever think I am ignoring you, I swear I am. My phone is in my hand 24×7",
            "Your attitude is like a price tag, it shows how valuable you are.",
            "Don’t be afraid of being outnumbered, eagles fly alone. Pigeons flock together.",
            "People understand you by your attitude. If your attitude is bad you are bad. If your attitude is good you are good…",
            "My status is already high….",
            "Roses are red skies are blue, out of my five fingers the middle one is for you.",
            "My life, my rule, that’s my attitude…",
            "Do you think I’m bad? Then you’re wrong. I am the worst.",
            "My choices are like fingerprints, they make me unique.",
            "Dear girls, keep your heels and standards always high…!!",
            "Sometimes I want to treat people how they treat me But I don’t because It’s out of my character.",
            "I am me and that’s all I can be…I’m not perfect and never wanted to be…but I am happy with who I am even with what people think of me and I’m great to be me",
            "Finally gotten completely back to myself again :)) hearts closed, minds on :))",
            "In the beginning, you’ll judge me, by the end, you’ll love me.",
            "If you don’t want me, don’t fuck with my feelings.",
            "Me + my room + music + internet connection + no study = A PERFECT DAY……",
            "You left without a reason, so please don't come back with an excuse.",
            "I am not your toy.",
            "EMOTIONS, so never advertise your FEELINGS, just display your ATTITUDE",
            "Never Love Someone at The Cost of Your Dignity and Self Respect…!!!",
            "I don’t treat people badly; I treat them accordingly.",
            "Sometimes patience has limits….",
            "Sometimes I need expert advice… So, I talk to myself.",
            "If someone tells you that you are ugly. well, just be nice and say. Excuse me. I'M NOT YOUR MIRROR.",
            "If you don’t like something, change it. If you can’t change it, change your attitude.",
            "If attitude kills…. I am the weapon of mass destruction….",
            "If your ego speaks with me then my attitude replies to you.",
            "I am who I am and I won't change for anyone.",
            "SINGLE is not a status. It is a word that best describes a person who is strong enough to live and enjoy life without depending on other",
            "Life is like Facebook. People will like your problems and comment, but no one will solve them because everyone else is too busy updating theirs. There is no market for your",
            "Just finished blocking some numbers on WhatsApp, if you can read this then you got lucky…!!!",
            "You treated me like an option, so I left you like a choice",
            "I love the ones who are in my life and make it amazing. I also love the ones who left my life and made it fantastic.",
            "I’ve had enough of trying to prove myself to people. Now I don’t care about what people think as long as I’m happy with myself!",
            "Don’t stress, do your best, forget the rest.",
            "It’s very easy to defeat someone, but it’s very hard to win someone.",
            "I'm a very private person. You don’t ask I don’t tell.",
            "Your attitude may hurt me, but mine can Kill You!!",
            "I’m born to express, not to impress.",
            "Take care of Your Status, don’t be caretaker of My Status",
            "There are two ways to be happy: Change your situation, or change your mindset towards it.",
            "I don’t care for people, who don’t care for me.",
            "The Man with Beard will never Look Weird",
            "I don’t have an attitude problem. You have a problem with my attitude and that is not my problem.",
            "Before you judge me, Make sure that you’re perfect.",
            "Beauty is only skin deep. Attitude is down to the bone.",
            "Always remember, you are bigger than your problems…….",
            "Beauty captures your attention, but personality captures your heart.",
            "OH, I am sorry it’s my fault that I forgot you are a true idiot.",
            "I am a hot dude with a cool attitude.",
            "It is wise to adopt a change in life.",
            "Time is precious, waste it wisely.",
            "When I was born. The devil said:” Oh Shit…!! Competition”.",
            "Boys are great, every girl should have one.",
            "The one who is reading my status…Back off 🤚!!",
            "80% of the boy have girlfriends. The rest 20% are having a brain.",
            "Attitude and knowledge are the best foundation of real beauty.",
            "Don’t hate me, just get to know me first!",
            "Mistakes are proof that you’re trying.",
            "I am a winner which makes me a true competitor.",
            "We come from God but attitude is from the devil 👿.",
            "Follow your heart but don’t be stupid.",
            "I’m Not Special, I’m Just Limited Edition.",
            "I am not bad; I am worst in the kind 🦄.",
            "Losers always complain while champions train 💪",
            "My attitude based on how you treat me.",
            "Never bend your head. Always hold it high. Look the world straight in the eye.",
            "I love my job only when I’m on vacation.",
            "Always trying to cool my self",
            "Boys never realize how much one little thing can hurt a girl.",
            "A naughty thought a day keeps the stress away.",
            "I’m not lazy, I’m just on my energy saving mode.",
            "Guys have no idea how long something they said can stay in a girl’s mind.",
            "Never complain or adopt the habit to whine over small things and never ever justify yourself.",
            "Don’t try to mess with me because you will see different aspects of my great personality.",
            "I forgive but I never forget.",
            "Forget the haters…cause somebody loves you",
            "It’s simple. Love me for who I am not what you want me to be.",
            "I never make the same mistake twice. I make it five or six times, just to be sure.",
            "I never insult people I tell them what they actually are 👉.",
            "Little goals will make you expect little achievements so think big to win big success.",
            "The best thing about being me, I’m a limited edition and there are no other copies!",
            "Boys who don’t have a girlfriend surely have a brain.",
            "My Life My Rules.",
            "Smartness is a perfect beauty.",
            "Never argue with a fool or an idiot otherwise you will be known one of them.",
            "Always set the goals high 🎯 and don’t drop until you get the desired result 😎.",
            "My attitude is based on your behavior 😎.",
            "It’s my life, so keep your nose out of it.",
            "I need someone who sees the fire in my eyes and wants to play with it.",
            "Follow the rule of the sun 🌞. Shine and let the world burn 😎.",
            "Display your character with class and pride.",
            "Men hang out in bars for one of two reasons: Either they have no wife to go home to, or they do.",
            "Boys lie more, but girls lie better.",
            "I like to stay focused, chase my dreams, and move towards my aim and destiny 💪.",
            "Fashion is about something that comes from within you.",
            "I don’t have an attitude! Just a personality that you can’t handle!",
            "If you want me to control my temper, so control your stupidity.",
            "What I stand for is what I stand on 😎",
            "Only a champion is afraid of losing.",
            "Boys like me belonged to rain. 😎",
            "My determination is higher than my smartness.",
            "Do not call me nerdy or geeky because of glasses. It’s just I have beautiful eyes.",
            "My Girlfriend says I need to be more affectionate…Now I have 2 Girlfriends!",
            "Champions always try and play until they get it right 🏆",
            "It’s not my attitude, It’s my style.",
            "People with status don’t need status.",
            "ATTITUDE is everything.",
            "I am the architect of my own fate 🎯 and captain of my soul.",
            "Be silent and let your success shout.",
            "A break up in a relationship is like a mirror that is broken. It’s better to leave it the way it is than hurt yourself for fixing it.",
            "Do not meet your enemy with an angry face. Instead, rise and greet them with your smiling face. Nothing is more insulting than seeing your enemy happy and without a care.",
            "Some people live in the business of minding the business of other people.",
            "Being alone is better than being in a relationship with somebody who can fill the heart with doubt.",
            "When I loved you, I loved you very much that I never imagined hating you. But now that I abhor you, I hate you very much that I can never imagine loving you again.",
            "The secret to my happiness is expecting nothing from no one.",
            "A relationship is just made for two, but a few forget how to count.",
            "The words coming out of my mouth are all of me – unfiltered, raw, and real. Love it or hate it, it’s up to you.",
            "Everyone is unique in their own little ways.",
            "All this time, our relationship and my life focused on YOU and JUST YOU. I’ve had enough, and it is the right time that I start concentrating on ME and JUST ME.",
            "Albeit we’re breaking up, I’ll never hate the love that we formerly had. After all, it is not the fault of love that you never embraced the best and always marked the bad.",
            "Often, people who think highly of themselves are the ones who fall below than they can imagine.",
            "The way I deal with you is the reflection of the way you deal with me.",
            "If you intend to fool and play with my heart, you are making a big mistake. Pain has cast iron around the fences of my heart.",
            "It is better to be single than being with somebody who makes you feel alone.",
            "My attitude with love is simple – I do what I love and love will find me along the way.",
            "The pain that love has dealt with my heart forced me to grow up.",
            "I’m sorry that I can’t be the kind of person you can disrespect, manipulate, and twist around your fingers. I prefer that we finish things here and now and go our own separate ways.",
            "Everyone says winner never quits and not to renounce… But when I gave up on you, I won masses…",
            "Along the way, I will stumble a hundred times but I will get back up to my feet a hundred and more.",
            "Don’t anticipate me to tell you why I’m breaking up with you. Just like how you never informed me why you never got around for accepting me as a person I am.",
            "If you want to improve your life, start working on your attitude first.",
            "I’d rather be single and happy than be in a relationship and miserable.",
            "Your attitude screams about the bursting colors of your soul and the rhythm of your heart without the need for any words.",
            "You won’t find anyone like me. That’s why I call myself ‘limited edition’.",
            "I may not be perfect but I am one of a kind.",
            "At times, breakups are like bitter pills that heal you from toxic relationships.",
            "Let people think what they want to think about you. It’s none of your business anyway.",
            "Those whose head is above the clouds, with egos as high as towers are the ones who fall hard in the lowest depths of greed and shame.",
            "A few individuals do not realize what they tossed away until it is too late, and they cannot retrieve it.",
            "True love comes in all sizes and shapes except one – YOU.",
            "In love, if you fall easily on your knees, you will never win your happy ending.",
            "Relationships are extremely simple. They’re just two things that can come about. You either get married or break up.",
            "Attitude is the mirror of your entire being.",
            "Relationships are like fantastic road trips. Sit back and enjoy the stunning views in place of complaining about the potholes and the bumps.",
            "Do you acquaint why a preceding relationship is called ex? It is not the terminology for the past. It is a short form of Expired.",
            "I don’t have time to dwell in pain because I am too busy enjoying the things that make me happy."
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
                        Intent i = new Intent(getActivity().getApplication(), DetailsAttitude.class);
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
                        Intent i = new Intent(getActivity().getApplication(), DetailsAttitude.class);
                        i.putExtra("Pos", pos);
                        startActivity(i);
                    }
                }
            });
            return convertView;
        }
    }
}