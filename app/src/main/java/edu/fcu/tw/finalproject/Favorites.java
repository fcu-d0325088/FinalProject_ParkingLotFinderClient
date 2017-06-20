package edu.fcu.tw.finalproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Favorites extends AppCompatActivity {
    private ListView lv;
    SharedPreferences settingPreferences;
    SharedPreferences.Editor settingPreferencesEditor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorite);
        lv = (ListView) findViewById(R.id.lv_favorite);
        settingPreferences=getSharedPreferences("SETTING_PREFERENCES",MODE_PRIVATE);
        settingPreferencesEditor=settingPreferences.edit();

//        Intent intent = getIntent();

//         Instanciating an array list (you don't need to do this,
//         you already have yours).
        List<String> your_array_list = new ArrayList<String>();
        if(!settingPreferences.getString("Detail","").equals("")){
            your_array_list.add(settingPreferences.getString("Detail",""));
        }




        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                your_array_list );

        lv.setAdapter(arrayAdapter);



    }
}
