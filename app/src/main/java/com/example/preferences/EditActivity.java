package com.example.preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    private EditText textEditor;

    private static final String SHARED_PREF_NAME = "sharedPref";
    private static final String KEY_TEXT = "keyText";

    public void startMain(View view) {
        textEditor = findViewById(R.id.textEditor);

        String tempText = textEditor.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editPrefs = sharedPreferences.edit();
        editPrefs.putString(KEY_TEXT,tempText);
        editPrefs.apply();

        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
    }
}