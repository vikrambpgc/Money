package ScoresDLL;

/** 
 * Class definition for a Node of a singly linked list of Game Entries. 
 */
public class Node {

	/* Note: these fields are public so that they can be directly accessed
	 * from outside this class.  For example, if v is a Node object, 
	 * then v.entry and v.next can be used to access these fields. */
	 
	public GameEntry entry;	//the high score entry  (lets me know its a gameEntry object 
	public Node next;		//refers to the next node in the list
	
	/** 
	 * Constructor: creates a node with the given entry and next Node. 
	 */
	public Node(GameEntry e, Node n) {
		entry = e;
		next = n;
	}
	public String toString() { 	//changes it from memory to actual words or intigers 
		return "(" + entry.getName() + ", " + entry.getScore() + ")"; 
	}
}