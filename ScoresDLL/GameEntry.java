package ScoresDLL;

/** 
 *  Definition of a GameEntry object, useful for things like
 *	tracking high scores in a video game.  
 *  Simply has two fields:  name and score (String and int)
 */
public class GameEntry {

	/* These fields are private,
	 * so they can only be accessed via the accessor methods below. */
	private String name;	// name of the person earning this score
	private int score;	// the score itself
	
	/** 
	 * Constructor that creates a new game entry object
	 * @param n
	 *		name of player
	 * @param s
	 *		score of player
	 */
	public GameEntry(String n, int s) {
		name = n;
		score = s;
	}
	
	/** 
	 * Retrieves the name field 
	 * @return 
	 *		the value of the name field
	 */
	public String getName() { 
		return name; 
	}
	
	/** 
	 * Retrieves the score field 
	 * @return
	 *		the value of the score field
	 */
	public int getScore() { 
		return score; 
	}
	
	/** 
	 * Returns a nice, readable, string representation of this 
	 * high score entry (with parens and comma in between).
	 * (This is a special method in Java that is automatically called
	 * whenever someone treats a GameEntry object like it's a String.)
	 */
	public String toString() { 
		return "(" + name + ", " + score + ")"; 
	}
}
