package com.example.currentdatetimeapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button dt_btn;
    private TextView current_time_with_am_and_pm, current_date_with_month_name;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.magenta));

        InitializeComponents();
        dt_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetTextForComponents();
            }
        });
    }

    private void SetTextForComponents() {
        current_time_with_am_and_pm.setText("Current Time: " + getTimeWithAMAndPM());
        current_date_with_month_name.setText("Current Date: " + getTodaysDateWithMonthName());
    }

    private void InitializeComponents(){
        dt_btn = findViewById(R.id.date_and_time_btn);
        current_time_with_am_and_pm = findViewById(R.id.text2);
        current_date_with_month_name = findViewById(R.id.text4);
    }

    private String getTimeWithAMAndPM(){
        return new SimpleDateFormat("hh:mm a", Locale.getDefault()).format(new Date());
    }

    private String getTodaysDateWithMonthName(){
        return new SimpleDateFormat("dd/LLL/yyyy", Locale.getDefault()).format(new Date());
    }
}