package com.captions.activity_fragments;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import com.captions.ConstantFile;

import com.captions.R;
import com.captions.others.SQLDatabaseFavorite;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class FavoriteInfomationActivity extends AppCompatActivity {

    TextView titletv, fulldetailstv, idtv;
    private Toolbar toolbar;

    private void setToolbar() {
        toolbar = (Toolbar) findViewById(R.id.anim_toolbar);
        if (toolbar != null) {
            toolbar.setTitle(R.string.app_name);
            setSupportActionBar(toolbar);
            toolbar.setNavigationIcon(R.mipmap.ic_back);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });

        }
    }

    private com.facebook.ads.InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_informartion);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        AdView aAdView;
        aAdView = findViewById(R.id.adViewfav);
        AdRequest adRequest = new AdRequest.Builder().build();
        aAdView.loadAd(adRequest);

//        if (ConstantFile.isActive_adMob == true) {
////            mAdView = (AdView) findViewById(R.id.adView);
////            AdRequest adRequest = new AdRequest.Builder().build();
////            mAdView.loadAd(adRequest);
//            if (ConstantFile.isActive_adMob) {
//                interstitialAd = new com.facebook.ads.InterstitialAd(this, ConstantFile.FB_INTRESTITIAL_AD_PUB_ID);
//                interstitialAd.loadAd();
//                    interstitialAd.setAdListener(new InterstitialAdListener() {
//                        @Override
//                        public void onInterstitialDisplayed(Ad ad) {
//
//                        }
//
//                        @Override
//                        public void onInterstitialDismissed(Ad ad) {
//                            interstitialAd = null;
//
//                        }
//
//                        @Override
//                        public void onError(Ad ad, AdError adError) {
//
//                        }
//
//                        @Override
//                        public void onAdLoaded(Ad ad) {
//                            interstitialAd.show();
//                        }
//
//                        @Override
//                        public void onAdClicked(Ad ad) {
//
//                        }
//
//                        @Override
//                        public void onLoggingImpression(Ad ad) {
//
//                        }
//                    });
//
//            }
//        }

        setToolbar();
        Intent intent = getIntent();
        String id = intent.getStringExtra("favorite_id1");
        String name = intent.getStringExtra("title");
        String listdata = intent.getStringExtra("favorite_data");

        idtv = (TextView) findViewById(R.id.idtv);
        titletv = (TextView) findViewById(R.id.titleTV);
        fulldetailstv = (TextView) findViewById(R.id.FullDetailsTv);
        idtv.setText(id);
        titletv.setText("Favourite Captions");
        titletv.setSelected(true);
        titletv.setSingleLine(true);
        fulldetailstv.setText(listdata);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_unfavorite, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent1 = getIntent();
        String id1 = intent1.getStringExtra("favorite_id1");

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;

            case R.id.FavoriteList:
                Toast.makeText(getApplication(), "Remove To Favorite list", Toast.LENGTH_LONG).show();
                SQLDatabaseFavorite database_favorite_list = new SQLDatabaseFavorite(FavoriteInfomationActivity.this);
                database_favorite_list.openDB();
                database_favorite_list.deletefavorite(Integer.parseInt(id1));
                database_favorite_list.closeDB();
                 finish();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        finish();
    }
}
