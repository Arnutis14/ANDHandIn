package com.example.exercise41;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);


        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, myToolbar, R.string.open, R.string.close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(this);

        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // when item on click it has to be boolean and taken as an item
    public boolean showToast(MenuItem item) {
        Toast.makeText(this, R.string.heartClicked, Toast.LENGTH_LONG).show();
        return true;
    }

    public void FABClicked(View v) {
        Snackbar mySnackBar = Snackbar.make(v, R.string.FABClicked, 1500);
        mySnackBar.show();
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.stateTracker:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new StateTrackerFragment()).commit();
                break;
            case R.id.visitedStates:
                Intent visitedStatesIntent = new Intent(MainActivity.this, VisitedStatesActivity.class);
                startActivity(visitedStatesIntent);
                break;
            case R.id.allStates:
                Intent allStatesIntent = new Intent(MainActivity.this, AllStatesActivity.class);
                startActivity(allStatesIntent);
                break;
            case R.id.settings:
                Intent settingsIntent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(settingsIntent);
                return true;
            case R.id.about:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new AboutFragment()).commit();
                break;

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
