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
class Computer extends TicTacToe2 {

public Computer(){

}

int boardsize = 3;

public void takeTurn(String[][] board, Human human) {

    int vertical = 0;
    int horizontal = 0;
    int diagonal = 0;
    boolean mademove = false;

    // check if you can take a win horizontally, if so, make the move
    //Case 1:
    for(int i = 0; i<3; i++){
        if(board[0][i].equals(board[1][i]) && board[0][i].equals(Marker)){

            if(board[2][i] != human.getMarker() && board[2][i] != Marker){
                board[2][i] = Marker;
                mademove = true;
                return;
            }

        }

    }
    //Case 2:
    for(int i = 0; i<3; i++){
        if(board[2][i].equals(board[1][i]) && board[2][i].equals(Marker)){

            if(board[0][i] != human.getMarker() && board[0][i] != Marker){
                board[0][i] = Marker;
                mademove = true;
                return;
            }
        }
    }

    // check if you can take a win vertically
    //Case 1:
    for(int i = 0; i<3; i++){
        if(board[i][0].equals(board[i][1]) && board[i][0].equals(Marker)){

            if(board[i][2] != human.getMarker() && board[i][2] != Marker){
                board[i][2] = Marker;
                mademove = true;
                return;
            }
        }
    }
    //Case 2:
    for(int i = 0; i<3; i++){

        if(board[i][2].equals(board[i][1]) && board[i][2].equals(Marker)){

            if(board[i][0] != human.getMarker() && board[i][0] != Marker){
                board[i][0] = Marker;
                mademove = true;
                return;
            }
        }
    }


    // check if you can take a win diagonally
    //Case 1:
    if(board[0][0].equals(board[1][1]) && board[0][0].equals(Marker)){
        if(board[2][2] != human.getMarker() && board[2][2] != Marker){
            board[2][2] = Marker;
            mademove = true;
            return;
        }
    }
    //Case 2:
    if(board[2][2].equals(board[1][1]) && board[2][2].equals(Marker)){

        if(board[0][0] != human.getMarker() && board[0][0] != Marker){
            board[0][0] = Marker;
            mademove = true;
            return;
        }
    }
    //Case 3:
    if(board[0][0].equals(board[1][1]) && board[0][0].equals(Marker)){

        if(board[2][2] != human.getMarker() && board[2][2] != Marker){
            board[2][2] = Marker;
            mademove = true;
            return;
        }
    }
    //Case 4:
    if(board[0][2].equals(board[1][1]) && board[0][2].equals(Marker)){

        if(board[2][0] != human.getMarker() && board[2][0] != Marker){
            board[2][0] = Marker;
            mademove = true;
            return;
        }
    }
    //Case 5:
    if(board[2][0].equals(board[1][1]) && board[2][0].equals(Marker)){

        if(board[0][2] != human.getMarker() && board[0][2] != Marker){
            board[0][2] = Marker;
            mademove = true;
            return;
        }
    }


    // Block the player if they gonna win the game 

    // check if you can block a win vertically
    //Case 1:
    for(int i = 0; i<3; i++){
        if(board[0][i].equals(board[1][i]) && board[0][i].equals(human.getMarker())){
            if(board[2][i] != Marker && board[2][i] != human.getMarker()){
                board[2][i] = Marker;
                mademove = true;
                return;
            }
        }
    }
    //Case 2:
    for(int i = 0; i<3; i++){
        if(board[2][i].equals(board[1][i]) && board[0][i].equals(human.getMarker())){
            if(board[0][i] != Marker && board[0][i] != human.getMarker()){
                board[0][i] = Marker;
                mademove = true;
                return;
            }
        }
    }

    // check if you can block a win horizontally
    //Case 1:
    for(int i = 0; i<3; i++){

        if(board[i][0].equals(board[i][1]) && board[i][0].equals(human.getMarker())){

            if(board[i][2] != Marker && board[i][2] != human.getMarker()){
                board[i][2] = Marker;
                mademove = true;
                return;
            }

        }

    }
    //Case 2:
    for(int i = 0; i<3; i++){
        if(board[i][2].equals(board[i][1]) && board[i][2].equals(human.getMarker())){
            if(board[i][0] != Marker && board[i][0] != human.getMarker()){
                board[i][0] = Marker;
                mademove = true;
                return;
            }

        }

    }
    //Case 3:
    for(int i = 0; i<3; i++){
        if(board[2][i].equals(board[1][i]) && board[2][i].equals(human.getMarker())){
            if(board[0][i] != Marker && board[0][i] != human.getMarker()){
                board[0][i] = Marker;
                mademove = true;
                return;
            }
        }
    }

    // check if you can block a win diagonally 
    //Case 1:
    if(board[0][0].equals(board[1][1]) && board[0][0].equals(human.getMarker())){
        if(board[2][2] != Marker && board[2][2] != human.getMarker()){
            board[2][2] = Marker;
            mademove = true;
            return;
        }
    }
    
    //Case 2:
    if(board[2][2].equals(board[1][1]) && board[2][2].equals(human.getMarker())){
        if(board[0][0] != Marker && board[0][0] != human.getMarker()){
            board[0][0] = Marker;
            mademove = true;
            return;
        }
    }
    
    //Case 3:
    if(board[0][0].equals(board[1][1]) && board[0][0].equals(human.getMarker())){
        if(board[2][2] != Marker && board[2][2] != human.getMarker()){
            board[2][2] = Marker;
            mademove = true;
            return;
        }
    }
    //Case 4:
    if(board[0][2].equals(board[1][1]) && board[0][2].equals(human.getMarker())){

        if(board[2][0] != Marker && board[2][0] != human.getMarker()){
            board[2][0] = Marker;
            mademove = true;
            return;
        }
    }
    //Case 5:
    if(board[2][0].equals(board[1][1]) && board[2][0].equals(human.getMarker())){

        if(board[0][2] != Marker && board[0][2] != human.getMarker()){
            board[0][2] = Marker;
            mademove = true;
            return;
        }
    }

    
    // Make random move if above rules dont apply

    //Generate randomn numbers for row and column numbers
    while(!mademove){
        int rand1 = (int) (Math.random() * 3);
        int rand2 = (int) (Math.random() * 3);
        //Check whether the slot has been taken before or not
        if(!"x".equals(board[rand1][rand2]) && !"o".equals(board[rand1][rand2])){
            board[rand1][rand2] = Marker;
            mademove = true;        

        }

    }


}  
}
