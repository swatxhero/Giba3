package com.example.giba2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.annotations.NotNull;

public class host_event_page extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Button mCreateEvent;
    private Button mManageEvents;
    private ImageButton mProfile;

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        String hostID = currentUser.getUid();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_event_page);

        mAuth = FirebaseAuth.getInstance();

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

        mProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(host_event_page.this, host_profile.class);
                host_event_page.this.startActivity(intent);
                finish();
            }
        });

    }
}
