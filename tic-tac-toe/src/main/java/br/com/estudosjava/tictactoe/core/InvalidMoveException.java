package br.com.estudosjava.tictactoe.core;

@SuppressWarnings("serial")
public class InvalidMoveException extends Exception {

	public InvalidMoveException() {
		// TODO Auto-generated constructor stub
	}

	public InvalidMoveException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidMoveException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidMoveException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidMoveException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
