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

public class QuestionActivity33 extends AppCompatActivity {


    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1, rb2, rb3, rb4;

    String questions[] = {
            "111 tiger - 111 tiger=?",
            "211 tigers - 111 tiger=?",
            "411 tigers - 311 tigers=?",
            "411 tigers - 111 tiger=?",
            "511 tigers - 411 tigers=?",
            "611 tigers - 211 tigers=?",
            "711 tigers - 411 tigers=?",
            "811 tigers - 511 tigers=?",
            "911 tigers - 111 tiger=?",
            "311 tigers - 111 tiger=?"
    };
    String answers[] = {"0 tigers", "100 tiger", "100 tiger", "300 tigers", "100 tiger", "400 tigers", "300 tigers", "300 tigers", "800 tigers", "200 tigers"};
    String opt[] = {
            "11 tigers", "0 tigers", "112 tigers", "100 tigers",
            "484 tigers", "88 tigers", "5 tigers", "100 tiger",
            "82 tigers", "100 tiger", "54 tigers", "55 tigers",
            "84 tigers", "300 tigers", "none", "554 tigers",
            "100 tiger", "none", "451 tigers", "215 tigers",
            "555 tigers", "400 tigers", "none", "555 tigers",
            "245 tigers", "none", "tigers", "300 tigers",
            "545 tigers", "300 tigers", "none", "555 tigers",
            "800 tigers", "none", "525 tigers", "884 tigers",
            "200 tigers", "none", "552 tigers", "247 tigers"
    };
    int flag = 0;
    public static int marks = 0, correct = 0, wrong = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question33);


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
                    Intent in = new Intent(getApplicationContext(), ResutActivity33.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ResutActivity33.class);
                startActivity(intent);
                finish();
            }
        });

    }
}