package org.androidtown.c8webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout slide;
    Animation translateBottom, translateClose;
    Button button;
    boolean isPageOpen = false;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        slide = (LinearLayout) findViewById(R.id.url);
        button = (Button) findViewById(R.id.button);
        translateBottom = AnimationUtils.loadAnimation(this, R.anim.translate_down);
        translateClose = AnimationUtils.loadAnimation(this, R.anim.translate_close);

        webView = (WebView) findViewById(R.id.webview);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        Button button2 = (Button) findViewById(R.id.button2);
        final EditText editText = (EditText) findViewById(R.id.editText);

        SlidingAnimationListener listener = new SlidingAnimationListener();
        translateBottom.setAnimationListener(listener);
        translateClose.setAnimationListener(listener);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPageOpen){
                    slide.startAnimation(translateClose);
                }
                else{
                    slide.setVisibility(View.VISIBLE);
                    slide.startAnimation(translateBottom);
                }

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slide.startAnimation(translateClose);
                webView.loadUrl(editText.getText() + "");
            }
        });


    }

    class SlidingAnimationListener implements Animation.AnimationListener {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            if(isPageOpen){
                slide.setVisibility(View.INVISIBLE);
                button.setText("열기");
                isPageOpen = false;
            }else{
                button.setText("닫기");
                isPageOpen = true;
            }
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}
