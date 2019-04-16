package com.example.giba2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "EmailPassword";
    private FirebaseAuth mAuth;
    private Button mRegisterButton;
    private Button mLoginButton;
    private EditText mEmail;
    private EditText mPassword;
    private CheckBox mVolunteerBox;
    private CheckBox mHostBox;

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        mLoginButton = findViewById(R.id.login_button);
        mRegisterButton = findViewById(R.id.register_button);
        mEmail = findViewById(R.id.username);
        mPassword = findViewById(R.id.password);
        mVolunteerBox = findViewById(R.id.volunteer_check_box);
        mHostBox = findViewById(R.id.host_check_box);

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mVolunteerBox.isChecked() && mHostBox.isChecked()) {
                    mVolunteerBox.setError("You cannot check both \'Host\' and " +
                            "\'Volunteer\' boxes at one time!");
                } else if (mVolunteerBox.isChecked()) {
                    Intent intent = new Intent(MainActivity.this, register_screen.class);
                    MainActivity.this.startActivity(intent);
                    finish();
                } else if (mHostBox.isChecked()) {
                    Intent intent = new Intent(MainActivity.this, host_register.class);
                    MainActivity.this.startActivity(intent);
                    finish();
                } else {
                    mVolunteerBox.setError("You must check either the \'Host\' or " +
                            "\'Volunteer\' check box!");
                }
            }
        });

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            String email = mEmail.getText().toString();
            String password = mPassword.getText().toString();

            @Override
            public void onClick(View view) {
                if (mVolunteerBox.isChecked() && mHostBox.isChecked()) {
                    mVolunteerBox.setError("You cannot check both \'Host\' and " +
                            "\'Volunteer\' boxes at one time!");
                } else if (mHostBox.isChecked()) {
                    attemptLogin(email, password);
                    Intent intent = new Intent(MainActivity.this, host_event_page.class);
                    MainActivity.this.startActivity(intent);
                    finish();
                } else if (mVolunteerBox.isChecked()) {
                    // TODO: start volunteer homepage
                    attemptLogin(email, password);

                    finish();
                } else {
                    mVolunteerBox.setError("You must check either the \'Host\' or " +
                            "\'Volunteer\' check box!");
                }
            }
        });
    }

    private void attemptLogin(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success
                            Log.d(TAG, "signInWithEmail:success");
                        } else {
                            // if Sign in fails, display a message to the user
                            Log.w(TAG, "signInWithEmail:success");
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
