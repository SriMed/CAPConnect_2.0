package com.example.capconnect20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MakeCampaign extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_campaign);
    }


    public void createCamp(View view) {
        Intent i = new Intent(this, FinishCamp.class);
        startActivity(i);
    }
}