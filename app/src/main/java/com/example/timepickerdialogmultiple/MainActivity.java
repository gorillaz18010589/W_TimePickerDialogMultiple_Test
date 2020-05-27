package com.example.timepickerdialogmultiple;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btnTime1, btnTime2;
    private ArrayList<TimePickerDialog> timePickerDialogArrayList;
    private TimePickerDialog timePickerDialog1, timePickerDialog2;
    private int which;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        btnTime1 = findViewById(R.id.btn_1);
        btnTime2 = findViewById(R.id.btn_2);

        btnTime1.setOnClickListener(monClickListener);
        btnTime2.setOnClickListener(monClickListener);

        timePickerDialog1 = getTimePikceDialog(this,timeSetListener,0,0,false);
        timePickerDialog2 = getTimePikceDialog(this,timeSetListener,0,0,false);
        timePickerDialogArrayList = new ArrayList<>();
        timePickerDialogArrayList.add(timePickerDialog1);
        timePickerDialogArrayList.add(timePickerDialog2);


        Log.v("hank", "btntimePickerDialogArrayList.add:" + timePickerDialogArrayList.get(0));
    }

    private TimePickerDialog getTimePikceDialog(Context context, TimePickerDialog.OnTimeSetListener timeSetListener, int hourOfDay, int munute, boolean is24HourView) {
        TimePickerDialog timePickerDialog = new TimePickerDialog(context, timeSetListener, hourOfDay, munute, is24HourView);
        return timePickerDialog;
    }

    View.OnClickListener monClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_1:
                    which = 2;
                    timePickerDialog1.show();
                    Log.v("hank", "btn_1");

                    break;
                case R.id.btn_2:
                    which = 3;
                    timePickerDialog1.show();
                    Log.v("hank", "btn_2");
                    break;
            }
        }
    };

    TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            if (which == 2) {
                Log.v("hank", "which:" + which);
            } else if (which == 3) {
                Log.v("hank", "which:" + which);
            }
        }
    };
}
