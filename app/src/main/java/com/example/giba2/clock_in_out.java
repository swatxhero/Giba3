package com.example.giba2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

        startTimer.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd:MMMM:yyyy HH:mm:ss a");
                String date = simpleDateFormat.format(calendar.getTime());
                timerText.setText(date);
            }



        });
    }

}
