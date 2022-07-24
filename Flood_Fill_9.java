//Grind 75 problem # 9
//Flood fill problem.  Converts nearby cells to the desired color if applicable

import java.util.*;

class Flood_Fill_9{

	private class cell{
		public int val;
		public boolean visited;
		public boolean mark;
		
		public cell(int val){
			this.val = val;
			this.visited = false;
			this.mark = false;
		}
	}

	cell[][] board;
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		Flood_Fill_9 ff = new Flood_Fill_9();
		System.out.print("Enter rows > ");
		int rows = in.nextInt();
		System.out.print("Enter cols > ");
		int cols = in.nextInt();		
		ff.makeBoard(in, rows, cols);
		ff.printBoard(rows, cols);
		System.out.print("Enter begining row > ");
		int sr = in.nextInt();
		System.out.print("Enter begining col > ");
		int sc = in.nextInt();
		System.out.print("Enter the color > ");
		int color = in.nextInt();
		//ff.preFlood(sr, sc, color);
		ff.floodFill(sr, sc, color, rows, cols);
		ff.solve(rows, cols, color);
		ff.printBoard(rows, cols);
	}
	
	private void preFlood(int sr, int sc, int color){
		board[sr][sc].val = color;
	}
	
	private void solve(int rows, int cols, int color){
		for(int i=0; i<rows; i++){
			for(int j=0; j<cols; j++){
				if(board[i][j].visited == true){
					board[i][j].val = color;
				}
			}
		}
	}
	
	private void floodFill(int sr, int sc, int color, int rows, int cols){
		if(sr+1 < rows){
			if(board[sr][sc].val == board[sr+1][sc].val && board[sr+1][sc].visited == false){
				board[sr+1][sc].visited = true;
				floodFill(sr+1, sc, color, rows, cols);
			}
		}
		if(sr-1 >= 0){
			if(board[sr][sc].val == board[sr-1][sc].val && board[sr-1][sc].visited == false){
				board[sr-1][sc].visited = true;
				floodFill(sr-1, sc, color, rows, cols);
			}
		}
		if(sc+1 < cols){
			if(board[sr][sc].val == board[sr][sc+1].val && board[sr][sc+1].visited == false){
				board[sr][sc+1].visited = true;
				floodFill(sr, sc+1, color, rows, cols);
			}
		}
		if(sc-1 >= 0){
			if(board[sr][sc].val == board[sr][sc-1].val && board[sr][sc-1].visited == false){
				board[sr][sc-1].visited = true;
				floodFill(sr, sc-1, color, rows, cols);
			}
		}
	}	
	
	private void makeBoard(Scanner in, int rows, int cols){
		board = new cell[rows][cols];
		for(int i=0; i<rows; i++){
			System.out.print("Enter row values x,y,z > ");
			String s = in.next();
			String[] sa = s.split(",");
			for(int j=0; j<sa.length; j++){
				board[i][j] = new cell(Integer.parseInt(sa[j]));
			}
		}
	}
	
	private void printBoard(int rows, int cols){
		for(int i=0; i<rows; i++){
			for(int j=0; j<cols; j++){
				System.out.print(board[i][j].val + " ");
			}
			System.out.println();
		}
	}
}
