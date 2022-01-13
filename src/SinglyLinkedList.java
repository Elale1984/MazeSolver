public class SinglyLinkedList<T extends Comparable<T>> {

    // Getters and setters
    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    private Node<T> head;
    private Node<T> tail;

    //Default Constructor
    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    //Parameterized Constructor with just head
    public SinglyLinkedList(Node<T> head) {
        this.head = head;
        assignTail();
    }

    // Copy Constructor with deep copy
    public SinglyLinkedList(SinglyLinkedList<T> list) {

        Node<T> referenceNode = list.head;
        Node<T> copyNode = null;

        while (referenceNode != null) {

            if (this.head == null) {
                copyNode = new Node<>(referenceNode.data);
                this.head = copyNode;
            } else {
                copyNode.nextNode = new Node<>(referenceNode.data);
                copyNode = copyNode.nextNode;

            }
            this.setTail(referenceNode);
            referenceNode = referenceNode.nextNode;

        }
        assignTail();


    }

    //Insert method
    public void insertNode(T data) {

        Node<T> newNode = new Node<>(data);
        if (head == null || newNode.data.compareTo(head.data) <= 0) {

            newNode.nextNode = head;
            this.head = newNode;
            this.tail = newNode;

        } else {
            Node<T> currentNode = head;
            Node<T> tempNode = currentNode;


            while (currentNode != null && currentNode.data.compareTo(newNode.data) < 0) {
                tempNode = currentNode;
                currentNode = currentNode.nextNode;

            }


            newNode.nextNode = currentNode;
            tempNode.nextNode = newNode;

        }
        assignTail();

    }

    // Get the Front Node
    public Node<T> getFront() {

        return this.head;
    }

    // Get the Back Node
    public Node<T> getBack() {

        Node<T> currentNode = head;

        if (currentNode == null) {
            return null;
        } else {
            Node<T> rearNode = currentNode;
            while (currentNode != null) {
                rearNode = currentNode;
                currentNode = currentNode.nextNode;
            }
            return rearNode;
        }
    }

    // Remove node from the front of the list
    public void popFront() {
        this.head = head.nextNode;
    }

    // Remove Node from the back of the list
    public void popBack() {
        Node<T> tempNode = this.head;
        while (tempNode != null) {
            if (tempNode.nextNode == getTail())
                tempNode.nextNode = null;
            else
                tempNode = tempNode.nextNode;

        }
    }

    // Get the size of the linked list
    public int size() {
        int size = 0;
        Node<T> currentNode = head;
        if (currentNode == null) {
            return size;
        } else {
            while (currentNode != null) {
                size++;
                currentNode = currentNode.nextNode;
            }
        }
        return size;
    }

    // Method returns true if singlyLinkedList is empty and false if it is not empty
    public boolean isEmpty() {
        return head == null;
    }

    // Reverse the singlyLinkedList
    public Node<T> reverse() {
        Node<T> previousNode = null;
        Node<T> tempHead = this.head;
        setTail(this.head);
        while (tempHead != null) {
            Node<T> nextNode = tempHead.nextNode;
            tempHead.nextNode = previousNode;
            previousNode = tempHead;
            tempHead = nextNode;
        }
        setHead(previousNode);
        return previousNode;
    }

    // This method will merge two lists in order
    public void mergeLists(SinglyLinkedList<T> secondList) {
        Node<T> tempHead1 = this.head;
        Node<T> tempHead2 = secondList.head;

        if (tempHead1 == null) {
            return;
        }
        if (tempHead2 == null) {
            return;
        }
        Node<T> result = new Node<>(null);
        Node<T> prev = result;
        while (tempHead1 != null && tempHead2 != null) {
            if (tempHead1.data.compareTo(tempHead2.data) <= 0) {
                prev.nextNode = tempHead1;
                tempHead1 = tempHead1.nextNode;
            } else {
                prev.nextNode = tempHead2;
                tempHead2 = tempHead2.nextNode;
            }
            prev = prev.nextNode;
        }
        if (tempHead1 != null) {
            prev.nextNode = tempHead1;
        }
        if (tempHead2 != null) {
            prev.nextNode = tempHead2;
        }
        this.head = result.nextNode;
    }


    // This utility method will reassign the tail when called
    private void assignTail() {

        if (this.head == null) {
            this.setTail(null);
        } else {
            Node<T> temp = this.head;
            while (temp != null) {
                this.setTail(temp);
                temp = temp.nextNode;
            }
        }
    }


}
