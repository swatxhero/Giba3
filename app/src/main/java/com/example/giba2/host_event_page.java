package com.example.giba2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class host_event_page extends AppCompatActivity {

    private Button mCreateEvent;
    private Button mManageEvents;
    private ImageButton mProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_event_page);

        mCreateEvent = findViewById(R.id.create_event);
        mManageEvents = findViewById(R.id.manage_events);
        mProfile = findViewById(R.id.host_profile);

        mCreateEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(host_event_page.this, create_event.class);
                host_event_page.this.startActivity(intent);
                finish();
            }
        });


    }
}
