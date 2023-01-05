/*
Student Name: Nathaniel Posesorsky
 */

public class MyBST {
    private Node1 ROOT; // declares ROOT using data type Node1 with value null (no attributes)

    private class Node1 { // node object model
        public int data; // data variable = data
        public Node1 leftChild; // pointer = leftChild
        public Node1 rightChild; // pointer = leftChild

        public Node1() {
        } // empty constructor to add a Node1 with values null

        public Node1(int data, Node1 leftChild, Node1 rightChild) { //creates a node with given input
            this.data = data;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }

    /***
     * Method to call searching method using integer data
     * @param data integer value being searched for
     * @return overridden search method
     */
    public boolean search(int data) {
        return this.search(data, null);
    }

    /***
     * Method to search for a integer data in a Tree
     * @param data integer value being searched for
     * @param compareNode Node used for searching purpose
     * @return boolean representing if value was found or not
     */
    private boolean search(int data, Node1 compareNode) {
        if (this.ROOT == null) { // if the ROOT is null, the Tree is empty, so return false
            return false;
        } else {
            if (compareNode == null) { // if the compareNode is null, set it to the ROOT
                compareNode = this.ROOT;
            }
            if (data < compareNode.data) { // if the data is smaller than the data of compareNode
                if (compareNode.leftChild != null) { // see if compareNode has a leftChild, if so,
                    // recursive call using leftChild as the new compareNode
                    return search(data, compareNode.leftChild);
                }
            }
            if (data > compareNode.data) { // if the data is bigger than the data of compareNode
                if (compareNode.rightChild != null) {// see if compareNode has a rightChild, if so,
                    // recursive call using rightChild as the new compareNode
                    return search(data, compareNode.rightChild);
                }
            }
        }
        // Once this line is reached, the leaf's data and the parent's data is verified
        // if no match is found, recursion moves back up and it verifies again

        if (data == compareNode.data) // if data of compareNode is equal to the data searched for
            return true; // return true since a match is found
        // if there is a leftChild and data of leftChild is equal to the data searched for
        if (compareNode.leftChild != null && data == compareNode.leftChild.data)
            return true; // return true since a match is found
        // if there is a rightChild and data of rightChild is equal to the data searched for
        if (compareNode.rightChild != null && data == compareNode.rightChild.data)
            return true; // return true since a match is found
        return false; // if this line is reached, no match was found, so return false
    }

    /***
     * Method to call addNode method using integer data
     * @param data Integer value being added to the Tree
     */
    public void addNode(int data) {
        this.addNode(data, null);
    }

    /***
     * Method to add a Node to the Tree using the Integer data
     * @param data Integer value assigned to the Node being created
     * @param compareNode Node used for searching purpose
     */
    private void addNode(int data, Node1 compareNode) {
        if (this.ROOT == null) { // if the ROOT is null, the Tree is empty, so
            this.ROOT = new Node1(data, null, null); // create a new node with data and assign it to ROOT
        } else {
            if (compareNode == null) { // if the compareNode is null, set it to the ROOT
                compareNode = this.ROOT;
            }
            if (data < compareNode.data) { // if the data is smaller than the data of compareNode
                if (compareNode.leftChild != null) // see if compareNode has a leftChild, if so,
                    // recursive call using leftChild as the new compareNode
                    addNode(data, compareNode.leftChild);
                else // else, the leftChild is null (no leftChild),so add a new leftChild node containing data
                    compareNode.leftChild = new Node1(data, null, null);
            }

            if (data > compareNode.data) { // if the data is bigger than the data of compareNode
                if (compareNode.rightChild != null) // see if compareNode has a rightChild, if so,
                    // recursive call using rightChild as the new compareNode
                    addNode(data, compareNode.rightChild);
                else // else, the rightChild is null (no rightChild),so add a new rightChild node containing data
                    compareNode.rightChild = new Node1(data, null, null);
            }

        }
    }

}
