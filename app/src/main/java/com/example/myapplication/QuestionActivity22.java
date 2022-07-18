package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionActivity22 extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1, rb2, rb3, rb4;

    String questions[] = {
            "10 Bear - 10 Bear=?",
            "20 Bears - 10 Bear=?",
            "40 Bears - 30 Bears=?",
            "40 Bears - 10 Bear=?",
            "50 Bears - 40 Bears=?",
            "60 Bears - 20 Bears=?",
            "70 Bears - 40 Bears=?",
            "80 Bears - 50 Bears=?",
            "90 Bears - 10 Bear=?",
            "30 Bears - 10 Bear=?"
    };
    String answers[] = {"0 Bears", "10 Bear", "10 Bear", "30 Bears", "10 Bear", "40 Bears", "30 Bears", "30 Bears", "80 Bears", "20 Bears"};
    String opt[] = {
            "1 Bears", "0 Bears", "7 Bears", "8 Bears",
            "5 Bears", " 9 Bears", "11 Bears", "10 Bear",
            "12 Bears", "10 Bear", "66 Bears", "77 Bears",
            "10 Bears", "30 Bears", "none", "20 Bears",
            "10 Bear", "none", "11 Bears", " 17 Bears",
            "77 Bears", "40 Bears", "88 none", "33 Bears",
            "33 Bears", "none", "25 Bears", "30 Bears",
            "77 Bears", "30 Bears", "none", "48 Bears",
            "80 Bears", "none", "50 Bears", "60 Bears",
            "20 Bears", "none", "60 Bears", "21 Bears"
    };
    int flag = 0;
    public static int marks = 0, correct = 0, wrong = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question22);



        final TextView score = (TextView) findViewById(R.id.textView4);
        TextView textView = (TextView) findViewById(R.id.DispName);

        submitbutton = (Button) findViewById(R.id.button3);
        quitbutton = (Button) findViewById(R.id.buttonquit);
        tv = (TextView) findViewById(R.id.tvque);

        radio_g = (RadioGroup) findViewById(R.id.answersgrp);
        rb1 = (RadioButton) findViewById(R.id.radioButton);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb3 = (RadioButton) findViewById(R.id.radioButton3);
        rb4 = (RadioButton) findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if (radio_g.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if (ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                } else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText("" + correct);

                if (flag < questions.length) {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag * 4]);
                    rb2.setText(opt[flag * 4 + 1]);
                    rb3.setText(opt[flag * 4 + 2]);
                    rb4.setText(opt[flag * 4 + 3]);
                } else {
                    marks = correct;
                    Intent in = new Intent(getApplicationContext(),ResutActivity22.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ResutActivity22.class);
                startActivity(intent);
                finish();
            }
        });
    }
}