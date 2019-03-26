package com.agaharwar.highlow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.*;

public class MainActivity extends AppCompatActivity {



    public int target = -1;
    public void guessed(View view){
        Log.i("High_low:", "Entered the method guessed");
        if (target == -1){
            Log.i("High_low:", "Target is not yet ;;itialized");
            Random rand = new Random();
            target = rand.nextInt(19) + 1;
            Log.i("High_low", "Target initialized to: " + target);
        }
        EditText inpVal = (EditText) findViewById(R.id.editText2);
        Log.i("High_low", "Number entered by user: " + inpVal.getText().toString());
        int test = Integer.parseInt(inpVal.getText().toString());
        if (test == target){
            Log.i("High_low", "User has guessed the number correctly");
            Log.i("High_low", "Initiating updating target number");
            Random rand2 = new Random();
            target = rand2.nextInt(19) + 1;
            Log.i("High_low", "New target set to: " + target);
            Toast.makeText(MainActivity.this, "CORRECT!!!!!", Toast.LENGTH_LONG).show();
            Toast.makeText(MainActivity.this, "Number is updated now :)", Toast.LENGTH_SHORT).show();
        } else if(test < target){
                Toast.makeText(MainActivity.this, "My number is higher", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(MainActivity.this, "My number is lower", Toast.LENGTH_LONG).show();
        }



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
