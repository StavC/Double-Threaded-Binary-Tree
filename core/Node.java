package core;

/*
 * written by Amir Philipps & Stav Cohen
 */

public class Node
{
    // Node instance variables
    private int id;
    private Node left;
    private Node right;
    private Node parent;
    private Node prevThreaded;
    private Node nextThreaded;

    /*
     * constructor of Node    
     */
    public Node(int id)
    {
        this.id = id;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.prevThreaded = null;
        this.nextThreaded = null;
    }

    /*
     * help us to copy the ID of a node to another one
     */
    
    public void copyData(Node sourceNode)
    {
        this.id = sourceNode.id;
    }

    /*
     * return the id of the node
     */
    public int getId()
    {
        return this.id;
    }

    /*
     * get the left node of this node
     */
    public Node getLeft()
    {
        return this.left;
    }

    /*
     * get the right node of this node
     */
    public Node getRight()
    {
        return this.right;
    }

    /*
     * get the parent of the node
     */
    public Node getParent()
    {
        return this.parent;
    }

    /*
     * get the prev threaded of this node
     */
    public Node getPrevThreaded()
    {
        return this.prevThreaded;
    }

    /*
      get the next threaded of this node
     */
    public Node getNextThreaded()
    {
        return this.nextThreaded;
    }

    /*
     * set the left son of this node
     */
    public void setLeft(Node left)
    {
        this.left = left;
    }

    /*
     * set the right son of this node
     */
    public void setRight(Node right)
    {
        this.right = right;
    }

    /*
     * set the parent of this node
     */
    public void setParent(Node parent)
    {
        this.parent = parent;
    }

    /*
     * set this node prevthreaded
     */
    public void setPrevThreaded(Node prevThreaded)
    {
        this.prevThreaded = prevThreaded;
    }

    /*
     * set this node nextthreaded
     */
    public void setNextThreaded(Node nextThreaded)
    {
        this.nextThreaded = nextThreaded;
    }
}
