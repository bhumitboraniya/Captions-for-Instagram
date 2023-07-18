package com.captions.activity_fragments;

import static com.captions.DataStoreInString.Answer;
import static com.captions.DataStoreInString.BestFriends;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.captions.ConstantFile;
import com.captions.DataStoreInString;
import com.captions.R;
import com.captions.others.SQLDatabaseFavorite;

public class DetailsBestFriends extends AppCompatActivity {

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

    ViewPager viewPager;
    int pos, adfav, adcopy;
    TextView txt_page_index;
    LinearLayout copybtn, sharebtn, prevbtn, nextbtn;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("SEE_YOUR_LOGCAT_TO_GET_YOUR_DEVICE_ID")
                .build();

        mInterstitialAd.loadAd(adRequest);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_deatails);
        mInterstitialAd = new InterstitialAd(this);

        if (ConstantFile.isActive_adMob == true) {
            mAdView = (AdView) findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);

            mInterstitialAd = new InterstitialAd(this);
            mInterstitialAd.setAdUnitId(getString(R.string.admob_interstitial));
            mInterstitialAd.setAdListener(new com.google.android.gms.ads.AdListener() {
                @Override
                public void onAdClosed() {
                    if (adfav == 1) {
                        int tab = viewPager.getCurrentItem();
                        Toast.makeText(getApplication(), "Add To Favorite List", Toast.LENGTH_LONG).show();
                        SQLDatabaseFavorite database_favorite_list1 = new SQLDatabaseFavorite(DetailsBestFriends.this);
                        database_favorite_list1.openDB();
                        database_favorite_list1.insertfavorite(FragmentCool.list_name1[tab], DataStoreInString.pages[tab]);
                        database_favorite_list1.closeDB();
                        requestNewInterstitial();

                    }
                    if (adcopy == 2) {
                        int tab = viewPager.getCurrentItem();
                        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                        ClipData clip = ClipData.newPlainText("FullDetailsTv", DataStoreInString.pages[tab]);
                        Toast.makeText(getApplicationContext(), "Text Is Copied To clipboard ", Toast.LENGTH_LONG).show();
                        clipboard.setPrimaryClip(clip);
                        requestNewInterstitial();

                    }
                }

            });
            requestNewInterstitial();

        }
        setToolbar();
        pos = getIntent().getExtras().getInt("Pos", 0);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        final DetailsBestFriends.PagePagerAdapter adapter = new PagePagerAdapter(DetailsBestFriends.this, DataStoreInString.BestFriends,Answer);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(pos);

        prevbtn = (LinearLayout) findViewById(R.id.prevLL);
        nextbtn = (LinearLayout) findViewById(R.id.nextLL);
        sharebtn = (LinearLayout) findViewById(R.id.shareLL);
        copybtn = (LinearLayout) findViewById(R.id.copyLL);

        prevbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tab = viewPager.getCurrentItem();
                if (tab > 0) {
                    tab--;
                    viewPager.setCurrentItem(tab);

                } else if (tab == 0) {
//                    viewPager.setCurrentItem(tab);
                    Toast.makeText(getApplicationContext(),"Last Caption!", Toast.LENGTH_LONG).show();
                    tab=BestFriends.length;
                    viewPager.setCurrentItem(tab);
                }
            }
        });
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tab = viewPager.getCurrentItem();
                tab++;
                viewPager.setCurrentItem(tab);
                if (tab== BestFriends.length)
                {
                    Toast.makeText(DetailsBestFriends.this, "First Caption!", Toast.LENGTH_SHORT).show();
                    tab=0;
                    viewPager.setCurrentItem(tab);
                }
            }
        });

        sharebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tab = viewPager.getCurrentItem();
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Content is Share");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, BestFriends[tab]);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });
        copybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adcopy = 2;
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    int tab = viewPager.getCurrentItem();
                    ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                    ClipData clip = ClipData.newPlainText("FullDetailsTv", BestFriends[tab]);
                    Toast.makeText(getApplicationContext(), "Text Is Copied To clipboard ", Toast.LENGTH_LONG).show();
                    clipboard.setPrimaryClip(clip);

                }
            }

        });
    }

    public class PagePagerAdapter extends PagerAdapter {
        String[] pages1;
        String[] answer;
        Context context;
        LayoutInflater inflater;

        public PagePagerAdapter(Context context, String[] pages1, String[] answer) {
            this.context = context;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            this.context = context;
            this.pages1 = pages1;
            this.answer = answer;

        }

        @Override
        public int getCount() {

            return pages1.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {

            return view == object;
        }

        public Object instantiateItem(ViewGroup container, final int position) {

            TextView tv, labelTv, Ans;
            View itemView = inflater.inflate(R.layout.pageview_layout, container, false);
            txt_page_index = (TextView) itemView.findViewById(R.id.txt_page_index);
            txt_page_index.setText(String.valueOf((position + 1) + "/" + BestFriends.length));
            labelTv = (TextView) itemView.findViewById(R.id.labelTv);
            tv = (TextView) itemView.findViewById(R.id.FullDetailsTv);
            tv.setText(pages1[position]);
            labelTv.setText("Best Friends Captions");
            labelTv.setSelected(true);
            labelTv.setSingleLine(true);

            container.addView(itemView);

            return itemView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((LinearLayout) object);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_favorite, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;

            case R.id.FavoriteList:
                adfav = 1;
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {

                    int tab = viewPager.getCurrentItem();
                    Toast.makeText(getApplication(), "Add To Favorite List", Toast.LENGTH_LONG).show();
                    SQLDatabaseFavorite database_favorite_list = new SQLDatabaseFavorite(DetailsBestFriends.this);
                    database_favorite_list.openDB();
                    database_favorite_list.insertfavorite(FragmentBestFriends.list_name1[tab], BestFriends[tab]);
                    database_favorite_list.closeDB();
                }
                return true;

        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        finish();
    }
}

