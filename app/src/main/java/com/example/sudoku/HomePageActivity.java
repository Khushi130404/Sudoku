package com.example.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePageActivity extends Activity
{
    Button btStartGame, btNewGame, btBackTracking;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        btStartGame = findViewById(R.id.btStartGame);
        btNewGame = findViewById(R.id.btNewGame);
        btBackTracking = findViewById(R.id.btBackTracking);

        btNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),NewGameActivity.class);
                startActivity(i);
            }
        });
    }
}