package com.example.gg.classicalindianmusictickets;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import java.text.DateFormat;
import java.util.Calendar;

    public class reserve extends AppCompatActivity {


          public View onCreateView(Bundle savedInstanceState) {
            final    TextView reservations = (TextView) findViewById(R.id.txtReservation);
                Button btDate = (Button) findViewById(R.id.btnDate);
              final  Calendar c = Calendar.getInstance();
             final   DateFormat fntDate = DateFormat.getDateInstance();
            final  DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
                  @Override
                  public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                      c.set(Calendar.YEAR, year);
                      c.set(Calendar.MONTH, monthOfYear);
                      c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                      reservations.setText("Your Reservation is set for" + fntDate.format(c.getTime()));
                  }
              };

              btDate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {
                        new DatePickerDialog(reserve.this, d,c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
                    }
                });
                return reservations;
            }
    }