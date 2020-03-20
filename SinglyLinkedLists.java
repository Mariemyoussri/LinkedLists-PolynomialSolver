package eg.edu.alexu.csd.datastructure.linkedList.cs77_cs84;

public class SinglyLinkedLists implements ILinkedList {
	public class Node {
		private  Object element ;
		private  Node next;
		}
	Node head;
	Node tail;
	int size=0;
  
	@Override
	public void add(int index, Object element) {
		if(size-1>=index) {
		Node node = new Node();
		node.element=element;
		size++;
		if(index==0) {
			node.next=head;
			head = node;
		}
		else if(index==size-1) {
			tail.next=node;
			tail=node;
		}
		else {
			Node temp = head;
			int count=0;
			while(count!=(index-1)) {
				temp=temp.next;
				count++;
			}
			node.next=temp.next;
			temp.next=node;
		}
		}
		else {
			throw new RuntimeException("Index " + index + " is out of bounds!");
		}
		 
	}


	public void add(Object element) {
		Node node =new Node();
		node.element = element;
		node.next=null;
		size++;
		if(head==null) {
			head=node;
			tail=node;
		}
		else {
		tail.next=node;
		tail=node;
		}
		
	}

	@Override
	public Object get(int index) {
		if(head!=null) {
			if(size-1>=index) {
				Node temp=head;
				int counter=0;
				while(counter!=index) {
					temp=temp.next;
					counter++;
				}
				return temp.element;
			}
			else {
				throw new RuntimeException("Index " + index + " is out of bounds!");
			}
		}
		else {
			 throw new NullPointerException("empty linked list");
		 }
	}

	@Override
	public void set(int index, Object element) {
		if(head!=null) {
			if(size-1>=index && index>=0) {
		int count=0;
		Node temp=head;
		while(count!=index) {
		temp=temp.next;
		count++;
		}
		temp.element=element;
	}
			else{
				throw new RuntimeException("Index " + index + " is out of bounds!");
			}
	}
		else {
			throw new NullPointerException("empty linked list");
		}
  }

	@Override
	public void clear() {
      head=null;
      size=0;
 	} 

	@Override
	public boolean isEmpty() {
	if(head == null) {
		return true; 
	}
		return false;
	}

	@Override
	public void remove(int index) {
	if(head!=null) {
		if(size-1>=index) {
			 size--;
	if(index==0) {
		if(head.next==null) {
			head=null;
		}
		else {
			head=head.next;
		}
	}		
	else {	
     Node temp=head;
     int count=0;
     while(count!=index-1) {
    	 temp=temp.next;
    	 count++;
     }
     temp.next=temp.next.next;
     }
	}
		else {
			throw new RuntimeException("Index " + index + " is out of bounds!");
		}
	}
	else {
		throw new NullPointerException("Linked List is empty");
	}
	}

	@Override
	public int size() {
		int counter=0;
		if(head!=null) {
       Node temp = head;
       while(temp.next!=null) {
    	   temp=temp.next;
    	   counter++;
       }
       counter++;}
		return counter;
	}

	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) {
		 SinglyLinkedLists list = new SinglyLinkedLists();
		Node temp=head;
		int count=0;
		if(size-1>=fromIndex && size-1>=toIndex) {
			 while(count<=toIndex) {
				 if(count>=fromIndex && count<=toIndex) {
					 list.add(temp.element);
				 }
				 temp=temp.next;
				 count++;
			 }
		}
		else {
			throw new RuntimeException("Index is out of bounds!");
		}
		
		return list;
	}

	@Override
	public boolean contains(Object o) {
     Node temp=head;
     while(temp.next!=null) {
    	  if(temp.element==o) {
    		  return true;
    	  }
    	  temp=temp.next;
     }
		return false;
	}
	
	public void print() {
		if(head!=null) {
		Node temp=head;
		while(temp!=null) {
			System.out.println(temp.element);
			temp=temp.next;
		}
	}
	}
}
