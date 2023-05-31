package com.mirea.kt.android2023.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class TelephoneActivity extends AppCompatActivity {
    private static final String TAG = "TelephoneActivity";
    DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telephone);
        Log.d(TAG, "onCreate: is created");

        this.dbManager = new DBManager(new MyAppSQLiteHelper(this, "my_database.db",
                null, 1));
        ArrayList<Telephone> telephones = dbManager.loadAllTelephoneFromDatabase();
        Log.d(TAG, "onCreate: telephones are loaded");
        Log.d(TAG, "onCreate: " + telephones);
        TelephoneAdapter adapter = new TelephoneAdapter(telephones);
        RecyclerView rcView = findViewById(R.id.recyclerView);
        rcView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        rcView.setAdapter(adapter);
        Log.d(TAG, "onCreate: adapter is set");
    }
}