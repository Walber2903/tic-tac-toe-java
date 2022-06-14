package br.com.estudosjava.tictactoe.core;

import br.com.estudosjava.tictactoe.Constants;
import br.com.estudosjava.tictactoe.ui.UI;

public class Board {

	private char [][] matrix;
	public Board() {
		matrix = new char[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
		clear();
	}
	
	public void clear() {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = ' ';
			}
		}
	}
	
	public void print() {

		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				UI.printTextWithoutNewLine(String.valueOf(matrix[i][j]));
				
				if(j < matrix.length -1) {
					UI.printTextWithoutNewLine("   | ");					
				}
			}
			UI.printNewLine();
			if(i < matrix.length -1) {
				UI.printText("=================");				
			}
		}
	}
	
	public boolean isFull() {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j] == ' ') {
					return false;
				};
			}
		}
		return true;
	}
	
	public boolean play(Player player, Move move) {
		int i = move.getI();
		int j = move.getJ();
		
		matrix[i][j] = player.getSymbol();
		
		// TODO Check if the player won with the movie
		
		return false;
	}
	
}
