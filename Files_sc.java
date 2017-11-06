/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package files_sc;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Shiying, Oct 2016
 */
public class Files_sc {
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    
    public static void main(String[] args) throws FileNotFoundException 
    {
        //Use the scanner to allow users to input 
        Scanner console = new Scanner(System.in);
        System.out.print("Please enter the name that you want to search: ");
        
        //Store the user's input in a string called searchName
        String searchName = console.next();
        searchName = searchName.toLowerCase();
        searchName = searchName.replaceAll("[^a-zA-Z\\s]", "");
       
        //Input the file "Names.txt" by Scanner
        File input = new File("Names.txt");
        Scanner in = new Scanner(input);
        
        //Write out the file by PrinterWriter
        PrintWriter out = new PrintWriter("NewNameList.txt");
      
        //Create an Array List to store names inside the file
        ArrayList<String> list = new ArrayList<>();
        
        //Store names from the file in the Arraylist list
        while (in.hasNext())
        {
            String s=in.next();
            s = s.toLowerCase(); //Make all words within the text file lower case
            s = s.replaceAll("[^a-zA-Z\\s]", ""); //Remove punctuations
            list.add(s);
        }
        
        //Initialize a boolean found
        boolean found = false;
                
        //If the name users entered was found in the file, the boolean value turns true;
        for (String names: list)
        {
            if (names.equals(searchName))
            {
                found = true;
            }
           
        }
        
        //When the name was found, printout "Yes"
        if (found == true) 
        {
            System.out.println("Yes!! This name is found in the file :D ");
        }
        //If the name was not found, print "Sorry" and add the name to the list of names
        else
        {
            System.out.println("Sorry! The name you entered was not found :(((");
            System.out.println("But I did add this name to the file now!");
            list.add(searchName);
        }
        
        //Add all the names to a new file NewNameList
        for (String newNames: list)
        {
          out.println(newNames);
        }
       
        //Close the files
        in.close();
        out.close();
    }
}
