package org.androidtown.c4_numbercount;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView textview;
    EditText edittext;
    Button sendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();

        textview = (TextView) findViewById(R.id.currentNumber);
        edittext = (EditText) findViewById(R.id.textbox);

        edittext.addTextChangedListener(new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            int length = edittext.length();
            String convert = String.valueOf(length);
            textview.setText(convert);
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) { }

        @Override
        public void afterTextChanged(Editable s) { }

    });

    }

    public void addListenerOnButton() {
        edittext = (EditText) findViewById(R.id.textbox);
        sendBtn = (Button) findViewById(R.id.sendBtn);

        sendBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
                toast.makeText(MainActivity.this, edittext.getText(), toast.LENGTH_SHORT).show();
            }

        });
    }

    public void onCloseBtnClicked(View v){
        Toast.makeText(getApplicationContext(), "You've clicked Close button", Toast.LENGTH_SHORT).show();
    }


}
