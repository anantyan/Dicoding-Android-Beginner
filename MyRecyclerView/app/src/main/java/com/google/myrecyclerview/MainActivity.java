package com.google.myrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.myrecyclerview.Adapter.HeroAdapter;
import com.google.myrecyclerview.Components.HeroComponent;
import com.google.myrecyclerview.Components.HeroDataComponent;
import com.google.myrecyclerview.Listener.RecyclerOnClickListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;

    private ArrayList<HeroComponent> records = new ArrayList<>();
    private HeroAdapter heroAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_main);

        setSupportActionBar(toolbar);

        recyclerView();

        records.addAll(HeroDataComponent.getListData()); //Untuk menampilkan data dari HeroDataComponent
    }

    private void recyclerView() {
        heroAdapter = new HeroAdapter(records);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(heroAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerOnClickListener(MainActivity.this, recyclerView, new RecyclerOnClickListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

            }

            @Override
            public void onLongClick(View view, int position) {
                HeroComponent heroComponent = records.get(position);
                Toast.makeText(MainActivity.this, heroComponent.getName(), Toast.LENGTH_SHORT).show();
            }
        }));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_list){

        }
        if(id == R.id.action_grid){

        }
        if(id == R.id.action_cardview){

        }
        return super.onOptionsItemSelected(item);
    }
}
