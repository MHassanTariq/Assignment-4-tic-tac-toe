/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ap.assignment.pkg4;

/**
 *
 * @author Muhammad Hassan
 */
public class Model {
    private int[][] matrix;
    Model()
    {
        matrix = new int[3][3];
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                matrix[i][j] = -1;
    }
    private boolean checkwin(View screen)
    {
        for(int i = 0; i < 3; i++)
        {
            if(matrix [i][0] != -1 && matrix[i][0] == matrix[i][1] && matrix[i][1] == matrix[i][2])
            {
                System.out.println("It got here with loop 1, i = " + i);
                screen.changeWinLable(matrix[i][0]);
                return true;
            }
        }
        for(int i = 0; i < 3; i++)
        {
            if(matrix [0][i] != -1 && matrix[0][i] == matrix[1][i] && matrix[1][i] == matrix[2][i])
            {
                System.out.println("It got here with loop 2, i = " + i);
                screen.changeWinLable(matrix[0][i]);
                return true;
            }
        }
        if(matrix [0][0] != -1 && matrix[0][0] == matrix[1][1] && matrix[1][1] == matrix[2][2])
        {
            System.out.println("It got here with [0][0]");
            screen.changeWinLable(matrix[0][0]);
            return true;
        }
        else if(matrix [2][0] != -1 && matrix[2][0] == matrix[1][1] && matrix[1][1] == matrix[0][2])
        {
            System.out.println("It got here with [2][0]");
            screen.changeWinLable(matrix[2][0]);
            return true;
        }
        return false;
    }
    int addMove(int row, int col, View screen, int turn)
    {
        if(matrix[row][col] == -1)
        {
            matrix[row][col] = turn;
            turn = (turn+1)%2;
            if(checkwin(screen))
            {
                System.out.println("Game should stop now");
            }
            return turn;
        }
        return turn;
    }
}
