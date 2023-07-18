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

public class FragmentGirl extends Fragment {

    ListView Title_list;
    CardView card_view;
    public static String[] list_name1 = new String[]{
            "Happy people are always beautiful.",
            "Take time to make your soul happy.",
            "Keep the smile on!",
            "If it makes you happy, do it a thousand and one times.",
            "Remember that there is never a shortage of beautiful reasons to be happy.",
            "Have the courage to be happy.",
            "Oh happy day.",
            "You decide your own happiness, so be happy as you want to.",
            "Studies suggest that the happier someone is, the more attractive they become.",
            "Smiles attract happiness like a magnet.",
            "Enjoying life as it is.",
            "Happy girls are the prettiest.",
            "You’re Never Completely Dressed Without A Smile.",
            "A smile never goes out of style.",
            "Be your own reason for your happiness.",
            "Look beyond all the imperfections and you’ll get a glimpse of happiness.",
            "Happy thoughts, happy life.",
            "It’s magical how happy you become once you make someone else happy.",
            "For every minute of unhappiness, you lose sixty seconds of happiness.",
            "If someone makes you happy, make them happier.",
            "Happy Girls Shine More.",
            "A Smile Is An Adorable Thing You Can Wear On.",
            "Happiness makes you glow better.",
            "Think of happiness as your default state, and you’ll be happier than ever.",
            "Happy is the new rich.",
            "A Smile Is The Most Beautiful Curve On A Woman’s Body.",
            "People often don’t realize that happiness doesn’t live in any one address. Happiness is actually everywhere!",
            "Beauty never asks for Attention.",
            "Braless is flawless.",
            "50% savage, 50% hotness",
            "Black as the devil, hot as hell, pure as an angel & sweet as love.",
            "Take off that shyness and wear some red.",
            "Wake up, workout, look hot.",
            "I am 99% angel, but oh, that 1%…",
            "Be your own kind of beautiful.",
            "Nothing is sexier than a girl who knows how to take control.",
            "Darling, I’m a nightmare, dressed like a daydream.",
            "Yes, I’m sexy and I know it.",
            "Be the badass with sexy ass.",
            "Take a ride on my energy.",
            "I’m not trying to be sexy, it’s just way of expressing myself when I move around.",
            "The best way to start my day is with our lips pressed together.",
            "Sexy doesn’t have to come with a price tag of being dumb.",
            "My lips are the gun. Smile is the trigger. My kisses are the bullets. Label me a killer.",
            "My Self Worth Is Not Determined By Others.",
            "Confidence Is True Beauty.",
            "I Am The Mixture Of A Cutie With A Mission And Hottie With An Ambition.",
            "No matter what a woman looks like, if she’s confident, she’s sexy.",
            "Be who you want to be and not what others want to see.",
            "I am the princess of my own Fairy Tale.",
            "I Am Sugar And Spice And Everything Nice, But If You Wanna Mess With Me, You Better Think Twice.",
            "Don’t Be Queen Waiting For A King. Be A Queen Busy With Her Kingdom Until Her King Arrives.",
            "There is a wolf in every girl.",
            "I did not dress this body up to come and waste it here.",
            "Brains make a woman classy.",
            "The few times I rule the world, they have to make everyone know.",
            "Imperfection is beauty, madness is genius, and it’s better to be absolutely ridiculous than absolutely boring.",
            "Strong women don’t have attitudes. They have standards.",
            "There is always a wild side to an innocent face.",
            "My attitude is inversely proportional to my height.",
            "I give my heart to whomever I want, that is why it is mine.",
            "I am the coolest devil at home.",
            "I come as a package, no room for trials.",
            "If it requires smiling, I probably won’t come.",
            "I feel like my attitude has an attitude of itself.",
            "Yeah, I’m single. And you’ll have to be amazing to change that.",
            "There’s always a wild side to an innocent face.",
            "No girl is me. She may be cute, but she is not me.",
            "People say I act like I don’t care. I’m not acting.",
            "I always laugh when people try to hurt my feelings. As if I have any.",
            "A smiling girl is the CEO of her own world.",
            "The world has a red carpet for any girl who is determined.",
            "Self-love is the greatest middle finger of all time.",
            "Like flowers, every girl has her season to blossom.",
            "There is a reason to live for the moment because tomorrow is just a promise.",
            "When life throws a rock at you, throw back a brick.",
            "A like in the morning will turn you into a legend by evening.",
            "Fake is a new trend and everyone seems to be in style.",
            "Be your own kind of beautiful.",
            "You are not gonna tell me who I m.",
            "Boys are like purses, cute, full of crap, and can always be replaced.",
            "You are magic, Don’t ever apologize for the fire in you.",
            "I am cool but global warming made me hot.",
            "Don’t show me your attitude as you can’t handle me.",
            "Do you hate me? I don’t care.",
            "There is a star high up for every girl, waiting for you to lift up your head.",
            "A woman has as many lives as her shoes.",
            "You are only down in order to build a foundation.",
            "Face the world with a smile, it will give up and smile back.",
            "I am who I am, Your approval is not needed.",
            "Beautiful girls rise with the sun every morning, to create new and beautiful memories.",
            "Don’t be like the rest of them.",
            "Women do not marry because they do not need anyone to advise them.",
            "I only need a smile to turn around a bad day.",
            "I may not be the best, but I know that I’m not like rest.",
            "I dress to impress myself.",
            "Punch as hard as you wish, I got a pile of makeup to seal any crack.",
            "People say I act like I don’t care. It’s not an act.",
            "I am unique.",
            "A woman is like a teabag, you will never know her strength until you put her in hot water.",
            "Heels will allow you to see far.",
            "Love me or hate me I’m still gonna shine.",
            "Don’t be ashamed of how someone else sees you. Be proud of who you are and what you are",
            "I literally have to remind myself all the time that being afraid of things going wrong isn't the way to make things go right.",
            "Dope days, chill nights, good company, and mellow vibes.",
            "Lighten up, just enjoy life. Smile more, laugh more, and don’t get so worked up about things.",
            "Do you know what true happiness is? Getting both your hair and makeup perfect at the same time",
            "Chin up, heads high – and you’re ready to conquer the world",
            "Happiness is having a bunch of freaking awesome and crazy friends.",
            "Why don’t scientists trust atoms? Because they make up everything.",
            "Be brave, be kind, be you.",
            "Walking with a friend in the dark is better than walking alone in the light.",
            "Real girls are never perfect and perfect girls are not real.",
            "Don’t walk behind me; I may not lead. Don’t walk in front of me; I may not follow. Just walk beside me and be my friend.",
            "My boyfriend says my mood swings are hard to understand. Well, hello! They’re not as hard as quantum physics",
            "Who’s that beauty queen? Oops! I clicked on my profile picture again",
            "According to research, chubby women live longer than men who mention it",
            "Why am I late? My nail polishes had to dry first",
            "NASA just announced that it is safe to eat without posting it on Instagram.",
            "I like to hang out with people who make me forget to look at my phone.",
            "Always remember you’re unique, just like everyone else.",
            "You only live once, but if you do it right, once is enough.",
            "You have to be ODD, to be number ONE.",
            "Your crowd should be clapping loudest when you win. If they don’t, look for a new crowd.",
            "You can’t pour from an empty cup. Take care of yourself first.",
            "Oh, I’m sorry. I forgot I only exist when you need something.",
            "There’s a fire in every woman. Love her and she’ll make your home warm. Hurt her, and she’ll burn it to ashes",
            "I need a vacation so long, I forget all my passwords!",
            "May your day be as good as taking a perfect selfie on the first try.",
            "Tell me not to do something and I will do it twice and take pictures.",
            "Behind every successful women is herself.",
            "Be proud of who you are, and not ashamed of how someone else sees you.",
            "I’m not beautiful like you. I’m beautiful like me.",
            "I’m no beauty queen, I’m just beautiful me.",
            "The world has a red carpet for any girl who is determined.",
            "Self-love is the greatest middle finger of all time.",
            "If you are confident, You are beautiful.",
            "Confidence is the ability to feel Beautiful, without needing someone to tell you.",
            "Beauty begins the moment you decided to be yourself.",
            "The most beautiful thing a woman can wear is confidence.",
            "Don’t forget to fall in love with yourself first.",
            "A wise girl knows her limits, a smart girl knows that she has none.",
            "You may see me struggle, but you’ll never see me quit.",
            "Be yourself there is no one better.",
            "Quit trying to fix me, I am not broken.",
            "Some call it arrogant, I call it confident.",
            "What others think of me is none of my business.",
            "Love me or hate me either way I’m gonna shine.",
            "I think beautiful is like you take care of yourself.",
            "Nothing makes a woman more beautiful than the belief that she is beautiful.",
            "Remind yourself that you cannot fail at being yourself.",
            "Be your own reason to smile.",
            "When I feel a little down, I put on my favorite high heels and dance.",
            "Know your worth.",
            "I’m not short, I’m concentrated awesome!",
            "Never a failure, always a lesson.",
            "My self worth is not determined by others.",
            "Love your haters, they’re your biggest fans.",
            "Be yourself because an original is worth more than a copy.",
            "A girl should be like a butterfly. Pretty to see, hard to catch.",
            "Sometimes you gotta be a beauty and a beast!",
            "Love me or hate me either way I’m gonna shine.",
            "I’m not short, I’m concentrated awesome!",
            "Money can’t buy happiness. But it can buy Makeup!",
            "Sometimes I pretend to be normal. But it gets boring. So I go back to being.",
            "Be so good they can’t ignore you.",
            "Born to express, not to impress.",
            "Embrace the glorious mess that you are.",
            "Lift up your head princess, if not the crown falls.",
            "Weekend, please don’t leave me.",
            "Be your own kind of beautiful.",
            "I love it when I catch you looking at me.",
            "My favorite place is inside your hug.",
            "My boyfriend still thinks my eyelashes are real. I guess we all have secrets, Don’t we?",
            "My hobbies are breakfast, lunch, and dinner.",
            "Cinderella never asked for a prince.",
            "Talking to you makes my day.",
            "The way you make me feel I love that feeling.",
            "I need vitamin u.",
            "Sunday FUNDAY.",
            "Sometimes it’s the princess who kills the dragon and saves the prince.",
            "All I need is Coffee and Mascara.",
            "Smile, it’s free therapy.",
            "I love the confidence that makeup gives me.",
            "Create your own magic.",
            "Behind every successful woman is herself.",
            "Be Who You Want To Be And Not What Others Want To See.",
            "No matter how you’re feeling: Go get up, Dress up, Show up and Never you dare to give up.",
            "Life Is Not Perfect, But My Hair Is!",
            "Keep Your Heels And Standards High.",
            "Dress To Impress.",
            "I have fallen in love with the confidence that makeup brings in me.",
            "Be a diamond esteemed and rare, not a stone found everywhere.",
            "Happiness Is..new Cosmetics, Many Of Them.",
            "Don’t Forget To Fall In Love With Yourself First.",
            "Don’t Believe Me When I Say I Will Be Ready In 2 Minutes.",
            "Beauty Begins The Moment You Decided To Be Yourself.",
            "Surround yourself with makeup, not negativity.",
            "I’m No Beauty Queen, I’m Just Beautiful Me.",
            "Real beauty never asks for attention.",
            "So Many Nail Polishes, Not Enough Fingers.",
            "I Know Looks Are Not Everything But I Have Them Just In Case.",
            "Elegance is the only beauty that never fades.",
            "It’s Better To Arrive Late Than To Arrive Ugly.",
            "Curls Run The World.",
            "Cute Girls Can Never Be Overdressed.",
            "Being stylish is about enjoying your life and expressing yourself and your inner light.",
            "Makeup Is Art. Beauty Is Passion.",
            "Life is too short to wear any boring clothes.",
            "The beauty of a woman must be seen from in her eyes because that is the doorway to her heart, the place where love resides.",
            "I Run On Coffee, Sarcasm, And Lipstick.",
            "With A Good Makeup Brush, Every Woman Can Be An Artist.",
            "Confidence Level: Selfie with no Filter.",
            "This is the most magical pic of your life.",
            "Dream without fear, love without limits.",
            "Sending my selfie to NASA, because I’m a star.",
            "Warning – You might fall in love with me.",
            "I am not trying to be cool, It’s what I am.",
            "Sparkle every single day.",
            "Wakeup and makeup",
            "Be happy; it drives people crazy.",
            "I did NOT wake up like this.",
            "The sky above me, earth below me & fire within me.",
            "Live for the moments you can’t put into words.",
            "I love looking in the mirror and feeling good about what I see.",
            "I was born to stand out.",
            "Classy & Fabulous",
            "A selfie a day keeps the doctor away!",
            "Smile, breathe and go slowly.",
            "You only live once, but if you do it right, once is enough.",
            "Crazy hair, don’t care.",
            "You cannot do EPIC shit with basic people.",
            "Be yourself, there’s no one better.",
            "Being part of this group is so much fun, I love it.",
            "Life is better when you’re laughing.",
            "If I send you ugly selfies, our friendship is real.",
            "I just got 30 likes, #selfiepro",
            "Normal is boring for me.",
            "Surround yourself with those who make you happy.",
            "Moments like these…This is what we live for, this is why we exist.",
            "I’m in desperate need of a 6-month vacation…twice a year.",
            "I’m on a seafood diet. When I see food, I eat it. Happy girls are the prettiest.",
            "Every woman is an angel, you only need to take her to heaven.",
            "I am dating anyone who hearts my status, that is what the hearts are meant for.",
            "I’m not short, I’m concentrated awesome!",
            "Catch flights, not feelings.",
            "The most beautiful woman is one who puts on a smile as her makeup every morning.",
            "God looked at the boring hairstyle of Adam and said, “Let’s create someone with a more creative head”.",
            "If you got eyes, look at me now.",
            "My bed is a magical place, I suddenly remember everything I forgot to do.",
            "When life gives you lemons, use them to make your skin glow.",
            "Believe in pink.",
            "There is nothing so serious about life, we are here to eat, look beautiful then die.",
            "I am not fat. I’m just much easier to see.",
            "The main reason Santa is so jolly is because he knows where all the bad girls live.",
            "Happiness is a new lipstick.",
            "Women have many faces, depending on who is looking.",
            "Behind every successful woman are her dreams to rule the world.",
            "Leave a little sparkle wherever you go.",
            "Inner beauty needs no makeup.",
            "Be You Till Full.",
            "If your dreams appear impossible, there is a wrong man in your life.",
            "No matter how you feel, get up, dress up, show up and never give up.",
            "So many nail polishes, not enough fingers.",
            "Have courage and be kind.",
            "Life is short to those with no makeup.",
            "All I need is coffee & mascara.",
            "The most beautiful hair is a brilliant mind.",
            "Women are never fat, it is their love that grows from within.",
            "Good girls go to heaven when they die only to find that all handsome angels are taken by beautiful girls.",
            "Speak english. Kiss french. Dress italian. Spend arab. Party caribbean.",
            "God is really creative, I mean just look at me.",
            "Curls run the world.",
            "Smile. Sparkle. Shine.",
            "I’m that quiet girl who is absolutely insane with her friends.",
            "Cute but psycho, yet cute.",
            "The most beautiful curve on a woman’s body is her smile.",
            "The purity of heart and sincerity in a smile.",
            "I don’t know whether love brings happiness or sadness, but it definitely brings something called ‘CHANGE.’",
            "Smile in the mirror. Do that every morning and you’ll start to see a big difference in your life.",
            "The most beautiful woman is one who puts on a smile as her makeup every morning.",
            "If you don’t have a smile, I’ll give you one of mine.!",
            "Never love anyone who treats you like you’re ordinary.",
            "A smile is an inexpensive way to change your looks.",
            "I’m a sweet girl. But honey, make me mad, and only God can save you",
            "I’m an odd combination of REALLY SWEET and DON’T MESS WITH ME!!!",
            "Keep smiling because life’s a beautiful thing and there’s so much to smile about.",
            "They say that good things take time, but really great things happen in the blink of an eye.",
            "Sometimes I pretend to be normal. But it gets boring. So I go back to being.",
            "Some girls are just born with glitter in their veins.",
            "If there were an award for being lazy, I would definitely send someone to get it for me",
            "I try to be a nice person, but sometimes my mouth doesn’t want to cooperate!",
            "A smile is the most beautiful curve on a woman’s body.",
            "I love it when I catch you looking at me.",
            "Twinkle, Twinkle little star, Brave & Beautiful is what you are.",
            "If people call me cute, I am happier.",
            "When you’re downie eat a brownie.",
            "It's better to be happy alone than unhappy with someone.",
            "I restore myself when I’m alone.",
            "I need some time alone with myself.",
            "When we truly realize that we are all alone is when we need others the most.",
            "Don't feel alone, because there is always someone out there who loves you more than you can imagine.",
            "The best part about being alone is that you really don't have to answer to anybody. You do what you want. ",
            "Learn to be alone, not everyone will stay forever.",
            "Maybe I should learn not to get toon attached.",
            "It’s hard to forget someone that gave you so much to remember.",
            "Sometimes its better to be alone, no one can hurt you that way.  ",
            "You cannot be lonely if you like the person you're alone with.",
            "Never lose your hope even if you are alone.",
            "Emptiness feels so heavy.",
            "I’m simple to understand. Like quantum physics.",
            "I used to think that the worst thing in life was to end up all alone. It's not. The worst thing in life is ending up with people who make you feel all alone.",
            "If you are afraid of being lonely, don't try to be right.",
            "I miss your smile but I miss my own more.",
            "Time changes everyone.",
            "Sometimes you have to stand alone just to make sure you still can.",
            "Boys are like purses, cute, full of crap, and can always be replaced.",
            "I love to be alone.",
            "Loneliness adds beauty to life. It puts a special burn on sunsets and makes night air smell better.",
            "As I get older I'm more and more comfortable being alone.    ",
            "Never be afraid to sit awhile and think.  ",
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
                        Intent i = new Intent(getActivity().getApplication(), DetailsGirl.class);
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
                        Intent i = new Intent(getActivity().getApplication(), DetailsGirl.class);
                        i.putExtra("Pos", pos);
                        startActivity(i);
                    }
                }
            });
            return convertView;
        }
    }
}