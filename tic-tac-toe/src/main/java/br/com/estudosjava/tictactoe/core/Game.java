package br.com.estudosjava.tictactoe.core;

import br.com.estudosjava.tictactoe.Constants;
import br.com.estudosjava.tictactoe.ui.UI;

public class Game {

	private Board board = new Board();
	private Player[] player = new Player[Constants.SYMBOL_PLAYERS.length];
	
	public void play() {
		UI.printGameTitle();
		
		board.clear();
		board.print();
		
		UI.readInput("Nome do jogador: ");
	}

}
