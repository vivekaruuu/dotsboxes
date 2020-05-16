package com.example.dotsandboxesgame;

import android.graphics.Paint;
import android.graphics.Path;

public class Stroke {
    Path path;
    Paint paint;




    Stroke(int color){
        path = new Path();

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(20);
        paint.setColor(color);
        paint.setStyle(Paint.Style.STROKE);
    }
}