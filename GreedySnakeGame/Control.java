/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 *
 * @author Shiying, Date Oct 2016
 */
public class Control implements KeyListener{
    SnakeModel model;

    /**
     * @param model the model of the snake
     */
    public Control(SnakeModel model){
        this.model = model;
    }

    /**
     * @param e the KeyEvent input
     */
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (model.running){
            //When the snake is running, the keyevent controls different part of the moving snakes
            switch (keyCode) {
                //Up keyevent allows to move upwards
                case KeyEvent.VK_UP:
                    model.changeDirection(SnakeModel.UP);
                    break;
                //Down key allows snakes to move downwards
                case KeyEvent.VK_DOWN:
                    model.changeDirection(SnakeModel.DOWN);
                    break;
                //Left keyevent snakes to move left
                case KeyEvent.VK_LEFT:
                    model.changeDirection(SnakeModel.LEFT);
                    break;
                //Right keyevent snakes to mvoe right
                case KeyEvent.VK_RIGHT:
                    model.changeDirection(SnakeModel.RIGHT);
                    break;
                //When snakes eat an extra block, its length increases
                case KeyEvent.VK_Q:
                    model.speedUp();
                    break;
                case KeyEvent.VK_S:
                    model.speedDown();
                    break;
                case KeyEvent.VK_SPACE:
                //Pause the game
                    model.changePauseState();
                    break;
                default:
            }
        }

        // Key Enter allows the player to re-start the game
        if (keyCode == KeyEvent.VK_ENTER) {
            model.restart();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}