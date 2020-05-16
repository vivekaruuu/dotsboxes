package com.example.dotsandboxesgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import static com.example.dotsandboxesgame.checker.chance;


public class MyCanvas extends View {

    private static final String TAG = "MyCanvas";
    static List<Stroke> allStrokes = new ArrayList<Stroke>();
    static List<fills> allFills =new ArrayList<fills>();
    Paint mPaint;
    int mPaintPath=Color.BLUE;
    static float[] arrayX;
    static float[] arrayY;
    checker checker=new checker();
    float mWidth,mHeight;
    float radius;
    static int n;
    boolean cc = false;


    public void setN(int n) {
        MyCanvas.n = n;
    }

    public void setRadius(float radius){this.radius=radius;}

    public void setmWidth(float mWidth) {
        this.mWidth = mWidth;
    }

    public void setmHeight(float mHeight) {
        this.mHeight = mHeight;
    }



    public MyCanvas(Context context) {
        super(context);

        init(null);
    }

    public MyCanvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public MyCanvas(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public MyCanvas(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    public void init(@Nullable AttributeSet set){

        mPaint=new Paint();
        mPaint.setColor(Color.BLACK);
        allStrokes.add(new Stroke(mPaintPath));
    }




    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    canvas.drawCircle(arrayX[i], arrayY[k], radius, mPaint);
                }
            }

            for (Stroke s : allStrokes) {
                canvas.drawPath(s.path, s.paint);
            }
            int count = 0;
            for (fills j : allFills) {
                canvas.drawPath(j.path, j.paint);
            }

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();


        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                for (int k = 0; k < n; k++) {
                    for (int i = 0; i < n-1; i++) {
                        if (arrayX[i] < x && x < arrayX[i + 1] && (arrayY[k] -radius ) < y && y < (arrayY[k] +radius)) {
                            if(MainActivity.mCheckX[k][i] == 1){
                                return true;
                            }
                            if(chance!=1){
                                mPaintPath = mPaintPath == Color.RED ? Color.BLUE : Color.RED;
                            }
                             chance=0;
                            allStrokes.add(new Stroke(mPaintPath));
                            MainActivity.mCheckX[k][i] = 1;
                            allStrokes.get(allStrokes.size() - 1).path.moveTo(arrayX[i], arrayY[k]);
                            allStrokes.get(allStrokes.size() - 1).path.lineTo(arrayX[i + 1], arrayY[k]);
                            checker.check(mPaintPath);
                            invalidate();
                            return true;
                        }

                    }
                }
                for (int i = 0; i < n; i++) {
                    for (int k = 0; k < n-1; k++) {
                        if (arrayY[k] < y && y < arrayY[k + 1] && (arrayX[i] - radius) < x && x < (arrayX[i] + radius)) {
                            if(MainActivity.mCheckY[k][i] == 1){
                                return true;
                            }
                            if(chance!=1) {
                                mPaintPath = mPaintPath == Color.RED ? Color.BLUE : Color.RED;
                            }
                            chance=0;
                            allStrokes.add(new Stroke(mPaintPath));
                            MainActivity.mCheckY[k][i] = 1;
                            allStrokes.get(allStrokes.size() - 1).path.moveTo(arrayX[i], arrayY[k]);
                            allStrokes.get(allStrokes.size() - 1).path.lineTo(arrayX[i], arrayY[k + 1]);
                            checker.check(mPaintPath);
                            invalidate();
                            return true;

                        }
                    }
                }


            }
        }
        return false;

    }
    public void CalcDots(){
        float f1=mWidth/(n+1);
        float f2=mHeight/(n+1);
        arrayY= new float[n+1];
        arrayX= new float[n+1];
        for(int k = 0; k< n; k++){
            arrayX[k]=f1*(k+1);
            arrayY[k]=f2*(k+1);
        }

    }


}
