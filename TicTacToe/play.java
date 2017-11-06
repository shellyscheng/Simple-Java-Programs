/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe2;

/**
 *
 * @author Shiying, Oct 2016
 */
import java.util.Scanner;

//Build the class to play the game;
public class play {

    public static void main(String[] args) {

        //The welcome slogans!!
        System.out.println("Welcome to SHIYING's Tic-Tac-Toe!! :D SHIYING is not very smart, so you have a high chance of winning!!");
        System.out.println();

        //Two palyers: play 1 is x, player 2 is o
        String marker1 = "x";
        String marker2 = "o";
        boolean playAgain = true;

        //Scanners allow players to enter the coordinates of the slot.
        Scanner s = new Scanner(System.in);

        //Human and Computer classes
        Human human = new Human();
        Computer computer = new Computer();
        
        //Method to allows players to play again
        while(playAgain){
            //Set up a new board
            set Setup = new set();

            Setup.createBoard();
            Setup.printBoard();

            System.out.println("What marker do you want to play? :)");
            System.out.println("Type 1 for 'x' or 2 for 'o'");

            //set markers for the player and computer depends on the input
            if(s.nextInt() == 1){
                human.setMarker("x");
                computer.setMarker("o");
            } 
            else
            {
                human.setMarker("o");
                computer.setMarker("x");
            }
            System.out.println("Haha, you do not alwasy go first. "
                    + "Now the computer is calculating who gonna go first, lol!");
            // determine who goes first (randonly)
            int first = (int) (Math.random() * 2);

            //Calculate who goes first
            boolean won = false;
            int turns = 0;
            //when the result = 0, player goes first;
            if(first == 0){
                System.out.println("You gots the winz!");
                System.out.println();
                
                /**If the player does not win the game
                 * Player's turn increases 1, and the board was reprint
                 */
                while(!won){
                    human.takeTurn(Setup.getBoard());
                    turns++;
                    Setup.printBoard();
                    //When the play wins the game
                    if(Setup.hasWon(Setup.getBoard())){
                        won = true;
                        System.out.println("Congrats you won!");
                    }
                    /**the maximum numbers of turns are 9
                     * If nobody wins the game after 9 turns, it is a draw!
                     */
                    if(turns == 9){
                        won = true;
                        System.out.println("Its a draw!");
                        break;
                    }
                    
                    /**The term when computer takes turns
                     * turns +1, reprint the board after each of computer's turns
                     */
                    if(!won){
                        computer.takeTurn(Setup.getBoard(), human);
                        turns++;
                        System.out.println();
                        Setup.printBoard();
                        System.out.println();
                        if(Setup.hasWon(Setup.getBoard())){
                            won = true;
                            System.out.println("You just got pwned by an A.I with an incomplete rule set. FACEPALM.");
                        }
                        /**the maximum numbers of turns are 9
                         * If nobody wins the game after 9 turns, it is a draw!
                         * (If the computer starts the first move)
                         */
                        if(turns == 9){
                            won = true;
                            System.out.println("Its a bore draw!");
                            break;
                        }
                    }

                }  
            }
            //When the result == 1, the computer goes first
            else {

                System.out.println("Computer goes first!");
                System.out.println();
                //When nobody wins, computer takes turns, turns+!, set the baord
                while(!won){
                    computer.takeTurn(Setup.getBoard(), human);
                    turns++;
                    Setup.printBoard();
                    //If the computer wins
                    if(Setup.hasWon(Setup.getBoard())){
                        won = true;
                        System.out.println("You were beat by SHIYING. (SHIYING is actaully not that samrt!");
                    }
                    //If nobody wins after nine turns
                    if(turns == 9){
                        won = true;
                        System.out.println("Its a draw!");
                        break;
                    }
                    //If nobdy wins, human takes turns, turns+!, set the baord
                    if(!won){
                        human.takeTurn(Setup.getBoard());
                        turns++;
                        System.out.println();
                        Setup.printBoard();
                        System.out.println();
                        //If the human beings win, print out message "You Won!"
                        if(Setup.hasWon(Setup.getBoard())){
                            won = true;
                            System.out.println("You won!!");
                        }
                        //If nobody wins after nine turns
                        if(turns == 9){
                            won = true;
                            System.out.println("Its a draw!");
                            break;
                        }
                    }
                } 
            }
            //Wanna Play again?
            System.out.println("Would you like to play again? Type 1 for yes or 2 to quit");
            System.out.println();
            //If the play enters 2, game over!!
            if(s.nextInt() == 2){
                playAgain = false;
            }

        }

    }
}