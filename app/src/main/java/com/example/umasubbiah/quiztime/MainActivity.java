package com.example.umasubbiah.quiztime;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void evaluate(View v) {

        int plus = 0;
        int minus = 0;

        //For q1:

        RadioGroup q1 = (RadioGroup) findViewById(R.id.q1);
        RadioButton answer1 = (RadioButton) findViewById(q1.getCheckedRadioButtonId());
        RadioButton correct1 = (RadioButton) findViewById(R.id.q1a1);

        if (answer1 == correct1) {
            plus += 4;
        } else if (answer1 == null) {
            plus+=0;
        } else {
            minus++;
        }

        //For q2:
        EditText e2 = (EditText) findViewById(R.id.q2a1);
        String answer2 = e2.getText().toString();

        if (answer2.equalsIgnoreCase("Mercury")) {
            plus += 4;
        } else if (TextUtils.isEmpty(answer2)) {
            plus+=0;
        } else {
            minus++;
        }

        //For q3:
        CheckBox c3a1 = (CheckBox) findViewById(R.id.q3a1);
        CheckBox c3a2 = (CheckBox) findViewById(R.id.q3a2);
        CheckBox c3a3 = (CheckBox) findViewById(R.id.q3a3);
        CheckBox c3a4 = (CheckBox) findViewById(R.id.q3a4);

        if (c3a1.isChecked() && !c3a2.isChecked() && c3a3.isChecked() && !c3a4.isChecked())
            plus += 4;
        else if (c3a1.isChecked() || c3a3.isChecked())
            plus += 2;
        else if (!c3a1.isChecked() && !c3a2.isChecked() && !c3a3.isChecked() && !c3a4.isChecked())
            plus += 0;
        else {
            minus += 2;
        }

        //For q4:
        RadioGroup q4 = (RadioGroup) findViewById(R.id.q4);
        RadioButton answer4 = (RadioButton) findViewById(q4.getCheckedRadioButtonId());
        RadioButton correct4 = (RadioButton) findViewById(R.id.q4a1);

        if (answer4 == correct4) {
            plus += 4;
        } else if (answer4 == null) {
            plus+=0;
        } else {
            minus++;
        }

        //For q5:
        EditText e5 = (EditText) findViewById(R.id.q5a1);
        String answer5 = e5.getText().toString();

        if (answer5.equalsIgnoreCase("Roentgen")||answer5.contains("Roentgen")) {
            plus += 4;
        } else if (TextUtils.isEmpty(answer5)){
            plus+=0;
        } else {
            minus++;
        }

        //For q6:
        CheckBox c6a1 = (CheckBox) findViewById(R.id.q6a1);
        CheckBox c6a2 = (CheckBox) findViewById(R.id.q6a2);
        CheckBox c6a3 = (CheckBox) findViewById(R.id.q6a3);
        CheckBox c6a4 = (CheckBox) findViewById(R.id.q6a4);

        if (!c6a1.isChecked() && c6a2.isChecked() && !c6a3.isChecked() && c6a4.isChecked()) {
            plus += 4;
        } else if (c6a2.isChecked() || c6a4.isChecked())
            plus += 2;
        else if (!c6a1.isChecked() && !c6a2.isChecked() && !c6a3.isChecked() && !c6a4.isChecked())
            plus += 0;
        else {
            minus += 2;
        }

        //For q7:
        RadioGroup q7 = (RadioGroup) findViewById(R.id.q7);
        RadioButton answer7 = (RadioButton) findViewById(q7.getCheckedRadioButtonId());
        RadioButton correct7 = (RadioButton) findViewById(R.id.q7a3);

        if (answer7 == correct7) {
            plus += 4;
        } else if (answer7 == null) {
            plus+=0;
        } else {
            minus++;
        }

        //For q8:
        EditText e8 = (EditText) findViewById(R.id.q8a1);
        String answer8 = e8.getText().toString();

        if (answer8.equalsIgnoreCase("Salivary gland") || answer8.contains("Salivary")) {
            plus += 4;
        } else if (TextUtils.isEmpty(answer8)){
            plus+=0;
        } else {
            minus++;
        }

        //For q9:
        CheckBox c9a1 = (CheckBox) findViewById(R.id.q9a1);
        CheckBox c9a2 = (CheckBox) findViewById(R.id.q9a2);
        CheckBox c9a3 = (CheckBox) findViewById(R.id.q9a3);
        CheckBox c9a4 = (CheckBox) findViewById(R.id.q9a4);

        if (c9a1.isChecked() && !c9a2.isChecked() && c9a3.isChecked() && !c9a4.isChecked()) {
            plus += 4;
        } else if (c9a2.isChecked() || c9a4.isChecked())
            plus += 2;
        else if (!c9a1.isChecked() && !c9a2.isChecked() && !c9a3.isChecked() && !c9a4.isChecked())
            plus += 0;
        else {
            minus += 2;
        }

        //For q10:
        EditText e10 = (EditText) findViewById(R.id.q10a1);
        String answer10 = e10.getText().toString();

        if (answer10.equalsIgnoreCase("Pea") || answer10.contains("Pea")) {
            plus += 4;
        }else if (TextUtils.isEmpty(answer10)) {
            plus+=0;
        } else {
            minus++;
        }
        calc(plus, minus);
    }

    public void calc(int plus, int minus) {
        int score = plus - minus;
        displayMarks(score);
    }

    public void displayMarks(int score) {
        Resources res = getResources();
        String message;
        if (score >= 30)
            message=res.getString(R.string.congo);
        else if (score >= 20)
            message=res.getString(R.string.amaze);
        else if (score >= 10)
            message=res.getString(R.string.well);
        else
            message=res.getString(R.string.hey);
        String message_complete = res.getString(R.string.score)+" " +score+message;
        Toast.makeText(getApplicationContext(),message_complete,Toast.LENGTH_SHORT).show();

    }
}