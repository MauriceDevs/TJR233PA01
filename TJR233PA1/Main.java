// Tyler Richard
// CptS 233 : PA01
// 9/20/20 
// github URL : https://github.com/MauriceDevs/TJR233PA01

// IMPORTANT:
//I ask for user input for file name initially, so if you run the program itself in command line, and then enter the file name after the prompt, it should respond.

import java.util.*;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.io.File;


class Main {
  public static void main(String[] args) {
    System.out.println();
    
    BinarySearchTree tree = new BinarySearchTree();
    LinkedList<Integer> list = new LinkedList<Integer>(); 

    // Scan file, read contents into BST
    try{
      System.out.println("Enter the name of the desired file: ");
      Scanner ChooseFile = new Scanner(System.in);
      String GivenFile = ChooseFile.nextLine();
      File f = new File(GivenFile); //"input1.text"
      Scanner sc = new Scanner(f); 
      while(sc.hasNextInt()){
        int input = sc.nextInt();
        tree.insert(input);
      } 
    } catch( Exception e){
      System.out.println("Input error. Try again");
    }
    System.out.println();
    

    // convert BST to LinkedList and report runtime. Method can be found in BinarySearchTree.java lines 52 to 61 
    long before0 = System.nanoTime();
    tree.convertToLL(tree.root, list);
    long later0 = System.nanoTime();
    long dif0 = later0 - before0;
    System.out.println("Time to insert: " + dif0 + " nanoseconds");
    System.out.println();
    

    // find median and runtime
    long before1 = System.nanoTime();
    System.out.println("Median : " + findMed(list));
    long later1 = System.nanoTime();
    long dif1 = later1 - before1;
    System.out.println("Time to find med: " + dif1 + " nanoseconds");
    System.out.println();


    // Find min and runtime
    long before2 = System.nanoTime();
    System.out.println("Minimum : " + list.get(0));
    long later2 = System.nanoTime();
    long dif2 = later2 - before2;
    System.out.println("Time to find Minimum: " + dif2 + " nanoseconds");
    System.out.println(); 


    // Find max and runtime.
    long before3 = System.nanoTime();
    System.out.println("Maximum: "+ list.get(list.size()-1));
    long later3 = System.nanoTime();
    long dif3 = later3 - before3;
    System.out.println("Time to find Max: " + dif3 + " nanoseconds");
    System.out.println(); 

  } // end of main

  public static double findMed(LinkedList<Integer> list){
    if (list.size() % 2 == 0){  // if even, take avg. of two medians
      int med1 = list.get((list.size()/2)+2);
      int med2 = list.get((list.size()/2)+1);
      double med = (med1+med2)/2; // avg of both median numbers
      return med;
    } else{ // if odd find median
      int even = (list.size()-1);
      double med = list.get((even/2));
      return med;
    }
  }

}