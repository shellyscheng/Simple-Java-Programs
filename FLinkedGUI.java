/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flinkedlist_sc;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
/**
 *
 * @author Shiying
 */
public class FLinkedGUI extends JFrame implements ActionListener
{
    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 500;
    
    private static final int AREA_ROWS = 10;
    private static final int AREA_COLUMNS = 30;
    
    private JLabel input;
    private JLabel output;
    
    private JTextArea inputArea;
    private JTextArea outputArea;
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
   
    private JPanel myPanel;
    private JPanel buttonPanel;
    private JPanel textPanel;
    private FLinkedList mylist;
    
   
    public FLinkedGUI()
    {
        setSize(FRAME_WIDTH,FRAME_HEIGHT); //size of GUI window
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        myPanel = new JPanel();
        myPanel.setBackground(Color.CYAN);
        
        buttonPanel = new JPanel();
        textPanel = new JPanel();
        
        mylist = new FLinkedList(); //create a new LinkedList for animals
        
        input = new JLabel(" Input Area: Please enter an animal for manipulation below"); //Label for input area
        output = new JLabel(" Output Area:"); //Label for output area
        
        inputArea = new JTextArea(AREA_ROWS, AREA_COLUMNS);
       
        outputArea = new JTextArea(AREA_ROWS,AREA_COLUMNS);
        outputArea.setEditable(false);
        
        JScrollPane sPane1 = new JScrollPane(outputArea);//add scrollpane for the output area;
        
        //add all four bottoms
        b1 = new JButton("Add");
        b1.addActionListener(this);
        
        b2 = new JButton("Delete");
        b2.addActionListener(this);
        
        b3 = new JButton("Find");
        b3.addActionListener(this);
        
        b4 = new JButton("List");
        b4.addActionListener(this);
        
        myPanel.setLayout(new BorderLayout());
        
        buttonPanel.setLayout(new GridLayout(1,4));
        buttonPanel.add(b1);
        buttonPanel.add(b2);
        buttonPanel.add(b3);
        buttonPanel.add(b4);
        
        textPanel.setLayout(new GridLayout(4,1));
        textPanel.add(input);
        textPanel.add(inputArea);
        textPanel.add(output);
        textPanel.add(sPane1);
        
        myPanel.add(buttonPanel, BorderLayout.SOUTH);
        myPanel.add(textPanel, BorderLayout.CENTER);
        
        add(myPanel);
        setResizable(true);
        setVisible(true);
    
    }
    
    
    public void actionPerformed(ActionEvent evt)
    {
        String s = inputArea.getText();
        s = s.toLowerCase(); //Make all words within the text file lower case
        s = s.replaceAll("[^a-zA-Z\\s]", ""); //Remove punctuations
        
        if(evt.getSource() == b1) // add
        {
            if(mylist.add(s)) //when add method was applied
            {
                outputArea.append("Your input animal has existed in the list.\n");
            }
            else
            {
                outputArea.append("This animal is added to the list.\n");
            }
        }
        
        if(evt.getSource() == b2) //Delete
        {
            if(mylist.remove(s)) //when the remove method is applied
            {
                outputArea.append("Your input animal is removed.\n");
            }
            else
            {
                outputArea.append("Your input animal was not found in the list.\n");
            }
        }
        
        if(evt.getSource() == b3) //find
        {
            if(mylist.find(s)) //when the find mehtod is applied
            {
                outputArea.append("Target animal was found in the list.\n");
            }
            else
            {
                outputArea.append("Target animal was not found in the list.\n");
            }   
        }
        
        if(evt.getSource() == b4) //list
        {
            outputArea.append("Current Animal List: ");
            String animals [] = mylist.list(); //list method
            int size = animals.length; //store the length of animal array as variable size
            
            for(int i = 0; i < size; i++) //print the array one by one
            {
                outputArea.append(animals[i] + ", ");
            }
            outputArea.append("\n");
        }
    }
}
    

