package com.example.mygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public TextView fish;
    public ImageView imge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fish=findViewById(R.id.text);
        imge=findViewById(R.id.imge_fish);

       Animation an= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.myanim);
        imge.setAnimation(an);

        new Thread(){

            @Override
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                finally {
                    Intent in=new Intent(getApplicationContext(),fishmove.class);
                    startActivity(in);
                    MainActivity.this.finish();
                }

            }
        }.start();




    }
}