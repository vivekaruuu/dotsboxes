package com.example.dotsandboxesgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    static public int n;
    static int[][] mCheckX;
    static int[][] mCheckY;
    static int[][] boxFill;



    EditText editText;


    public void startGame(View view){



        n=Integer.parseInt(editText.getText().toString());
        if(n>10||n<3){
            Toast.makeText(this,"enter valid number",Toast.LENGTH_SHORT).show();
        }
        else {
            mCheckX = new int[n + 1][n + 1];

            mCheckY = new int[n + 1][n + 1];
            boxFill = new int[n][n];


            Intent intent = new Intent(getApplicationContext(), StartActivity.class);
            startActivity(intent);
        }

    }


    MyCanvas mMyCanvas;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);


        editText=findViewById(R.id.editText);


    }


}
