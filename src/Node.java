class Node<MazeCell>  {
   MazeCell cell;
   Node<MazeCell> nextCell;

    // Constructor


    public Node(MazeCell cell) {
        this.cell = cell;
        this.nextCell = null;
    }

    public Node(){
        this.cell = null;
        this.nextCell = null;
    }
}