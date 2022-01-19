/**
 * Node Class
 * @param <MazeCell>
 *     This is an implementation of a node that is of type MazeCell.
 *     It is used as a node for the implementation of the MyStack
 *     MyQueue classes.
 * @author Edward Lale
 *     All work was completed by Edward Lale
 */
class Node<MazeCell>  {
   final MazeCell cell;
   Node<MazeCell> nextCell;

    // Constructor
    public Node(MazeCell cell){
        this.cell = cell;
    }

}