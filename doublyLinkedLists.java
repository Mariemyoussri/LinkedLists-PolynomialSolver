package eg.edu.alexu.csd.datastructure.linkedList.cs77_cs84;

public class doublyLinkedLists implements ILinkedList {
	public class Nodes {
		private  Object element ;
		private  Nodes next;
		private  Nodes prev;
		public Nodes(Object e,Nodes n, Nodes p) {
			element=e;
			next=n;
			prev=p;
		}
		public void setElement(Object element) {
			this.element=element;
		}
		public Object getElement() {
			return this.element;
		}
		public void setNext(Nodes next) {
			this.next=next;
		}
		public Nodes getNext() {
			return this.next;
		}
		public void setPrev(Nodes prev) {
			this.prev=prev;
		}
		public Nodes getPrev() {
			return this.prev;
		}
	}
	
	Nodes header;
	Nodes trailer;
	int size=0;
	
public doublyLinkedLists() {
	 header=new Nodes(null,null,null);
	 trailer=new Nodes(null,null,header);
	header.setNext(trailer);
}

	@Override
	public void add(int index, Object element) {
	if(size-1>=index) {	
    int count=0;
    size++;
    Nodes node= new Nodes(element, null,null);
    Nodes temp=header.getNext();
    while(count!=index) {
    	temp=temp.getNext();
    	count++;
    }
    node.setPrev(temp.getPrev());
    Nodes n = node.getPrev();
    n.setNext(node);
	node.setNext(temp);
	temp.setPrev(node);
	}
	else {
		throw new RuntimeException("Index "+index+" is out of bounds!");
		}
	}

	@Override
	public void add(Object element) {
	Nodes node = new Nodes(element, trailer, null);
	node.setPrev(trailer.getPrev());
	Nodes temp = node.getPrev();
	temp.setNext(node);
	trailer.setPrev(node);
	size++;
	}

	@Override
	public Object get(int index) {
		 if(size!=0) {
			 if(size-1>=index) {
				 Nodes temp=header.getNext();
				 int count=0;
				 while(count!=index) {
					 temp=temp.getNext();
					 count++;
				 }
				 return temp.getElement();
			 }
			 else {
				 throw new RuntimeException("Index "+index+" is out of bounds!");
			 }
		 }
		 else {
			 throw new NullPointerException("empty linked list");
		 }
	}

	@Override
	public void set(int index, Object element) {
		if(size-1>=index) {
			 Nodes temp=header.getNext();
			 int count=0;
			 while(count!=index) { 
				 temp=temp.getNext();
				 count++;
			 }
			 temp.setElement(element);
		 }
		 else {
			 throw new RuntimeException("Index "+index+" is out of bounds!");
		 }
		
	}

	@Override
	public void clear() {
		header.setNext(trailer);
		trailer.setPrev(header);
		size=0;
	}

	@Override
	public boolean isEmpty() {
		if(header.getNext()==trailer) {
			return true;
		}
		return false;
	}

	@Override
	public void remove(int index) {
		if(header.getNext()!=null) {
		if(size-1>=index) {
		Nodes temp=header.getNext();
		int count=0;
		while(count!=index) {
			temp=temp.getNext();
			count++;
		}
		Nodes n=temp.getPrev();
		n.setNext(temp.getNext());
		temp=temp.getNext();
		temp.setPrev(n);
		size--;
	}
		else {
			throw new RuntimeException("Index "+index+" is out of bounds!");
			}
		}
		else {
			throw new NullPointerException("Linked List is empty");
			}
		}

	@Override
	public int size() {
		return size;
	}

	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) {
		doublyLinkedLists list = new doublyLinkedLists();
		Nodes temp=header.getNext();
		int count=0;
		if(size-1>=fromIndex && size-1>=toIndex) {
			 while(count<=toIndex) {
				 if(count>=fromIndex && count<=toIndex) {
					 list.add(temp.element);
				 }
				 temp=temp.getNext();
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
		Nodes temp=header.getNext();
		while(temp.getNext()!=null) {
			if(temp.getElement()==o) {
				return true;
			}
			else {
				temp=temp.getNext();
			}
		}
		return false;
	}
	
	public void print() {
		Nodes temp=header.getNext();
		while(temp.getNext()!=null) {
			System.out.println(temp.getElement());
			temp=temp.next;
		}
	}
	
	
}
