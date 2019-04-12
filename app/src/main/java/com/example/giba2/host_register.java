package com.example.giba2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class host_register extends AppCompatActivity {

    private static final String alphaRegex = "[a-zA-Z]+";
    private EditText mOrgName;
    private EditText mUsername;
    private EditText mPassword;
    private EditText mEin;
    private EditText mEmail;
    private Button mRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_register);

        mOrgName = findViewById(R.id.org_name);
        mUsername = findViewById(R.id.username);
        mPassword = findViewById(R.id.password);
        mEin = findViewById(R.id.ein);
        mEmail = findViewById(R.id.email);
        mRegister = findViewById(R.id.register_button);

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String orgName = mOrgName.getText().toString();
                String username = mUsername.getText().toString();
                String password = mPassword.getText().toString();
                String ein = mEin.getText().toString();
                String email = mEmail.getText().toString();

                if (!isValidName(orgName)) {
                    mOrgName.setError("Organizaiton Name cannot be empty and must only contain letters.");
                }
                else if (!isValidUsername(username)) {
                    mUsername.setError("Username cannot be empty and must contain more than 5 " +
                            "characters");
                }
                else if (!isValidPassword(password)) {
                    mPassword.setError("Password must contain more than 8 characters.");
                }
                else if (isEmpty(ein)) {
                    mEin.setError("EIN must not be empty.");
                }
                else if (!isValidEmail(email)) {
                    mEmail.setError("Email must contain \'@\'.");
                }
                else {
                    // TODO: start host homepage
                    FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
                    DatabaseReference mRef = mDatabase.getReference("Hosts");

                    Map<String, Object> docData = new HashMap<>();
                    docData.put("Organization Name", orgName);
                    docData.put("Username", username);
                    docData.put("Password", password);
                    docData.put("EIN", ein);
                    docData.put("Email", email);

                    FirebaseFirestore db = FirebaseFirestore.getInstance();

                    db.collection("Hosts")
                            .add(docData)
                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Log.d("USER", "DocumentSnapshot added with ID: " +
                                            documentReference.getId());
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.w("USER", "Error adding document", e);
                                }
                            });

                    Intent intent = new Intent(host_register.this, host_event_page.class);
                    host_register.this.startActivity(intent);
                }
            }
        });
    }

    private static boolean isEmpty(String userInformation) {
        return userInformation.length() == 0;
    } // end isEmpty

    private static boolean isValidUsername(String username) {
        return username.length() > 5;
    } // end isValidUsername

    private static boolean isValidName(String name) {
        return name.matches(alphaRegex) && !name.isEmpty();
    } // end isValidFirstName

    private static boolean isValidPassword(String password) {
        return password.length() > 8;
    } // end isValidPassword

    private static boolean isValidEmail(String email) {
        return email.contains("@");
    }
}
