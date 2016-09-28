package CoinGame;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class StrictCoinGameOld implements CoinGameOld {
    private int boardSize = 0;
    private int coinCount = 0;
    private ArrayList<Coin> posMap = new ArrayList<Coin>();
    private LinkedHashMap<String, Player> playersMap = new LinkedHashMap<String, Player>();
    private String lastSuccessfulMoveByPlayer = null;
    private String currentPlayer;

    public StrictCoinGameOld(String board) throws IllegalArgumentException {
    
        if (board == null || board.length() == 0) {
            throw new IllegalArgumentException("Not a valid configuration");
        }
        
        this.boardSize = board.length();
        
       int coinNumber = 0;
       for(int i=0; i < boardSize; i++) {
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

    public int boardSize() {
        return boardSize;
    }
    
    public int coinCount() {
        return coinCount;
    }

    public int getCoinPosition(int coinIndex) {
    	Coin c = null; 
        for(int i=0; i < boardSize; i++){
            c = posMap.get(i);
            if ( null != c && c.getCoinIndex() == coinIndex) {
                return i;
            }
        }
        
        //if execution comes here, it means
        //there is no coin in the posMap with that index.
        return -1;
    }
   
   /**
    *Any player can move any coin to the left in a single move.
    *Any number of coins can be there on the board.
    */
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
    
    public String getWinner() {
    	String player = null;
    	if (true == isGameOver()) {
    		player = lastSuccessfulMoveByPlayer;
    	} else {
    		System.out.println("Game not yet over");
    	}
    	
    	return player;
    }
    
    //Decides whether a coin at a position 'coinAtPosition' can be moved left or not
    private boolean canMoveLeft(int coinAtPosition) {
    	boolean canMoveLeft = false;
    	
        for(int i = coinAtPosition - 1; i >= 0; i--) {
            if (posMap.get(i) != null) {
            	canMoveLeft = false;
            } else {
            	canMoveLeft = true;
            	break;
            }
        }
        
        return canMoveLeft;
    }
    
    public void startGameAndDecideTurns(List<String> players) {
    		
    	System.out.println("Initial Game configuration is " + this);
    	
    	for(String player:players) {
    		playersMap.put(player, new Player(player));
    	}
    	
    	outer:
    	while(true) {
    		   		
    		for(String player: playersMap.keySet()) {
    			System.out.println();
    			
    			if (true == isGameOver()) {
    				System.out.println("----GAME OVER---");
    				System.out.println("\n Winner of the game is: " + lastSuccessfulMoveByPlayer);
    				break outer;
    			}
    			
    			executeTurnOfPlayer(player);			
    		}
    	}
    }
    
    public void executeTurnOfPlayer(String player) {
    	BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
    	int coinNumber = 0;
    	int newPosition = 0;
    	
    	currentPlayer = player;
    	
    	try {
    		System.out.println(player + "'s turn:");
    		System.out.print("Enter coin number to move:");
    		coinNumber = Integer.parseInt(bufferReader.readLine());

    		System.out.print("Enter position to which coin Number \'" + coinNumber + "\' needs to be moved:");
    		newPosition = Integer.parseInt(bufferReader.readLine());
    		
    	} catch(Exception e) {
    		System.out.println("Problem in taking input from Console.");
    	}
		
		move(player, coinNumber, newPosition);
			
		System.out.println("New Game configuration is " + this);
		
		
    }
    
    public String getCurrentPlayer() {
    	return currentPlayer;
    }

    public void move(String player, int coinIndex, int newPosition) {
    	int initialPosition = 0;
    	initialPosition = getCoinPosition(coinIndex);
    	
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
        for (int i = (coinCurrentPosition - 1); i > newPosition; i--) {
            if (posMap.get(i) != null) {
                throw new IllegalMoveException("A coin is present between newPosition and currentPosition of the coin.So Invalid move");
            }
        }
        
        //Now all cases are validated, and it is perfectly ok to move the
        //coin to the new Position. So doing the logistics.
        Coin coin = posMap.get(coinCurrentPosition);
        posMap.set(coinCurrentPosition, null);
        posMap.set(newPosition, coin);
        
        
        addSucessfulMoveToDatabase(player, coinIndex, initialPosition, newPosition);
    }
    
    public void addSucessfulMoveToDatabase(String player, int coinIndex, int fromPosition, int toPosition) {
    	
		System.out.println(String.format("Player %s moved '%d' coinIndex from %d to %d",
				player, coinIndex, fromPosition, toPosition));
		
    	lastSuccessfulMoveByPlayer = player;
    }
    
    @Override
    public String toString() {
    	StringBuilder str = new StringBuilder();
    	
    	for(Coin coin:posMap) {
    		if (coin == null) str.append('-');
    		else str.append('O');
    	}
    	
    	return str.toString();
    }
    
    public static void main(String[] args) {
    	//-O-O-O
    	//OO_
    	StrictCoinGameOld game = new StrictCoinGameOld("-O-O-O");
    	
    	/*
    	System.out.println(game.toString());
    	System.out.println(game.getCoinPosition(2));
    	System.out.println("BoardSize: " + game.boardSize() + " Coins count: " + game.coinCount());
    	
    	while(true) {
    		System.out.println("Is Game Over: " + game.isGameOver());
    		game.move(0, 0);
    		game.move(1, 1);
    		game.move(2, 2);
    		System.out.println("Is Game Over: " + game.isGameOver());
    		System.out.println(game.toString());
    	}
    	
    	*/
    	
    	game.startGameAndDecideTurns(Arrays.asList("Vikram", "Rajesh"));
    			
    }
}