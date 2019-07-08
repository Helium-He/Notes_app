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
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {

    private EditText email,pass;
    private Button signup ;
    private FirebaseAuth mAuth;
    private ProgressDialog pddia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        email = findViewById(R.id.emailreg);
        pass = findViewById(R.id.passwordreg);
        //signin  =  findViewById(R.id.signinreg);
        signup  =  findViewById(R.id.signupreg);
        mAuth = FirebaseAuth.getInstance();
        pddia = new ProgressDialog(this);

/*
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
*/
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mEmail = email.getText().toString().trim();
                String mPass = pass.getText().toString().trim();

                if ( TextUtils.isEmpty(mEmail))
                {
                    email.setError("RequiredField..");
                    return;
                }
                if ( TextUtils.isEmpty(mPass))
                {
                    pass.setError("RequiredField..");
                    return;
                }
                pddia.setMessage("Processing");
                pddia.show();
                mAuth.createUserWithEmailAndPassword(mEmail,mPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            pddia.dismiss();
                            Toast.makeText(RegistrationActivity.this, "Successfull", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                        }
                        else
                            pddia.dismiss();
                        Toast.makeText(RegistrationActivity.this, "Fail", Toast.LENGTH_SHORT).show();
                    }

                });

            }
        });

    }
}
