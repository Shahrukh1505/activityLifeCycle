package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private Button showGuess;
private EditText enterGuess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showGuess = findViewById(R.id.button_guess);
enterGuess = findViewById(R.id.guess_field);
        showGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String guess = enterGuess.getText().toString().trim();
               //first we need to check whether there is text in edittext or not
                //if text is there then proceed otherwise display a toast letting the user know he hasn't enter the values
                if(!guess.isEmpty()){
                Intent intent = new Intent(MainActivity.this, showGuess.class);
          intent.putExtra("guess", guess); //like HashMap guess is the key will string guess is the value
intent.putExtra("name", " bond");
intent.putExtra("age", 21);

            startActivity(intent);
            }
            else{
                Toast.makeText(MainActivity.this, " Enter guess", Toast.LENGTH_SHORT).show();
            }
            }
        });

    }


}