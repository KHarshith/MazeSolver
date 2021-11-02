
import java.util.*;
public class Square {
	
	public static final int  FREE_PASS = 0;
	public static final int BLOCK = 1;
	public static final int START = 2;
	public static final int FINISH = 3;
    public static final String UNEXPLORED = "";
    public static final String TO_BE_EXPLORED = "O";
    public static final String EXPLORED = ".";
	private int row;
	private int col;
	private int type;
	private String status;
	
	public Square(int row, int col, int type)
	{
		this.row = row;
		this.col = col;
		this.type = type;
		this.status = UNEXPLORED;
	}
	public String toString()
	{
		if( type == FREE_PASS)
		{
			if (status.equals(""))
				return "_ ";
			return status + " ";
		}
		else if(type == BLOCK)
		{
			return "# ";
		}
		else if (type == START)
		{
			return "S ";
		
		}
		else if (type == FINISH)
		{
			return "E ";
		}
		return "e";
	}
	
	public int getRow()
	{
		return row;
		
	}
	public int getCol()
	{
		return col;
	}
	public int getType()
	{
		return type;
	}
    public String getStatus()
    {
    	return status;
    }
    public boolean equals(Object obj)
    {
    	return true;
    }
    public void setStatus(String status)
    {
    	this.status = status;
    }
}
