
/**
 * The MyQueue class uses the SinglyLinkedList class to provide
 * its underline structure
 **/

public class MyQueue<T extends Comparable<T>>{
    // MyQueue is a SinglyLinkedList with limited functionality
    SinglyLinkedList<T> queueList;

    // Constructor
    public MyQueue(SinglyLinkedList<T> queueList) {
        this.queueList = queueList;
    }

    // push method takes in generic data and creates new node from it. Using the SinglyLinkedList
    // getHead() to set the new node to the head of the existing queueList. Then using the SinglyLinkedList
    // setHead to assign the new node as the Head officially.
    public void push(T v){
        Node<T> newHead = new Node<>(v);

        newHead.nextCell = queueList.getHead();
        queueList.setHead(newHead);
    }

    // using the SinglyLinkedList popFront() method to pop from the queueList.
    public void pop(){
        queueList.popFront();
    }

    // using the SinglyLinkedList isEmpty() method to check if the queueList is empty
    public boolean isEmpty(){
        return queueList.isEmpty();
    }

    // using the SinglyLinkedList size() method to return the size of the queueList
    public int qSize(){

        return queueList.size();
    }

    // using the SinglyLinkedList getHead().data to return the queueList front data
    public T front(){
        return queueList.getHead().cell;
    }
}
