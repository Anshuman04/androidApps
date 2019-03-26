package com.agaharwar.tictactoe;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    Player player_1 = new Player();
    Player player_2 = new Player();
    Player presentPlayer = player_1;
    int turnCounter = 0;

    public void togglePlayer(){
        if (presentPlayer == player_1){
            presentPlayer = player_2;
        } else {
            presentPlayer = player_1;
        }
    }

    public void cellClicked(View view){
        Log.i("TicTacToe", "Entered cell clicked method");
        ImageView counter = (ImageView) view;
        if (counter.getDrawable() != null){
            return;
        }
        turnCounter++;
        counter.setImageResource(presentPlayer.symbol);
        int cellId = view.getId();
        presentPlayer.updateBoardStatus(view, cellId);
        if (turnCounter > 4){
            if (presentPlayer.isWinner()){
                gameEnds(view);
                return;
            }
        }
        togglePlayer();
        Toast.makeText(MainActivity.this, presentPlayer.name + "'s turn !", Toast.LENGTH_SHORT).show();
    }

    public void startClicked(View view){
        Log.i("TicTacToe", "Entered start clicked method");
        turnCounter = 0;
        RelativeLayout main_menu = (RelativeLayout) findViewById(R.id.main_menu);
        RelativeLayout game_board = (RelativeLayout) findViewById(R.id.game_board);
        clearBoard();
        main_menu.animate().translationXBy(1200f).setDuration(1000);
        game_board.animate().translationXBy(1200f).setDuration(1000);
        EditText et = (EditText) findViewById(R.id.player1);
        String p1Name = et.getText().toString();
        EditText et2 = (EditText) findViewById(R.id.player2);
        String p2Name = et2.getText().toString();
        player_1.symbol = R.drawable.cross_new;
        player_1.name = p1Name;
        player_2.symbol = R.drawable.zero_new;
        player_2.name = p2Name;
        Toast.makeText(MainActivity.this, player_1.name + "'s turn !", Toast.LENGTH_SHORT).show();
    }

    public void gameEnds(View view){
        Toast.makeText(MainActivity.this, presentPlayer.name + " WON !!!", Toast.LENGTH_LONG).show();
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        backButtonClicked(view);
    }

    public void clearBoard(){
        ImageView allViews[] = {(ImageView) findViewById(R.id.cross00),
                (ImageView) findViewById(R.id.cross01),
                (ImageView) findViewById(R.id.cross02),
                (ImageView) findViewById(R.id.cross10),
                (ImageView) findViewById(R.id.cross11),
                (ImageView) findViewById(R.id.cross12),
                (ImageView) findViewById(R.id.cross20),
                (ImageView) findViewById(R.id.cross21),
                (ImageView) findViewById(R.id.cross22)};
        for (ImageView cell: allViews){
            cell.setImageResource(0);
        }
    }

    public void exitClicked(View view){
        finish();
        System.exit(0);
    }

    public void backButtonClicked(View view){
        RelativeLayout main_menu = (RelativeLayout) findViewById(R.id.main_menu);
        RelativeLayout game_board = (RelativeLayout) findViewById(R.id.game_board);
        main_menu.animate().translationXBy(-1200f).setDuration(1000);
        game_board.animate().translationXBy(-1200f).setDuration(1000);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout game_board = (RelativeLayout) findViewById(R.id.game_board);
        game_board.setTranslationX(-1200f);
    }
}
