package com.ucv.menuapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
private TextView txtuser1;
private FirebaseAuth mAuth;
private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //REFERENCIAS FIREBASE
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        txtuser1= (TextView) findViewById(R.id.txtuser1);
        getName();
    }


    private void getName(){
        String id= mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()){
                    String name = dataSnapshot.child("name").getValue().toString();

                    txtuser1.setText(name);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }



    public void irContrato(View view) {

        Intent intent = new Intent
                (this, Form_Contrato2.class);
        startActivity(intent);
    }

    public void irProd(View view) {

        Intent intent = new Intent
                (this, VistaProd.class);
        startActivity(intent);
    }



    public void Salir(View view){
        mAuth.signOut();

        Intent intent = new Intent
                (this, LoginP.class);
        startActivity(intent);

        finish();


    }

}