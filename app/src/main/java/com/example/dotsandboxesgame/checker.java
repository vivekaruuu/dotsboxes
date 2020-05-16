package com.example.dotsandboxesgame;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;


public class checker {


    int score1=0;
    int score2=0;
    float x[];
    float y[];
    static int n;
    static int chance=0;
    void setN(int o) {
        n = o;
    }

    checker(){}


    void check(int paintS) {


        x=MyCanvas.arrayX;
        y=MyCanvas.arrayY;
        int temp=paintS;

        for (int k = 0; k <n;k++) {
            for (int i = 0; i < n; i++) {
                paintS=temp;
                if(MainActivity.mCheckX[k][i]==1&&MainActivity.mCheckX[k+1][i]==1&&MainActivity.mCheckY[k][i]==1&&MainActivity.mCheckY[k][i+1]==1&&MainActivity.boxFill[k][i]==0){

                    MainActivity.boxFill[k][i]=1;
                        if(paintS==Color.RED){
                           score1++;
                           chance=1;
                        }
                        else {
                            score2++;
                            chance=1;
                        }


                        paintS=paintS==Color.RED?Color.argb(128,255,189,189):Color.argb(128,200,200,255);

                        StartActivity.textView1.setText("player1\n"+score1);
                        StartActivity.textView2.setText("player2\n"+score2);

                        MyCanvas.allFills.add(new fills(paintS));
                        MyCanvas.allFills.get(MyCanvas.allFills.size() - 1).path.moveTo(x[i], y[k]);
                        MyCanvas.allFills.get(MyCanvas.allFills.size() - 1).path.lineTo(x[i], y[k + 1]);
                        MyCanvas.allFills.get(MyCanvas.allFills.size() - 1).path.lineTo(x[i + 1], y[k + 1]);
                        MyCanvas.allFills.get(MyCanvas.allFills.size() - 1).path.lineTo(x[i + 1], y[k]);
                        MyCanvas.allFills.get(MyCanvas.allFills.size() - 1).path.lineTo(x[i], y[k]);

                        if((score1+score2)==((n-1)*(n-1)))
                        {
                            StartActivity.textView3.setText(score1>score2?"player 1 wins":"player 2 wins");
                            StartActivity.textView3.setVisibility(View.VISIBLE);
                        }
                }

            }
        }
    }


}
