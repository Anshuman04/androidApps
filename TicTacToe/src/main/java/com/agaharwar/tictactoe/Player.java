package com.agaharwar.tictactoe;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by agaharwar on 03/13/2019.
 */

public class Player {
    int boardStatus[][] = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    int resultArr[] = {0, 0, 0, 0, 0, 0, 0, 0};
    int symbol;
    String name;


        public boolean isWinner(){
            if (boardStatus[0][0] + boardStatus[0][1] + boardStatus[0][2] == 3){
                return true;
            }
            if (boardStatus[1][0] + boardStatus[1][1] + boardStatus[1][2] == 3){
                return true;
            }
            if (boardStatus[2][0] + boardStatus[2][1] + boardStatus[2][2] == 3){
                return true;
            }
            if (boardStatus[0][0] + boardStatus[1][0] + boardStatus[2][0] == 3){
                return true;
            }
            if (boardStatus[0][1] + boardStatus[1][1] + boardStatus[2][1] == 3){
                return true;
            }
            if (boardStatus[0][2] + boardStatus[1][2] + boardStatus[2][2] == 3){
                return true;
            }
            if (boardStatus[0][0] + boardStatus[1][1] + boardStatus[2][2] == 3){
                return true;
            }
            if (boardStatus[0][2] + boardStatus[1][1] + boardStatus[2][0] == 3){
                return true;
            }
            return false;

        }

        public void updateBoardStatus(View view, int cellPressed){
            Log.i("TicTacToe", "Entered update method");
            String idName = view.getResources().getResourceEntryName(cellPressed);
            Log.i("TicTacToe", "ID NAME: " + idName);
            String cellNo = idName.substring(5);
            Log.i("TicTacToe", "CELL NO.: " + cellNo);
            int i = Integer.parseInt(cellNo.substring(0,1));
            int j = Integer.parseInt(cellNo.substring(1));
            Log.i("TicTacToe", "i = " + i + " j = " + j);
            boardStatus[i][j] = 1;

        }

}
