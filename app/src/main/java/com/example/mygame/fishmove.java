package com.example.mygame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

import java.util.Timer;
import java.util.TimerTask;

public class fishmove extends AppCompatActivity {
    private flinFish gameView;
    private Handler handler=new Handler();
    private final static long interwal=30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        gameView=new flinFish(this);
        setContentView(gameView);


        Timer tim=new Timer();
        tim.schedule(new TimerTask() {
            @Override
            public void run() {
              handler.post(new Runnable() {
                  @Override
                  public void run() {
                      gameView.invalidate();
                  }
              });

            }
        },0,interwal);


    }
}