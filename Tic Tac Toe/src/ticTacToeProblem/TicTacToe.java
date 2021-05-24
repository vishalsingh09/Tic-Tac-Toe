package ticTacToeProblem;

public class TicTacToe {
	
	private String[][] board;
    private int turn;
    
    /**
     * Creates a new Tic Tac Toe board.  Instantiates the 3x3 board
     * with all dashes or other place holders.
     * 
     * initializes number of turns taken to equal 0
     */
    
    public TicTacToe() 
    {
    	board = new String[3][3];
    	for(int r=0; r < board.length;r++)
    	{
    		for(int c = 0; c < board[r].length; c++)
    		{
    			board[r][c] = "-";
    		}
    	}
    }
    
    
   
    /**
     * Getter method for current turn number
     * @return number of turns taken
     */
    
    public int getTurn() 
    {
    	return turn;
    }
    
    
    
   
   /**
    * This method prints out the board array on to the console
    */
    
   public void printBoard()
   {
	   System.out.println();
	   for(int r=0; r < board.length;r++)
	   {
		   for(int c = 0; c < board[r].length; c++)
		   {
			   System.out.print(board[r][c] + " ");
			   if(c != 2)
			   {
				   System.out.print("|");
			   }
			   
		   }
		   if(r == 0 || r == 1)
		   {
			   System.out.println();
			   System.out.print("______________");
		   }
		   System.out.println();
	   }
   }
   
   /**
    * 
    * This method determines if space row, col is an available space to choose
    * @return: true if the board[row][col] is available, false otherwise
    * 
    */
   
   public boolean pickLocation(int row, int col)
   {
	   if(row < 3 && col < 3)
       {
           if(board[row][col] != " -" || board[row][col] != "-" || board[row][col] != "- ")
           {
               return true;
           }
       }
       return false;
   }
   
   /**
    * 
    * This method places an X or O at board[row][col] based on the int turn
    */
   
   public void takeTurn(int row, int col)
   {
	   if(turn %2 == 0)
       {
           board[row][col] = "X";
       }
       else
       {
           board[row][col] = "O";
       }
       turn++;
   }
   
   /**
    * 
    * This method checks if any row has all X's or all Os
    * @return: true if there is a row with all the same value, false otherwise. 
    */
   
   
   public boolean checkRow()
   {
	   for(int r = 0; r < board.length;r++)
	   {
		   if(!board[r][0].equals("-"))
		   {
			   if(board[r][0].equals(board[r][1]) && board[r][1].equals(board[r][2]))
			   {
				   return true;
			   }
		   }		   
	   }
	   return false;
   }
   
   
   /**
    * 
    * This method checks if any col has all X's or all Os
    * @return: true if there is a col with all the same value, false otherwise. 
    */
   
   public boolean checkCol()
   {
       for (int c = 0; c < board.length; c++)
       {
           if (!board[c][0].equals("-"))
           {
                if (board[c][0].equals(board[c][1]) && board[c][1].equals(board[c][2]))
                {
                   return true;
                }
           }
       }
       return false;
   
   }
   
   
   /**
    * 
    * This method checks if either diagonal has all X's or all Os
    * @return: true if either diagonal with all the same value, false otherwise. 
    */
   
   public boolean checkDiag()
   {
	   if(!board[0][0].equals("-")) 
	   {
           if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]))
               return true; 
       }
       
       if(!board[0][2].equals("-")) 
       {
           if (board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]))
               return true; 
       }
       
       return false;
	
   }
   
   /**
    * 
    * This method checks if a player has won the game via a row, col, or diagonal
    * @return: true if the game is won, false otherwise
    */
   public boolean checkWin()
   {
	   return checkCol() || checkRow() || checkDiag();
   }

}
