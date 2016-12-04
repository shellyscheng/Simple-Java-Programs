/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package permutations;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 *
 * @author Shiying
 */
public class permutationBox extends JFrame {
    private JPanel myPanel;
    private JPanel textPanel;
    private JPanel inputx, outputx;
    private JButton myButton;
    private JTextArea input;
    private JTextArea output;
    private JLabel label;
    private JLabel iLabel;
    private JLabel oLabel;
    private JScrollPane scrollPane;

   
    
    public permutationBox()
    {
        //build and set the size of JFrame
        setSize(750,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Create JPanels to contain input and output
        myPanel = new JPanel();
        textPanel = new JPanel();
    
        //JLabel to give users instructions;
        label = new JLabel("Please enter the string that you want to manipulate in the Input Area");
        iLabel = new JLabel("Input Area: ");
        oLabel = new JLabel("Output Area: ");
        
        //Create JTextArea to allow input and print output
        input = new JTextArea(10,30);
        output = new JTextArea(10,30);
        output.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(output);
        
        //Arrange the input and output panels
        inputx = new JPanel();
        outputx = new JPanel();
        inputx.setLayout(new FlowLayout());
        outputx.setLayout(new FlowLayout());
        inputx.add(iLabel);
        inputx.add(input);
        outputx.add(oLabel);
        outputx.add(scrollPane);
        
        //Create the button to manimupate the string
        myButton = new JButton("Enter");
        
        //Set the layout of the GUI
        myPanel.setLayout(new BorderLayout());
        myPanel.add(label, BorderLayout.NORTH);
        
        textPanel.setLayout(new GridLayout(1,2));
        textPanel.add(inputx);
        textPanel.add(outputx);
        
        myPanel.add(textPanel, BorderLayout.CENTER);
        myPanel.add(myButton, BorderLayout.SOUTH);
        
        //Add actionListener for the button to perform Permutation method;
        myButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
            	if (evt.getSource() == myButton) 
                {
                    /**
                     * Grab the input from the users
                     * Change all characters to lower cases and remove punctuation;
                     */
                    String entered = input.getText();
                    entered = entered.toLowerCase();
                    entered = entered.replaceAll("[^a-zA-Z\\s]", "");
                    
                    /**
                     * Create an ArrayList to store the results after permutations
                     * Covert the ArrayList to an Array
                     * Print out the Array in the Output field;
                     */
                    ArrayList<String> outputr = permutations(entered);
                    String aOutputr[] = new String[outputr.size()];
                    aOutputr = outputr.toArray(aOutputr);
                    String sOutputr = "";
                    for(String i: aOutputr){
                    	sOutputr = sOutputr + i +"\n";
                    }
                    output.setText(sOutputr);
                    
                }
            }
         });
        
        //Add my Panel to the JFrame
        add(myPanel);
        setResizable(true);
        setVisible(true);
       
    }
    
    /**
     * the permutation method
     * @param word
     * @return 
     */
    public static ArrayList<String> permutations (String word)
    {
        ArrayList<String> result = new ArrayList<String>(); //Create a new ArrayList to store the result
   
        //The empty string has only one permutation: itself
        if (word.length() == 0)
        { 
            result.add(word);
            return result;
        }
        else
        {
            //Loop through all characters
            for (int i = 0; i < word.length(); i++)
            {
                //Increment one character at one time; form a shorter word by removing the ith character
                String shorter = word.substring(0,i) + word.substring(i+1);

                //Generate all permutations of the substring
                ArrayList<String> shorterPermutations = permutations(shorter);

                
                //Add the removed character to the front of each permutation of the new substring;
                for (String s: shorterPermutations)
                {
                    result.add(word.charAt(i)+ s);
                }
        }
            //Return all permutations
            return result;
        }
    }

    //Main mehtod to run the GUIBox
    public static void main(String[] args)
    {
        new permutationBox();
    }
}
