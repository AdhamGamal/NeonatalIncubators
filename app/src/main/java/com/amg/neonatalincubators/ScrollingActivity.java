package com.amg.neonatalincubators;


import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.allattentionhere.fabulousfilter.AAH_FabulousFragment;

import java.util.ArrayList;
import java.util.List;

public class ScrollingActivity extends AppCompatActivity implements AAH_FabulousFragment.Callbacks, AAH_FabulousFragment.AnimationListener {

    FloatingActionButton fab;
    private ArrayMap<String, List<String>> applied_filters = new ArrayMap<>();
    MyFabFragment dialogFrag1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView theListView = (RecyclerView) findViewById(R.id.mainListView);
        theListView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Item> items = getTestingList();
        ItemAdapter adapter = new ItemAdapter(items, this);
        theListView.setAdapter(adapter);

        fab = (FloatingActionButton) findViewById(R.id.fab);

        dialogFrag1 = new MyFabFragment();
        dialogFrag1.setParentFab(fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogFrag1.show(getSupportFragmentManager(), dialogFrag1.getTag());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem menuSearch = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuSearch.getActionView();
        menuSearch.collapseActionView();
        return true;
    }

    public ArrayMap<String, List<String>> getApplied_filters() {
        return applied_filters;
    }

    @Override
    public void onResult(Object result) {
        Log.d("k9res", "onResult: " + result.toString());
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (dialogFrag1.isAdded()) {
            dialogFrag1.dismiss();
            dialogFrag1.show(getSupportFragmentManager(), dialogFrag1.getTag());
        }
    }

    @Override
    public void onOpenAnimationStart() {
        Log.d("aah_animation", "onOpenAnimationStart: ");
    }

    @Override
    public void onOpenAnimationEnd() {
        Log.d("aah_animation", "onOpenAnimationEnd: ");

    }

    @Override
    public void onCloseAnimationStart() {
        Log.d("aah_animation", "onCloseAnimationStart: ");

    }

    @Override
    public void onCloseAnimationEnd() {
        Log.d("aah_animation", "onCloseAnimationEnd: ");

    }

    public ArrayList<Item> getTestingList() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("مستشفى عين شمس التخصصي", 25, 6, 60, "BABY NEST I-700", "شارع الخليفة المأمون، أمام جامعة عين شمس", "Ain Shams", "01233445566\n01011223344", 7, getDrawable(R.drawable.ainshamshos), getDrawable(R.drawable.baby_nest_i_700)));
        items.add(new Item("مستشفى دار الشفاء", 25, 11, 30, "CALEO", "375 شارع رمسيس بالعباسية، قرب من مستشفى الدمرداش", "Benha", "01233445566\n01011223344", 7, getDrawable(R.drawable.darshfaa), getDrawable(R.drawable.caleo)));
        items.add(new Item("مستشفى القصر العيني التعليمي الجديد", 25, 0, 20, "YP-90AC", "27 نافذة شيم الشافعي، كورنيش النيل", "Benha", "01233445566\n01011223344", 7, getDrawable(R.drawable.qaser3eny), getDrawable(R.drawable.yp_90ac)));
        items.add(new Item("مستشفى العذراء وأبي سيفين", 25, 2, 20, "PC-305", "3 شارع ضياء الحق من آخر مصطفى النحاس (أعلي التبة)", "Benha", "01233445566\n01011223344", 7, getDrawable(R.drawable.m3zraa), getDrawable(R.drawable.pc_305)));
        items.add(new Item("مستشفى أحمد ماهر التعليمي", 25, 1, 20, "SHELLY", "341 شارع بورسعيد، باب الخلق", "Benha", "01233445566\n01011223344", 7, getDrawable(R.drawable.ahmedmaher), getDrawable(R.drawable.shelly)));
        items.add(new Item("مركز الرضوان الطبي", 25, 5, 20, "GIRAFFE OMNIBED", "13 شارع عباس العقاد، مدينة نصر", "Benha", "01233445566\n01011223344", 7, getDrawable(R.drawable.background), getDrawable(R.drawable.giraffe_omnibed)));
        return items;
    }
}
