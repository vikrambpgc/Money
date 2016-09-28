package CoinGame;

import java.util.ArrayList;


public abstract class LaxCoinGameOld implements CoinGameOld {

    private int boardSize = 0;
    private int coinCount = 0;
    private ArrayList<Coin> posMap = new ArrayList<Coin>();


    /**
     * Constructor for LaxCoinGame
     * @param board  represented as a String
     * -- written in --and-O notation
     * @throws IllegalArgumentException  --when there's
     * not a valid configuration or invalid characters
     */
    public LaxCoinGameOld(String board) throws IllegalArgumentException {

        if (board == null || board.length() == 0) {
            throw new IllegalArgumentException("Not a valid configuration");
        }

        this.boardSize = board.length();

        int coinNumber = 0;
        for (int i = 0; i < boardSize; i++) {
            char myChar = board.charAt(i);

            if (myChar == '-' || myChar == 'O') {
                if (myChar == 'O') {
                    posMap.add(new Coin(coinNumber));
                    coinNumber++;
                    coinCount++;
                } else {
                    posMap.add(null);
                }
            } else {
                throw new IllegalArgumentException("Invalid characters in configuration");
            }
        }
    }


    @Override
    public int boardSize() {
        return boardSize;
    }

    @Override
    public int coinCount() {
        return coinCount;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Coin coin : posMap) {
            if (coin == null){
                str.append('-');
            }
            else str.append('O');
        }
        return str.toString();
    }


    @Override
    public int getCoinPosition(int coinIndex) {
        Coin c = null;
        for (int i = 0; i < boardSize; i++) {
            c = posMap.get(i);
            if (null != c && c.getCoinIndex() == coinIndex) {
                return i;
            }
        }

        //if execution comes here, it means
        //there is no coin in the posMap with that index.
        return -1;
    }

    /**
     * Any player can move any coin to the left in a single move.
     * Any number of coins can be there on the board.
     */
    @Override
    public boolean isGameOver() {
        Coin coin = null;
        for (int i = 0; i < boardSize; i++) {
            coin = posMap.get(i);

            if (coin == null) {
                continue;
            } else {
                if (true == canMoveLeft(i)) {
                    return false;
                }
            }
        }

        return true;
    }

    /**Private method
     * Decides whether a coin at a position
     * coin at Position can be moved left or not
     *
     */
    private boolean canMoveLeft(int coinAtPosition) {
    	boolean canMoveLeft = false;
    	
        for(int i = coinAtPosition - 1; i >= 0; i--) {
            if (posMap.get(i) == null) {
            	canMoveLeft = true;
            	break;
            }
        }
        
        return canMoveLeft;
    }

    /**Differs from LaxCoinGame
     * A coin can be moved any number of squares to the left,
     * but it cannot pass another coin
     * @param coinIndex   which coin to move
     * @param newPosition where to move it to
     */
    public void move(Player player, int coinIndex, int newPosition) {
        if (false == (coinIndex < coinCount)) {
            throw new IllegalMoveException("No coin with that index in the game");
        }

        if (newPosition > (boardSize - 1) || newPosition < 0) {
            throw new IllegalMoveException("newPosition out of bounds of board");
        }

        if (posMap.get(newPosition) != null) {
            throw new IllegalMoveException("newPosition already has a Coin present");
        }

        //this varies for Strict/Lax game.
        //see if a coin is present between newPosition and currentPosition of the coin.
        int coinCurrentPosition = getCoinPosition(coinIndex);

        if (coinCurrentPosition == -1) {
            throw new IllegalMoveException("No coin in the board with index");
        }


        Coin coin = posMap.get(coinCurrentPosition);
        posMap.set(coinCurrentPosition, null);
        posMap.set(newPosition, coin);
    }

}