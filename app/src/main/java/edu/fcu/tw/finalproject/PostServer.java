package edu.fcu.tw.finalproject;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;



public class PostServer extends AsyncTask<String, String, String> {
    @Override
    protected String doInBackground(String... params) {
        URL targetUrl = null;
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            targetUrl = new URL(params[0]);
            urlConnection = (HttpURLConnection) targetUrl.openConnection();
            reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));//do something

            String line = null;

            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }
        } catch (Exception e) {
        } finally {
            urlConnection.disconnect();
        }
        Log.v("test", stringBuilder.toString());

        return stringBuilder.toString();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        onResponse(s);
        Log.v("log_tag", s);

    }

    public void onResponse(String response) {
    }
}
