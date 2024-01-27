package com.example.droidplaygroundjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity {

    private static String TAG = "###";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Button buttonThird = findViewById(R.id.button_third);
        Button buttonMain = findViewById(R.id.button_third_main);
        Button buttonSecond = findViewById(R.id.button_third_second);
        buttonMain.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        buttonSecond.setOnClickListener(v -> {
            Intent intent = new Intent(this, SecondActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });

        buttonThird.setOnClickListener(v -> {
            Intent intent = new Intent(this, ThirdActivity.class);
            startActivity(intent);
        });

        Log.d(TAG, "onCreate: Third");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: Third");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: Third");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: Third");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: Third");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: Third");
    }
}