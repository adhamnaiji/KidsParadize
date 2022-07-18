package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private ImageView p;
private TextView a,s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.p=(ImageView) findViewById(R.id.parametre);
        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent add_act=new Intent(getApplicationContext(),parametre.class);
                startActivity(add_act);
                finish();
            }
        });
        this.a=(TextView) findViewById(R.id.addi);
        this.s=(TextView) findViewById(R.id.soussi);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent add_a=new Intent(getApplicationContext(),Addition.class);
                startActivity(add_a);
                finish();
            }
        });
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent add_s=new Intent(getApplicationContext(),Soustraction.class);
                startActivity(add_s);
                finish();
            }
        });


    }
}