package org.androidtown.c4_numbercount;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msg = (EditText) findViewById(R.id.textbox);

    }


    public void onSendBtnClicked(View v){

    }

    public void onCloseBtnClicked(View v){

    }


}
