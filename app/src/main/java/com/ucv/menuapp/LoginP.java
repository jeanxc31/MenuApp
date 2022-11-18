package com.ucv.menuapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LoginP extends AppCompatActivity{


    private Button botonregistro;
    private EditText edtuser2, edtpass, edtname;

    //variables
    private String name="";
    private String user ="";
    private String pass = "";

    FirebaseAuth mAuth;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_p);

        //REFERENCIA FIREBASE
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference("Usuarios");

        //VARIABLES
        edtuser2 = findViewById(R.id.edtuser3);
        edtname = findViewById(R.id.edtname);
        edtpass = findViewById(R.id.edtpass3);
        botonregistro = findViewById(R.id.botonregistro);


        botonregistro.setOnClickListener(new OnClickListener() {
            @Override

            public void onClick(View view) {

                name = edtname.getText().toString();
                user = edtuser2.getText().toString();
                pass = edtpass.getText().toString();

                if (!name.isEmpty() && !user.isEmpty() && !pass.isEmpty()) {

                    if (pass.length() >= 6) {
                        registerUser();

                    } else {
                        Toast.makeText(LoginP.this, "La contraseña debe tener al menos 6 caracteres", Toast.LENGTH_LONG).show();

                    }

                } else {
                    Toast.makeText(LoginP.this, "Debe completar los campos", Toast.LENGTH_LONG).show();
                }
            }

        });


    }

    private void registerUser(){
      mAuth.createUserWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
          @Override
          public void onComplete(@NonNull Task<AuthResult> task) {

              if (task.isSuccessful()){
                  Map<String, Object> map = new HashMap<>();
                  map.put("name", name);
                  map.put("email", user);
                  map.put("pass", pass);


                  String id = Objects.requireNonNull(mAuth.getCurrentUser()).getUid();
                  mDatabase.child("Users").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                      @Override
                      public void onComplete(@NonNull Task<Void> task2) {
                          if(task2.isSuccessful()){
                              startActivity(new Intent ( LoginP.this, MainActivity.class));
                              finish();
                          }
                          else{
                              Toast.makeText(LoginP.this, "No se pudieron crear los datos correctamente", Toast.LENGTH_LONG).show();
                          }
                      }
                  });


              }else{
                  Toast.makeText(LoginP.this, "No se pudo registrar el usuario", Toast.LENGTH_LONG).show();
              }
          }
      });
    }
    public void irLogin(View view) {

        Intent intent = new Intent
                (this, InicioSes.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (mAuth.getCurrentUser() !=null){
            startActivity(new Intent(LoginP.this, MainActivity.class));
            finish();
        }
    }
}