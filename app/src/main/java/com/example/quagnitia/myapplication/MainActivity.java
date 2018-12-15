package com.example.quagnitia.myapplication;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnsubmit;
    EditText ename, eid, eage, emale, eaddr;
    TextView ebdate;
    String name = "", id = "", age = "", male = "", bdate = "", addr = "";
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnsubmit = findViewById(R.id.btnsubmit);

        ename = findViewById(R.id.ename);
        eid = findViewById(R.id.eid);
        eage = findViewById(R.id.eage);
        emale = findViewById(R.id.emale);
        ebdate = findViewById(R.id.ebdate);
        eaddr = findViewById(R.id.eaddr);


        ebdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dpd =new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        String currentYear = year+"/"+month+"/"+day;
                        ebdate.setText(currentYear);
                    }
                },mYear,mMonth,mDay);

                dpd.show();
            }
        });

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    Intent i = new Intent(context, FirstActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(context, "Invalid credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validate() {
        name = ename.getText().toString().trim();
        id = eid.getText().toString().trim();
        bdate = ebdate.getText().toString().trim();
        age = eage.getText().toString().trim();
        addr = eaddr.getText().toString().trim();
        male = emale.getText().toString().trim();

        if (name.equals("")) {
            ename.setError("Name cannot be empty");
            Toast.makeText(context, "Name cannot be empty", Toast.LENGTH_SHORT).show();
        } else if (id.equals("")) {
            eid.setError("id cannot be empty");
            Toast.makeText(context, " id cannot be empty", Toast.LENGTH_SHORT).show();
        } else if (bdate.equals("")) {
            ebdate.setError("Birthdate cannot be empty");
            Toast.makeText(context, "Birthdate cannot be empty", Toast.LENGTH_SHORT).show();

        } else if (age.equals("")) {
            eage.setError("Age cannot be empty");
            Toast.makeText(context, "Age cannot be empty", Toast.LENGTH_SHORT).show();

        } else if (addr.equals("")) {
            eaddr.setError("Birthdate cannot be empty");
            Toast.makeText(context, "Birthdate cannot be empty", Toast.LENGTH_SHORT).show();

        } else if (male.equals("")) {
            emale.setError("Birthdate cannot be empty");
            Toast.makeText(context, "Birthdate cannot be empty", Toast.LENGTH_SHORT).show();

        } else {
            return true;
        }


        return false;
    }
}
