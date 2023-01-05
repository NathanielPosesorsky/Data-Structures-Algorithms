/*
Student Name: Nathaniel Posesorsky
Student ID:260803332
 */
package CCCS315.CCCS315_Assignment;

public class MyLinkedList{
    private Node1 HEAD; // declares HEAD using data type Node1 with value null (no attributes)

    private class Node1 { // node object model
        public int data; // data variable = data - T(n) = 1
        public Node1 next; // pointer = next

        public Node1() {
        } // empty constructor to add a Node1 with both values null

        public Node1(int data, Node1 next) { //creates a node with given input
            this.data = data;
            this.next = next;
        }
    }

    // adds a node to the head
    public void add(int data) { // creates a new node containing passed data at the HEAD (adds to the head)
        if (this.HEAD == null) // if the HEAD is null,
            this.HEAD = new Node1(data, null); // create a new node with data and assign it to HEAD
        else // if the HEAD is not null
            // creates a new node and assigns Head to it.
            // This new node has passed data and the pointer is equal to the current head
            this.HEAD = new Node1(data, this.HEAD);
    }

    // removes a node
    public void remove(int data) {
        Node1 current = this.HEAD; // current is HEAD
        if (this.HEAD == null) {
        } else if (this.HEAD.data == data)  // if the data at head is equal to the passed data
            this.HEAD = this.HEAD.next; // remove the node by changing HEAD to the next node
        else { // if the passed data is not equal to the one at HEAD
            // as long as the data is not equal as well to the data of the next node
            while (current.next != null && data != current.next.data) {
                current = current.next; // increase current and the while loop repeats
            } // once the data is equal to the data of the next node
            if (current.next != null)
                current.next = current.next.next; // remove the next node by replacing it by the one that comes after it
        }
    }

    // provides the size
    public int size() {
        int counter = 1; // sets counter to 1
        Node1 current = this.HEAD; // current is HEAD
        if(this.HEAD == null) // if the HEAD is null, return size 0
            return 0;
        while (current.next != null) { // as long as the next node contains data
            current = current.next; // traverse to the next node
            counter++; // increase counter to keep track of the size
        }
        return counter; // return counter for the size
    }

    // checks if the Linked List contains a value
    public boolean contain(int data){
        Node1 current = this.HEAD;// current is HEAD
        if(this.HEAD.data == data) return true; // returns true if the first value of the linked list matches
        while (current.next != null) { // as long as the next node contains data
            if(current.data == data) return true; // checks if the current node matches data, if so, return true
            current = current.next; //if not, current goes to the next node
        }
        return false; // if no match is found, return false
    }

    // Returns the linked list as a string
    public String toString(){
        String str = "[ "; // defines string str with opening bracket
        Node1 current = this.HEAD; // current is HEAD
        while (current.next != null) { // as long as the next node contains data
            str += current.data+" -> "; // converts to string the data and adds it to str
            current = current.next; // current goes to the next node and repeats
        }
        str+= current.data + " ]\n"; // once current.next = null, adds current data and closing bracket
        return str; // returns the string
    }

    //Compares two linked lists to see if they are the same
    public boolean compare(MyLinkedList list){
        Node1 current = this.HEAD;  // current is HEAD
        Node1 current2 = list.HEAD;  // current2 is HEAD of list
        if(this.size() != list.size()) return false; // returns false if the lists are not of the same size
        while(current.next != null){ // until it reaches the tail,
            // verifies that the data of the node for the first list is the same as the one for the second
            if(current.data != current2.data)
                return false; // if not, return false
            current = current.next; // goes to the next node
            current2 = current2.next; // goes to the next node
        }
        // if the data at both of the last nodes of both lists is the same, return true
        if(current.data == current2.data) return true;
        return false;// if not, return false
    }

    public static void main(String[] args) {
        MyLinkedList list1 = new MyLinkedList();
        MyLinkedList list2 = new MyLinkedList();
        MyLinkedList list3 = new MyLinkedList();

        list1.add(1); // adds 1 to list1
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        list1.add(7);
        list1.add(8);
        list1.add(9);

        list2.add(1);// adds 1 to list2
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(6);
        list2.add(7);


        list1.remove(9); // removes 9 from list1
        list2.add(8); // adds 8 to list2

        System.out.println(list1.size()); // prints list1 size = 8
        System.out.println(list3.size()); // prints list3 size (empty so 0)

        System.out.println(list1.contain(7)); // checks if list1 contains 7 and prints true
        System.out.println(list1.contain(11)); // Since list1 does not contain 11, prints false

        System.out.println(list1.toString()); // prints list1 to string
        // gives [ 8 -> 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 ]

        System.out.println(list1.compare(list2)); // compares list1 and list2. Since they are the same, gives true
    }
}
