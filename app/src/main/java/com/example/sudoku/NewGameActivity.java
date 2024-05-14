package com.example.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class NewGameActivity extends Activity
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

    int btNumId[] = {R.id.btNum1,R.id.btNum2,R.id.btNum3,
            R.id.btNum4,R.id.btNum5,R.id.btNum6,
            R.id.btNum7,R.id.btNum8,R.id.btNum9};

    int btCountId[] = {R.id.btCount1, R.id.btCount2, R.id.btCount3,
            R.id.btCount4, R.id.btCount5, R.id.btCount6,
            R.id.btCount7, R.id.btCount8, R.id.btCount9};

    Button btNum[];
    Button btCount[];

    TextView tvSelected;
    int selectedI,selectedJ;
    List<TextView> tvAdjecent;
    int board[][] = new int[9][9];
    QuestionSudoku qs = new QuestionSudoku(board,50);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);

        cell = new TextView[3][3][3][3];
        llBoard = findViewById(R.id.llBoard);
        View inBoard = findViewById(R.id.inBoard);
        tvAdjecent = new ArrayList<TextView>();
        btNum = new Button[9];
        btCount = new Button[9];
        board= new int[9][9];
        qs = new QuestionSudoku(board,10);
        qs.createQuestionSudoku();

        for(int i=0; i<9; i++)
        {
            btNum[i] = findViewById(btNumId[i]);
            btCount[i] = findViewById(btCountId[i]);

            int finalI = i;
            btNum[i].setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    int n = Integer.parseInt(btCount[finalI].getText().toString());
                    if(n>0)
                    {
                        if(tvSelected!=null)
                        {
                            if(!tvSelected.getText().toString().equals(""))
                            {
                                int nn = Integer.parseInt(tvSelected.getText().toString());
                                int mm = Integer.parseInt(btCount[nn-1].getText().toString()) + 1;
                                btCount[nn-1].setText(""+mm);
                            }
                            n = Integer.parseInt(btCount[finalI].getText().toString())-1;
                            btCount[finalI].setText(""+n);
                            tvSelected.setText(""+(finalI+1));
                            //int x = tvSelected.getId();
                            if(qs.fullBoard[selectedI][selectedJ]==finalI+1)
                            {
                                board[selectedI][selectedJ] = finalI+1;
                                tvSelected = null;
                                Toast.makeText(getApplicationContext(), "Correct position...!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "Plz select correct cell...!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Element "+n+" has been used.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
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
                                        int ik = (finalI*3) + finalK;
                                        int jl = (finalJ*3) + finalL;

                                        if(board[ik][jl]!=0)
                                        {
                                            return;
                                        }
                                        if(tvSelected!=null)
                                        {
                                            tvSelected.setBackground(getDrawable(R.drawable.cell));
                                        }
                                        if(tvSelected==cell[finalI][finalJ][finalK][finalL])
                                        {
                                            try
                                            {
                                                int n = Integer.parseInt(tvSelected.getText().toString());
                                                btCount[n-1].setText(""+(Integer.parseInt(btCount[n-1].getText().toString())+1));
                                            }
                                            catch (Exception e)
                                            {
                                                // Do nothing
                                            }
                                            tvSelected.setText("");
                                            tvSelected = null;
                                            while(!tvAdjecent.isEmpty())
                                            {
                                                tvAdjecent.remove(0).setBackground(getDrawable(R.drawable.cell));
                                            }
                                            return;
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
                                        selectedI = (3*finalI) + finalK;
                                        selectedJ = (3*finalJ) + finalL;
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }

        for(int i=0; i<9; i++)
        {
            for(int j=0; j<9; j++)
            {
                if(board[i][j] != 0)
                {
                    int n = Integer.parseInt(btCount[board[i][j]-1].getText().toString())-1;
                    btCount[board[i][j]-1].setText(""+n);
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