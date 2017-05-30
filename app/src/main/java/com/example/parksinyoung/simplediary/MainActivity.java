package com.example.parksinyoung.simplediary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    int month;
    int day;
    int year;
    DatePicker date;
    EditText edit;
    Button but;
    String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        date = (DatePicker)findViewById(R.id.date_pick);
        edit = (EditText)findViewById(R.id.edit);
        but = (Button)findViewById(R.id.but);

        Calendar cal = Calendar.getInstance();//추상클래스이므로 new연산자 사용 불가
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DATE); //DAY_OF_MANTH도 선택가능
        date.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                fileName = year+" "+(month+1)+"_"+day+".txt";
                String readData = readDiary(fileName);
                edit.setText(readData);
                but.setEnabled(true);
            }
        });

    }
    public String readDiary(String fileName){
        return null;
    }
}
