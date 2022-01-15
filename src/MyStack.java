public class MyStack<MazeCell> {

    Node<MazeCell> head;
    Node<MazeCell> tail;
    int stackSize = 0;


    public MyStack() {
    }

    // push method takes in generic data and creates new node from it. Using the SinglyLinkedList
    // getHead() to set the new node to the head of the existing stackList. Then using the SinglyLinkedList
    // setHead to assign the new node as the Head officially.
    public void push(MazeCell cell){
        Node<MazeCell> newCell = new Node<>(cell);
        tail.nextCell = newCell;
        stackSize++;
    }


    // using the SinglyLinkedList isEmpty() method to check if the stackList is empty
    public boolean isEmpty(){
        return stackSize == 0;
    }


    // using the SinglyLinkedList popFront() method to pop from the stackList.
    public void pop(){
        this.head.nextCell = null;
    }



}
