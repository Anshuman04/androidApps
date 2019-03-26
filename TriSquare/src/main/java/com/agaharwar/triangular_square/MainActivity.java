package com.agaharwar.triangular_square;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import java.lang.Math;
import android.widget.EditText;
import android.widget.Toast;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    public class Triangular{
        public double testNum = -1.0;

        public boolean isTriangular(){
            double op = Math.sqrt((8 * testNum + 1));
            if (op % 1.0 == 0.0){
                Log.i("Tri_Sq", "Entered number " + testNum + "is triangular");
                return true;
            } else {

                Log.i("Tri_Sq", "Entered number " + testNum + "is not triangular");
                return false;
            }
        }
    }

    public class Square{
        public double testNum = -1.0;

        public boolean isSquare(){
            double op = Math.sqrt(testNum);
            if (op % 1.0 == 0.0){
                Log.i("Tri_Sq", "Entered number " + testNum + "is square");
                return true;
            } else {

                Log.i("Tri_Sq", "Entered number " + testNum + "is square");
                return false;
            }
        }
    }



    public void checkNumber(View view){
        Log.i("Tri_Sq:", "Entered the method checkNumber");
        Triangular tObj = new Triangular();
        Square sObj = new Square();
        EditText numText = (EditText) findViewById(R.id.numBox);
        double numEntered = Double.parseDouble(numText.getText().toString());
        tObj.testNum = numEntered;
        sObj.testNum = numEntered;
        boolean isTri = tObj.isTriangular();
        boolean isSq = sObj.isSquare();
        String op = "";
        if (!(isTri || isSq)){
            Log.i("Tri_Sq", "Number entered is neither triangular nor a perfect square");
            op = "Number is neither triangular nor square.";
        } else if (isSq && isTri){
            Log.i("Tri_Sq", "Number entered is both triangular and square");
            op = "Number is both triangular and sqaure!!!!";
        } else if (isTri){
            Log.i("Tri_Sq", "Number entered is only triangular");
            op = "Number is only triangular!!";
        } else {
            Log.i("Tri_Sq", "Number entered is only perfect sqaure");
            op = "Number is only perfect sqaure";
        }
        Toast.makeText(MainActivity.this, op, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
