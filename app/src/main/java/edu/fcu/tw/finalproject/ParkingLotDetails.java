package edu.fcu.tw.finalproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotDetails extends AppCompatActivity {
    private ListView lv;
    private Button addBtn;
    private SharedPreferences settingPreferences;
    private SharedPreferences.Editor settingPreferencesEditor;
    private  String details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_lot_details);

        settingPreferences=getSharedPreferences("SETTING_PREFERENCES",MODE_PRIVATE);
        settingPreferencesEditor=settingPreferences.edit();

        Intent intent = getIntent();
        ParkingLot pl = (ParkingLot)intent.getSerializableExtra("obj");

        lv = (ListView) findViewById(R.id.lv_parkingLotDetails);

        // Instanciating an array list (you don't need to do this,
        // you already have yours).
        List<String> your_array_list = new ArrayList<String>();
        your_array_list.add("Name: " + pl.getName());
        your_array_list.add("Address: "+ pl.getAddress());
        your_array_list.add("Price: "+ pl.getPrice());
        your_array_list.add("Available Slots Left: "+ pl.getAvailable());
        your_array_list.add("Opening hours: "+ pl.getOpR());

        details = pl.getName() + " : " + pl.getAddress();

        addBtn = (Button)findViewById(R.id.add_btn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                settingPreferencesEditor.putString("Detail",details);
                settingPreferencesEditor.commit();
            }
        });


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
