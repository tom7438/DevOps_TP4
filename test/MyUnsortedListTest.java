package datastruct;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class MyUnsortedListTest {

	@Test
	public void testisEmpty() {
		MyUnsortedList<Integer> list = MyUnsortedList.of();
		assertTrue(list.isEmpty());
		
	}
	@Test
	public void isNotEmpty() {
		MyUnsortedList<Integer> list = MyUnsortedList.of(1);
		assertFalse(list.isEmpty());
	}
	@Test
	public void testSize() {
		MyUnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4, 5);
		assertEquals(5, list.size());
	}
	@Test
	public void testsize0() {
		MyUnsortedList<Integer> list = MyUnsortedList.of();
		assertEquals(0, list.size());
	}
	@Test
	public void testPrepend() {
		MyUnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3);
		list.prepend(0);
		assertEquals("Taille non correspondante à l'insertion",4, list.size());
		assertEquals("Insertion incorrecte","MyUnsortedList { size = 4, [0, 1, 2, 3] }", list.toString());
	}
	@Test
	public void testPrependEmpty() {
		MyUnsortedList<Integer> list = MyUnsortedList.of();
		list.prepend(0);
		assertEquals("Taille non correspondante à l'insertion", 1, list.size());
		assertEquals("Insertion incorrecte", "MyUnsortedList { size = 1, [0] }", list.toString());
	}
	@Test
	public void testAppend() {
		MyUnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3);
		list.append(4);
		assertEquals("Taille non correspondante à l'insertion", 4, list.size());
		assertEquals("Insertion incorrecte", "MyUnsortedList { size = 4, [1, 2, 3, 4] }", list.toString());
	}
	@Test
	public void testAppendEmpty() {
		MyUnsortedList<Integer> list = MyUnsortedList.of();
		list.append(0);
		assertEquals("Taille non correspondante à l'insertion", 1, list.size());
		assertEquals("Insertion incorrecte", "MyUnsortedList { size = 1, [0] }", list.toString());
	}
	@Test
	public void testInsertFirst() {
		MyUnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3);
		list.insert(0, 0);
		assertEquals("Taille non correspondante à l'insertion", 4, list.size());
		assertEquals("Insertion incorrecte", "MyUnsortedList { size = 4, [0, 1, 2, 3] }", list.toString());
	}
	@Test
	public void testInsertLast() {
		MyUnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3);
		list.insert(4, 3);
		assertEquals("Taille non correspondante à l'insertion", 4, list.size());
		assertEquals("Insertion incorrecte", "MyUnsortedList { size = 4, [1, 2, 3, 4] }", list.toString());
	}
	@Test
	public void testInsert() {
		MyUnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3);
		list.insert(4, 2);
		assertEquals("Taille non correspondante à l'insertion", 4, list.size());
		assertEquals("Insertion incorrecte", "MyUnsortedList { size = 4, [1, 2, 4, 3] }", list.toString());
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void testInsertOutOfBoundsUP() {
		MyUnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3);
		list.insert(4, 4);
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void testInsertOutOfBoundsDown() {
		MyUnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3);
		list.insert(4, -1);
	}
	@Test
	public void testPop() {
		MyUnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3);
		assertEquals("Valeur incorrecte", 1, list.pop().intValue());
		assertEquals("Taille incorrecte", 2, list.size());
		assertEquals("Liste incorrecte", "MyUnsortedList { size = 2, [2, 3] }", list.toString());
	}
	@Test(expected = EmptyListException.class)
	public void testPopEmpty() {
		MyUnsortedList<Integer> list = MyUnsortedList.of();
		list.pop();
	}
	@Test
	public void testPopLast() {
		MyUnsortedList<Integer> list = MyUnsortedList.of(1,2);
		assertEquals("Valeur incorrecte", 2, list.popLast().intValue());
		assertEquals("Taille incorrecte", 1, list.size());
		assertEquals("Liste incorrecte", "MyUnsortedList { size = 1, [1] }", list.toString());
	}
	@Test
	public void testPopLastOne() {
		MyUnsortedList<Integer> list = MyUnsortedList.of(1);
		assertEquals("Valeur incorrecte", 1, list.popLast().intValue());
		assertEquals("Taille incorrecte", 0, list.size());
		assertEquals("Liste incorrecte", "MyUnsortedList { size = 0, [] }", list.toString());
	}
	@Test(expected = EmptyListException.class)
	public void testPopLastEmpty() {
		MyUnsortedList<Integer> list = MyUnsortedList.of();
		list.popLast();
	}
	@Test
	public void testRemove() {
		MyUnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4);
		list.remove(2);
		assertEquals("Taille incorrecte", 3, list.size());
		assertEquals("Liste incorrecte", "MyUnsortedList { size = 3, [1, 2, 4] }", list.toString());
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveOutOfBoundsUp() {
		MyUnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3);
		list.remove(3);
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveOutOfBoundsDown() {
		MyUnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3);
		list.remove(-1);
	}
	@Test
	public void testequals() {
        MyUnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3);
        MyUnsortedList<Integer> list2 = MyUnsortedList.of(1, 2, 3);
        assertTrue(list.equals(list2));
    }
	@Test
	public void testequalsFalse() {
		MyUnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3);
		MyUnsortedList<Integer> list2 = MyUnsortedList.of(1, 2, 4);
		assertFalse(list.equals(list2));
	}
	@Test
	public void testequalsWrongtype() {
		MyUnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3);
		List<Integer> list2 = new java.util.LinkedList<>();
		assertFalse(list.equals(list2));
	}
	@Test
	public void testequalsFalseSize() {
		MyUnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3);
		MyUnsortedList<Integer> list2 = MyUnsortedList.of(1, 2, 3, 4);
		assertFalse(list.equals(list2));
	}
}
