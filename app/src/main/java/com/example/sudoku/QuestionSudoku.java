package com.example.sudoku;

import java.util.Random;

class QuestionSudoku
{
    int fullBoard[][];
    int empty;
    int createBoard[][];
    Random random;
    CompleteSudoku cs;

    public QuestionSudoku(int createBoard[][],int empty)
    {
        this.createBoard = createBoard;
        this.empty = empty;
        random = new Random();
        fullBoard = new int [9][9];
        cs = new CompleteSudoku(fullBoard);
        cs.fullSudoku(0, 0);
    }

    void createQuetionSudoku()
    {
        for(int i=0; i<empty; i++)
        {
            int j = random.nextInt(9);
            int k = random.nextInt(9);

            if(createBoard[j][k]!=0)
            {
                i--;
            }
            else
            {
                createBoard[j][k] = fullBoard[j][k];
            }
        }
    }
}
