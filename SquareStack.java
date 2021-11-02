import java.util.EmptyStackException;
import java.util.*;
public class SquareStack {
	 Square[] stack;
	    int size;
	   
	    public SquareStack()
	    {
	        size=0;
	        stack = new Square[1];  
	    }
	    public SquareStack(int initCap)
	    {
	        this();
	        stack = new Square[initCap];
	    }
	    public boolean isEmpty()
	    {
	        if(size == 0)
	        {
	            return true;
	        }
	        return false;
	    }
	    public Square peek()
	    {
	        if(size == 0)
	        {
	           throw new EmptyStackException();
	        }
	        return stack[size-1];
	    }
	    public Square pop()
	    {
	        if(size == 0)
	        {
	           throw new EmptyStackException();
	        }
	       
	        Square j = stack[size-1];
	        size--;
	        Square[] x = new Square[size];
	        for(int i = 0;i < size;i++)
	        {
	            x[i] = stack[i];
	        }        
	        stack = x;
	       
	        return j;
	       
	    }
	    public void push(Square item)
	    {      
	        if (stack.length == size)
	        {
	            doubleCapacity();
	        }
	       
	        Square[] h = new Square[size + 1];
	        if (size > 0) {
	            for(int i = 0;i <= size;i++)
	            {
	                h[i] = stack[i];
	            }
	        }
	        h[size] = item;
	        stack = h;
	        size++;
	    }
	    private void doubleCapacity()
	    {
	        Square[] p = new Square[size * 2];
	        for(int i = 0;i < size;i++)
	        {
	            p[i] = stack[i];
	        }
	        stack = p;
	       
	    }
	    public String toString()
	    {
	        String a = "";
	        for(int i = size-1;i >=0;i--)
	        {
	            if(i == size - 1)
	            {
	                a = a + stack[i] + "        <----------  TOP";
	            }
	            else
	            {
	                a = a + "\n" + stack[i];
	            }
	           
	        }
	        a = a +  "\n--------";
	       
	        return a;
	    }
	   

}
