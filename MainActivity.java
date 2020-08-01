package com.example.pralhad.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //0:y,1:r,2:emprty
    int[] gamestate = {2,2,2,2,2,2,2,2,2};
    int[][] winningposition = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int activeplayer = 0;
    boolean gameactive = true;
    public void dropin(View view){
        ImageView counter = (ImageView) view;
        int tappedcounter = Integer.parseInt(counter.getTag().toString());
        if(gamestate[tappedcounter] == 2 && gameactive){
        gamestate[tappedcounter] = activeplayer;
        counter.setTranslationY(-1500);
        if (activeplayer == 0) {
            counter.setImageResource(R.drawable.y);
            activeplayer = 1;
        }
        else {
            counter.setImageResource(R.drawable.r);
            activeplayer = 0;
        }
        counter.animate().translationYBy(1500).setDuration(300);
        for(int[] winningposition : winningposition){
            if(gamestate[winningposition[0]]== gamestate[winningposition[1]] && gamestate[winningposition[1]] == gamestate[winningposition[2]] && gamestate[winningposition[0]] != 2){
                //somewon has won
                gameactive = false;
                String winner;
                if (activeplayer == 1){
                    winner = "Yellow";
                }
                else {
                    winner = "Red";
                }
                Button b = (Button) findViewById(R.id.b);
                TextView t =(TextView) findViewById(R.id.t);
                t.setText(winner + " has won");
                b.setVisibility(view.VISIBLE);
                t.setVisibility(view.VISIBLE);

            }
        }
        }
    }
    public void playagain(View view){
            Button b = (Button) findViewById(R.id.b);
            TextView t =(TextView) findViewById(R.id.t);
            b.setVisibility(view.VISIBLE);
            t.setVisibility(view.VISIBLE);
            GridLayout gridLayout=(GridLayout) findViewById(R.id.gridLayout);
            for(int i=0;i<gridLayout.getChildCount();i++)
            {
                ImageView counter = (ImageView) gridLayout.getChildAt(i);
                counter.setImageDrawable(null);
            }
            for(int i=0;i<gamestate.length;i++) {
                gamestate[i] = 2;
            }
         activeplayer = 0;
         gameactive = true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
