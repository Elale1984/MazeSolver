
/**
 * The MyQueue class uses the SinglyLinkedList class to provide
 * its underline structure
 **/

public class MyQueue<MazeCell>{

    Node<MazeCell> headCell;
    Node<MazeCell> tailCell;
    int queueSize;

    // Constructor
    public MyQueue(){
        headCell = null;
        tailCell = null;
        queueSize = 0;
    }
    // push method takes in generic data and creates new node from it. Using the SinglyLinkedList
    // getHead() to set the new node to the head of the existing queueList. Then using the SinglyLinkedList
    // setHead to assign the new node as the Head officially.
    public void push(MazeCell cell){
        this.tailCell.nextCell = new Node<>(cell);
    }

    // using the SinglyLinkedList popFront() method to pop from the queueList.
    public void pop(){
        headCell.nextCell = null;
    }

    // using the SinglyLinkedList isEmpty() method to check if the queu
    // eList is empty
    public boolean isEmpty(){
        return queueSize == 0;
    }

    // using the SinglyLinkedList size() method to return the size of the queueList
    public int qSize(){

        return queueSize;
    }


}
