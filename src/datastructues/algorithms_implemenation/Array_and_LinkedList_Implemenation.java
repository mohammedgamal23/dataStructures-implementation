/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructues.algorithms_implemenation;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Programming with MOSH Tutorial
 * @author Jimmy
 */

// Big O notation first
// descibes the runtime complexity of an algorithm
public class Array_and_LinkedList_Implemenation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);
        System.out.println(list);
        list.remove(0);
        list.contains(12);
        list.size();
        list.toArray();
        */
        // if you don't specify the wrapper class it will hold any datatype
        /*
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(20);
        list.addLast(30);
        list.addLast(50);
        list.addFirst(5);
        list.removeLast();
        list.remove(1);
        list.contains(30);
        list.indexOf(50);
        Object[] array = list.toArray();
        System.out.println(Arrays.toString(array));
    */
    }
    
    // O(n)--> depends on the number of inputs, if inputs are high -> time is!
    // LINEAR GROWTH
    public void log(int[] numbers)
    { 
        /* foreach loop
        for(int number : numbers)
            sout(number")
        */
        for (int i = 0; i<=numbers.length; i++)
        {
            System.out.println(numbers[i]);
        }
    }
    
    // constant time == O(1)
    // O(1)
    public void log2(int[] numbers)
    {
        
        //O(1) ---> needs constant time not depending on the input size
        System.out.println(numbers[0]); 
    }
    
    // O(n^2) == n-square
    // Quadratic Growth
    public void log3(int[] numbers)
    {
        for (int first : numbers)
        {
            for (int seconds : numbers)
            {
                // Do something
            }
        }
    }
    
    // O(log(n))
    // Logarithmic Growth
    // No example here cause i understood it very fast as i'm genius :D
    // ----------------------------------------------------
}


// Array Implementation
//comments are literally for no reason :"D
class Array{
    private int[] items;
    private int count;
    public Array(int length)
    {
        items = new int[length];
    }

    public void print(){
        for (int i = 0; i <count;i++)
        {
            System.out.println(items[i]);
        }
    }
    
    public void insert(int item){
        
        // resize if the array is full
        if(items.length == count){
            //create new array with twice the size
            
            int[] newItems = new int[count*2];
            //copy the existing elements into the new one
            
            for(int i =0; i< count ; i++)
            {
                newItems[i] = items[i];
            }
            //set the items array the new field
            items = newItems;
        }
        // add the new item at the end
        items[count++] = item;
    }
    
    public void removeAt(int index){
        
        //validate the index
        if(index < 0 || index >=count){
            throw new IndexOutOfBoundsException();
        }
        
        //shift items to the left to fill the hole
        for (int i = index ; i < count ; i++){
            items[i] = items[i+1];
        }
        // to shrink array members
        count --;
    }
    
    public int indexOf(int item){
        // loop through every item in the array and if you find it return its index
        for (int i =0;i<count;i++)
        {
            if(items[i]==item)
                return i;
            
        }
        // item is not in the array --> return -1
        return -1;
    }
}

// LinkedList Java implementation from Scratch


class LinkedList{
    
    private class Node{
    private int value;
    private Node next;
    
    public Node(int value){
        this.value = value;
    }
}
    
    private Node first;
    private Node last;
    
    //addFirst
    public void addfirst(int mValue){
        Node node = new Node(mValue);
        if (first == null)
        {
            first = last = node;
        }else{
        node.next = first;
        first = node;
        }
    }
    
    //addLast
    public void addLast(int item){
        Node node = new Node(item);
        
        // check if list is empty
        if (first == null){
            first = node;
            last = node;
        }
        else{
            last.next = node;
            last = node;
        }
    }
    
    //deleteFirst
    public void removeFirst(){
        
        if(first == null){
            throw new NoSuchElementException();
        }
        
        if (first == last){
            first = last = null;
            return;
        }
        Node second = first.next;
        first.next = null;
        first = second;
    }
    
    //deleteLast
    // [10 -> 20 -> 30]
    public void removeLast(){
        if(first == null ){
            throw new NoSuchElementException();
        }
        
        if(first == last){
            first = last = null;
            return;
        }
        
        Node previous = getPrevious(last);
        last = previous;
        last.next = null;
    }
    
    private Node getPrevious(Node node){
            Node current = first;
        while(current != null){
            if(current.next == node){
                return current;
            }
            else{
                current = current.next;
            }
        }
        return null;
        }
    
    //indexOf
    public int indexOf(int item){
        int index = 0;
        Node current = first;
        while(current != null){
            if(current.value == item){
                return index;
            }else{
                current = current.next;
                index++;
            }
        }
        return -1;
    }
    
    //contains
    public boolean contains(int item){
        return indexOf(item)!= -1;
    }
}
// I love conding in Java :D

