
//Cooper Coleman
//Analysis of Algorithms
//4/15/20
//Project 3 

import java.io.File;
import java.util.Scanner;
public class DirectedGraphApp 
{
		public static void main(String args[]) throws Exception
		{
			
			File input = new File("13vertices.txt");	
			Scanner infile = new Scanner(input);	//sets the scanner for the file 
			
			DirectedGraph list = new DirectedGraph(infile.nextInt());
			int first = 0;
			int second = 0;
			while(infile.hasNextInt())
			{
				first = infile.nextInt();	//sends the first int as the base
				second = infile.nextInt();	//sends the second int as the attached vertex
				list.addPoint(first, second);
			}
			infile.close();	//closes scanner for file input
			
			Scanner keyboard = new Scanner(System.in);
			System.out.println("Please enter in a vertex to start at: ");
			list.setLocation(keyboard.nextInt());
			
			String response;
			
			list.printVertexList();
			System.out.println("What would you like to do? (M)ove (P)rint Graph (Q)uit?: ");
			response = keyboard.next();

			do	//loops till user inputs Q
			{
				
				if(response.contentEquals("P"))
				{
					list.printGraph();	//prints graph
				}
				
				else if(response.contentEquals("M"))
				{
					System.out.println("Please enter the vertex you wish to move to: ");
					list.movePoints(keyboard.nextInt());	//passes the new vertex to move to 
				}
				
				list.printVertexList();
				System.out.println("What would you like to do? (M)ove (P)rint Graph (Q)uit?: ");
				response = keyboard.next();
				
				
			} while(!response.contentEquals("Q"));
			keyboard.close();
			
		}
	
}
