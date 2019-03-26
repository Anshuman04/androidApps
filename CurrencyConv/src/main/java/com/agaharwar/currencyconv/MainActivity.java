package com.agaharwar.currencyconv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void usd_to_rs(View view) {
        Log.i("CURR_CONV:", "Entered function usd_to_rs");
        EditText inpVal = (EditText) findViewById(R.id.inpVal);
        Log.i("CURR_CONV:", "Value entered by user: " + inpVal.getText().toString());
        double op = Double.parseDouble(inpVal.getText().toString()) * 70.0;
        String opReturn = "₹" + Double.toString(op);
        Log.i("CURR_CONV:", "Output: " + opReturn);
        Toast.makeText(MainActivity.this, opReturn, Toast.LENGTH_LONG).show();
    }

    public void rs_to_usd(View view) {
        Log.i("CURR_CONV:", "Entered function rs_to_usd");
        EditText inpVal = (EditText) findViewById(R.id.inpVal);
        Log.i("CURR_CONV:", "Value entered by user: " + inpVal.getText().toString());
        double op = Double.parseDouble(inpVal.getText().toString()) * 0.014;
        String opReturn = "$" + Double.toString(op);
        Log.i("CURR_CONV:", "Output: " + opReturn);
        Toast.makeText(MainActivity.this, opReturn, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
