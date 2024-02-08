package no.hvl.dat102.sortering;


public class SortArray {
	
	
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
	
	
	
	
	
	
}
