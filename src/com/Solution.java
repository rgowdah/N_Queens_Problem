package com;

public class Solution {
	final int n=4;
	public void printSolution(int[][] board){
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++)
				System.out.print(" " + board[i][j]+ " ");
			System.out.println();
		}
	}
	//function to check is it safe to place queen at row, col
	private boolean isSafe(int board[][], int row, int col) {
		//check this row on left side
		for (int i = 0; i < col; i++)
			if (board[row][i] == 1)
				return false;
		//check upper diagonal on left side
		for (int i = row,j=col; i>=0 && j>=0; i--,j--)
			if (board[i][j] == 1)
				return false;
		//check lower diagonal on left side
		for (int i =row,j=col; i < n && j>=0; i++,j--)	
			if (board[i][j] == 1)
				return false;
		return true;	
	}
	private boolean solveNQUtil(int[][] board, int col) {
		//If all queens are placed then return true
		if(col>=n)
			return true;
		for (int i = 0; i < n; i++) {
			if(isSafe(board, i, col)){
				board[i][col]=1;
				if (solveNQUtil(board, col+1)==true)
					return true;
				board[i][col]=0;
			}
		}
		return false;
	}

	private boolean solveNQueen() {
		int[][] board={{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		if(solveNQUtil(board, 0)==false){
			System.out.println("There is no solution to the problem");
			return false;
		}
		printSolution(board);
		return true;
	}	

	public static void main(String[] args) {
		Solution sol=new Solution();
		sol.solveNQueen();
	}
}
