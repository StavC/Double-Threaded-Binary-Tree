import core.TBinaryTree;
import core.Node;
import java.io.*;
import java.util.Scanner;
/*
 * written by Amir Philipps & Stav Cohen
 */

public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int id; // saves the id to insert
        TBinaryTree myTree; // our binary tree
        int instruction; // saves the instruction that we gonna do
        int temp; // will help us with the id we work on
        Node node; // will hold a node for our functions

        myTree = new TBinaryTree();

        // initialize the root
        System.out.println("what do you wanna do? for insert enter 0,delete enter 1 ,search enter 2, predcessor 3 ,successor 4, minimum 5, maximum 6, Median 7 ,inorderprint 8, preorderprint 9, postorderprint 10, exit 11,");
        System.out.println("after every instruction you can write another instruction using the same rules above");
        instruction = scan.nextInt();

        while (instruction != 11)
        {
            switch (instruction)
            {
                case 0: //doing insert
                    System.out.println(" enter the ID that you want to insert");
                    id = scan.nextInt();
                    System.out.println("you are trying to insert the ID: "+id);
                    myTree.insert(id);
                     System.out.println("Node added with ID: "+id);
                   /* System.out.println("what do you wanna do? for insert enter 0,delete enter 1 ,search enter 2, predcessor 3 ,successor 4, minimum 5, maximum 6, Median 7 ,inorderprint 8, preorderprint 9, postorderprint 10, exit 11,");
                  */  instruction = scan.nextInt();

                  
                    break;

                case 1: // delteing
                    System.out.println("which ID do you want to delete?");
                    temp = scan.nextInt();
                    System.out.println("you are trying to delete the ID "+temp);
                    if ((myTree.search(myTree.getRoot(), temp)) == null)
                    {
                        System.out.println(temp);
                    } 
                    else
                    {
                        System.out.println("We found the ID:"+temp+" and deleted him");
                    }


                    myTree.delete(temp);
                  /*  System.out.println("what do you wanna do? for insert enter 0,delete enter 1 ,search enter 2, predcessor 3 ,successor 4, minimum 5, maximum 6, Median 7 ,inorderprint 8, preorderprint 9, postorderprint 10, exit 11,");
                   */ instruction = scan.nextInt();
                    break;

                case 2: // searching
                    System.out.println("what do you wanna search?");
                    temp = scan.nextInt();
                    System.out.println("you are searching the ID: "+temp);
                    if ((myTree.search(myTree.getRoot(), temp)) == null)
                    {
                        System.out.println("didnt find ID: "+temp);
                    }
                    else
                    {
                        System.out.println("We found the ID: "+temp);
                    }

                   /* System.out.println("what do you wanna do? for insert enter 0,delete enter 1 ,search enter 2, predcessor 3 ,successor 4, minimum 5, maximum 6, Median 7 ,inorderprint 8, preorderprint 9, postorderprint 10, exit 11,");
                  */  instruction = scan.nextInt();
                    break;

                case 3: // predecessor
                    System.out.println("in Which ID predecessor are you intrested?");
                    temp = scan.nextInt();
                    System.out.println("you are looking for the predecessor of ID: "+temp);
                    node = myTree.search(myTree.getRoot(), temp);
                    if (node != null)
                    {
                        System.out.print("the Predecessor of ID "+temp+" is: ");
                        System.out.println(myTree.predecessor(node).getId());
                    }
                    else
                    {
                        System.out.println("we didnt find that ID in the tree");
                    }
                  /*  System.out.println("what do you wanna do? for insert enter 0,delete enter 1 ,search enter 2, predcessor 3 ,successor 4, minimum 5, maximum 6, Median 7 ,inorderprint 8, preorderprint 9, postorderprint 10, exit 11,");
                   */ instruction = scan.nextInt();

                    break;
                    
                case 4: //successor
                    System.out.println("in Which ID successor are you intrested?");
                    temp = scan.nextInt();
                     System.out.println("you are looking for the successor of ID: "+temp);
                    node = myTree.search(myTree.getRoot(), temp);
                    if (node != null)
                    {
                        System.out.print("the successor of ID "+temp+" is: ");
                         System.out.println(myTree.successor(node).getId());
                    }
                    else
                    {
                        System.out.println("we didnt find that ID in the tree");
                    }
                   /* System.out.println("what do you wanna do? for insert enter 0,delete enter 1 ,search enter 2, predcessor 3 ,successor 4, minimum 5, maximum 6, Median 7 ,inorderprint 8, preorderprint 9, postorderprint 10, exit 11,");
                   */ instruction = scan.nextInt();
                    break;

                case 5: // minimum
                    System.out.print("you are searching for the minimum ID of the tree the minimum is: ");
                    System.out.println(myTree.minimum(myTree.getRoot()).getId());
                  /*  System.out.println("what do you wanna do? for insert enter 0,delete enter 1 ,search enter 2, predcessor 3 ,successor 4, minimum 5, maximum 6, Median 7 ,inorderprint 8, preorderprint 9, postorderprint 10, exit 11,");
                   */ instruction = scan.nextInt();
                    break;

                case 6: // maximum
                System.out.print("you are searching for the maxiumum ID of the tree the maximum is: ");
                    System.out.println(myTree.maximum(myTree.getRoot()).getId());
                  /*  System.out.println("what do you wanna do? for insert enter 0,delete enter 1 ,search enter 2, predcessor 3 ,successor 4, minimum 5, maximum 6, Median 7 ,inorderprint 8, preorderprint 9, postorderprint 10, exit 11,");
                   */ instruction = scan.nextInt();
                    break;

                case 7: // median
                System.out.print("you are searching for the Median of the tree the Median is: ");
                    System.out.println(myTree.getMedian().getId());
                  /*  System.out.println("what do you wanna do? for insert enter 0,delete enter 1 ,search enter 2, predcessor 3 ,successor 4, minimum 5, maximum 6, Median 7 ,inorderprint 8, preorderprint 9, postorderprint 10, exit 11,");
                  */  instruction = scan.nextInt();
                    break;

                case 8: // inorderprint
                System.out.print("you want to know the inorderPrint of the tree so here it is: ");
                    System.out.println(myTree.inorderPrint());
                   /* System.out.println("what do you wanna do? for insert enter 0,delete enter 1 ,search enter 2, predcessor 3 ,successor 4, minimum 5, maximum 6, Median 7 ,inorderprint 8, preorderprint 9, postorderprint 10, exit 11,");
                   */ instruction = scan.nextInt();
                    break;

                case 9: // preorderprint
                  System.out.print("you want to know the preorderPrint of the tree so here it is: ");
                    System.out.println(myTree.preorderPrint(myTree.getRoot()));
                  /*  System.out.println("what do you wanna do? for insert enter 0,delete enter 1 ,search enter 2, predcessor 3 ,successor 4, minimum 5, maximum 6, Median 7 ,inorderprint 8, preorderprint 9, postorderprint 10, exit 11,");
                  */  instruction = scan.nextInt();
                    break;

                case 10: // postorderprint
                 System.out.print("you want to know the postorderPrint of the tree so here it is: ");
                    System.out.println(myTree.postorderPrint(myTree.getRoot()));
                  /*  System.out.println("what do you wanna do? for insert enter 0,delete enter 1 ,search enter 2, predcessor 3 ,successor 4, minimum 5, maximum 6, Median 7 ,inorderprint 8, preorderprint 9, postorderprint 10, exit 11,");
                   */ instruction = scan.nextInt();
                    break;

                case 11: // exit
                    System.out.println("Programed stopped");
                    break;

                default:
                    System.out.println("error please right according to the instructions!");
                    break;
            }
        }
    }
}