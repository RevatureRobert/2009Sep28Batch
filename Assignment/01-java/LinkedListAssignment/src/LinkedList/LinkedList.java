package LinkedList;

public class LinkedList {

    private Node head;
    private Node tail;
    private int size = 0;
    
    /*
     * Constructors
     */
   
    public LinkedList(Node head, Node tail, int size) {
		super();
		this.head = head;
		this.tail = tail;
        this.size = size;
	}
    
	public LinkedList () {      
    }
	
	public LinkedList(int[] inputArray) {
		if (inputArray.length == 0) {
			this.size = 0;
			this.head = null;
			this.tail = null;
		}
		else {
		}
		for (int i=0; i<inputArray.length; i++) {
			this.add(inputArray[i]);	
		} 
	}
	
	//Private method Return boolean true if size zero
	private boolean isEmpty() {
	    return (this.size == 0);
	}
	
	//.length()
	public int length() {
		return this.size;
	}
	
	//Method to look for a value in LinkedList
//	public boolean contains(int x) {
//		for (int i = 0; i)
//		
//	}
	
	
	//remove tail from list
    public Node removeLast(){
		Node toReturn = this.tail;
        this.tail = this.tail.getPrev();
        this.tail.setNext(null);
        this.size--;
        return toReturn;
    }

    //remove by int value

    public void removeByValue(int val){
        if (this.head.getValue() == val){
            this.head = this.head.getNext();
            this.head.setPrev(null);
            this.size--;
        } else {
            Node ptr = this.head;
            ptr = ptr.getNext();
            while (ptr != null){
                if (ptr.getValue() == val){
                	if (ptr.getNext() != null) {
                        ptr.getPrev().setNext(ptr.getNext());
                        this.size--;
                        return;
                	} else {
                		this.tail = this.tail.getPrev();
                		this.tail.setNext(null);
                		this.size--;
                		return;
                	}
                }
                ptr = ptr.getNext();
            }
        }
    }

    //remove by index
	public void remove(int index){
            if(index >= size || index < 0){
                throw new IndexOutOfBoundsException("There is no value at that index");
            }
            Node current = this.head;
            Node prev = null;
            Node next = null;
            //looping through index number of times
            for(int i = 0; i<size; i++) {
                if(i == index){
                    //if index is 0;
                    if(current.equals(this.head)){
                        //if next node exists, erase prev point in next node and set next
                        //  as head.
                        if(current.getNext() != null){
                            next = current.getNext();
                            this.head = next;
                            this.head.setPrev(null);
                            break;
                        } else{
                            //if there is no next node, means head is the only node. 
                            this.head = null;
                            this.tail = null;
                            break;
                        } 
                    } else if(index == (size-1)){ //if removing the last node
                        //make previous node the tail and set its next value to null
                        prev.setNext(null);
                        this.tail = prev;
                        break;
                    } else{ //removing inner nodes, make the prev and next nodes 
                            //point to each other
                        prev.setNext(next);
                        next.setPrev(prev);
                        break;
                    }
                } else{ //if not at right index, set next to current and move on to next 
                        // iteration of the loop
                    prev = current;
                    current = current.getNext();
                    next = current.getNext();
                     
                } 
                
            } 
        
        //decrement size
        this.size--;
    }//end of method
	
    // add 1 (returns boolean) if size is zero, create new head node
    public boolean add(int x){
        //if adding the zero, then 
        if(this.isEmpty()){
            //function to initialize head
       createHead(x);
        } else{ 
            
        //Creates new node with x as value, sets current tail as previous, and 
        // null as next since it's at the end. 
        Node newNode = new Node(x, this.tail, null);
        //sets current tail's next node as newNode
        this.tail.setNext(newNode);
        //sets current tail to the new node
        this.tail = newNode;
        }
        this.size++; 
        return true;
    }

    //creates head if size is zero
    private void createHead(int x){
        this.head = new Node(x);
        this.tail = this.head;
    }
      
    // Create Array from Linked List
    public int[] toArray() {
    	//Initialize a temporary array
    	//Set a temporary node variable to iterate across the linked list
    	int[] tempArray = new int[this.size];
    	Node tempNode = this.head;
    	//Iterate through the linked list and insert the values into the array 
    	for(int i=0; i<this.size; i++) {
    		tempArray[i] = tempNode.getValue();
    		//Move our reference node to the next location
    		tempNode = tempNode.getNext();
    	}
    	return tempArray;
    }
    
    //Method for printing 'prettily' to console
    public void printNice(){
        if (this.size == 0) {
            System.out.println("");
            return;
        }
    	String consoleOutput = "";
        int[] vals = this.toArray();
        for (int val : vals) {
	        consoleOutput += val + " <---> ";
        }
    	consoleOutput = consoleOutput.substring(0, consoleOutput.length() - 6);
    	System.out.println(consoleOutput);
    }

}


