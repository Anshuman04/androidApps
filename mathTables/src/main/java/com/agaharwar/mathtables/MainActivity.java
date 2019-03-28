package com.agaharwar.mathtables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList getTable(int table){
        ArrayList<String> compTable = new ArrayList<String>();
        for(int i=1; i <= 21; i++){
            compTable.add("  " + Integer.toString((table * i)));
        }
        return compTable;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize seekbar and list view objects.
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        final ListView listView = (ListView) findViewById(R.id.listView);
        // Set max limit of showing tables to 20 and init as table of 1.
        seekBar.setMax(20);
        seekBar.setProgress(1);

        ArrayList initTable = getTable(1);
        final ArrayAdapter<String> adaptor = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, initTable);
        listView.setAdapter(adaptor);

        // Read changes in seekbar and accordingly update listView.
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress == 0){
                    Toast.makeText(MainActivity.this, "Min Math table is 1", Toast.LENGTH_SHORT).show();
                    progress = 1;
                    seekBar.setProgress(1);
                }
                ArrayList newTable = getTable(progress);
                ArrayAdapter<String> newAdaptor = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, newTable);
                listView.setAdapter(newAdaptor);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
