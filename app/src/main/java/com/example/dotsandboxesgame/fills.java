package com.example.dotsandboxesgame;

import android.graphics.Paint;
import android.graphics.Path;

public class fills {
    Path path;
    Paint paint;




    fills(int color){
        path =new Path();

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(20);
        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL);
    }
}
