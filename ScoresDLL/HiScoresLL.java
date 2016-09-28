package ScoresDLL;

/** 
 * Class definition for a Node of a singly linked list of HighScores. 
 */
public class HiScoresLL {
	
	/* These fields are private,
	 * so they can only be accessed via the accessor methods below. */
	private Node head;
	private int size; 
	private Node tail;  
	private Node temp;
	public Node v;
	public Node curr;
	public Node prev;
	public Node firstElement;
	/**
	* Constructor that creates a new empty list
	*/
	public HiScoresLL(){
		head=null;
		size=0;
		tail=null;
	}
	
	/**
	* Prints out all the game entries in the linked list 
	*/	
	public void display() { 
		Node prev=null;
		Node curr=head; 
		while(curr!= null) {
			System.out.println(curr);
			prev=curr;
			curr=curr.next;
		}
	}
	/**
		public void display() { 
		Node curr=firstElement; 
		while(curr!= null) {
			System.out.println(curr.entry);
		curr=curr.next;
		}
	}
	**/
	/**
	*Add a node to the head of the list 
	* @param v
	*	the Node object to be added 
	*/	
	public void addFirst(Node v){
	
		if (size!=0){
			v.next=head;
			head=v;
			size++;
		}
		else{					//if the list is empty then you have to account for the tail (the head and the tail may be the same thing)  head=node, tail=node 
			head=v;
			tail=v;
			size++;
		}
		System.out.println("test1");
	}
	
	/**
	*Removes the first node and returns it, 
	*this method assumes the list is non-empty
	* @param v
	*	the Node that was removed
	*/
	
	public Node removeFirst(){
		head=head.next; 		//make head point to next node or null 
		size--;				//decrement the node count
		return head;   
	}

	/**
	*Add a node to the tail of the list.
	* @param v
	*	the Node object to be added 
	*/
	
	public void addLast(Node v){
		if (head==null) {		//nothing in list
			head=v;}
		else {
			v.next=null;			//set new node's next to refrence the null object 
			tail.next=v;			//make old tail node point to new node 
			tail=v;				//set variable tail to refrence the new node 
			size++; 				//increment the node count
		}
		size++;
	}
	
	/**
	*Assuming the list of game entries is in decreasing order by score,
	*this method creates a Node with the given GameEntry e, and then 
	*inserts it in the appropriate spot in the list 
	* @param e
	*	the GameEntry object to be added to the list 
	/**
	
	/**
	*PseudoCode: 
	*public void add(GameEntry e){ 
	*Create a new node and call it GameEntry 
	*We are assuming that this is new so the head may be null, if it is then get the score for the head and if its less than any othe score add it as head
	*By calling the addFirst methhod and running the head entry in the parameter'
	*If this score does not belong in the head then name it something else 
	*As long as you have nodes that are not equal to the head and are not empty get the score and label them something  
	Call to the add first or addlast ***/
	
	/**Figure out how to make it in the right spot rather than just after each other**/ 

	public void add(GameEntry e){
		Node v=new Node(e, null);
		Node prev=null;
		Node cur=head;
		
		while (cur!=null && cur.entry.getScore()>e.getScore()){
			prev=cur;				//previous node to point to new node 
			cur=cur.next;			//traverssing //new node points to the next node 
		}
		if (prev==null){
			addFirst(v);
		}
		else if(cur==null){
			addLast(v);
		}
		else if(prev==tail){
			addLast(v);
		}
		else{
			prev.next=v.next=cur;
		}
		
		size++;
		
	}
	
	/*** 
	*Removes the node at position i in the list 
	*(emulating an array index)
	*@return 
	*	the GameEntry of the removed node
	*	or null if position is invalid 
	*/
	
	public GameEntry remove(int i){
		Node cur=head;
		prev=null;
		GameEntry e=new GameEntry("GM", 1000);

		while(cur!=null && cur.entry.getScore()!=i){		//if it finds it it will stop 
			prev=cur;
			cur=cur.next;
		}
		if(cur==null){								//if value is not found 
			return null;
		}
		else if(prev==null){							//found prev as first stop
			head=head.next;
		}
		else{
			prev.next=cur.next;
		}
		size--;
		return e;
		
	}
	
	/**public GameEntry remove(int i){ 
		Node cur=head;
		Node prev=null;
		
		if (i==0){
			head=head.next;
		}
		else {
			GameEntry curr=head;
			for (int k=0; k<i-1, i++){
				cur=cur.next;
			}
			cur.next=cur.next.next;
			
		}	
	
	}
	**/
	
	/**
	
	public GameEntry remove(int i){
		Node prev=null;
		Node cur=head;
		
		while(cur.next!=null) {
			cur=cur.next;
			if(cur.getScore==i){
				size--;
				head=head.next();
				if(prev!=null){
					prev.next(head.next());
				}
				else{
					head.next();
				}
			}
			prev=cur;
		return GameEntry(String z, int i);	
		}
	return null;
		
		
		GameEntry cur=entries[i];
	return curr;
	
	}
	**/
	
	/**
	public void GameEntry remove(int i){
		Node prev=null;

		if (head==null) {				//check if something needs to be removed 
			throw new RuntimeException("cannot delete"); 
		}
		if (head.entry.getScore()==i){
			head=head.next;	//remove first 
			size--;

		}
	
		Node cur=head;
		while(cur!=null && cur.entry.getScore()==i) {
			prev=cur;
			cur=cur.next;
			size--;

		}
		if (cur==null){ 
			throw new RuntimeException ("cannot delete"); 
		}
		
		prev.next=cur.next;
		
		
	}
	
	
		/**while(cur.next.getScore()!=int i){
			cur=cur.next;
			size++;
			}
			if(cur.getScore==int i){
				cur=null;
			return cur;
			size++;
			
			}
		}	
	}
	**/
	
	
	
	public static void main(String[] args) {	//created a node/new object called constructor/new node 
		HiScoresLL hsList=new HiScoresLL();
		hsList.addFirst(new Node(new GameEntry("GM", 1000), null));
		System.out.println("Test addFirst");
		hsList.display();
		System.out.println("Test Display");
		//hsList.removeFirst();
		//hsList.display();
		//System.out.println("Test removeFirst");
		hsList.add(new GameEntry("GN", 2000));
		hsList.display();
		System.out.println("Test add");
		hsList.add(new GameEntry("GN", 3000));
		hsList.display();
		System.out.println("Test add");
		//hsList.addLast(new Node(new GameEntry("GN", 6000),null));
		//hsList.display();
		//System.out.println("Test addLast");
		hsList.add(new GameEntry("GN", 2500));
		hsList.display();
		System.out.println("Test add 2500");
		hsList.remove(1000);
		hsList.display();
		System.out.println("Test remove 1000");
		hsList.remove(2000);
		hsList.display();
		System.out.println("Test remove 2000");
	}
	
	/**
	*Removes the node at position i in the list
	*(emulating an array index)
	*@return
	*		the GameEntry of the removed node
	*		or null if position i is invalid
	*/
	/**
	public GameEntry remove(int i){
		cur=head
		prev=null
		while(cur!!=null&& cur.value!=target.value){
			prev=cur;
			cur=cur.next;
		}
		if (cur==null){
			return null
		}
		else if(prev==null){
			head=head.next;
		else{
			pre.next=cur.next;
		}
		return cur;
			size--;
	**/	
	
	
}
