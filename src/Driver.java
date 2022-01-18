import javax.crypto.Mac;
import javax.xml.crypto.dsig.spec.XPathFilterParameterSpec;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;


//starter code for MazeSolver
//CST-201

public class Driver {

    public static MazeCell[][] cells;
    public static int [][] grid;
    public static int rows;
    public static int cols;
    public static MyStack<MazeCell> path = new MyStack<>();
    /**
     *
     * @param start
     * @param end
     * find a path through the maze
     * if found, output the path from start to end
     * if not path exists, output a message stating so
     *
     */
    // implement this method
    public static void depthFirst(MazeCell start, MazeCell end) {

        int r = start.getRow();
        int c = start.getCol();

        path.push(start);

        while (path.head.cell != end){

            if(grid[r][c + 1] == 1 && isValidCell(r,c + 1)){
                c = c + 1;
                path.push(new MazeCell(r,c));
            }
            else if (grid[r + 1][c] == 1 && isValidCell(r + 1,c)){
                r = r + 1;
                path.push(new MazeCell(r,c));
            }
            else if (grid[r][c - 1] == 1 && isValidCell(r,c - 1)){
                c = c - 1;
                path.push(new MazeCell(r,c));
            }
            else if (grid[r - 1][c] == 1 && isValidCell(r - 1,c)){
                r = r - 1;
                path.push(new MazeCell(r,c));
            }
            else {

                System.out.println(path);
            }
        }
    }

    public static boolean isValidCell(int r, int c) {
       if (r >= 0 && r < rows && c >= 0 && c < cols)
           return true;
       else
           return false;
    }

    public static void main(String[] args) throws FileNotFoundException {

        //create the Maze from the file
        Scanner fin = new Scanner(new File("Maze.in"));
        //read in the rows and cols
        rows = fin.nextInt();
        cols = fin.nextInt();

        //create the maze
        grid = new int[rows][cols];

        //read in the data from the file to populate
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = fin.nextInt();
            }
        }

        //look at it
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 3)
                    System.out.print("S ");
                else if (grid[i][j] == 4)
                    System.out.print("E ");
                else
                    System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

        //make a 2-d array of cells
        cells  = new MazeCell[rows][cols];

        //populate with MazeCell obj - default obj for walls

        MazeCell start = new MazeCell(), end = new MazeCell();

        //iterate over the grid, make cells and set coordinates
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //make a new cell
                cells[i][j] = new MazeCell();
                //if it isn't a wall, set the coordinates
                if (grid[i][j] != 0) {
                    cells[i][j].setCoordinates(i, j);
                    //look for the start and end cells
                    if (grid[i][j] == 3)
                        start = cells[i][j];
                    if (grid[i][j] == 4)
                        end = cells[i][j];

                }

            }
        }

        //testing
        System.out.println("start:"+start+" end:"+end);

        //solve it!
        depthFirst(start, end);

    }
}

