package com.example.giba2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.annotations.NotNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class create_event extends AppCompatActivity {

    private EditText mEventName;
    private EditText mEventDate;
    private EditText mEventTime;
    private EditText mEventLocation;
    private EditText mEventDescription;
    @NotNull
    private EditText mMaxVolunteers;
    private Button mCreateEvent;
    // this needs to be changed to a button to upload a picture private EditText mUploadPicture


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        mEventName = findViewById(R.id.name);
        mEventDate = findViewById(R.id.date);
        mEventTime = findViewById(R.id.time);
        mEventLocation = findViewById(R.id.location);
        mEventDescription = findViewById(R.id.description);
        mMaxVolunteers = findViewById(R.id.max_volunteers);
        mCreateEvent = findViewById(R.id.submit);

        mCreateEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mEventName.getText().toString();
                String dateString = mEventDate.getText().toString();
                String time = mEventTime.getText().toString();
                String location = mEventLocation.getText().toString();
                String description = mEventDescription.getText().toString();
                Integer numVolunteers = Integer.parseInt(mMaxVolunteers.getText().toString());

                DateFormat format = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT);

                try {
                    Date date = format.parse(dateString);
                }
                catch (ParseException pe) {
                    System.out.println("ERROR: could not parse date in the string \"" +
                            dateString + "\"");
                }

                if (isEmpty(name)) {
                    mEventName.setError("Your event must have a name!");
                }
                else if (isEmpty(dateString)) {
                    mEventDate.setError("Your event must have a date!");
                }
                else if (isEmpty(time)) {
                    mEventTime.setError("Your event must have a time!");
                }
                else if (isEmpty(location)) {
                    mEventLocation.setError("Your event must have a location!");
                }
                else if (numVolunteers == 0) {
                    mMaxVolunteers.setError("Number of volunteers must not be 0!");
                }
                else if (isEmpty(description)) {
                    mEventDescription.setError("Your event must have a description!");
                }
                else {
                    
                }
            }
        });
    }

    private boolean isEmpty(String userInformation) {
        return userInformation.length() == 0;
    }
}
