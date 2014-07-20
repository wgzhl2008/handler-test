package com.hongshu;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {
    private Button startBtn=null;
    private Button endBtn=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        startBtn= (Button) findViewById(R.id.startButton);
        endBtn= (Button) findViewById(R.id.endButton );
        startBtn.setOnClickListener(new StartBtnListener());
        endBtn.setOnClickListener(new EndBtnListener());


    }
    Handler handler = new Handler( );
    class StartBtnListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            handler.post(updateThread);
        }
    }
    class EndBtnListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
        handler.removeCallbacks(updateThread);
        }
    }
    Runnable updateThread = new Runnable() {
        @Override
        public void run() {
            System.out.println("update thread");
            handler.postDelayed(updateThread,3*1000);
        }
    };
}
