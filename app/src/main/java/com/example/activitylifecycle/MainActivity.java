package com.example.activitylifecycle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private Button showGuess;
private EditText enterGuess;
private final int REQUEST_CODE = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showGuess = findViewById(R.id.button_guess);
enterGuess = findViewById(R.id.guess_field);
//important snippet for passing data from activity B(showGuess) to A(Main Activity)
        ActivityResultLauncher<Intent> launchSomeActivity = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            String val = data.getStringExtra("message_back");
                            Toast.makeText(MainActivity.this, val, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
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
launchSomeActivity.launch(intent);
//            startActivity(intent);
            }
            else{
                Toast.makeText(MainActivity.this, " Enter guess", Toast.LENGTH_SHORT).show();
            }
            }
        });

    }
//making Main Activity listen to other different activities



}