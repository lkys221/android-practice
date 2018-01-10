package org.androidtown.apptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView, imageView2;
    int imageIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
    }

    public void onButton1Clicked(View v) {
        changeImage();
    }

    private void changeImage() {
        if(imageIndex == 0){
            imageView.setImageResource(R.drawable.cat1);
            imageView2.setImageResource(R.drawable.dog);

            imageIndex = 1;
        }
        else if(imageIndex == 1){
            imageView.setImageResource(R.drawable.dog);
            imageView2.setImageResource(R.drawable.cat1);

            imageIndex = 0;
        }
    }


}
