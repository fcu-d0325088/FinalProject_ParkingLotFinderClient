package edu.fcu.tw.finalproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Switch;

public class profileActivity extends AppCompatActivity {

    ImageButton home,aboutUs,favorite,setting,history;
    View include_first,include_favorite,include_setting,include_history,include_aboutUs;
    ListView favoriteListView,historyListView;
    Switch soundSwitch;
    SharedPreferences settingPreferences;
    SharedPreferences.Editor settingPreferencesEditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        home=(ImageButton)findViewById(R.id.homeIcon);
        aboutUs=(ImageButton)findViewById(R.id.aboutus);
        favorite=(ImageButton)findViewById(R.id.detial);
        setting=(ImageButton)findViewById(R.id.setting);
        history=(ImageButton)findViewById(R.id.history);
        include_first=findViewById(R.id.include_first);
        include_favorite=findViewById(R.id.include_favorite);
        include_setting=findViewById(R.id.include_setting);
        include_history=findViewById(R.id.include_history);
        include_aboutUs=findViewById(R.id.include_aboutUs);
        favoriteListView=(ListView)findViewById(R.id.favoriteListView);
        historyListView=(ListView)findViewById(R.id.historyListView);
        soundSwitch=(Switch)findViewById(R.id.soundSwitch);
        settingPreferences=getSharedPreferences("SETTING_PREFERENCES",MODE_PRIVATE);
        settingPreferencesEditor=settingPreferences.edit();
/*        ArrayList<String> favoriteList=new ArrayList<String>();
        favoriteList.add("福星停車場-台中市西屯區福星停車場");
        favoriteList.add("逢甲夜市文華停車場-台中市西屯區福上巷");
        ArrayAdapter<String> favoriteArrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,favoriteList);
        favoriteListView.setAdapter(favoriteArrayAdapter);
        favoriteListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent();
                intent.setClass(profileActivity.this,ParkingDetail.class);
                startActivity(intent);
            }
        });
        ArrayList<String> historyList=new ArrayList<String>();
        historyList.add("2016/5/2-福星停車場-台中市西屯區福星停車場");
        historyList.add("2016/5/3-逢甲夜市文華停車場-台中市西屯區福上巷");
        ArrayAdapter<String> historyArrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,historyList);
        historyListView.setAdapter(historyArrayAdapter);
        historyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent();
                intent.setClass(profileActivity.this,ParkingDetail.class);
                startActivity(intent);
            }
        });*/
        if(settingPreferences.getInt("SOUND_PREFERENCES",1)==1)
        {
            soundSwitch.setChecked(true);
        }
        else
        {
            soundSwitch.setChecked(false);
        }
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(profileActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                include_first.setVisibility(View.GONE);
                include_aboutUs.setVisibility(View.VISIBLE);
                include_history.setVisibility(View.GONE);
                include_setting.setVisibility(View.GONE);
                include_favorite.setVisibility(View.GONE);
            }
        });
        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                include_first.setVisibility(View.GONE);
                include_aboutUs.setVisibility(View.GONE);
                include_history.setVisibility(View.GONE);
                include_setting.setVisibility(View.GONE);
                include_favorite.setVisibility(View.VISIBLE);
            }
        });
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                include_first.setVisibility(View.GONE);
                include_aboutUs.setVisibility(View.GONE);
                include_history.setVisibility(View.GONE);
                include_setting.setVisibility(View.VISIBLE);
                include_favorite.setVisibility(View.GONE);
            }
        });
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                include_first.setVisibility(View.GONE);
                include_aboutUs.setVisibility(View.GONE);
                include_history.setVisibility(View.VISIBLE);
                include_setting.setVisibility(View.GONE);
                include_favorite.setVisibility(View.GONE);
            }
        });
        soundSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    settingPreferencesEditor.putInt("SOUND_PREFERENCES",1);
                    settingPreferencesEditor.commit();
                }
                else
                {
                    settingPreferencesEditor.putInt("SOUND_PREFERENCES",0);
                    settingPreferencesEditor.commit();
                }
            }
        });
    }

}
