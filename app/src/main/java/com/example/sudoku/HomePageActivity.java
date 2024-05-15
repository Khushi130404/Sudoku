package com.example.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Spinner;

public class HomePageActivity extends Activity {
    Button btStartGame, btNewGame, btBackTracking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        btStartGame = findViewById(R.id.btStartGame);
        btNewGame = findViewById(R.id.btNewGame);
        btBackTracking = findViewById(R.id.btBackTracking);


        btNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });
    }

    private void showPopupMenu(View v)
    {
        PopupMenu pop = new PopupMenu(getApplicationContext(),v);
        pop.getMenuInflater().inflate(R.menu.popup_difficulty,pop.getMenu());


        pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item)
            {
                switch (item.getTitle().toString())
                {
                    case "Easy" :
                        Intent i1 = new Intent(getApplicationContext(), NewGameActivity.class);
                        startActivity(i1);
                        return true;
                    case "Medium" :
                        Intent i2 = new Intent(getApplicationContext(), NewGameActivity.class);
                        startActivity(i2);
                        return true;
                    case "Hard" :
                        Intent i3 = new Intent(getApplicationContext(), NewGameActivity.class);
                        startActivity(i3);
                        return true;
                    default: return false;
                }
            }
        });
        pop.show();
    }

}