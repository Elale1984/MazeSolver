/**
 * MyStack Class
 * @param <MazeCell>
 *
 *     This is an implementation of a stack that is of type MazeCell. It has basic methods for the use of
 *     a stack implementation for a maze.
 * @author Edward Lale
 *      All work was completed by Edward Lale
 */

public class MyStack<MazeCell> {

    Node<MazeCell> head;
    int stackSize = 0;

    public MyStack() {

    }

    // push method takes in generic data and creates new node from it. Using the SinglyLinkedList
    // getHead() to set the new node to the head of the existing stackList. Then using the SinglyLinkedList
    // setHead to assign the new node as the Head officially.
    public void push(MazeCell cell) {
        Node<MazeCell> newCell = new Node<>(cell);
        Node<MazeCell> prevHead = this.head;
        this.head = newCell;
        newCell.nextCell = prevHead;
        stackSize++;

    }
    // using the SinglyLinkedList isEmpty() method to check if the stackList is empty
    public boolean isEmpty(){
        return this.head == null;
    }


    // using the SinglyLinkedList popFront() method to pop from the stackList.
    public void pop(){
        Node<MazeCell> newHead = this.head.nextCell;
        this.head.nextCell = null;
        this.head = newHead;
    }

    @Override
    public String toString() {

        System.out.println("\nMaze Solved!! \n");
        Node<MazeCell> currentNode = this.head;
        StringBuilder list = new StringBuilder();
        list.append("Path:\nEnd <- ").append(currentNode.cell.toString());
        currentNode = currentNode.nextCell;
        while (currentNode != null){
            list.append(" <- ").append(currentNode.cell.toString());
            currentNode = currentNode.nextCell;
        }
        list.append(" <- Start");
        return list.toString();
    }
}
