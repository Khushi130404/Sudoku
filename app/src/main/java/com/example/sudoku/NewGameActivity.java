package com.example.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NewGameActivity extends AppCompatActivity
{

    LinearLayout llBoard;
    TextView cell[][][][];
    int llId[][] = {{R.id.ll11,R.id.ll12,R.id.ll13},
            {R.id.ll21,R.id.ll22,R.id.ll23},
            {R.id.ll31,R.id.ll32,R.id.ll33}};

    int blockId[][] = {{R.id.block11,R.id.block12,R.id.block13},
            {R.id.block21,R.id.block22,R.id.block23},
            {R.id.block31,R.id.block32,R.id.block33}};

    int celId[][] = {{R.id.cell11,R.id.cell12,R.id.cell13},
            {R.id.cell21,R.id.cell22,R.id.cell23},
            {R.id.cell31,R.id.cell32,R.id.cell33}};

    TextView tvSelected;
    List<TextView> tvAdjecent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);

        cell = new TextView[3][3][3][3];
        llBoard = findViewById(R.id.llBoard);
        View inBoard = findViewById(R.id.inBoard);
        tvAdjecent = new ArrayList<TextView>();

        if(inBoard instanceof LinearLayout)
        {
            LinearLayout innerLayout = (LinearLayout) inBoard;

            for(int i=0; i<3; i++)
            {
                for(int j=0; j<3; j++)
                {
                    LinearLayout ll = innerLayout.findViewById(llId[i][j]);
                    View block = innerLayout.findViewById(blockId[i][j]);

                    if(block instanceof LinearLayout)
                    {
                        for(int k=0; k<3; k++)
                        {
                            for(int l=0; l<3; l++)
                            {
                                cell[i][j][k][l] = block.findViewById(celId[k][l]);
                                int finalI = i;
                                int finalJ = j;
                                int finalK = k;
                                int finalL = l;
                                cell[i][j][k][l].setOnClickListener(new View.OnClickListener()
                                {
                                    @Override
                                    public void onClick(View v)
                                    {
                                        if(tvSelected!=null)
                                        {
                                            tvSelected.setBackground(getDrawable(R.drawable.cell));
                                        }
                                        while(!tvAdjecent.isEmpty())
                                        {
                                            tvAdjecent.remove(0).setBackground(getDrawable(R.drawable.cell));
                                        }
                                        for(int ii=0; ii<3; ii++)
                                        {
                                            for(int jj=0; jj<3; jj++)
                                            {
                                                cell[ii][finalJ][jj][finalL].setBackground(getDrawable(R.drawable.cell_adjecent));
                                                cell[finalI][ii][finalK][jj].setBackground(getDrawable(R.drawable.cell_adjecent));
                                                cell[finalI][finalJ][ii][jj].setBackground(getDrawable(R.drawable.cell_adjecent));
                                                tvAdjecent.add(cell[finalI][finalJ][ii][jj]);
                                                tvAdjecent.add(cell[ii][finalJ][jj][finalL]);
                                                tvAdjecent.add(cell[finalI][ii][finalK][jj]);
                                            }
                                        }
                                        cell[finalI][finalJ][finalK][finalL].setBackground(getDrawable(R.drawable.cell_on_select));
                                        tvSelected = cell[finalI][finalJ][finalK][finalL];

                                    }
                                });


                            }
                        }
                    }
                }
            }
        }

        int board[][] = new int[9][9];
        QuestionSudoku qs = new QuestionSudoku(board,32);
        qs.createQuetionSudoku();
        for(int i=0; i<9; i++)
        {
            for(int j=0; j<9; j++)
            {
                if(board[i][j] != 0)
                {
                    int blockRow = i / 3;
                    int blockCol = j / 3;
                    int cellRow = i % 3;
                    int cellCol = j % 3;
                    cell[blockRow][blockCol][cellRow][cellCol].setText(""+board[i][j]);
                }
            }
        }

    }
}