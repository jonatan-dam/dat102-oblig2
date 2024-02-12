package no.hvl.dat102.sortering_test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat102.sortering.SortArray;

class SortTest {
	private Integer[] a;
	private Integer[] b;
	private Integer[] c;
	private Integer[] fasitABC = {0, 1, 2, 4, 5, 7, 8, 9, 10, 15}; 
	
	@BeforeEach
	void setUp() throws Exception {
		a = new Integer[]{15, 5, 10, 0, 7, 1, 4, 2, 8, 9};
		b = new Integer[]{0, 5, 8, 15, 1, 4, 9, 2, 10, 7};
		c = new Integer[]{5, 9, 7, 8, 1, 4, 2, 0, 15, 10};
	}

	@Test
	void testInsertionSort() {
		SortArray.insertionSort(a);
		assertTrue(erSortert(a));
		
		SortArray.insertionSort(b);
		assertTrue(erSortert(b));
		
		SortArray.insertionSort(c);
		// assertTrue(erSortert(c));
		assertArrayEquals(fasitABC, c);
	}
	
	@Test
	void testSelectionSort() {
		SortArray.selectionSort(a);
		assertTrue(erSortert(a));
		
		SortArray.selectionSort(b);
		assertTrue(erSortert(b));
		
		SortArray.selectionSort(c);
		// assertTrue(erSortert(c));
		assertArrayEquals(fasitABC, c);
	}
	
	@Test
	void testQuickSort(){
		SortArray.quickSort(a);
		assertTrue(erSortert(a));
		
		SortArray.quickSort(b);
		assertTrue(erSortert(b));
		
		SortArray.quickSort(c);
		// assertTrue(erSortert(c));
		assertArrayEquals(fasitABC, c);
	}
	

	@Test
	void testMergeSort(){
		SortArray.mergeSort(a); 
		assertTrue(erSortert(a));
		
		SortArray.mergeSort(b);
		assertTrue(erSortert(b));
		
		SortArray.mergeSort(c);
		// assertTrue(erSortert(c));
		assertArrayEquals(fasitABC, c);
	}
	
	private boolean erSortert(Integer[] tab) {
		for (int i = 0; i < tab.length - 1; i++) {
			if (tab[i].compareTo(tab[i + 1]) > 0) {
				return false;
			}
		}
		
		return true;
	}
}