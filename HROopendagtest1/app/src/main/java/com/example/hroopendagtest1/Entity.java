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
        int touchX = (int) x_;
        int touchY = (int) y_;
        int centerX = touchX + size/2;
        int centerY = touchY + size/2;

        position.set(touchX, touchY);
        rectangle.set(x, y, centerX + size/2, centerY + size/2);
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

    public void update(Point point) {
        rectangle.set(point.x - rectangle.width() / 2, point.y - rectangle.height() / 2,
                point.x + rectangle.width() / 2, point.y + rectangle.height() / 2);
    }

}
