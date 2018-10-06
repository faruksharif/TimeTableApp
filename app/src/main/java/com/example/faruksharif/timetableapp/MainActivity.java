package com.example.faruksharif.timetableapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView timeTablesListView;

    public void generateTimesTable(int timeTablesNumber){


        ArrayList<String> timeTablesContent=new ArrayList<String>();

        for(int i=1;i<=10;i++){
            timeTablesContent.add(Integer.toString(i*timeTablesNumber));
        }

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timeTablesContent);
        timeTablesListView.setAdapter(arrayAdapter);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        final SeekBar timeTablesSeekBar=findViewById(R.id.timeTablesSeekBar);
        timeTablesListView=findViewById(R.id.timeTablesListView);

        timeTablesSeekBar.setMax(20);
        timeTablesSeekBar.setProgress(1);

        timeTablesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int min=1;
                int timeTablesNumber;

                if(progress<min){
                    timeTablesNumber=min;
                    timeTablesSeekBar.setProgress(min);

                }else{
                    timeTablesNumber=progress;}
                    Log.i("seek progress", Integer.toString(timeTablesNumber));
                generateTimesTable(timeTablesNumber);

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
