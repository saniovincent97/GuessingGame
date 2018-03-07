package com.example.svinc.guessinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static final int MAX_VALUE = 10;
    public static final Random RANDOM = new Random();
    private TextView gameStatus;
    private EditText insertValue;
    private int randomlyChosenNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.edit_value);
        gameStatus = (TextView) findViewById(R.id.game_status);
        insertValue = (EditText) findViewById(R.id.insert_value);

        startGame();

        insertValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkAnswer();
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondaryActivity.class));
            }
        });
    }

    private void checkAnswer() {
        String StringEditNum= insertValue.getText().toString();
        if(!StringEditNum.equals("")){
            int n = Integer.parseInt(StringEditNum);
        if (n == randomlyChosenNumber) {
            gameStatus.setText(R.string.win_msg);
        } else if (n > randomlyChosenNumber) {
            gameStatus.setText(R.string.too_high);
        } else if (n < randomlyChosenNumber) {
            gameStatus.setText(R.string.too_low);
        }
    }}


    private void startGame() {
        randomlyChosenNumber = RANDOM.nextInt(MAX_VALUE) + 1;
        gameStatus.setText(R.string.intro_msg);
        insertValue.setText("");
    }
    }

