package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Addition extends AppCompatActivity {
private Button b1,b2,b3;
private ImageView rr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);
        b1=(Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b1.setBackgroundResource(R.color.purple_200);
                Intent Q_1=new Intent(Addition.this,QuestionsActivity.class);
                startActivity(Q_1);
                finish();

            }
        });
        rr=(ImageView)findViewById(R.id.imageView5);
        rr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent neww=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(neww);
                finish();
            }
        });




        b2=(Button) findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b2.setBackgroundResource(R.color.purple_200);
                Intent Q_1=new Intent(Addition.this,QuestionsActivity2.class);
                startActivity(Q_1);
                finish();

            }
        });





        b3=(Button) findViewById(R.id.button3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b3.setBackgroundResource(R.color.purple_200);
                Intent Q_1=new Intent(Addition.this,QuestionsActivity3.class);
                startActivity(Q_1);
                finish();

            }
        });



    }
}