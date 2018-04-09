package org.androidtown.c12_redrectangle;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    ImageView rec;
    RelativeLayout layout;
    float oldX, oldY;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = (RelativeLayout) findViewById(R.id.layout);
        rec = (ImageView) findViewById(R.id.rec);
        rec.setOnTouchListener(new View.OnTouchListener() {


            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();

                float curX = event.getX();
                float curY = event.getY();

                switch (action){
                    case MotionEvent.ACTION_DOWN:
                        oldX = curX;
                        oldY = curY;
                        break;

                    case MotionEvent.ACTION_MOVE:
                        if ((oldX > 0 || oldY > 0) && (curX > 0 || curX < layout.getWidth() || curY > 0 || curY < layout.getHeight())){
                            rec.setX(curX);
                            rec.setY(curY);
                        }
                        break;

                    case MotionEvent.ACTION_UP:
                        oldX = -1;
                        oldY = -1;
                        break;

                }
                return true;
            }

        });
    }
}
