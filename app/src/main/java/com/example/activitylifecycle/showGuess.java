package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import static android.content.ContentValues.TAG;

public class showGuess extends AppCompatActivity {
private TextView showGuessTextview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_guess);
        //Bundle is a class that allows to put all sort of things inside it

        Bundle extra = getIntent().getExtras(); //everything that comes with the getIntent comes here
       showGuessTextview = findViewById(R.id.received_textview);


       if (extra != null){
           String value = extra.getString("guess");
           Log.d("Name extra ", "onCreate: " + extra.getString("name"));
           Log.d("Name extra 2 ", "onCreate: " + extra.getInt("age"));
           showGuessTextview.setText(value);
       }
//when the intent we're getting is not null
//       if(getIntent().getStringExtra("guess" )!= null){
//           Log.d("Stuff", " " + getIntent().getStringExtra("name"));
//
//            String value = getIntent().getStringExtra("guess");
//            showGuessTextview.setText(value);
//       }


    }
}