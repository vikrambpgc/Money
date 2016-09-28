package CoinGame;

import java.util.List;

/**
 * An interface for playing a coin game. The rules of a particular coin game
 * will be implemented by classes that implement this interface.
 */
public interface CoinGameOld {
    /**
     * Gets the size of the board (the number of squares)
     *
     * @return the board size
     */
    int boardSize();

    /**
     * Gets the number of coins.
     *
     * @return the number of coins
     */
    int coinCount();

    /**
     * Gets the (zero-based) position of coin number {@code coinIndex}.
     *
     * @param coinIndex which coin to look up
     * @return the coin's position
     */
    int getCoinPosition(int coinIndex);

    /**
     * Returns whether the current game is over. The game is over if there are
     * no valid moves.
     *
     * @return whether the game is over
     */
     boolean isGameOver();
    
    /**
     * The first method to call after creating an instance of the CoinGame.
     * Takes List of players, who are to be tracked, as an argument and 
     * has logic to decide whose turn it is to make the move.
     *      
     *      The turns can be decided either by some compile time defined sequence (or)
     * at run-time by asking input from console.
     * 
     * Decides whose turn it is and calls executeTurnOfPlayer() method.
     * 
     * @param players
     */
    void startGameAndDecideTurns(List<String> players);
    
    /**
     * This method contains the logic for initializing and implementing
     * a player's turn(move). Here, we can prompt the 'player' to give
     * input on what coin he wants to move and to which position he wanted
     * it to move.
     * 
     * Also sets the currentPlayer.
     * 
     * @param player
     */
    void executeTurnOfPlayer(String player);
    
    /**
     * 
     * @return the Current Player's name who is making the move.
     */
    String getCurrentPlayer();
    
    /**
     * This method should have the implementation to keep track of 'Turns(moves)'
     * happened successfully in the game. It stores the name of the player who made the move,
     * the coin he moved, the fromPosition and toPosition information.
     * 
     * This method can be called in the 'move' method after successfully making the move.
     * 
     * @param player
     * @param coinIndex
     * @param fromPosition
     * @param toPosition
     */
    void addSucessfulMoveToDatabase(String player, int coinIndex, int fromPosition, int toPosition);
    
    /**
     * If the game is over, this method returns the 'Name' of the 'Winner'(a Player)
     * by observing the Player's name in the last entry in the 'Successful Moves'
     * database. If the game isn't over, it returns null.
     * 
     * @return
     */
    String getWinner();

    /**
     * Moves coin {@code coinIndex} to position {@code newPosition},
     * if the requested move is legal. Throws {@code IllegalMoveException} if
     * the requested move is illegal, which can happen in several ways:
     *
     * <ul>
     *   <li>There is no coin with the requested index.</li>
     *   <li>The new position is occupied by another coin.</li>
     *   <li>There is some other reason the move is illegal,
     *   as specified by the concrete game.</li>
     * </ul>
     *
     * @param name of the player making the move.
     * @param coinIndex   which coin to move
     * @param newPosition where to move it to
     * @throws IllegalMoveException the move is illegal
     */
    void move(String player, int coinIndex, int newPosition);

    /**
     * The exception thrown by {@code move} when the requested move is illegal.
     *
     * <p>(Implementation Note: Implementing this interface doesn't require
     * "implementing" the {@code IllegalMoveException} class. Nesting a class
     * within an interface is a way to strongly associate that class with the
     * interface, which makes sense here because the exception is intended to be
     * used specifically by implementations and clients of this interface.)
     */
    static class IllegalMoveException extends IllegalArgumentException {
        /**
         * Constructs a illegal move exception with no description.
         */
        public IllegalMoveException() {
            super();
        }

        /**
         * Constructs a illegal move exception with the given description.
         *
         * @param msg the description
         */
        public IllegalMoveException(String msg) {
            super(msg);
        }
    }
}