/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;
//SnakeModel.java
import javax.swing.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Random;
/**
 *
 * @author Shiying, Date Oct 2016
 */
//Create class SnakeModel extends from superclass Observable. Interferace with Runnable
class SnakeModel extends Observable implements Runnable {
    // If the location does nto have snake body or any food
    boolean[][] location;                         
    // Create a linkedlist for the body of the snake named nodeArray
    LinkedList<Node> nodeArray = new LinkedList<>();    
    Node food;
    
    //Initialize maxX and max Y
    int maxX;
    int maxY;
    
    //Inititalize the direction where the snakes is moving
    int direction = 2; 
    //Initialize the orignial status of the running of the program
    boolean running = false;                    

    
    //The interval of time
    int timeInterval = 200;
    
    //The change of the moving speed everytime when the snake eats food
    double speedChangeRate = 0.75; 
    
    //The Paused sign
    boolean paused = false;                     

    //Initialize the score
    int score = 0;  
    
    // Counts how many times that the snake has eaten before moving
    int countMove = 0;                          

    /**Make UP and DOWN should be even numbers, RIGHT and LEFT should be odd numbers
     * Easier for future manipulations.
     */
    public static final int UP = 2;
    public static final int DOWN = 4;
    public static final int LEFT = 1;
    public static final int RIGHT = 3;

    
    //The position of the snake 
    public SnakeModel( int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;

        restart(); //Reset its position everytime when it mvoes;
    }
    
   
    /**Create the restart method. 
     * Repaint the board. 
     * all the variables back to its initial values
     * */
    public void restart(){
        //The same variables as decleared above
        direction = SnakeModel.UP;              
        timeInterval = 200;                     
        paused = false;                        
        score = 0;                              
        countMove = 0;                          

        
        
        // initial matirx, 全部清0
        location = new boolean[maxX][];
        for (int i = 0; i < maxX; ++i) {
            location[i] = new boolean[maxY];
            Arrays.fill(location[i], false);
        }

        
        // initial the snake
        /** Set the condition of initial snake at the beginning of the game
         *  if the horizontal initial location (x-coordinate) is more than 20, 
         *  then the horizontal length is 10
         *  Otherwise, the initial length of the snake would be half of its x-coordinate
         * (The initial direction of the snake would be up anyway)
         */
        int initArrayLength = maxX > 20 ? 10 : maxX / 2;
        nodeArray.clear();
        for (int i = 0; i < initArrayLength; ++i) {
            int x = maxX / 2 + i;
            int y = maxY / 2;    
            
        //The food will always be added to the list   
            nodeArray.addLast(new Node(x, y));
            location[x][y] = true;
        }

        // Create the food for the snake
        food = createFood();
        location[food.x][food.y] = true;
    }

    public void changeDirection(int newDirection) {
        /**Because the directions was initialized as values, even or odd 
         * When changing directions, the direction cannot be the same or the opposite of the orginal directions
         */
        if (direction % 2 != newDirection % 2) {
            direction = newDirection;
        }
    }

   
    //Create bollean value of Moveon Method
    public boolean moveOn() {
        Node n = (Node) nodeArray.getFirst();
        int x = n.x;
        int y = n.y;

        //According to the direction of moving, adjusting the coordinates of the snakes
        switch (direction) {
            case UP:
                y--;
                break;
            case DOWN:
                y++;
                break;
            case LEFT:
                x--;
                break;
            case RIGHT:
                x++;
                break;
        }


        
        /** If the new coordinates falls within the range, then executes the following methods
         * @return whether the boolean value of x,y-coordinates
         */
        if ((0 <= x && x < maxX) && (0 <= y && y < maxY)) {
        
            //If new coordinates has either food or the snake body
            if (location[x][y]) {       
                if (x == food.x && y == food.y) {       // eat the food
                    nodeArray.addFirst(food);           // increase the length of the snake

                    
                    //Calculate the socre, each food accoutns for (200 points divided by the time interveral
                    int scoreGet = (10000 - 200 * countMove) / timeInterval;
                    score += scoreGet > 0 ? scoreGet : 10;
                    countMove = 0;

                    food = createFood();                // create the new food for next move
                    location[food.x][food.y] = true;    
                    return true;
                } else                                  // if the snake teaches itself, mission fails
                    return false;
               
            } else {                 
                /**If there is nothing on the new coordinates
                 * Snake continues moving on its location
                 */
                nodeArray.addFirst(new Node(x, y));
                location[x][y] = true;
                n = (Node) nodeArray.removeLast();
                location[n.x][n.y] = false;
                countMove++;
                return true;
            }
        }
        return false;         //If the snake touches the boundary, game over!!
    }

    //Create the method of running
    @Override
    public void run() {
        running = true;
        while (running) {
            try {
                Thread.sleep(timeInterval);
            } catch (Exception e) {
                break;
            }

            //When the game is not pasued
            if (!paused) {
                if (moveOn()) {
                    // Model will notify View that data has been updated
                    setChanged();           
                    notifyObservers();
                } else {
                    JOptionPane.showMessageDialog(null,
                            "you failed",
                            "Game Over",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            }
        }
        running = false;
    }

    //CreateFood method (private)
    private Node createFood() {
        int x = 0;
        int y = 0;

        /**Randomly create the location of the food
         * But the location does not coincide with the position of the snake
         */
        do {
            Random r = new Random();
            x = r.nextInt(maxX);
            y = r.nextInt(maxY);
        } while (location[x][y]);

        return new Node(x, y);
    }

    //Allows the player to increase the speed of the snake
    public void speedUp() {
        timeInterval *= speedChangeRate;
    }

    //Allow the player to slow down the speed of the snake
    public void speedDown() {
        timeInterval /= speedChangeRate;
    }

    //Pause the game
    public void changePauseState() {
        paused = !paused;
    }

    /**for loop to return the result of nodeArray
     * 
     * @return the result of the Node
     */
    public String toString() {
        String result = "";
        for (int i = 0; i < nodeArray.size(); ++i) {
            Node n = (Node) nodeArray.get(i);
            result += "[" + n.x + "," + n.y + "]";
        }
        return result;
    }
}

//Class Node
class Node {
    int x;
    int y;

    //location of Node
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}