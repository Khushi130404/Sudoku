package com.example.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {


    LinearLayout llBoard;
    TextView cell[][];

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cell = new TextView[9][9];
        llBoard = findViewById(R.id.llBoard);
        View inBoard = findViewById(R.id.inBoard);

        if(inBoard instanceof LinearLayout)
        {
            LinearLayout innerLayout = (LinearLayout) inBoard;
            LinearLayout ll11 = innerLayout.findViewById(R.id.ll11);
        }

        int board[][] = new int[9][9];
        CompleteSudoku cs = new CompleteSudoku(board);

    }
}