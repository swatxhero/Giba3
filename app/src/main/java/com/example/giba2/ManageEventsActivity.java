package com.example.giba2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ManageEventsActivity extends AppCompatActivity {

    private static final String DATE_FORMAT = "dd-MM-yyyy";
    private FirebaseAuth mAuth;
    private EditText mStartDate;
    private EditText mEndDate;
    private Button mSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_events);

        mAuth = FirebaseAuth.getInstance();
        String hostID = mAuth.getUid();

        mStartDate = findViewById(R.id.start_date);
        mEndDate = findViewById(R.id.end_date);
        mSubmit = findViewById(R.id.submit);

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String startDate = mStartDate.getText().toString();
                String endDate = mEndDate.getText().toString();

                if(!isValidDate(startDate)) {
                    mStartDate.setError("Date must be in \"dd-MM-yyyy\" format.");
                } else if (!isValidDate(endDate)) {
                    mEndDate.setError("Date must be in \"dd-MM-yyyy\" format.");
                }
                else {
                    // TODO: search database for events within date range

                }
            }
        });
    }

    private boolean isValidDate(String date) {
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
