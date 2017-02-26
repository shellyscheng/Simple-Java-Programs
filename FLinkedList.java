/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flinkedlist_sc;

import java.util.ArrayList;
/**
 *
 * @author Shiying
 */
public class FLinkedList 
{
    private Node first;
    private Node current;
    private Node previous;

    public FLinkedList() //create an empty linkedlist
    {
        first = null;
        current = null;
        previous = null;
    }
    
    public String[] list() //list method: return a array of sring of original lists
    {
        ArrayList<String> animalList = new ArrayList<String>(); //build a new arraylist
        current = first;
        
        while(current != null) //when the current is not the last node of the list
        {
            animalList.add(current.entry); //add the current entry to the arraylist
            current = current.link; //increment by one
        }
        String animals [] = new String[animalList.size()]; //change arraylist to array
        animals = animalList.toArray(animals);
        return animals;
    }
    
    
    public boolean find(String target) //find whether the target is in the animallists
    {
        boolean found = false; //set the orignal status
        current = first;
        while (current != null)
        {
            if(current.entry.equalsIgnoreCase(target))
            {
                found = true; //set the boolean value to be true
            }
            current = current.link; //increment by one node
        }
        return found;
    }
    
    public boolean add (String newAnimal)
    {
        boolean found = true;
        if(find(newAnimal) == false)
        {
            if (first != null) //When the list is not empty
            {
                if (newAnimal.compareToIgnoreCase(first.entry) < 0) //when the newanimal is before 1st entry
                {
                    Node myNode = new Node(); //create a new node
                    myNode.entry = newAnimal;//set the entry as new anmial (entered)
                    myNode.link = first; //link to the first node
                    first = myNode; //first equals to the new Node created
                }
                else //when the newanimal is after the first node
                {
                    current = first; //set current to be the first;
                    
                    while (current != null && (newAnimal.compareToIgnoreCase(current.entry) >= 0))
                    {//when the new animal is after the current entry
                        previous = current; 
                        current = current.link; //increnmnet
                    }
                    if(current != null) //add new animal at the middle of the linked list
                    {
                        Node myNode = new Node(); //create a new node
                        myNode.entry = newAnimal; //set the entty as new animal
                        myNode.link = current; 
                        previous.link = myNode;
                    }
                    else //add the node at the end of the list
                    {
                        Node myNode = new Node();
                        myNode.entry = newAnimal;
                        myNode.link = null;
                        previous.link = myNode;
                    }
                }
            }
            else //if the linked list is empty
            {
                Node myNode = new Node();//create a new node
                myNode.entry = newAnimal; //new node contains new animal
                myNode.link = first; //link to the first node
                first = myNode; 
            }
            found = false;
        }
        return found;
    }
    
    
    public boolean remove (String target) //remove an animal from the list
    {
        boolean found = false; 
        
       if(find(target) == true) //if the target animal existed in the list
       {
           if(first.entry.equalsIgnoreCase(target)) //check the first node
           {
               first = first.link;
           }
           else //If the target animail is not the first node
           {
               current = first.link;
               previous = first; //increment
               
               while(current.entry.equals(target) == false)
               {
                   previous = current; //set the previous to be current
                   current = current.link; //increment by one node
               }
               if(current != null) //if not reach the end of the list
               {
                   previous.link = current.link;
               }
               else //if it is the last item
               {
                   previous.link = null;
               }
           }
           found = true;
       }
       return found; //return the value
    }
}
