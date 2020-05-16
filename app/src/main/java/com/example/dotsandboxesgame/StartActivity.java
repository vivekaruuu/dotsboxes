package com.example.dotsandboxesgame;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static com.example.dotsandboxesgame.MainActivity.n;

public class StartActivity extends AppCompatActivity {

    MyCanvas mMyCanvas;
    float w,h;
    public static TextView textView1;
    public static TextView textView2;
    public static TextView textView3;
  //  static Context context;
    public void gameStart(){


        mMyCanvas=(MyCanvas) findViewById(R.id.myCanvas);
        checker checker=new checker();
        mMyCanvas.setN(n);
        checker.setN(n);
        mMyCanvas.setmWidth(w);
        mMyCanvas.setmHeight(dipToPixels(getApplicationContext(),450));
        mMyCanvas.setRadius(w/(n*9));
        mMyCanvas.CalcDots();


    }

    public static float dipToPixels(Context context, float dipValue){
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,  dipValue, metrics);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_layout);
//        context=getBaseContext();
        DisplayMetrics metrics = getBaseContext().getResources().getDisplayMetrics();
        w = metrics.widthPixels;
        h = metrics.heightPixels;
        textView1=findViewById(R.id.textView);
        textView2=findViewById(R.id.textView2);
        textView3=findViewById(R.id.textView4);
        gameStart();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        MyCanvas.allFills.clear();
        MyCanvas.allStrokes.clear();


    }
}
