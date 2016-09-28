package ShortPrograms;

public class MaxHeapIllustrator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] inputArray = {52, 32, 28, 23, 15, 24, 14, 9, 10, 11};
		MaxHeap maxHeap = new MaxHeap(inputArray);

		maxHeap.insert(47, true);
	}

}

//Implementing a Max Heap
class MaxHeap {

	private int[] A; //Array that stores the heap
	private int capacity; //Max elements that can be present in the heap
	private int count; //Current number of elements in the heap.
	
	public MaxHeap(int[] inputArray) {
		if (inputArray.length > 0) {
			this.capacity = 2 * inputArray.length;
		} else {
			this.capacity = 10; //default capacity.
		}
		this.A = new int[capacity];
		
		//Make a heap with the given array of elements
		for(int i=0, arrayLength = inputArray.length; i < arrayLength; i++) {
			insert(inputArray[i], false);
		}
	}

	//Returns the parent index of a node in the heap
	private int parent(int i) {
		int temp = 0;
		if (i >=  count || i < 0) return -1;
		temp = (i - 1) / 2;
		
		if (temp<0) return -1;
		
		return temp;
	}
	
	//Insert an element into a heap
	public void insert(int data, boolean shouldPrintTree) {
		int i;
		
		if (true == shouldPrintTree) printHeap(); //Heap before Inserting
		
		//Since we decided to insert, increase the count.
		count++;
		i = count - 1;
		A[i] = data; //Insert the new data at the end of the core array of the Heap.
		
		if (true == shouldPrintTree) printHeap();
		
		//Every iteration, see if the parent is less than data or not, if so,
		//exchange the child with the parent.
		while(i>0 && parent(i) != -1 && data > A[(i-1)/2]) {
			A[i] = A[(i-1)/2];
			A[(i-1)/2] = data;
			if (true == shouldPrintTree) printHeap();  //Prints the heap after every exchange
			i = (i-1)/2;
		}
		
		this.A[i] = data;
	}
	
	//Print the tree. You can change the way heap gets printed if u want.
	public void printHeap() {
		if (count > 0) {
			for(int i=0; i < count; i++) {
				System.out.print(A[i] + ", ");
			}
		}
		System.out.println();
	}
}
