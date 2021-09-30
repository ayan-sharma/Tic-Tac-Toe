package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameActive = true;

    //    player
//    0 = x
//    1 = 0
    int activePlayer = 0;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
//    game state means
//    0= x
//    1= 0
//    2= null

    int[][] winPos = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}
            , {0, 3, 6}, {1, 4, 5}, {2, 5, 8}
            , {0, 4, 8}, {2, 4, 6}
    };

    public void playerTap(View view) {
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if (!gameActive) {
            gameReset(view);
        }
        if (gameState[tappedImage] == 2 && gameActive) {
            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("O's Turn Tap to Play");
            } else {
                activePlayer = 1;
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("O's Turn Tap to Play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }

        for (int[] winPostion : winPos) {

            if (gameState[winPostion[0]] == gameState[winPostion[1]] &&
                    gameState[winPostion[1]] == gameState[winPostion[2]] &&
                    gameState[winPostion[0]] != 2) {
                String winner;
                gameActive = false;
                if (gameState[winPostion[0]] == 0) {
                    winner = "X has won";
                } else {
                    winner = "0 has won";

                }
                TextView status = findViewById(R.id.status);
                status.setText(winner);

            }


        }
    }

    public void gameReset(View view) {
        gameActive = true;
        activePlayer = 0;
        for(int i=0; i<gameState.length; i++){
            gameState[i] = 2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText("X's Turn - Tap to play");

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}