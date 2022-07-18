package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Soustraction extends AppCompatActivity {
    private Button b1,b2,b3;
    private ImageView ss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soustraction);
        b1=(Button) findViewById(R.id.button4);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b1.setBackgroundResource(R.color.purple_200);
                Intent Q_2=new Intent(Soustraction.this,QuestionActivity00.class);
                startActivity(Q_2);
                finish();
    }});
        ss=(ImageView)findViewById(R.id.imageView4);
        ss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent neww=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(neww);
                finish();
            }
        });


        b2=(Button) findViewById(R.id.button5);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b2.setBackgroundResource(R.color.purple_200);
                Intent Q_2=new Intent(Soustraction.this,QuestionActivity22.class);
                startActivity(Q_2);
                finish();

            }
        });





        b3=(Button) findViewById(R.id.button6);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b3.setBackgroundResource(R.color.purple_200);
                Intent Q_2=new Intent(Soustraction.this,QuestionActivity33.class);
                startActivity(Q_2);
                finish();

            }
        });
}
}