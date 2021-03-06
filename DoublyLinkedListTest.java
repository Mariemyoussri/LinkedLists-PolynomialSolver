package eg.edu.alexu.csd.datastructure.linkedList.cs77_cs84;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DoublyLinkedListTest {
 
	doublyLinkedLists list = new doublyLinkedLists();
	DoublyLinkedListTest(){
		list.add(0);
		list.add(1);
		list.add(5);
		list.add(3);
		list.add(4);
	}
	
	@Test
	void testadd() {
		assertEquals(0,list.get(0));
		assertEquals(1,list.get(1));
		assertEquals(5,list.get(2));
		assertEquals(3,list.get(3));
		assertEquals(4,list.get(4));
	}
	
	@Test
	void testaddIndex() {
		assertEquals(0,list.get(0));
		list.add(0, 6);
		assertEquals(6,list.get(0));
		//Testing for an invalid index
		assertThrows(RuntimeException.class,() -> list.add(9, 3));
	}
	
	@Test
	void testGet() {
		assertEquals(0,list.get(0));
		assertEquals(1,list.get(1));
		assertEquals(5,list.get(2));
		assertEquals(3,list.get(3));
		//Testing for an invalid index
		   assertThrows(RuntimeException.class,() -> list.get(-1));
	}
	
	@Test
	void testSet() {
		assertEquals(false,list.contains(8));
		list.set(3, 8);
		assertEquals(8,list.get(3));
		//Testing for an invalid index
	    assertThrows(RuntimeException.class,() -> list.set(10, 0));
	}
 
	@Test
	void testClear() {
        assertEquals(false,list.isEmpty());
        list.clear();
		assertEquals(true,list.isEmpty());
	}
	
	@Test
	void testEmpty() {
		assertEquals(false,list.isEmpty());
	}
	
	@Test
	void testRemove() {
		assertEquals(5,list.size());
		assertEquals(5,list.get(2));
		assertEquals(3,list.get(3));
		list.remove(2);
		assertEquals(4,list.size());
		assertEquals(false,list.contains(5));
		assertEquals(3,list.get(2));
		//Testing for an invalid index
		assertThrows(RuntimeException.class,()->{list.get(-1);});
	}
	
	@Test
	void testSize() {
		assertEquals(5,list.size());
	}
	
	@Test
	void testSubList() {
		doublyLinkedLists list1 = new doublyLinkedLists();
		list1 = (doublyLinkedLists) list.sublist(2, 4);
		assertEquals(list.get(2),list1.get(0));
		assertEquals(list.get(3),list1.get(1));
		assertEquals(list.get(4),list1.get(2));
		assertEquals(3,list1.size());
		//Testing for an invalid index
        assertThrows(RuntimeException.class,() -> list.sublist(2, 100));
	}
	
	@Test
	void testContanis() {
        assertEquals(true,list.contains(1));
		assertEquals(true,list.contains(5));
		assertEquals(false,list.contains(7));
		assertEquals(false,list.contains(9));

	}
}
