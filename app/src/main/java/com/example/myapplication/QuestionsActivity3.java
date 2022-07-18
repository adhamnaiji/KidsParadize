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

public class QuestionsActivity3 extends AppCompatActivity {


    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1, rb2, rb3, rb4;

    String questions[] = {
            "111 orange + 211 oranges=?",
            "211 oranges + 211 oranges=?",
            "311 oranges + 611 oranges=?",
            "411 oranges + 511 oranges=?",
            "511 oranges + 111 orange=?",
            "611 oranges + 411 oranges=?",
            "711 oranges + 411 oranges=?",
            "811 oranges + 511 oranges=?",
            "911 oranges + 111 oranges=?",
            "111 orange + 211 oranges=?"
    };
    String answers[] = {"322 oranges", "422 oranges", "922 oranges", "922 oranges", "622 oranges", "1022 oranges", "1122 oranges", "1322 oranges", "1022 oranges", "322 oranges"};
    String opt[] = {
            "848 oranges", "322 oranges", "44 oranges", "none",
            "44 oranges", "21 oranges", "none", "422 oranges",
            "24 none", "922 oranges", "022 oranges", "87 oranges",
            "44 oranges", "922 oranges", "none", "14 oranges",
            "622 oranges", "none", "78 oranges", "98 oranges",
            "none", "1022 oranges", "87 oranges", "77 oranges",
            "74 oranges", "025 oranges", "none", "1122 oranges",
            "20 oranges", "1322 oranges", "none", "78 oranges",
            "1022 oranges", "none", "85 oranges", "14 oranges",
            "322 oranges", "none", "88 oranges", "25 oranges"
    };
    int flag = 0;
    public static int marks = 0, correct = 0, wrong = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions3);


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
                    Intent in = new Intent(getApplicationContext(),ResultActivity3.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ResultActivity3.class);
                startActivity(intent);
                finish();
            }
        });

    }
}