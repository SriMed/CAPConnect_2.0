package com.example.capconnect20;
import android.os.AsyncTask;
import android.util.Log;

import com.eclipsesource.json.*;
import com.eclipsesource.json.JsonObject.Member;//use data library to make json objects converted to String (?), add to post request
//when u get input from python, convert to JSON

import org.json.JSONArray;

import java.net.*;
import java.io.*;
import java.util.Map;
import java.util.Scanner;

public class PostRequestMakeCampaign extends AsyncTask<String, Integer, Long> {
    protected Long doInBackground(String... s) { //pass data
        Long l = new Long(0);
        try {
            makePostRequest(s[0]); //pass data
        } catch (Exception e) {
            e.printStackTrace();
        }
        return l;
    }

    protected void makePostRequest(String s) throws Exception { //comes here

        String urlString = "";

        URL url = new URL((String) urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        OutputStream outputStream = new BufferedOutputStream(connection.getOutputStream());

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
        writer.write(s);
        writer.flush();
        writer.close();
        outputStream.close();

        connection.connect();

    }

    protected void onProgressUpdate(int progress) { }

    protected void onPostExecute(Long result) { }
}
