package CoinGame;

public class Player {
	private String name;
	
	public Player(String name) {
		this.name = name;
	}
	
	public String getNameOfPlayer() {
		return name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
