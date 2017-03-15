package com.devlovepreet.nssdtu.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.devlovepreet.nssdtu.R;

public class SplashActivity extends AppCompatActivity {

    TextView tvTitle, tvSubTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_layout);

        //tvTitle=(TextView)findViewById(R.id.tvSplashTitle);
        tvSubTitle = (TextView) findViewById(R.id.tvSplashSubTitle);

        //tvTitle.setTypeface(EasyFonts.caviarDreams(this));
        //tvSubTitle.setTypeface(EasyFonts.caviarDreamsBold(this));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        }, 2000);
    }
}
