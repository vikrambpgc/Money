package CoinGame;

public class Coin {
	private int coinIndex;
	
	public Coin(int index) {
	    this.coinIndex = index;
	}
	
	public int getCoinIndex() {
		return coinIndex;
	}
	
	public void setCoinIndex(int index) {
		this.coinIndex = index;
	}
}
