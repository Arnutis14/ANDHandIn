package com.example.exercise41;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class VisitedStatesActivity extends AppCompatActivity {

    EditText editText;
    Button btnSave;
    VisitedStates visitedStates;
    TextView textViewVisited;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitedstates);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);


        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("visitedStates");


        editText = (EditText) findViewById(R.id.edit_text);
        btnSave = (Button) findViewById(R.id.btnSave);
        textViewVisited = (TextView) findViewById(R.id.textViewVisited);


        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                visitedStates = dataSnapshot.getValue(VisitedStates.class);
                editText.setText(visitedStates.getVisitedStates());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VisitedStates visitedStates = new VisitedStates(editText.getText().toString());
                myRef.setValue(visitedStates);

            }

        });

    }



    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean showToast(MenuItem item) {
        Toast.makeText(this, R.string.heartClicked, Toast.LENGTH_LONG).show();
        return true;
    }

}
