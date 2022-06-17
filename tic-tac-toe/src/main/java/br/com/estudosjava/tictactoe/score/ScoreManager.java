package br.com.estudosjava.tictactoe.score;

import java.io.IOException;

import br.com.estudosjava.tictactoe.core.Player;

public interface ScoreManager {

	public Integer readScore(Player player);

	public void writeScore(Player player) throws IOException;
}
