package com.example.mygame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;

public class flinFish extends View {
      private Bitmap fish[]=new Bitmap[2];
      private Bitmap bracgrundImage;
      private int fishX=10;
      private int fishY;
      private int canvasWidth,canvasHight;
      private int fishspeed;
      private Boolean toch=false;

      private Paint score=new Paint();

      private  Bitmap life[]=new Bitmap[2];

      private int scor;

      // yellow   ball ----------------

    private  int yellowX,yellowY,yellowspeed=17;
    private Paint yellowpaint=new Paint();
    private Paint yellowpaint2=new Paint();
//-----------------------------------------


    //green ball----------

    private int greenX,greenY,greenspeed=15;
    private Paint greenpaint=new Paint();
    private Paint greenpaint2=new Paint();
    //--------------------------------


    // red ball hits --------------
    private  int redX,redY,redspeed=12;
    private  Paint redpaint= new Paint();
    private  Paint redpaint2= new Paint();
    //------------------------------


    public flinFish(Context context) {
        super(context);

        fish[0]= BitmapFactory.decodeResource(getResources(),R.drawable.fish1);
        fish[1]= BitmapFactory.decodeResource(getResources(),R.drawable.fish2);
        bracgrundImage=BitmapFactory.decodeResource(getResources(),R.drawable.background);
        score.setColor(Color.WHITE);
        score.setTextSize(70);
        score.setTypeface(Typeface.DEFAULT_BOLD);
        score.setAntiAlias(true);

        life[0]=BitmapFactory.decodeResource(getResources(),R.drawable.hearts);
        life[1]=BitmapFactory.decodeResource(getResources(),R.drawable.heart_grey);

        // yellow ball
        yellowpaint.setColor(Color.YELLOW);
        yellowpaint.setAntiAlias(false);

      //green balll---------------
        greenpaint.setColor(Color.GREEN);
        greenpaint.setAntiAlias(false);

        // red ball ------------
        redpaint.setColor(Color.RED);
        redpaint.setAntiAlias(false);

        fishY=0;
        scor=0;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // fish canvas width and higt---------
        canvasWidth=canvas.getWidth();
        canvasHight=canvas.getHeight();

        //---------------------------------------

        canvas.drawBitmap(bracgrundImage,0,0,null);
     // move the fish code --------------------------------------------------------
        int mainFishY=fish[0].getHeight();
        int maxFishY=canvasHight-fish[0].getHeight();



        fishY=fishY+fishspeed;

        if(fishY<mainFishY)
        {
             fishY=mainFishY;

        }
        if(fishY>maxFishY)
        {
            fishY=maxFishY;

        }

        fishspeed=fishspeed+2;

        if(toch)
        {


            canvas.drawBitmap(fish[1],fishX,fishY,null);
            toch=false;

        }else {
            canvas.drawBitmap(fish[0],fishX,fishY,null);

        }

//----------------------------------------------------------------------------------


        yellowX=yellowX-yellowspeed;

        if(hitball(yellowX,yellowY))
        {
            scor=scor+10;
            yellowX= -100;

        }


        if(yellowX<0)
        {
         yellowX=canvasWidth+21;
        yellowY=(int)Math.floor(Math.random()*(maxFishY-mainFishY))+(mainFishY+50);



        }

        canvas.drawCircle(yellowX,yellowY,25,yellowpaint);

        // greeen ball ----------------

        greenX=greenX-greenspeed;

        if(hitball(greenX,greenY))
        {
            scor=scor+20;
            greenX= -100;

        }


        if(greenX<0)
        {
            greenX=canvasWidth+21;

             greenY=(int)Math.floor(Math.random()*(maxFishY-mainFishY))+(mainFishY+100);




        }

        canvas.drawCircle(greenX,greenY,30,greenpaint);








        canvas.drawText("Score :"+scor,40,80,score);

        canvas.drawBitmap(life[0],420,40,null);
        canvas.drawBitmap(life[0],500,40,null);
        canvas.drawBitmap(life[0],580,40,null);


    }


    public  Boolean hitball(int x,int y)

    {

        if(fishX<x && x<(fishX+fish[0].getWidth()) && fishY<y && y<(fishY+fish[0].getHeight()))
        {
            return true;

        }

      return false;

    }




    @Override
    public boolean onTouchEvent(MotionEvent event) {


        if(event.getAction()==MotionEvent.ACTION_DOWN)
        {
              toch=true;
              fishspeed=-22;

        }

        return true;


    }
}
