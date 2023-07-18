package com.captions.activity_fragments;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.facebook.ads.BuildConfig;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;


import com.captions.ConstantFile;
import com.captions.R;

public class MainActivity extends AppCompatActivity {

    TabLayout mTabLayout;
    ViewPager mViewPager;
    ViewPagerAdapter mAdapter;
    private Toolbar toolbar;
    private AdView adView;


    private void setToolbar() {
        toolbar = (Toolbar) findViewById(R.id.anim_toolbar);
        if (toolbar != null) {
            toolbar.setTitle(R.string.app_name);
            setSupportActionBar(toolbar);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        com.google.android.gms.ads.AdView aAdView;
        aAdView = findViewById(R.id.adViewmain);
        AdRequest adRequest = new AdRequest.Builder().build();
        aAdView.loadAd(adRequest);

        if (ConstantFile.isActive_adMob == true) {
            RelativeLayout adViewContainer = (RelativeLayout) findViewById(R.id.adViewContainer);
            adView = new AdView(this, ConstantFile.FB_BANNER_PUB_ID, AdSize.BANNER_320_50);
            adViewContainer.addView(adView);
            adView.loadAd();
        }

        setToolbar();
        findViews();
        setUpViews();
    }

    private void findViews() {

        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
    }


    private void setUpViews() {

        mAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setOffscreenPageLimit(mAdapter.getCount());
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }


    private class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:

                FragmentBestFriends fragmentBestFriends = new FragmentBestFriends();
                return fragmentBestFriends;
                case 1:
                    FragmentFunnyy fragment_home = new FragmentFunnyy();
                    return fragment_home;
                case 2:
                    FragmentCool fragmentCool = new FragmentCool();
                    return fragmentCool;
                case 3:
                    FragmentLyrics fragmentLyrics = new FragmentLyrics();
                    return fragmentLyrics;

                case 4:
                    FragmentSummer fragmentSummer = new FragmentSummer();
                    return fragmentSummer;

                case 5:

                FragmentAttitude fragmentAttitude = new FragmentAttitude();
                return fragmentAttitude;

                case 6:
                    FragmentCouples fragmentCouples = new FragmentCouples();
                    return fragmentCouples;

                case 7:
                    FragmentBirthday fragmentBirthday = new FragmentBirthday();
                    return fragmentBirthday;

                case 8:
                    FragmentOneword fragmentOneword = new FragmentOneword();
                    return fragmentOneword;

                case 9:
                    FragmentGirl fragmentGirl = new FragmentGirl();
                    return fragmentGirl;

                case 10:
                    Fragmentfavorite fragment_favorite = new Fragmentfavorite();
                    return fragment_favorite;

            }

            return null;
        }

        @Override
        public int getCount() {
            return 11;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "BEST FRIENDS";
                case 1:
                    return "FUNNY";

                case 2:
                    return "COOl";
                case 3:
                    return "LYRICS";
                case 4:
                    return "SUMMER";
                case 5:
                    return "Attitude";
                case 6:
                    return "LOVE";

                case 7:
                    return "BIRTHDAY";

                case 8:
                    return "ONE WORD";

                case 9:
                    return "FOR GIRLS";

                case 10:
                    int unicode = 0x2764;
                    return new String(Character.toChars(unicode));

            }
            return null;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;

            case R.id.rate_us:
//                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName())));

                try
                {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id="+getPackageName())));
                }
                catch(ActivityNotFoundException e)
                {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id="+getPackageName())));
                }

                return true;
            case R.id.share_app:
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                String shareMessage = "\n This App Provide Best Captions For Your Photo Download Now  \n\n";
                shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + getPackageName() + "\n\n";
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                startActivity(Intent.createChooser(shareIntent, "choose one"));
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
