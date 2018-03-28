package org.androidtown.c7_infoinputpage;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.*;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
    Button button, saveBtn;
    EditText name, age;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        saveBtn = (Button) findViewById(R.id.saveBtn);
        name = (EditText) findViewById(R.id.editText2);
        age = (EditText) findViewById(R.id.editText3);


        button.setText(date);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.support.v4.app.DialogFragment datePicker = new DateFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "저장된 정보: " + name.getText() + ", " + age.getText() + ", " + button.getText(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        String currentDateString = DateFormat.getDateInstance().format(c.getTime());
        button.setText(currentDateString);
    }
}
