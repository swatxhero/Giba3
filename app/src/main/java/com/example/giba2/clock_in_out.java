package com.example.giba2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;

public class clock_in_out extends AppCompatActivity {
    private TextView timerText;
    private Button startTimer;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock_in_out);
        startTimer = (Button) findViewById(R.id.button13);
        timerText = (TextView) findViewById(R.id.textView14);
        ImageButton btn = (ImageButton)findViewById(R.id.SearchImage);
        ImageButton btn2 = (ImageButton)findViewById(R.id.ProfileImage);
        ImageButton btn3 = (ImageButton)findViewById(R.id.CalandarImage);

        startTimer.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd:MMMM:yyyy HH:mm:ss a");
                String date = simpleDateFormat.format(calendar.getTime());
                timerText.setText(date);
            }



        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(clock_in_out.this, Volunteer_Search.class));
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(clock_in_out.this, volunteer_profile.class));
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(clock_in_out.this, volunteer_calendar2.class));
            }
        });
    }

}
