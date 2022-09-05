package com.example.capconnect20;
import android.os.AsyncTask;
import android.util.Log;

import com.eclipsesource.json.*;
import com.eclipsesource.json.JsonObject.Member;//use data library to make json objects converted to String (?), add to post request
                                    //when u get input from python, convert to JSON

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class GetRequestExistingCampaigns extends AsyncTask<String, Integer, Long> {
    protected Long doInBackground(String... test) { //pass data
        Long l = new Long(0);
        try {
            makeGetRequest(); //pass data
        } catch (Exception e) {
            e.printStackTrace();
        }
        return l;
    }

    protected String makeGetRequest() throws Exception { //comes here

        String endpoint = "http://cf6b346f.ngrok.io"; //ex ..../login
        URL phone2ActionURL = new URL(endpoint); //THIS IS WHAT'S CHANGING (...in request?)

        HttpURLConnection connection = (HttpURLConnection) phone2ActionURL.openConnection();
        connection.setRequestMethod("GET"); // We need to set the HTTP Request type!

        InputStream response = connection.getInputStream(); // The HttpURLConnection's response is an InputStream

        Scanner scanner = new Scanner(response);
        String responseBody = scanner.useDelimiter("\\A").next(); // The response is a String, which isn't useful
        Log.d("test", responseBody); // We convert the key's value to a JsonObject
        // JsonObject responseObject = Json.parse(responseBody).asObject(); // This converts it to a (useful) JsonObject
        scanner.close();
        return responseBody;
    }

    protected void onProgressUpdate(int progress) { }

    protected void onPostExecute(Long result) { }
}
