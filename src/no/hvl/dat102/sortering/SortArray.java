package no.hvl.dat102.sortering;


public class SortArray {
	
	
	public static <T extends Comparable<? super T>> void insertionSort(T[] a) {
		//minsteForst(a);
		insertionSort(a, 0, a.length - 1);
	}
	
	
	public static <T extends Comparable<? super T>> void insertionSort(T[] a, int forste, int siste) {
		
		for(int i = forste + 1; i <= siste; i++) {
			
			T temp = a[i];
			int j = i - 1;
			
			while (j >= 0 && a[j].compareTo(temp) < 0) {
				a[j + 1] = a[j];
				j--;
			}
			
			a[j + 1] = temp;
		}
	}
	
	
	public static <T extends Comparable<? super T>> void minsteForst(T[] a) {
		
		int minsteIndex = 0;
		for(int i = 0; i < a.length; i++) {
			if(a[i].compareTo(a[minsteIndex]) < 0) {
				minsteIndex = i;
			}
		}
		
		if (minsteIndex != 0) {
			T temp = a[0];
			a[0] = a[minsteIndex];
			a[minsteIndex] = temp;
		}
	}
	
	
	
}
