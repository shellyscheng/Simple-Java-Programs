/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe2;
/**
 *
 * @author Shiying
 */

public class set {

    /**setup variables default board size and board
     * create a 3X3 2D Array
     */
    private int N = 3;
    public String[][] board = new String [N][N];

    //When either the play or the computer won the game
    public boolean hasWon (String [] [] board){
        //Three same elements in a row
        for(int i = 0; i<3; i++){
            if(board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2])){
                return true;
            }
        }
        //Three same elements in a column
        for(int i = 0; i<3; i++){
            if(board [0][i].equals(board[1][i]) && board[1][i].equals(board[2][i])){
                return true;
            }
        }
        //Three same elements in a diagonal
        if(board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) || board[2][0].equals(board[1][1]) && board[1][1].equals(board[0][2]))
            return true;
        //Otherwise, nobody wins the game
        
        else {
        return false;
    }
    }


    //Create a method to build the board, 
    int x = 1;
    public void createBoard(){
        for (String[] board1 : board) {
            for (int j = 0; j < board.length; j++) {
                board1[j] = "" + (x);
                x++;
            }
        }
    }
    //print the board by for loop
    public void printBoard(){
        for (String[] board1 : board) {
            for (int j = 0; j < board.length; j++) {
                System.out.print("[" + board1[j] + "]" + " ");
            }
            System.out.println();
        }

    }

    //getBoard method. Return the board every time.
    public String[][] getBoard(){

        return board;

    }



}
