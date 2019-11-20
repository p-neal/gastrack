package com.example.gastrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.gastrack.ui.home.HomeFragment;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra(HomeFragment.EXTRA_MESSAGE);

        String jsonString = intent.getStringExtra("entryInfoJSON");

        TextView textView = findViewById(R.id.textResultsCombined);
        TextView textViewJSON = findViewById(R.id.textJSONObject);
        textView.setText(message);
        textViewJSON.setText(jsonString);
    }
}
