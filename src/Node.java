import jdk.incubator.foreign.MappedMemorySegments;

class Node<MazeCell>  {
   MazeCell cell;
   Node<MazeCell> nextCell;

    // Constructor
    public Node(MazeCell cell){
        this.cell = cell;
    }

    public Node(){
        MazeCell cell;
        Node<MazeCell> nextCell;
    }
}