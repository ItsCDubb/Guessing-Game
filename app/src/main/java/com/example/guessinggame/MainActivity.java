package com.example.guessinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final static int CORRECT = 0;
    final static int LOW     = 1;
    final static int HIGH    = 2;
    int THE_NUMBER_TO_GUESS  = 4;

    int guess   = 0;

    TextView textQuestion;
    EditText textEntry;
    Button   buttonSubmit;
    TextView textResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textQuestion=findViewById(R.id.text_question);
        textResult=findViewById(R.id.text_result);
        textEntry = findViewById(R.id.text_entry);
        buttonSubmit = findViewById(R.id.button_submit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guess = Integer.parseInt(textEntry.getText().toString());

                int result = checkGuess(guess);

                updateUI(result);
            }
        });
    }

    int checkGuess(int guess) {
        //check to see if the number is correct and return the result as an integer value

        if (guess == THE_NUMBER_TO_GUESS) {
            return CORRECT;
        } else if (guess < THE_NUMBER_TO_GUESS) {
            return LOW;
        } else {
            return HIGH;
        }
    }

    void updateUI(int result) {
        // this will perform all the tasks necessary to update the display once the result has been determined
        // use a switch statement inside of this method to determine what to display to the user based on the provided result.
        switch (result) {
            case CORRECT:
                textResult.setText("You got it! The number was: " +guess);
                break;
            case LOW:
                textResult.setText(guess + " is too low.");
                break;
            case HIGH:
                textResult.setText(guess +" is too high.");
                break;
            default:
                textResult.setText("Okay, restart it yourself.");
        }
    }
}