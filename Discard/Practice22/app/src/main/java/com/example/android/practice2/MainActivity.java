package com.example.android.practice2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void printToLogs(View view) {
        // Find first menu item TextView and print the text to the logs
        TextView first = (TextView)findViewById(R.id.menu_item_1);
        String menu1 = first.getText().toString();
        Log.e("MainActivity",menu1);
        // Find second menu item TextView and print the text to the logs
        TextView second = (TextView)findViewById(R.id.menu_item_2);
        String menu2 = second.getText().toString();
        Log.e("MainActivity",menu2);

        // Find third menu item TextView and print the text to the logs
        TextView third = (TextView)findViewById(R.id.menu_item_3);
        String menu3 = third.getText().toString();
        Log.v("MainActivity",menu3);
    }
}