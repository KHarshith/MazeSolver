import java.util.*;

public abstract class MazeSolver {
	private Maze maze;
	private boolean mazeSolved = false;
	
	public MazeSolver(Maze maze) {
		this.maze = maze;
		
	}

	public abstract void makeEmpty();

	public abstract boolean isEmpty();

	public abstract void add(Square s);

	public abstract Square next();

	public boolean isSolved() {
		System.out.println("isSolved - " + mazeSolved);
		return mazeSolved;
	}

	/*
	 * This method  is called for moving by one cell
	 */
	public void step() {
		System.out.println("step() called");
		
		//First tiem when called it starts at square marked as start square
		if (isEmpty())
		{
			
			Square startSquare = maze.getStartSquare();
			if (startSquare != null)
				add(startSquare);
		}
		
		if (isEmpty())
			return;
		
		Square nextSquare = next();
		if(nextSquare.getType() == Square.FINISH)
		{
			mazeSolved = true;
			return;//Maze is Solved
		}
		
		List <Square> neighbours = maze.getNeighbours(nextSquare);
		for(int i = 0; i<neighbours.size();i++)
		{
			Square neighbour = neighbours.get(i);
			if(neighbour.getType() != Square.BLOCK && !neighbour.getStatus().equals(Square.EXPLORED))
			 {
				neighbour.setStatus(Square.TO_BE_EXPLORED);
				add(neighbour);
			 }
			
		}
		nextSquare.setStatus(Square.EXPLORED);
	}

	public String getPath() {
		return "";
	}

	public void solve() {
		System.out.println("solve() called");
	}

}
