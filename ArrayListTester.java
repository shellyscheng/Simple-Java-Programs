/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylisttester;

import java.util.ArrayList;
import java.util.Scanner;



/**s
 *
 * @author Shiying
 */
public class ArrayListTester {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) {
        // Use Scanner to read the text.txt
        Scanner in = new Scanner(System.in);
        
        //Create an Arraylist to store the input
        ArrayList<String> list = new ArrayList<>();
        //Create another Arraylist to store the counts (how many times each word shows up)
        ArrayList<Integer> counts = new ArrayList<>();
        
        /**Create the while loop, String s takes words in the file
         * Index stores the first occurrence of certain word in a string s
         */
        while (in.hasNext()) {
            String s=in.next();
            s = s.toLowerCase(); //Make all words within the text file lower case
            s = s.replaceAll("[^a-zA-Z\\s]", ""); // remove all the punctuasions
            int index = list.indexOf(s);
            /**When the first occurrence of certain word appears
             * Counts +1, this word was added to String s
             */
            if (index == -1) {
                counts.add(1);
                list.add(s);}
            /**When certain words was not showed at the first time
             * this word was added to string s
             * index of this word when it last occurred +1 (counts increases 1)
             */
            else
            {
                counts.set(index,counts.get(index)+1);
            }
        }
        //Use for loop to print out each elemts of ArrayList list and ArrayList counts
        for (int i = 0; i < list.size(); i++)
        {
        System.out.println();
        System.out.printf("%15s",list.get(i));
        System.out.printf("%5d",counts.get(i));
      }
        System.out.println();
    }
}
    
        
