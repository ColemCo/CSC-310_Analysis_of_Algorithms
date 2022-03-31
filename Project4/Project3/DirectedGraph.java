
//Cooper Coleman
//Analysis of Algorithms
//4/15/20
//Project 3 

import java.util.LinkedList;
public class DirectedGraph 
{
	int vertex;
	int location;	
	LinkedList<Integer> points[];
	
	public DirectedGraph(int vertex)
	{
		this.vertex = vertex;
		points = new LinkedList[vertex];
	    location = 0;
	    
	    for (int i = 0; i < vertex ; i++) 
	    {
	    	points[i] = new LinkedList<>();
	    }
	}   
	     
	public void addPoint(int first, int second)
	{
		points[first].addFirst(second);	//adds one way edge
		points[second].addFirst(first);	//adds reverse of edge
	}
	
	public void printGraph()
	{
		for(int i = 0; i < vertex; i++)	//outer for loop to loop through every vertex
		{
			System.out.print(i + ": ");
			
			for(int n = 0; n < points[i].size(); n++)	//inner for loop to loop through the edges of vertex
			{
				System.out.print(points[i].get(n) + " " );
			}
			
			System.out.println();
		}
	}
	
	public void printVertexList()	//similar to graph print, but only loops throught the base vertex and not all
	{
		System.out.print("Currently at vertex " + location + ". Adjacent vertices: ");
		for(int i = 0; i < points[location].size(); i++)
		{
			System.out.print(points[location].get(i) + " ");
		}
		System.out.println();
	}
	
	public void movePoints(int destination)
	{
		
		Boolean valid = false;
		for(int i = 0; i < points[location].size(); i++)	//adjacency check
		{
			if(destination == points[location].get(i))	//compares vertices touching current vertex to proposed destination
			{
				valid = true;	//if vertices are touched then move is valid.
				break;	//once it is true then the move is valid.
			}
		}
		
		if(valid)	//if adjacent then valid move
		{
			location = destination;
		}
		
		else	//not valid move
		{
			System.out.println("The vertices must be connected in order to move there. Move not completed.");
		}
		
	}
	
	public void setLocation(int loc)	//uses to set initial location rather than using movePoints because of adjaceny check
	{
		location = loc;
	}
	

}
