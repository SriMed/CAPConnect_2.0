package com.example.capconnect20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

public class PersonInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_info);
    }

    public void submitinfo(View view) {
        EditText ObjNameText = (EditText) findViewById(R.id.editNameText);
        String name = ObjNameText.getText().toString().trim();

        EditText ObjEmailText = (EditText) findViewById(R.id.editEmailText);
        String email = ObjEmailText.getText().toString().trim();

        EditText ObjPhoneText = (EditText) findViewById(R.id.editPhoneText);
        String phone = ObjPhoneText.getText().toString().trim();

        EditText ObjAddressText = (EditText) findViewById(R.id.editAddressText);
        String address = ObjAddressText.getText().toString().trim();

        EditText ObjPasswordText = (EditText) findViewById(R.id.editPasswordText);
        String password = ObjPasswordText.getText().toString().trim();

//        Map<String, String> personalInfo = new HashMap<String, String>();
//        personalInfo.put("name", name);
//        personalInfo.put("email", email);
//        personalInfo.put("phone", phone);
//        personalInfo.put("address", address);
//        personalInfo.put("password", password);

        String info =  "{\"name\": \"" + name + "\", \"email\": \"" + email + "\", \"phone\": \"" + phone + "\", \"address\": \"" + address + "\", \"password\": \"" + password + "\"}";

        new PostRequestPersonalInfo().execute(info);

        new GetRequestExistingCampaigns().execute();

        Intent i = new Intent(this, ExistingCampaigns.class);
        startActivity(i);
    }
}
