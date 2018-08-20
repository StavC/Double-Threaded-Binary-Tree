package core;

/*
 * written by Amir Philipps & Stav Cohen
 */
public class TBinaryTree
{
    // instance variables
    private Node root;
    private final int INSERT = 0;
    private final int DELETE = 1;
    private int numOfNodes;
    private Node median;

    /*
     * ThreadedBinaryTree constructor
     */
    public TBinaryTree()
    {
        // ThreadedBinaryTree variables
        root = null;
        median = null;
        numOfNodes = 0;
    }

    /*
     * Get the root of the tree
     */
    public Node getRoot()
    {
        return this.root;
    }
    
    /*
     * return the median of our tree
     */
    public Node getMedian()
    {
        return median;
    }
    
    /*
     * update median of tree
     * keep an lower median if numOfNodes that we have is even
     */
    private void updateMedian(Node node, int status)
    {
        if (numOfNodes == 0)
        {
            median = null;
        }

        else if (numOfNodes == 1)
        {
            median = root;
        }

        else // numOfNodes > 1
        {
            if (status == INSERT)
            {
                if (numOfNodes%2 == 0) // even
                {
                    if (node.getId() < median.getId())
                    {
                        median = predecessor(median);
                    }
                }
                else // numOfNodes is odd
                {
                    if (node.getId() > median.getId())
                    {
                        median = successor(median);
                    }
                }
            }
            else // status is DELETE
            {
                if (numOfNodes%2 == 0) // even
                {
                    // == if median itself is deleted
                    if (node.getId() <= median.getId())
                    {
                        median = successor(median);
                    }
                }
                else // numOfNodes is odd
                {
                    // == if median itself is deleted
                    if (node.getId() >= median.getId())
                    {
                        median = predecessor(median);
                    }
                }
            }
        }
    }
    
    /*
     * return the minimum ID in the tree 
     */
    public Node minimum(Node rootNode)
    {
        Node min = rootNode;
        if (min != null)
        {
            while (!(min.getLeft()== null))
            {
                min = min.getLeft();
            }
        }
        return min;
    }

    /*
     * return the maximum ID in the tree 
     */
    public Node maximum(Node rootNode)
    {
        Node max = rootNode;
        if (max != null)
        {
            while (max.getRight()!= null)
            {
                max = max.getRight();
            }
        }
        return max;
    }

    /*
     * return the successor of a given node
     */
    public Node successor(Node node)
    {
        if (node == null)
        {
            return null;
        }
        // if node's next threaded is not its right son
        // then return its next threaded (its successor)
        if (node.getNextThreaded() != node.getRight())
        {
            return node.getNextThreaded();
        }
        // if node's next threaded is its right son and has right sub tree
        //  return the minimum of that sub tree.
        else if (node.getRight() != null)
        {
            return minimum(node.getRight());
        }
        else
        {
            return null;
        }
    }

    /*
     * return the predcessor of a given node
     */
    public Node predecessor(Node node)
    {
        if (node == null)
        {
            return null;
        }
        // if node's prev threaded is not its left son
        // then return its prev threaded (its successor)
        if (node.getPrevThreaded() != node.getLeft())
        {
            return node.getPrevThreaded();
        }
        // if node's prev threaded is its left son and has left sub tree
        //  return the maximum of that sub tree.
        else if (node.getLeft() != null)
        {
            return maximum(node.getLeft());
        }
        else
        {
            return null;
        }
    }
    
    /*
     * search a given ID in a given tree and return if him if we found him otherwise return false
     */
    public Node search(Node rootSubTree, int id)
    {
        Node current = rootSubTree;
        while (current != null)
        {
            if (id == current.getId())
            {
                return current;
            }

            if (id < current.getId())
            {
                current = current.getLeft();
            }
            else 
            {
                current = current.getRight();
            }
        }
        return null;
    }

    /*
   * insert new Node into the tree with a given ID (in the right place) 
   * updating the number of nodes and the median
     */
    public void insert(int id)
    {
        Node newNode = new Node(id);
        Node parent = null;
        Node current = getRoot();
        Node n = null;

        while (current != null)
        {
            parent = current;
            if (id == current.getId())
            {
                return;
            }

            if (current.getLeft() == null && id < current.getId())
            {
                break;
            }

            if (current.getRight() == null && id > current.getId())
            {
                break;
            }

            if (id < current.getId())
            {
                current = current.getLeft();
            }
            else
            {
                current = current.getRight();
            }
        }
        newNode.setParent(parent);
        // make newNode left/right child of parent and update treadeds
        if (parent != null)
        {
            if (id < parent.getId())
            {
                if (parent.getPrevThreaded() != null)
                {
                    n = parent.getPrevThreaded();
                    n.setNextThreaded(newNode);
                }
                parent.setLeft(newNode);
                newNode.setPrevThreaded(parent.getPrevThreaded());
                newNode.setNextThreaded(parent);
                parent.setPrevThreaded(newNode);
            }
            else
            {
                if (parent.getNextThreaded() != null )
                {
                    n = parent.getNextThreaded();
                    n.setPrevThreaded(newNode);
                }
                parent.setRight(newNode);
                newNode.setNextThreaded(parent.getNextThreaded());
                newNode.setPrevThreaded(parent);
                parent.setNextThreaded(newNode);
            }
        }
        else // tree was empty
        {
            this.root = newNode;
        }
        numOfNodes++;
        updateMedian(newNode, INSERT);
    }

    /*check if node is a leaf to help us maintain the BST order
     */
    
    private boolean isLeaf(Node node)
    {
        if (node.getLeft() == null && node.getRight() == null)
        {
            return true;
        }
        return false;
    }

    /*check if a node has only a left child to help us maintain the BST order
     * */
     
    private boolean hasOnlyLeftChild(Node node)
    {
        if (node.getLeft() != null && node.getRight() == null)
        {
            return true;
        }
        return false;
    }

    /* check if a node has only a right child to help us maintain the BST order
      */
    
    private boolean hasOnlyRightChild(Node node)
    {
        if (node.getLeft() == null && node.getRight() != null)
        {
            return true;
        }
        return false;
    }

    /* check if node is a left child of its parent to help us maintain the BST order
     
     */
    private boolean isLeftChild(Node child)
    {
        Node parent = child.getParent();
        return (child == parent.getLeft());
    }

    /*
     getting an ID and Deleting his Node from our tree (using search to find him)
     and updating num of nodes
     */
    public Node delete(int id)
    {
        Node toDelete = search(getRoot(), id);
        if (toDelete == null)
        {
            System.out.println("Error: No node with key=" + id + " in Tree.");
            return null;
        }
        else 
        {
            numOfNodes--;
            if (isLeaf(toDelete))
            {
                toDelete = deleteLeaf(toDelete);
                updateMedian(toDelete, DELETE);
            }
            else if (hasOnlyLeftChild(toDelete) || hasOnlyRightChild(toDelete))
            {
                toDelete = deleteNodeWithOneChild(toDelete);
                updateMedian(toDelete, DELETE);
            }
            else // node has both left and right children
            {
                toDelete = deleteNodeWithTwoChildren(toDelete);
                // updating median inside deleteNodeWithTwoChildren()
            }
            return toDelete;
        }
    }

    /*  delete a leaf from the tree using our deleting functions
     */
    private Node deleteLeaf(Node toDelete)
    {
        Node parent = toDelete.getParent();
        if (parent == null) // toDelete is the only node in tree
        {
            this.root = null;
        }
        else if (isLeftChild(toDelete)) // toDelete is the left son of his parent
        {
            if (toDelete.getPrevThreaded() != null)
            {
                Node n = toDelete.getPrevThreaded();
                n.setNextThreaded(parent);
            }
            parent.setLeft(null);
            parent.setPrevThreaded(toDelete.getPrevThreaded());
        }
        else // if (isRightChild(toDelete)) -> toDelete is the right son of his parent
        {
            if (toDelete.getNextThreaded() != null)
            {
                Node n = toDelete.getNextThreaded();
                n.setPrevThreaded(parent);
            }
            parent.setRight(null);
            parent.setNextThreaded(toDelete.getNextThreaded());
        }
        return toDelete;
    }

    /*
     * delte a node with only one child and maintain the BST order
     */
    private Node deleteNodeWithOneChild(Node toDelete)
    {
        Node parent, child;
        parent = toDelete.getParent();
        // get successor and predecessor of node to delete
        Node predecessor = predecessor(toDelete);
        Node successor = successor(toDelete);
        if (hasOnlyLeftChild(toDelete)) // node to delete has only left child
        {
            child = toDelete.getLeft();
        }
        else // node to delete has only right child
        {
            child = toDelete.getRight();
        }

        if (parent == null) // node to delete is root
        {
            this.root = child;
        }
        else if (isLeftChild(toDelete)) // node to delete is left child of his parent
        {
            parent.setLeft(child);
            if (hasOnlyLeftChild(toDelete)) // node to delete has only left child
            {
                parent.setPrevThreaded(predecessor);
                predecessor.setNextThreaded(parent);
            }
            else // node to delete has only right child
            {
                if (predecessor != null)
                {
                    predecessor.setNextThreaded(successor);
                    successor.setPrevThreaded(predecessor);
                }
            }
        }
        else // node to delete is right child of his parent
        {
            parent.setRight(child);
            if (hasOnlyLeftChild(toDelete)) // node to delete has only left child
            {
                if (successor != null)
                {
                    successor.setPrevThreaded(predecessor);
                    predecessor.setNextThreaded(successor);
                }
            }
            else // node to delete has only right child
            {
                parent.setNextThreaded(successor);
                successor.setPrevThreaded(parent);
            }
        }
        child.setParent(parent);
        return toDelete;
    }

    /*
     * delte a node with two childerens and main the the BST order
     */
    private Node deleteNodeWithTwoChildren(Node toDelete)
    {
        Node temp = new Node(0);
        Node successor = successor(toDelete);
        // save toDelete data to temp
        temp.copyData(toDelete);
        if (!(median == toDelete && numOfNodes%2==0))
        {
            updateMedian(toDelete,DELETE);
        }
        // copy successor data into toDelete node
        toDelete.copyData(successor);
        // copy toDelete data into its successor node
        successor.copyData(temp);
        // delete toDelete's successor
        if (isLeaf(successor))// if node is leaf
        {
            return deleteLeaf(successor);
        }

        else // node has only one child
        {
            return deleteNodeWithOneChild(successor);
        }
    }
    
    /*
     * making a string of the preorder of the tree ready to be printed
     */
    public String preorderPrint(Node currentNode)
    {
        StringBuilder sb = new StringBuilder();
        if (currentNode != null)
        {
            sb.append(currentNode.getId()+" "); 
            if (currentNode.getLeft() != null)
            {
                sb.append(preorderPrint(currentNode.getLeft()));
            }

            if (currentNode.getRight() != null)
            {
                sb.append(preorderPrint(currentNode.getRight()));
            }
        }
        return sb.toString();
    }

     /*
     * making a string of the inorder of the tree ready to be printed
     */
    public String inorderPrint()
    {
        Node runner = minimum(getRoot());
        StringBuilder sb = new StringBuilder();
        while (runner != null)
        {
            sb.append(runner.getId()+" "); 
            // If this node is right-threaded
            // then go to inorder successor
            if (runner.getNextThreaded() != runner.getRight())
            {
                runner = runner.getNextThreaded();
            }
            // Otherwise, go to the leftmost child in right sub-tree
            else
            {
                runner = minimum(runner.getRight());
            }
        }
        return sb.toString();
    }

    /*
     * making a string of the postorder of the tree ready to be printed
     */
    public String postorderPrint(Node currentNode)
    {
        StringBuilder sb = new StringBuilder();
        if (currentNode != null)
        {
            if (currentNode.getLeft() != null)
            {
                sb.append(postorderPrint(currentNode.getLeft()));
            }

            if (currentNode.getRight() != null)
            {
                sb.append(postorderPrint(currentNode.getRight()));
            }
            sb.append(currentNode.getId()+" "); 
        }
        return sb.toString();
    }

    
    }

    


