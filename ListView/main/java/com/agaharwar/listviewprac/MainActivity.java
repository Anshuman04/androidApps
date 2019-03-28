package com.agaharwar.listviewprac;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView myListView = (ListView) findViewById(R.id.listView);
        final ArrayList<String> myList = new ArrayList<String>();
        myList.add("Anshuman");
        myList.add("Pratibha");
        myList.add("Rajesh");
        myList.add("Animesh");
        myList.add("Himali");
        myList.add("Rutuja");
        myList.add("Rushi");
        myList.add("Kirtya");
        ArrayAdapter<String> adaptor = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myList);
        myListView.setAdapter(adaptor);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Log.i("NOTICE: ", "I LOVE " + myList.get(position));
                Toast.makeText(MainActivity.this, "I Love " + myList.get(position), Toast.LENGTH_LONG).show();
            }
        });
//        ListView myListView = (ListView) findViewById(R.id.listView);
//        final ArrayList<String> myList = new ArrayList<String>();
//        myList.add("Anshuman");
//        myList.add("Animesh");
//        ArrayAdapter<String> adaptor = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myList);
//        myListView.setAdapter(adaptor);
//        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
//                Log.i("NOTICE", "BLA " + myList.get(position));
//
//            }
//
//        });

    }
}
