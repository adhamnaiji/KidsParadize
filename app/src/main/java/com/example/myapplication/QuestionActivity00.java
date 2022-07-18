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

public class QuestionActivity00 extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1, rb2, rb3, rb4;

    String questions[] = {
            "1 Monkey - 1 Monkey=?",
            "2 Monkeys - 1 Monkey=?",
            "4 Monkeys - 3 Monkeys=?",
            "4 Monkeys - 1 Monkey=?",
            "5 Monkeys - 4 Monkeys=?",
            "6 Monkeys - 2 Monkeys=?",
            "7 Monkeys - 4 Monkeys=?",
            "8 Monkeys - 5 Monkeys=?",
            "9 Monkeys - 1 Monkey=?",
            "3 Monkeys - 1 Monkey=?"
    };
    String answers[] = {"0 Monkeys", "1 Monkey", "1 Monkey", "3 Monkeys", "1 Monkey", "4 Monkeys", "3 Monkeys", "3 Monkeys", "8 Monkeys", "2 Monkeys"};
    String opt[] = {
            "2 Monkeys", "0 Monkeys", "8 Monkeys", "7 Monkeys",
            "3 Monkeys", "8 Monkeys", "10 Monkeys", "1 Monkey",
            "4 Monkeys", "1 Monkey", "22 Monkeys", "23 Monkeys",
            "5 Monkeys", "3 Monkeys", "none", "9 Monkeys",
            "1 Monkey", "none", "6 Monkeys", "7 Monkeys",
            "25 Monkeys", "4 Monkeys", "none", "Monkeys",
            "44 Monkeys", "none", "25 Monkeys", "3 Monkeys",
            "4 Monkeys", "3 Monkeys", "none", "Monkeys",
            "8 Monkeys", "none", "84 Monkeys", "87 Monkeys",
            "2 Monkeys", "none", "12 Monkeys", "11 Monkeys"
    };
    int flag = 0;
    public static int marks = 0, correct = 0, wrong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question00);
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
                    Intent in = new Intent(getApplicationContext(), ResutActivity00.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ResutActivity00.class);
                startActivity(intent);
                finish();
            }
        });
    }
}