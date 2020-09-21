// Tyler Richard
// CptS 233 : PA01
// 9/20/20 
// github URL : https://github.com/MauriceDevs/TJR233PA01

// Method that traverses BST and adds the file's contents to the LinkedList in order are shown in BinarySearchTree.java lines 131 to 143.

import java.util.*;
import java.util.List;

class BinarySearchTree { 
    /* Class containing left and right child of current node and key value*/
    class Node { 
        int key; 
        Node left, right; 

        public Node(int item) { 
            key = item; 
            left = right = null; 
        } 
    } 
    // Root of BST 
    Node root; 

    // Constructor 
    BinarySearchTree() { 
      root = null; 
    } 

    // This method mainly calls insertRec() 
    void insert(int key) { 
      root = insertRec(root, key); 
    } 

    /* A recursive function to insert a new key in BST */
    Node insertRec(Node root, int key) { 
      /* If the tree is empty, return a new node */
      if (root == null) { 
        root = new Node(key); 
        return root; 
      } 
      /* Otherwise, recur down the tree */
      if (key < root.key) 
        root.left = insertRec(root.left, key); 
      else if (key > root.key) 
        root.right = insertRec(root.right, key); 
      /* return the (unchanged) node pointer */
        return root; 
    } 

/////////////////////////////////////////
// This method recursively traverses the BST inorder and adds it's contents to a given LinkedList. 
  LinkedList<Integer> convertToLL(Node root, LinkedList<Integer> list){
    if (root != null) 
        { 
            convertToLL(root.left, list); 
            list.add(root.key); 
            convertToLL(root.right, list); 
        }
    return list; 
  }
//////////////////////////////////////////
// This method finds the largest number within the BST.
int maxValue(Node node) { 
  if (node.right == null) 
    return node.key; 
  return maxValue(node.right); 
}
// original findMax method before re-reading the preoject spec.
//////////////////////////////////////////// 
  
} 