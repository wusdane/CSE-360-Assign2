/* Name: William Usdane
 * Class ID: 434
 * Assignment 2
 * Description: This is the junit test cases file for SimpleList, this will test
 * the different methods of the SimpleList class and be able to test the different
 * routes and possible errors that this class could cause.
 */
package assign2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

//Junit class to test the different methods of SimpleList
public class SimpleListTest {

	//Checks the integer count is properly set to 0
	@Test
	public void testSimpleListCount() {
		SimpleList test = new SimpleList();
		int x = test.count();
		assertEquals(0, x);
	}
	
	//Checks the int array list is set and NULL is printed when initialized
	@Test
	public void testSimpleListArray() {
		SimpleList test = new SimpleList();
		assertNull(test.toString());
	}
	
	//Tests the add() method is adding the correct integer
	@Test
	public void testAdd() {
		SimpleList test = new SimpleList();
		test.add(3);
		assertEquals("3", test.toString());
	}
	
	//Tests the add() method after it adds 11 elements
	@Test
	public void testAddAfterTen() {
		SimpleList test = new SimpleList();
		test.add(9);
		test.add(11);
		test.add(4);
		test.add(11);
		test.add(5);
		test.add(3);
		test.add(11);
		test.add(4);
		test.add(11);
		test.add(5);
		test.add(1);
		assertEquals(10, test.search(9));
	}
	
	//Tests count() is incrementing
	@Test
	public void testCount() {
		SimpleList test = new SimpleList();
		test.add(3);
		test.add(11);
		test.add(4);
		int x = test.count();
		assertEquals(3, x);
	}
	
	//Tests count() incrementing and decrementing
	@Test
	public void testCountWithRemove() {
		SimpleList test = new SimpleList();
		test.add(3);
		test.add(11);
		test.add(4);
		test.remove(11);
		int x = test.count();
		assertEquals(2, x);
	}
	
	//Tests max() is reducing
	@Test
	public void testMaxRemoveReduction() {
		SimpleList test = new SimpleList();
		test.add(3);
		test.add(11);
		test.add(4);
		test.remove(11);
		int x = test.size();
		assertEquals(2, x);
	}
	
	//Tests max() is not reducing when count is over 75%
	@Test
	public void testMaxRemoveNoReduction() {
		SimpleList test = new SimpleList();
		test.add(3);
		test.add(11);
		test.add(4);
		test.add(3);
		test.add(11);
		test.add(4);
		test.add(3);
		test.add(11);
		test.add(4);
		test.remove(11);
		int x = test.size();
		assertEquals(10, x);
	}
	
	//Tests count() after 11 elements are added
	@Test
	public void testCountOver10() {
		SimpleList test = new SimpleList();
		test.add(3);
		test.add(11);
		test.add(4);
		test.add(11);
		test.add(5);
		test.add(3);
		test.add(11);
		test.add(4);
		test.add(11);
		test.add(5);
		test.add(1);
		int x = test.count();
		assertEquals(11, x);
	}
	
	//Tests max() after 11 elements are added
	@Test
	public void testMaxOver10() {
		SimpleList test = new SimpleList();
		test.add(3);
		test.add(11);
		test.add(4);
		test.add(11);
		test.add(5);
		test.add(3);
		test.add(11);
		test.add(4);
		test.add(11);
		test.add(5);
		test.add(1);
		int x = test.size();
		assertEquals(15, x);
	}
	
	//Tests if the remove() method removes the desired number
	@Test
	public void testRemove() {
		SimpleList test = new SimpleList();
		test.add(3);
		test.add(11);
		test.add(4);
		test.remove(11);
		assertEquals("4 3", test.toString());
	}
	
	//Tests if the remove() method reduces max below 1
	@Test
	public void testMaxRemove1Element() {
		SimpleList test = new SimpleList();
		test.add(11);
		test.remove(11);
		assertEquals(1, test.size());
	}
	
	//Tests if the max is increased after being brought to 1
	@Test
	public void testMaxIncreaseAfterReduction() {
		SimpleList test = new SimpleList();
		test.add(11);
		test.remove(11);
		test.add(11);
		test.add(4);
		assertEquals(2, test.size());
	}
	
	//Tests remove() when there are duplicates, and removes the first instances of that element
	@Test
	public void testRemoveDupe() {
		SimpleList test = new SimpleList();
		test.add(3);
		test.add(11);
		test.add(4);
		test.add(3);
		test.add(4);
		test.remove(4);
		assertEquals("3 4 11 3", test.toString());
	}
	
	//Tests the search() method to see if it is returning the correct position
	@Test
	public void testSearch() {
		SimpleList test = new SimpleList();
		test.add(3);
		test.add(11);
		test.add(4);
		int y = test.search(11);
		assertEquals(1, y);
	}
	
	//Tests search() when the requested element is not in the array
	@Test
	public void testSearchNotFound() {
		SimpleList test = new SimpleList();
		test.add(3);
		test.add(11);
		test.add(4);
		int z = test.search(2);
		assertEquals(-1, z);
	}
	
	//Tests that search() will bring the first appearance of a duplicate number
	@Test
	public void testSearchDupe() {
		SimpleList test = new SimpleList();
		test.add(3);
		test.add(11);
		test.add(4);
		test.add(3);
		test.add(4);
		int y = test.search(3);
		assertEquals(1, y);
	}
	
	//Tests the toString() method
	@Test
	public void testToString() {
		SimpleList test = new SimpleList();
		test.add(3);
		test.add(11);
		test.add(4);
		assertEquals("4 11 3", test.toString());
	}
	
	//Tests the toString() method after a remove() method is completed
	@Test
	public void testToStringAfterRemove() {
		SimpleList test = new SimpleList();
		test.add(3);
		test.add(11);
		test.add(4);
		test.remove(11);
		assertEquals("4 3", test.toString());
	}
}