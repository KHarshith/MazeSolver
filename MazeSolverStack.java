import java.util.*;
public class MazeSolverStack extends MazeSolver{
	SquareStack stack ;

	public MazeSolverStack(Maze maze)
	{
		
		super(maze);
		stack = new SquareStack();
	
	}
	
	
	@Override
	public void makeEmpty() {
		stack = new SquareStack();
	}
	@Override
	public boolean isEmpty()
	{
	  return stack.isEmpty();	
	}
	
	@Override
	public void add(Square s)
	{
		stack.push(s);
	}
	
	@Override
	public Square next()
	{
		
		return stack.pop();
	}
}
