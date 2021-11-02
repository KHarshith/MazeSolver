
import java.util.*;
import java.io.*;

public class Maze {
	private Square[][] mazeCells ;
	private int rows ;
	private int cols;
	public Maze()
	{
		
	}
    public boolean loadMaze(String fileName)
    {
    	try
    	{
    		FileReader reader = new FileReader(fileName);
    		BufferedReader reader2 = new BufferedReader(reader);
    		String firstLine;
    		firstLine = reader2.readLine();
    		System.out.println(firstLine);
    		String[] data = firstLine.split(" ");
    		rows = Integer.parseInt(data[0]);
    		cols = Integer.parseInt(data[1]);
    		mazeCells = new Square[rows][cols];
    		
    		String mazeLine;
    		mazeLine = reader2.readLine();
    		int currentRowNumber = 0;
    		
    		
    		while (mazeLine != null) {
	    		data = mazeLine.split( " ");
	    		for(int i = 0; i < cols; i++)
	    		{
	    			int cellType = Integer.parseInt(data[i]);
	    			Square square = new Square(currentRowNumber, i, cellType);
	    			mazeCells[currentRowNumber][i] = square;
	    			
	    		}
	    		mazeLine = reader2.readLine();
	    		currentRowNumber++;
    		}
    		
    	}
    	catch (Exception ex)
    	{
    		System.err.println("File not found");
    		ex.printStackTrace();
    		return false;
    	}
    	
    	return true;
    }
    
    public Square getStartSquare () {
    	for(int row = 0; row < rows; row++)
    	{
    		for(int col = 0; col < cols; col++)
    		{
    			 if(mazeCells[row][col].getType() == Square.START)
    			 {
    				 return mazeCells[row][col];
    			 }
    		}
    		
    	}
    	return null;
    }
    
    List<Square> getNeighbours(Square s)
    {
    	int currentRow = s.getRow();
    	int currentCol = s.getCol();
    	ArrayList<Square> neighbours = new ArrayList<Square>();
    	
    	//Check if there is a previous cell
    	if (currentCol != 0)
    	{
    		Square previousSquare = mazeCells[currentRow][currentCol-1];
    		neighbours.add(previousSquare);
    		
    	}
    	if(currentCol != cols - 1)
    	{
    	    Square nextSquare = mazeCells[currentRow][currentCol+1];
    	    neighbours.add(nextSquare);
    	}
    	if (currentRow != 0)
    	{
    		Square aboveSquare = mazeCells[currentRow-1][currentCol];
    		neighbours.add(aboveSquare);
    	}
    	if(currentRow != rows - 1)
    	{
    		Square belowSquare = mazeCells[currentRow + 1][currentCol];
    		neighbours.add(belowSquare);
    	}
    	return neighbours;
    	
    }
    
    public void reset()
    {
    	System.out.println("Maze class reset() called");
    	for(int i = 0; i < rows; i++)
    	{
    		for(int j = 0; j < cols; j++)
    		{
    			mazeCells[i][j].setStatus(Square.UNEXPLORED);
    		}
    	}
    }
    
    public String toString()
    {
    	String mazeStr = "" ;
    	for(int row = 0; row < rows; row++)
    	{
    		for(int col = 0; col < cols; col++)
    		{
    			mazeStr = mazeStr + mazeCells[row][col].toString() ;
    		}
    		mazeStr = mazeStr + "\n";
    	}
    	return mazeStr;
    }
}
