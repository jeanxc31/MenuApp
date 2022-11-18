package com.ucv.menuapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class InicioSes extends AppCompatActivity {

    private Button botonlogin3;
    private EditText edtuser3, edtpass3;

    private String  email = "";
    private String password = "";

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_ses);

        //FIREBASE
        mAuth = FirebaseAuth.getInstance();

        //VARIABLES
        edtuser3 = findViewById(R.id.edtuser3);
        edtpass3 = findViewById(R.id.edtpass3);
        botonlogin3 = findViewById(R.id.botonlogin3);


        botonlogin3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = edtuser3.getText().toString();
                password = edtpass3.getText().toString();

                if (!email.isEmpty() && !password.isEmpty()){
                   loginUser();
                }
                else{
                    Toast.makeText(InicioSes.this, "Completar los campos", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private void loginUser(){

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    startActivity(new Intent( InicioSes.this, MainActivity.class));
                    finish();
                }else{
                    Toast.makeText(InicioSes.this, "Error, compruebe los datos ingresados", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}