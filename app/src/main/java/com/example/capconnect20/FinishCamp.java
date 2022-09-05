package com.example.capconnect20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FinishCamp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_camp);
    }

    public void returntoMM(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}