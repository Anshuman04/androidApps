package com.agaharwar.animation3;

import android.media.Image;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    boolean oddClick = true;


    private String readFromFile() {

        String ret = "";
        InputStream inputStream = null;
        try {
            inputStream = openFileInput("/storage/emulated/0/testJson.json");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }

                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }
        finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return ret;
    }


    public void narutoClicked(View view){
        Log.i("animate", "Entered narutoCLicked method");

        ImageView naruto = (ImageView) findViewById(R.id.naruto);
//        naruto.animate().translationXBy(2000f).setDuration(2000);
//        ImageView sasuke = (ImageView) findViewById(R.id.sasuke);
//        sasuke.animate().alpha(0f).setDuration(1000);
        if (oddClick) {
            naruto.animate().scaleX(2f).scaleY(2f).rotation(180f).setDuration(2000);
        } else {
            naruto.animate().rotation(360f).scaleX(1f).scaleY(1f).setDuration(2000);
        }
        oddClick = !oddClick;

    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // String allVals = readFromFile();
        String extStorageState = Environment.getExternalStorageState();
        // File bla = getExternalFilesDir("/storage/emulated/0/testJson.json");
        Log.i("TestJson", extStorageState);
        String allVals = readFromFile();
        Log.i("TestJson", allVals);
//        ImageView naruto = (ImageView) findViewById(R.id.naruto);
//        naruto.setTranslationX(-2000f);
    }
}
