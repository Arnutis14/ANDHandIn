package com.example.exercise41;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.ArrayList;

public class AllStatesActivity extends AppCompatActivity implements StateAdapter.OnListItemClickListener {

    RecyclerView mStateList;
    RecyclerView.Adapter mStateAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allstates);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        mStateList = findViewById(R.id.rv);
        mStateList.hasFixedSize();
        mStateList.setLayoutManager(new LinearLayoutManager(this));
        APIConsumer apiConsumer = new APIConsumer();
        ArrayList<State> states = null;
        try {
            states = apiConsumer.getAllStates();
        } catch (UnirestException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


        mStateAdapter = new StateAdapter(states, this);
        mStateList.setAdapter(mStateAdapter);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean showToast(MenuItem item) {
        Toast.makeText(this, R.string.heartClicked, Toast.LENGTH_LONG).show();
        return true;
    }


    @Override
    public void onListItemClick(int clickedItemIndex) {

    }
}
