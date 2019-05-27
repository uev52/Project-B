package com.example.hroopendagtest1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread thread;

    private Entity player;


    

    private float scaleX;
    private float scaleY;





    

    public GamePanel(Context context){
        super(context);
        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);
        setFocusable(true);

        player = new Entity(new Point(), new Rect(0, 0, 100, 100), Color.RED);



    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        thread = new MainThread(getHolder(), this);

        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        boolean retry = true;
        while(true){
            try{
                thread.setRunning(false);
                thread.join();

            }catch (Exception e){ e.printStackTrace(); }
            retry = false;


        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                player.setPosition(x, y);
                break;

            case MotionEvent.ACTION_UP:

                break;


        }

        return true;
    }

    public void swipeUp(){

    }
    public void swipeRight(){

    }
    public void swipeDown(){

    }
    public void swipeLeft(){

    }



    public void update() {
    }

    public void draw(Canvas canvas){
        super.draw(canvas);

        // background
        canvas.drawColor(Color.YELLOW);

        player.draw(canvas);
    }
}
