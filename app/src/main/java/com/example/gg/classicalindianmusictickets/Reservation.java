package com.example.gg.classicalindianmusictickets;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class Reservation extends AppCompatActivity {
String groupChoice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        final TextView reservations = (TextView) findViewById(R.id.txtReservation);
        Button btDate = (Button) findViewById(R.id.btnDate);
        final Calendar c = Calendar.getInstance();
        final DateFormat fntDate = DateFormat.getDateInstance();
        Spinner spinner = (Spinner) findViewById(R.id.txtGroup);
        final Spinner group= (Spinner)findViewById(R.id.txtGroup);
        final DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                c.set(Calendar.YEAR, year);
                c.set(Calendar.MONTH, monthOfYear);
                c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                groupChoice = group.getSelectedItem().toString();
                reservations.setText("Your Reservation is set for" + fntDate.format(c.getTime()) +" at "+groupChoice);
            }
        };

        btDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(Reservation.this, d, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }
    }

