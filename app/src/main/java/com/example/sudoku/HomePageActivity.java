package com.example.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.Toast;

public class HomePageActivity extends Activity {
    Button btContinueGame, btNewGame, btBackTracking;
    SharedPreferences share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        btContinueGame = findViewById(R.id.btContinueGame);
        btNewGame = findViewById(R.id.btNewGame);
        btBackTracking = findViewById(R.id.btBackTracking);

        share = getSharedPreferences("continue",MODE_PRIVATE);

        btNewGame.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });

        btContinueGame.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(share.getInt("empty",0)==0)
                {
                    Toast.makeText(getApplicationContext(), "No continue Game", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Game Continue", Toast.LENGTH_SHORT).show();
                }
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
                        i1.putExtra("empty",10);
                        startActivity(i1);
                        return true;
                    case "Medium" :
                        Intent i2 = new Intent(getApplicationContext(), NewGameActivity.class);
                        i2.putExtra("empty",30);
                        startActivity(i2);
                        return true;
                    case "Hard" :
                        Intent i3 = new Intent(getApplicationContext(), NewGameActivity.class);
                        i3.putExtra("empty",50);
                        startActivity(i3);
                        return true;
                    default: return false;
                }
            }
        });
        pop.show();
    }

}