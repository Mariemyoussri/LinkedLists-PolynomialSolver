package eg.edu.alexu.csd.datastructure.linkedList.cs77_cs84;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

class PolynomialSolverTest {

	int[][] arr = {{1,3},{1,2},{1,2},{2,2},{3,0},{1,2}};
	int[][] arr1 = {{1,2},{10,0}};
	int[][] arr2 = {{0,0}};
	PolynomialSolver polynomial = new PolynomialSolver();
	SinglyLinkedLists list = new SinglyLinkedLists();
	
	@Test
	void testSet() {
		polynomial.setPolynomial('A',arr1);
		list = polynomial.A;
		Point temp = new Point(1,2);
		Point temp1 = new Point(10,0);
		assertEquals(temp,list.get(0));
		assertEquals(temp1,list.get(1));
	}
	
	@Test
	void testPrint() {
		polynomial.setPolynomial('A', arr);
		polynomial.setPolynomial('B', arr1);
		polynomial.setPolynomial('C', arr2);
		assertEquals("x^3 + 5x^2 + 3",polynomial.print('A'));
		assertEquals("x^2 + 10",polynomial.print('B'));
		assertEquals("0",polynomial.print('C'));
	}

	@Test
	void testClear() {
		polynomial.setPolynomial('A',arr1);
		polynomial.clearPolynomial('A');
		list = polynomial.A;
		assertTrue(list.isEmpty());
	}
	
	@Test
	void testEvaluate() {
		polynomial.setPolynomial('A',arr1);
		float value = 1;
		assertEquals(11,polynomial.evaluatePolynomial('A', value));
		assertEquals(35,polynomial.evaluatePolynomial('A', 5));
	}
	
	@Test
	void testAddition() {
		polynomial.setPolynomial('A',arr1);
		polynomial.setPolynomial('B',arr);
		int[][] result = {{1,3},{6,2},{13,0}};
		int[][] result2 = {{1,3},{5,2},{3,0}};
		assertArrayEquals(result,polynomial.add('A', 'B')); //A+B = B+A
		assertArrayEquals(result,polynomial.add('B', 'A'));
		assertEquals(20,polynomial.evaluatePolynomial('R', 1));
		assertArrayEquals(result2,polynomial.add('B', 'C'));  //B+C=C+B=B as c is 0
		assertArrayEquals(result2,polynomial.add('C', 'B'));
	}
	
	@Test
	void testSubtraction() {
		polynomial.setPolynomial('A',arr1);
		polynomial.setPolynomial('B',arr);
		int[][] result = {{-1,3},{-4,2},{7,0}};   //A-B
		int[][] result2 = {{1,3},{4,2},{-7,0}};   //B-A
		int[][] result4 = {{1,3},{5,2},{3,0}};    //B-C
		int[][] result3 = {{0,0}};           //A-A or B-B
		assertArrayEquals(result,polynomial.subtract('A', 'B'));
		assertEquals(2,polynomial.evaluatePolynomial('R', 1));
		assertArrayEquals(result4,polynomial.subtract('B', 'C'));
		assertArrayEquals(result2,polynomial.subtract('B', 'A'));
		assertArrayEquals(result3,polynomial.subtract('A', 'A'));
	}
	
	@Test
	void testMultiplication() {
		polynomial.setPolynomial('A',arr1);
		polynomial.setPolynomial('B',arr);
		int[][] result = {{1,5},{5,4},{10,3},{53,2},{30,0}};  //result of A*b
		assertArrayEquals(result,polynomial.multiply('A', 'B'));  //A*B=B*A
		assertArrayEquals(result,polynomial.multiply('B', 'A'));
		assertEquals(99,polynomial.evaluatePolynomial('R', 1));
	}
	
	@Test
	void testMultiplyByzero() {
		polynomial.setPolynomial('A',arr1);
		polynomial.setPolynomial('C',arr2);
		int[][] result = {{0,0}};
		assertArrayEquals(result,polynomial.multiply('A', 'C'));
		assertEquals(0,polynomial.evaluatePolynomial('R', 5));
	}
	

}
