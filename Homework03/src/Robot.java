//Written by Mia Dia
public class Robot {
	
// Variables / / / / / / / / / / / / / / / / / / / / / / / / / / / 
	private String[] board; 
	private int row;
	private int col;
	private robQueue<String> commands;
	//private String currentCommand;
	
// Constructor / / / / / / / / / / / / / / / / / / / / / / / / / /
	public Robot(String[] b, String[] c)
	{
		this.commands = new robQueue<String>();
		this.row = 0; // row 
		this.col = 0; // column/substring at
		
		this.board = b;

		createCommands(c);
		setLocOnBoard();
	}

// Methods / / / / / / / / / / / / / / / / / / / / / / / / / / / /
	public boolean move()
	{
		boolean crash = false;
		String dir = this.commands.dequeue();
		if(dir.equals("Move Right"))
		{
			this.col++;
		}
		if(dir.equals("Move Left"))
		{
			this.col--;
		}
		if(dir.equals("Move Down"))
		{
			this.row++;
		}
		if(dir.equals("Move Up"))
		{
			this.row--;
		}
		
		crash = checkCrash();
		setLocOnBoard();
		
		return crash;// if did not crash
	}
	
	public void setLocOnBoard()
	{
		resetBoard();
		String ROW = this.board[this.row];
		
		String one =  ROW.substring(0,this.col);
		String two ="O" + ROW.substring(this.col+1);
		
		this.board[this.row]=(one+two);
		
	
	}
	public void resetBoard()
	{
		for(int i=0; i<10;i++)
		{
			if(this.board[i].indexOf("O") != -1)
			{
				String ROW = this.board[i];
				
				String one =  ROW.substring(0,this.board[i].indexOf("O"));
				String two ="_" + ROW.substring(this.board[i].indexOf("O")+1);
				this.board[i]=(one+two);
				
			}
		}
	}
	
	public void createCommands(String[] c)
	{
		for(int i=0; i<c.length;i++)
		{
			this.commands.enqueue(c[i]);
		}
	}
	
	public void printBoard()
	{
		for(int i=0; i<this.board.length; i++)
		{
			System.out.println(this.board[i]);
		}
	}
	
	public boolean checkCrash()
	{
		String point =this.board[this.row].substring(this.col,this.col+1);
		if(point.equals("X"))
		{
			return true;
		}
		return false;
	}
}
