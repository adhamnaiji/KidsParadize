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

public class QuestionsActivity2 extends AppCompatActivity {

    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1, rb2, rb3, rb4;

    String questions[] = {
            "11 banana + 21 bananas =?",
            "21 bananas  + 21 bananas =?",
            "31 bananas  + 61 bananas =?",
            "41 bananas  + 51 bananas =?",
            "51 bananas  + 11 banana =?",
            "61 bananas  + 41 bananas =?",
            "71 bananas  + 41 bananas =?",
            "81 bananas  + 51 bananas =?",
            "91 bananas  + 11 banana =?",
            "10 bananas  + 21 bananas =?"
    };
    String answers[] = {"32 bananas", "42 bananas", "92 bananas", "92 bananas", "62 bananas", "102 bananas", "112 bananas", "132 bananas", "102 bananas", "31 bananas"};
    String opt[] = {

            "515 bananas", "32 bananas", "45 bananas", "none",
            "45 bananas", "54 bananas", "none", "42 bananas",
            "none", "92 bananas", "58 bananas", "875 bananas",
            "214 bananas", "92 bananas", "none", "481 bananas",
            "62 bananas", "none", "245 bananas", "248 bananas",
            "none", "102 bananas", "451 bananas", "015 bananas",
            "54 bananas", "554 bananas", "none", "112 bananas",
            "54 bananas", "132 bananas", "none", "544 bananas",
            "102 bananas", "none", "548 bananas", "557 bananas",
            "31 bananas", "none", "87 bananas", "488 bananas"
    };
    int flag = 0;
    public static int marks = 0, correct = 0, wrong = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions2);

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
                    Intent in = new Intent(getApplicationContext(), ResultActivity2.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ResultActivity2.class);
                startActivity(intent);
                finish();
            }
        });

    }
}