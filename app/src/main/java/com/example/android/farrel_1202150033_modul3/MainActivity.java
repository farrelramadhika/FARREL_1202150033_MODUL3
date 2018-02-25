package com.example.android.farrel_1202150033_modul3;

import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<menu> menuList = new ArrayList<>();
    private RecyclerView recyclerView;
    private menuAdapter mAdapter;
    Configuration newConfig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycleMinuman);
        mAdapter = new menuAdapter(this, menuList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());       //menginisiasi adapter untuk recycleView
        recyclerView.setLayoutManager(mLayoutManager);      //menghubungkan adapter dan layout
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        prepareMenuData();
        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);
        recyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));
    }
    private void prepareMenuData() {                                                                                    //memasukkan beberapa menu ke dalam array objek
        String[] merk_title = getResources().getStringArray(R.array.merkMinuman);
        String[] merk_deskripsi = getResources().getStringArray(R.array.merkDeskripsi);
        String[] details = getResources().getStringArray(R.array.detailMinuman);
        TypedArray sportsImageResources = getResources().obtainTypedArray(R.array.gambarMinuman);
        //Clear the existing data (to avoid duplication)
        menuList.clear();


        //Create the ArrayList of Sports objects containing the titles,
        // images and information about each sport
        for(int i=0; i<merk_title.length; i++){
            menuList.add(new menu(sportsImageResources.getResourceId(i,0),merk_title[i], merk_deskripsi[i]
                    , details[i]));
        }

        //Recycle the typed array
        sportsImageResources.recycle();

        //Notify the adapter of the change
        mAdapter.notifyDataSetChanged();



        // mAdapter.notifyDataSetChanged();
    }
}
