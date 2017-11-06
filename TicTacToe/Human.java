/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe2;

import java.util.Scanner;

/**
 *
 * @author Shiying, Oct 2016
 */

class Human extends TicTacToe2 {

public Human (){
}

public void takeTurn(String[][] board) {

    //Scanner allows player to enter the position that they wants to play
    Scanner s = new Scanner(System.in);

    //When it is the turn for play to paly
    boolean turn = true;
    while(turn){
        System.out.println("please enter row (1-3)");
        int row = s.nextInt();
        System.out.println("please enter column (1-3)");
        int col = s.nextInt();
        System.out.print("you entered "+row+" "+col);
        System.out.println();
        if(board[row - 1][col - 1] != "x" && board[row - 1][col - 1] != "o"){
            board[row - 1][col - 1] = Marker;
            turn = false;
        }
        //If play makes the slot that has already been taken
        else {
            System.out.println("Already Marker here! please re-enter the row and column numbers!");
        }
    } 
}
} 