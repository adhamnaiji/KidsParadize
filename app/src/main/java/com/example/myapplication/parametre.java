package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

public class parametre extends AppCompatActivity {
private ImageView q,r;
private Switch d,ss;
MediaPlayer mysong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametre);
       this.q=(ImageView) findViewById(R.id.imageView10);
       this.r=(ImageView)findViewById(R.id.returnn);
       this.d=(Switch)findViewById(R.id.switch2);
       this.ss=(Switch)findViewById(R.id.switch1);
        mysong=MediaPlayer.create(this,R.raw.ech);
       ss.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
               if(b){
                   mysong.start();
               }
               else
                   mysong.pause();
           }
       });


       d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
               if(b){
                   AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
               }
               else
                   AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

           }
       });
       r.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent neww=new Intent(getApplicationContext(),MainActivity.class);
               startActivity(neww);
               finish();
           }
       });
       q.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               finish();
               System.exit(0);
           }
       });
    }
}