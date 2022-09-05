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

public class PostRequestPersonalInfo extends AsyncTask<String, Integer, Long> {
    protected Long doInBackground(String... s) { //pass data
        Long l = new Long(0);
        try {
            Log.d("string-test", s[0]);
            makePostRequest(s[0]); //pass data
        } catch (Exception e) {
            e.printStackTrace();
        }
        return l;
    }

    protected void makePostRequest(String info) throws Exception { //comes here

        String urlString = "http://cf6b346f.ngrok.io/personInfo";

        URL url = new URL((String) urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        OutputStream outputStream = new BufferedOutputStream(connection.getOutputStream());

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
        writer.write(info);
        writer.flush();
        writer.close();
        outputStream.close();

        connection.connect();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
    }
        in.close();

        Log.d("personInfo", response.toString());
        }

    protected void onProgressUpdate(int progress) { }

    protected void onPostExecute(Long result) { }
}
