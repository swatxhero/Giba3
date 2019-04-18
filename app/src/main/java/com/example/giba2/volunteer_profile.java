package com.example.giba2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View;

public class volunteer_profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_profile);
        ImageButton btn = (ImageButton)findViewById(R.id.SearchImage);
        ImageButton btn2 = (ImageButton)findViewById(R.id.ProfileImage);
        ImageButton btn3 = (ImageButton)findViewById(R.id.CalandarImage);
        Button btn4 = (Button)findViewById(R.id.GenerateReportB);
        Button btn5 = (Button)findViewById(R.id.ClockinB);
        Button btn6 = (Button)findViewById(R.id.LogoutB);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(volunteer_profile.this, Volunteer_Search.class));
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(volunteer_profile.this, volunteer_profile.class));
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(volunteer_profile.this, volunteer_calendar2.class));
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(volunteer_profile.this, generate_report.class));
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(volunteer_profile.this, clock_in_out.class));
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(volunteer_profile.this, MainActivity.class));
            }
        });
        }
    }




