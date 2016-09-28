package ScoresDLL;

/** 
 * Class definition for a DNode of a doubly linked list of Game Entries. 
 */
public class DNode {

	public GameEntry entry; //Node carries GamEntry object 
	public DNode next;		//refers to the next node in the list
	public DNode prev; 		//pointer to the previous node 

	
		
	/** 
	 * Constructor: creates a node with the given entry, next Node and previous node. 
	 */
	public DNode(GameEntry e, DNode n, DNode p) {
		next = n;
		entry = e;
		prev = p;
	}
	
	public String toString() { 	//changes it from memory to actual words or intigers 
		return "(" + entry.getName() + ", " + entry.getScore() + ")"; 
	}
}
