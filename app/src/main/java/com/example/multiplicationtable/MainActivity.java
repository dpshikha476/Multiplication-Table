package com.example.multiplicationtable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timesTableListView;
    public void generateTimesTable(int timesTableNumber)
    {
        ArrayList<String> timesTableContent = new ArrayList<String>();
        for(int j=1; j<=40; j++)
        {
            timesTableContent.add(Integer.toString(timesTableNumber) + " x " + Integer.toString(j) + " = " + Integer.toString(j*timesTableNumber));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,timesTableContent);
        timesTableListView.setAdapter(arrayAdapter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timesTableSeekBar = findViewById(R.id.timesTableSeekBar);
        timesTableListView = findViewById(R.id.timesTableListView);

        int max= 40;
        int Starting= 20;

        timesTableSeekBar.setMax(max);
        timesTableSeekBar.setProgress(Starting);

        generateTimesTable(Starting);

        timesTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min=1;
                int timesTableNumber;
                if(progress < min)
                {
                    timesTableNumber = min;
                    timesTableSeekBar.setProgress(min);
                }
                else
                {
                    timesTableNumber= progress;
                }
                Log.i("Seekbar Value", Integer.toString(timesTableNumber));
                generateTimesTable(timesTableNumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}