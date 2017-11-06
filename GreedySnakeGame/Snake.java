/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

/**
 *
 * @author Shiying, Date Oct 2016
 */
public class Snake { 


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       SnakeModel model = new SnakeModel(20,30);
       Control control = new Control(model);
       SnakeView view = new SnakeView(model,control);
       
       /**Add an observer for the game
        * View will become an observer for the model
        */
       model.addObserver(view);
      
       //Create a new thread
       (new Thread(model)).start();
        
    }
    
}
