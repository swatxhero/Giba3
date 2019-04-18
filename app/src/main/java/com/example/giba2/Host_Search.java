package com.example.giba2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Host_Search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host__search);
        ImageButton btn1 = (ImageButton)findViewById(R.id.HostProfileImage);
        ImageButton btn2 = (ImageButton)findViewById(R.id.HostSearchImage);
        ImageButton btn3 = (ImageButton)findViewById(R.id.HostCalendarImage);
        btn1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(Host_Search.this, host_profile.class));
            }
        } );
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(Host_Search.this, Host_Search.class));
            }
        });
        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(Host_Search.this, host_event_page.class));
            }
        });
    }
}
