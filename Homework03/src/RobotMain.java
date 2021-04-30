//Written by Mia Dia
import java.io.File;
import java.io.IOException;
import java.util.*;
public class RobotMain {

	public static void main(String[] args) 
	{
		Scanner input = new Scanner (System.in);
		String[] board = null;
		String[] commands = null;
		
		boolean inSim = true;
		
		p("Welcome to the Robot Simulator!");
		while(inSim)
		{
			p("Enter a file for the board");
			board = readFile(input.nextLine());
			p("Enter a file for the Robot Commands");
			commands = readFile(input.nextLine());
			
			Robot Sim = new Robot(board,commands);
			Sim.printBoard();
			p("");
			p("Simulation begin");
			
			for(int i=0; i<commands.length; i++)
			{
				p("\nCommand "+i);
				if(Sim.move())//if it crashed
				{
					i = commands.length+5;
					p("*CRASH*\nAw Jeepers Creepers, looks like it crashed.");
				}
				else
				{
					Sim.printBoard();
				}
			}
			
			//After
			p("\nSimulation End\n\nWould you like to try another simulation? Enter \"yes\" to continue.");
			if(!input.nextLine().equalsIgnoreCase("yes"))
			{
				inSim = false;
			}
		}
		
		p("Goodbye!");
	}
// methods / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / /
	//print method bcs I lazy
	public static void p(String words)
	{
		System.out.println(words);
	}
	
	//reads file and makes a list
		public static String[] readFile(String fileName)
		{
			try
			{
				
				Scanner fileScanner = new Scanner(new File(fileName));
				int lineCount = 0;
				while(fileScanner.hasNextLine())
				{
					fileScanner.nextLine();
					lineCount++;
				}
				
				if(lineCount <= 0) {
					return null;
				}
				
				
				//Creates the return array, resets the file scanner, and populates the array
				String[] strArr = new String[lineCount];
				Scanner scan = new Scanner(new File(fileName));
				int count = 0;
				while(scan.hasNextLine())
				{
					if(!scan.hasNextLine())
						{break;}
					
					strArr[count] = scan.nextLine();
					count++;
					}
				
					return strArr;
				}
				
			
			catch(IOException e)
			{
				System.out.println(e);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			return null;
		}

}
