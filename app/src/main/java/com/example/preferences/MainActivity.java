package com.example.preferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private TextView prefText;

    private static final String SHARED_PREF_NAME = "sharedPref";
    private static final String KEY_TEXT = "keyText";

    private String savedText;
    public void startEdit(View view) {
        //Starts the edit activity
        Intent i = new Intent(MainActivity.this, EditActivity.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        prefText = findViewById(R.id.prefText);
    }

    protected void onResume() {
        super.onResume();

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        savedText = sharedPreferences.getString(KEY_TEXT    , "");

        prefText.setText(savedText);
    }
}
