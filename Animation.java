/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animation;
// Include the libraries necessary for graphics
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;


class Animation extends JComponent {

    // Instance variables that define the current characteristics
    // of your animated object.
    int ballX = 50;
    int ballY = 50;
    final int BALL_SIZE = 50;
    
    // Ball's speed for x and y
    private float ballSpeedX = 3;   
    private float ballSpeedY = 3;
    
    private static final int UPDATE_RATE = 24;
    
    // This special method is automatically called when the scene needs to be drawn.
    public void paintComponent(Graphics g) {

        // Clear the background to white
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 800, 600);

        // Draw the ball at the current ballX, ballY position
        g.setColor(Color.ORANGE);  // Orange like a basketball?
        g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);

    }


    // Pause the program for ms milliseconds so the animation doesn't go too fast
    public void pause(int ms) {
        try {
            Thread.sleep(ms);
        }
        catch (InterruptedException ex) {
            System.out.println("Error occurred!");
        }
    }

    public void playAnimation() {
        // Inside the loop you should do 4 things:
        // Update the ball position variables (ballX and ballY)
        while (true) {
            //Calculate the ball's new position
            ballX += ballSpeedX;
            ballY += ballSpeedY;
        //Check the new position to see if a bounce occurs; 
        //If the bounce occurs, the moving direction changes
        if (ballX < 0 || ballX + BALL_SIZE > 800){
            ballSpeedX = -ballSpeedX;
        } else if (ballY <0 || ballY + BALL_SIZE > 580) {
            ballSpeedY = -ballSpeedY;
        }
        //Use repaint() to draw the ball in the new location
        repaint();
        //Use pause(x) to pause the program's execution for x milliseconds (you should fill in a value for x)
        pause(10);
        }
    }


    public static void main(String[] args) {

        Animation my_animation = new Animation();
        JFrame frame = new JFrame();

        // Set the size of the window
        frame.add(my_animation);

        // Set the title of the window
        frame.setTitle("My Animation");
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Launch your animation!
        my_animation.playAnimation();
    }
}
