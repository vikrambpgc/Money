package ScoresDLL;

/** 
 * Class definition for a DNode of a doubly linked list of HighScores. 
 */
public class HiScoresDLL {	
                            //public-outside can access/mutate these fiellds of an object
	public DNode head;		//instance variables of DoublyLinkedList 	
	public DNode tail;  
	public int size;	

	/**
	 * Constructor that creates a new empty list
	 */
	public HiScoresDLL(){
		head=null;
		tail = null;
		size = 0;
	}
	
	public void addFirst(DNode v){

		if (head == null){      //list is empty 
			head = v;
			tail = v;
			size = 1;
		} else{
			v.next = head;
			v.prev = null;
			head = v;
		}
		
		size++;
	}
	
		
	public void addLast(DNode v){
		if(head == null) {      //nothing in the list 
			head = v;
			tail = v;
			size = 1;
		} else{
		    v.next = null;  //already  have a tail just have to change it
            tail.next = v;
            v.prev = tail;
            tail = v;
		}
		size++;
	}
	
	public int size(){
		return size;
	}
	
	public void display() { 
		DNode cur=head;
		
		if (head == null) System.out.println("Empty list");
		while(cur!= null){
			System.out.print(cur);  //No need to use cur.value bc toString() will be called
			cur=cur.next;
		}
		System.out.println();
	}
	
	public void removeFirst(){
		//Thre Cases to account for
		//1. Empty node case 
		if (head == null){
			return; //Using void in this method so it will not return anything 
		}
		
		//Will only be executed if head!=null
		
		//2. Single node case
		if (head.next == null) {
		    head = null;
		    tail = null;
		} else {
		    //3. More than one node case
		    head=head.next;
            head.prev=null;
		}
		
		size--;
	}
	
	public void removeLast(){
	    //Thre Cases to account for
	    //1. Empty list case.
		if(head == null){
			return;
		}
	
	    //Will only be executed if head != null
	    
	    //2. Single node case 
	    if (tail.prev == null) {
	        head = null;    //Once the node is removed make sure to make head null
	        tail = null;    //Once the node is removed make sure to make tail null
	    } else {
	       //3. More than one node case 
		    tail = tail.prev;   
		    tail.next = null;
		}
		
		size--;
	}
	
	/**
     * Assuming the list of game entries is in decreasing order by score,
     * this method creates a Node with the given GameEntry e, and then
     * inserts it in the appropriate spot in the list.
     * @param e
     * the GameEntry object to be added to the list
     */ 

	public void add(GameEntry e){
	   //Four cases to deal with 
	   //1. Empty List (current Score=e Score) 
	   //2. Inserting at the start (e Score> all the scores after it)
	   //3. Inserting at the end (e Score< all the scores before it) 
	   //4. Inserting in between head and tail  
	
		DNode v = new DNode(e, null, null);
		
		DNode curNode = head, prevNode = null;
		
		//Empty list case
		if (head == null) {
		    head = v;
		    tail = v;
		    
		    return;
		} else if (v.entry.getScore() >= head.entry.getScore()) {
		    //Case 2
		    v.next = head;
		    head.prev = v;
		    head = v;
		} else if (v.entry.getScore() <= tail.entry.getScore()) {
		    //Case 3
		    tail.next = v;
		    v.prev = tail;
		    tail = v;
		} else {
		    //Case 4
		    //curNode will never become null because
		    //the new node v's score is b/w head and tail.
		    
		    while (curNode.entry.getScore() > v.entry.getScore()) { 
		        prevNode = curNode;				//previous node to point to new node 
		        curNode = curNode.next;			//traverssing //new node points to the next node 
		    }
		    
		    v.next = curNode;
		    curNode.prev = v;
		    prevNode.next = v;
		    v.prev = prevNode;
		}
		
		size++;
	}


    /**
    * Removes the node at position i in the list
    * (emulating an array index)
    * @return
    * the GameEntry of the removed node
    * or null if position i is invalid
    */

	
	public GameEntry remove(int i){
		DNode curNode = null, prevNode = null, nextNode = null, tempNode = null;
		//Empty list case
		if (head == null) return null;
		
		//Single Node case 
		if (head == tail) {
		    tempNode = head;
		    head = tail = null;
		    
		    size--;
		    return tempNode.entry;
		}
		
		//'i' head (or) tail case
		//remove head 
		if (i == 0) {
		    //'i' is head.
		    tempNode = head;
		    head = head.next;
		    head.prev = null;
		    
		    size--;
		    return tempNode.entry;
		} else if (i == size - 1) {
		    //'i' is tail.
		    
		    tempNode = tail;
		    tail = tail.prev;
		    tail.next = null;
		    
		    size--;
		    return tempNode.entry;
		}
 		
		int distanceFromHead = i;
		int distanceFromTail = size - 1 - i;
		
		if (distanceFromHead <= distanceFromTail) {
		    //Traverse from head forwards.
		    
		    prevNode = null;
		    curNode = head;
		    
		    for (int index = 0; index < i; index++) {
		        prevNode = curNode;
		        curNode = curNode.next;
		    }
		    
		    //Now curNode points to node at 'i' and we need to remove curNode.
		    nextNode = curNode.next;
		    prevNode.next = nextNode;
		    nextNode.prev = prevNode;
		    
		    size--;
		    return curNode.entry;
		} else {
		    //Traverse from tail backwards.
			
		    prevNode = null;
		    curNode = tail;
		    
		    for (int index = size - 1; index > i; index--) {
		        prevNode = curNode;
		        curNode = curNode.prev;
		    }
		    
		    //Now curNode points to node at 'i' and we need to remove curNode.
		    nextNode = curNode.prev;
		    prevNode.prev = nextNode;
		    nextNode.next = prevNode;
		    
		    size--;
		    return curNode.entry;		    
		}
	}

	
	public static void main(String[] args) {	//created a node/new object called constructor/new node 
		HiScoresDLL hsList=new HiScoresDLL();
		
		//Testing addFirst() and removeFirst()
		System.out.println("Testing addFirst() and removeFirst():");
		hsList.addFirst(new DNode(new GameEntry("AB",1000), null, null));
		hsList.display();
		hsList.addFirst(new DNode(new GameEntry("CD",500), null, null));
		hsList.display();
		hsList.addFirst(new DNode(new GameEntry("EF",400), null, null));
		hsList.display();
		hsList.removeFirst();
		hsList.display();
		hsList.removeFirst();
		hsList.display();
		hsList.removeFirst();
		hsList.display();
		
		//Testing addLast() and removeLast()
		System.out.println("Testing addLast() and removeLast():");
		hsList.addLast(new DNode(new GameEntry("AB",1000), null, null));
		hsList.display();
		hsList.addLast(new DNode(new GameEntry("CD",500), null, null));
		hsList.display();
		hsList.addLast(new DNode(new GameEntry("EF",400), null, null));
		hsList.display();
		hsList.removeLast();
		hsList.display();
		hsList.removeLast();
		hsList.display();
		hsList.removeLast();
		hsList.display();
		
		//Testing 4 different cases of add(GameEntry e)
		System.out.println("Testing 4 different cases of add(GameEntry e):");
		hsList.add(new GameEntry("AB",1000));
		hsList.addLast(new DNode(new GameEntry("CD",500), null, null));
		hsList.addLast(new DNode(new GameEntry("EF",400), null, null));
		
		hsList.add(new GameEntry("GH",1200));
		hsList.add(new GameEntry("IJ",300));
		hsList.add(new GameEntry("KL",700));
		hsList.display();
		
		//Testing different cases of \'GameEntry remove(int i)\':
		System.out.println("\nTesting different cases of \'GameEntry remove(int i)\':");
		System.out.print("Initial: ");
		hsList.display();
		System.out.println("Removed entry at 1: " + hsList.remove(1));
		hsList.display();
		System.out.println("Removed entry at last but one: " + hsList.remove(hsList.size() - 2));
		hsList.display();
		System.out.println("Removed entry at 1: " + hsList.remove(1));
		hsList.display();
		System.out.println("Removed entry at 2: " + hsList.remove(2));
		hsList.display();
		System.out.println("Removed entry at 1: " + hsList.remove(1));
		hsList.display();
		System.out.println("Removed entry at 0: " + hsList.remove(0));
		hsList.display();
	}
	
}