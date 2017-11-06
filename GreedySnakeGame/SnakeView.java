/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;
/**
 *
 * @author Shiying, Date Oct 2016
 */
//Create class snakeView. Implements interferances
public class SnakeView implements Observer {
    Control control = null;
    SnakeModel model = null;

    //Declear and initalizes varialbes
    JFrame mainFrame;
    Canvas paintBackground;
    JLabel labelScore;

    public static final int bgWidth = 200;
    public static final int bgHeight = 300;

    public static final int nodeWidth = 10;
    public static final int nodeHeight = 10;

    
    /**
     * Constructors 
     * @param model the SnakeModel
     * @param control The control variables declared before
     */
    public SnakeView(SnakeModel model, Control control) {
        this.model = model;
        this.control = control;

        //Create the JFrame which the game runs
        mainFrame = new JFrame("Greedy Snake Game!");

        Container cp = mainFrame.getContentPane();

        // Create the JLable to show the Score above
        labelScore = new JLabel("Score:");
        cp.add(labelScore, BorderLayout.NORTH);

        // The GameArea will be right at the center of the Canvas
        paintBackground = new Canvas();
        paintBackground.setSize(bgWidth + 2, bgHeight + 2);
        paintBackground.addKeyListener(control);
        cp.add(paintBackground, BorderLayout.CENTER);

        // Create the area at the bottom of the board that about instructions;
        JPanel panelButtom = new JPanel();
        panelButtom.setLayout(new BorderLayout());
        
        //Use JLabel to print out instructions;
        JLabel labelHelp;
        labelHelp = new JLabel("Press Q or S for speed;", JLabel.CENTER);
        panelButtom.add(labelHelp, BorderLayout.NORTH);
        labelHelp = new JLabel("ENTER to restart the game;", JLabel.CENTER);
        panelButtom.add(labelHelp, BorderLayout.CENTER);
        labelHelp = new JLabel("SPACE for pause", JLabel.CENTER);
        panelButtom.add(labelHelp, BorderLayout.SOUTH);
        cp.add(panelButtom, BorderLayout.SOUTH);

        
        //Add KeyListeners
        mainFrame.addKeyListener(control);
        mainFrame.pack();
        
        //Set the conditions of the JFrame visiblevisible
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    public void repaint() {
        Graphics g = paintBackground.getGraphics();

        //draw background
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, bgWidth, bgHeight);

        // draw the snake
        g.setColor(Color.BLUE);
        LinkedList<?> na = model.nodeArray;
        Iterator<?> it = na.iterator();
        while (it.hasNext()) {
            Node n = (Node) it.next();
            drawNode(g, n);
        }

        // draw the food
        g.setColor(Color.RED);
        Node n = model.food;
        drawNode(g, n);

        updateScore(); //Update the score
    }

    //DrawNode method (new food for the snakes)
    private void drawNode(Graphics g, Node n) {
        g.fillRect(n.x * nodeWidth,
                n.y * nodeHeight,
                nodeWidth - 1,
                nodeHeight - 1);
    }

    //UpdateScore mehtod
    public void updateScore() {
        String s = "Score: " + model.score;
        labelScore.setText(s);
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
}