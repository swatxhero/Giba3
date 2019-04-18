package com.example.giba2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class generate_report extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_report);
        ImageButton btn = (ImageButton)findViewById(R.id.SearchImage);
        ImageButton btn2 = (ImageButton)findViewById(R.id.ProfileImage);
        ImageButton btn3 = (ImageButton)findViewById(R.id.CalandarImage);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(generate_report.this, Volunteer_Search.class));
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(generate_report.this, volunteer_profile.class));
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(generate_report.this, volunteer_calendar2.class));
            }
        });
    }
}
