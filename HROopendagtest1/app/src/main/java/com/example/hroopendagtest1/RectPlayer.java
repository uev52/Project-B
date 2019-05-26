package com.example.hroopendagtest1;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

public class RectPlayer implements GameObject {

    private Point position;
    private Rect rectangle;
    private int color;

    public RectPlayer(Point position,Rect rectangle, int color){
        this.position = position;
        this.rectangle = rectangle;
        this.color = color;
    }

    public void setPosition(float x, float y){
        this.position.set((int)x , (int)y);
    }

    @Override
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(color);
        canvas.drawRect(rectangle, paint);
    }

    @Override
    public void update() {

    }

    public void update(Point point){
        rectangle.set(point.x - rectangle.width()/2, point.y - rectangle.height() / 2,
                point.x + rectangle.width()/2, point.y + rectangle.height() / 2);
    }

}
