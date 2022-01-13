public class MyStack<T extends Comparable<T>> {

    SinglyLinkedList<T> stackList;

    public MyStack(SinglyLinkedList<T> stackList) {
        this.stackList = stackList;
    }

    // push method takes in generic data and creates new node from it. Using the SinglyLinkedList
    // getHead() to set the new node to the head of the existing stackList. Then using the SinglyLinkedList
    // setHead to assign the new node as the Head officially.
    public void push(T v){
        Node<T> newHead = new Node<>(v);

        newHead.nextNode = stackList.getHead();
        stackList.setHead(newHead);
    }

    // using the SinglyLinkedList size() method to return the size of the stackList
    public int stackSize(){

        return stackList.size();
    }

    // using the SinglyLinkedList isEmpty() method to check if the stackList is empty
    public boolean isEmpty(){
        return stackList.isEmpty();
    }

    // Returns the data at the top of the stack
    public T top() {
        return stackList.getHead().data;
    }


    // using the SinglyLinkedList popFront() method to pop from the stackList.
    public void pop(){
        stackList.popFront();
    }



}
