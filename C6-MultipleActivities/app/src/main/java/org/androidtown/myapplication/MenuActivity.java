package org.androidtown.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent = new Intent(this.getIntent());
        String username = intent.getStringExtra("Username");
        String password = intent.getStringExtra("Password");

        Toast.makeText(getApplicationContext(), "Username: "  + username + " Password: " + password, Toast.LENGTH_LONG).show();
    }
}
