package com.example.giba2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firestore.v1.WriteResult;

import java.util.HashMap;
import java.util.Map;

public class register_screen extends AppCompatActivity {

    private static final String alphaRegex = "[a-zA-Z]+";
    private EditText mFirstName;
    private EditText mLastName;
    private EditText mUsername;
    private EditText mPassword;
    private EditText mAddress;
    private EditText mEmail;
    private Button mHomepage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);

        Intent intent = getIntent();

        mFirstName = findViewById(R.id.first_name);
        mLastName = findViewById(R.id.last_name);
        mUsername = findViewById(R.id.username);
        mPassword = findViewById(R.id.password);
        mAddress = findViewById(R.id.address);
        mEmail = findViewById(R.id.email);
        mHomepage = findViewById(R.id.to_homepage);

        mHomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstName = mFirstName.getText().toString();
                String lastName = mLastName.getText().toString();
                String username = mUsername.getText().toString();
                String password = mPassword.getText().toString();
                String address = mAddress.getText().toString();
                String email = mEmail.getText().toString();

                if (!isValidUsername(username)) {
                    mUsername.setError("Username cannot be empty and must contain more than 5" +
                            "characters.");
                } else if (!isValidName(firstName)) {
                    mFirstName.setError("First Name cannot be empty and must only contain letters.");
                } else if (!isValidName(lastName)) {
                    mLastName.setError("Last Name cannot be empty and must only contain letters.");
                } else if (!isValidPassword(password)) {
                    mPassword.setError("Password must contain more than 8 characters.");
                } else if (!isValidEmail(email)) {
                    mEmail.setError("Email must contain \'@\'.");
                } else if (isEmpty(address)) {
                    mAddress.setError("Address must not be empty.");
                } else {
                    // TODO: start volunteer homepage
                    FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
                    DatabaseReference mRef = mDatabase.getReference("Volunteers");

                    Map<String, Object> docData = new HashMap<>();
                    docData.put("First Name", firstName);
                    docData.put("Last Name", lastName);
                    docData.put("Username", username);
                    docData.put("Password", password);
                    docData.put("Email", email);
                    docData.put("Address", address);

                    String userID = mRef.push().getKey();

                    FirebaseFirestore db = FirebaseFirestore.getInstance();

                    db.collection("Volunteers")
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
    } // end isValidEmail

}
