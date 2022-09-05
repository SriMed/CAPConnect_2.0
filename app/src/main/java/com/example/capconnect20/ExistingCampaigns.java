package com.example.capconnect20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ExistingCampaigns extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existing_campaigns);

        //here show a bunch of already existing campaigns according to the user's info
    }

    public void makeCampaign(View view) {

        Intent i = new Intent(this, MakeCampaign.class);
        startActivity(i);
    }
}