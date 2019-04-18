package com.example.giba2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class host_profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_profile);
        ImageButton btn1 = (ImageButton)findViewById(R.id.HostProfileImage);
        ImageButton btn2 = (ImageButton)findViewById(R.id.HostSearchImage);
        ImageButton btn3 = (ImageButton)findViewById(R.id.HostCalendarImage);
        Button btn4 = (Button)findViewById(R.id.SigScreen);
        btn1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(host_profile.this, host_profile.class));
            }
        } );
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(host_profile.this, Host_Search.class));
            }
        });
        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(host_profile.this, host_event_page.class));
            }
        });
        btn4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(host_profile.this, Signature_Screen.class));
            }
        });


    }
}
