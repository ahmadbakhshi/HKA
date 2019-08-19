package com.example.ahmad.hka_1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Locale;

public class loading extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        String languageload="en";
        Locale locale=new Locale(languageload);
        Configuration config=new Configuration();
        config.locale=locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());




        ImageView img1= (ImageView) findViewById(R.id.imageView);

        Animation anim1= AnimationUtils.loadAnimation(loading.this, R.anim.anim1);

        img1.startAnimation(anim1);


        final SharedPreferences txtseting=getSharedPreferences("program codes", MODE_ENABLE_WRITE_AHEAD_LOGGING);
        SharedPreferences.Editor edi=txtseting.edit();
        edi.commit();



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (txtseting.getInt("password cancel",0)==1)
                {
                    Intent inent1=new Intent(loading.this,firstpage.class);
                    startActivity(inent1);
                }else
                {
                    Intent inent1=new Intent(loading.this,login.class);
                    startActivity(inent1);
                }


            }
        },4500);

    }

    @Override
    public void finish() {
        super.finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
