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

      //  setting=(ImageButton)findViewById(R.id.setting);
      //  history=(ImageButton)findViewById(R.id.history);


//        soundSwitch=(Switch)findViewById(R.id.soundSwitch);
        settingPreferences=getSharedPreferences("SETTING_PREFERENCES",MODE_PRIVATE);
        settingPreferencesEditor=settingPreferences.edit();

        if(settingPreferences.getInt("SOUND_PREFERENCES",1)==1)
        {
            soundSwitch.setChecked(true);
        }
        else
        {
            soundSwitch.setChecked(false);
        }

        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(profileActivity.this,Favorites.class);
                startActivity(intent);
            }
        });
        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(profileActivity.this,AboutUs.class);
                startActivity(intent);
            }
        });

//        soundSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked)
//                {
//                    settingPreferencesEditor.putInt("SOUND_PREFERENCES",1);
//                    settingPreferencesEditor.commit();
//                }
//                else
//                {
//                    settingPreferencesEditor.putInt("SOUND_PREFERENCES",0);
//                    settingPreferencesEditor.commit();
//                }
//            }
//        });
    }

}
