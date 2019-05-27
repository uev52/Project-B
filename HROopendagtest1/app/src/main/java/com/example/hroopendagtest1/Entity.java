package com.example.hroopendagtest1;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

public class Entity implements GameObject {

    private Point position;
    private Rect rectangle;
    private int color;
    private int size = 100;

    public Entity(Point position, Rect rectangle, int color) {
        this.position = position;
        this.rectangle = rectangle;
        this.color = color;
    }

    public void setPosition(float x_, float y_) {
        int x = (int) x_;
        int y = (int) y_;

        position.set(x, y);
        rectangle.set(x - size / 2, y - size / 2,
                x + size / 2, y + size / 2);
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

}
