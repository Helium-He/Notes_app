package com.harpreet.notes_app;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private EditText email,password;
    private Button btnsignin,btnsignup;
    //Firebase..
    FirebaseAuth mAuth;
    ProgressDialog progressd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btnsignin = findViewById(R.id.signin);
        btnsignup = findViewById(R.id.signup);
        mAuth = FirebaseAuth.getInstance();
        progressd = new ProgressDialog(MainActivity.this);

        if (mAuth.getCurrentUser()!=null)
        {
            startActivity(new Intent(getApplicationContext(),HomeActivity.class));
        }


        btnsignin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String mEmail = email.getText().toString().trim();
                        String mPass = password.getText().toString().trim();
                        if(mEmail.isEmpty()||mEmail=="")
                        {
                            email.setError("Required field");
                            return;
                        }
                        if(mPass.isEmpty()||mPass=="")
                        {
                            password.setError("Required field..");
                            return;
                        }

                        progressd.setMessage("Processing");
                        progressd.show();
                        mAuth.signInWithEmailAndPassword(mEmail,mPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful())
                                {
                                    progressd.dismiss();
                                    startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                                    Toast.makeText(MainActivity.this, "Login Complete", Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    progressd.dismiss();
                                    Toast.makeText(MainActivity.this, "Username or Password wrong", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                    }
                });

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),RegistrationActivity.class));
            }
        });
    }
}
