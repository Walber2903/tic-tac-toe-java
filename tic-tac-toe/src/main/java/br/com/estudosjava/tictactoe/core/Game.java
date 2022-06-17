package br.com.estudosjava.tictactoe.core;

import java.io.IOException;

import br.com.estudosjava.tictactoe.Constants;
import br.com.estudosjava.tictactoe.score.FileScoreManager;
import br.com.estudosjava.tictactoe.score.ScoreManager;
import br.com.estudosjava.tictactoe.ui.UI;

public class Game {

	private Board board = new Board();
	private Player[] players = new Player[Constants.SYMBOL_PLAYERS.length];
	private int currentPlayerIndex = -1;
	private ScoreManager scoreManager;
	
	public void play() throws IOException {
		scoreManager = createScoreManager();
		
		UI.printGameTitle();

		for(int i = 0; i < players.length; i++) {
			players[i] = createPlayer(i);
		}
		
		boolean gameEnded = false;
		Player currentPlayer = nextPlayer();
		Player winner = null;
		
		while(!gameEnded) {
			board.print();
			
			boolean sequenceWin;
			try {
				sequenceWin = currentPlayer.play();
			} catch (InvalidMoveException e) {
				UI.printText("Erro: " + e.getMessage());
				continue;
			}
			
			if(sequenceWin) {
				gameEnded = true;
				winner = currentPlayer;
			} else if(board.isFull()) {
				gameEnded = true;
			} else {
				currentPlayer = nextPlayer();				
			}
			
		}
	
		if(winner == null) {
			UI.printText("The game tied.");
		} else {
			UI.printText("The player '" + winner.getName() + "' won the game!");
			
			scoreManager.writeScore(winner);
		}
		
		board.print();
		UI.printText(" End Game!");
	}
	
	
	private Player createPlayer(int index) {
		String name = UI.readInput("Player " + (index +1) + " => ");
		Player player = new Player(name, board, Constants.SYMBOL_PLAYERS[index]);
		
		Integer score = scoreManager.readScore(player);
		
		if(score != null) {
			UI.printText("The player '" + player.getName() + "' has " + score + " victories!");
		}
		
		UI.printText("The player '" + name + "' will use the symbol '" + Constants.SYMBOL_PLAYERS[index] + "'.");
		
		return player;
	}
	
	private Player nextPlayer() {
		currentPlayerIndex ++;
		
		if(currentPlayerIndex >= players.length) {
			currentPlayerIndex = 0;
		}
		return players[currentPlayerIndex];
	}
	
	private ScoreManager createScoreManager() throws IOException {
		return new FileScoreManager();
	}

}
