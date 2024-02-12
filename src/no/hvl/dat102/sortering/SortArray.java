package no.hvl.dat102.sortering;


public class SortArray {
	
	
	public static <T extends Comparable<? super T>> void insertionSort(T[] a) {
		insertionSort(a, 0, a.length - 1);
	}

	public static <T extends Comparable<? super T>> void insertionSort(T[] a, int forste, int siste) {

		for (int i = forste + 1; i <= siste; i++) {

			T temp = a[i];
			int j = i - 1;

			
			while (j >= forste && temp.compareTo(a[j]) < 0) {
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
	
	
	public static <T extends Comparable<? super T>> void selectionSort(T[] a, int n) {
		
		for (int i = 0; i < n; i++) {
			
			T min = a[i];
			int minIndex = i;
			
			for(int j = i + 1; j < n; j++) {
				if(a[j].compareTo(min) < 0) {
					min = a[j];
					minIndex = j;
				}
			}
			
			swap(a, i, minIndex);
		}
	}
	
	public static <T extends Comparable<? super T>> void selectionSort(T[] a) {
		selectionSort(a, a.length);
	}
	
	
	
	public static <T extends Comparable<? super T>> void mergeSort(T[] a, int n) {
		mergeSort(a, 0, n-1);
	}
	
	public static <T extends Comparable<? super T>> void mergeSort(T[] a) {
		mergeSort(a, 0, a.length -1);
	}
	
	public static <T extends Comparable<? super T>> void mergeSort(T[] a, int forste, int siste) {
		
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempArray = (T[]) new Comparable<?>[a.length]; // Unchecked cast
		mergeSort(a, tempArray, forste, siste);
	}
	
	public static <T extends Comparable<? super T>> void mergeSort(T[] a, T[] tempTab, int forste, int siste) {
		if(forste >= siste) {
			
		}else {
			int midtpkt = (forste + siste) / 2;
			mergeSort(a, tempTab, forste, midtpkt);
			mergeSort(a, tempTab, midtpkt + 1, siste);
			merge(a, tempTab, forste, midtpkt, siste);
		}
	}
	
	
	public static <T extends Comparable<? super T>> void quickSort(T[] a) {
		quickSort(a, 0, a.length - 1);
		insertionSort(a);
	}
	
	private static final int MIN_GRENSE = 3;
	
	private static <T extends Comparable<? super T>> void quickSort(T[]a, int forste, int siste) {
		if(siste - forste + 1 < MIN_GRENSE) {
			
		}else {
			int delepunkt = partition(a, forste, siste);
			quickSort(a, forste, delepunkt - 1);
			quickSort(a, delepunkt + 1, siste);
		}
	}
	
	public static void swap(Object[] a, int i, int j) {
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	private static <T extends Comparable<? super T>> void merge(T[] a, T[] tempTab, int forste, int midten, int siste) {

		
		int fV = forste;
		int sluttV = midten;
		int fH = midten + 1;
		int sluttH = siste;

		
		int index = fV; // Next available location in tempArray
		for (; (fV <= sluttV) && (fH <= sluttH); index++) {
			if (a[fV].compareTo(a[fH]) < 0) {
				tempTab[index] = a[fV];
				fV++;
			} else {
				tempTab[index] = a[fH];
				fH++;
			}
		}

	
		for (; fV <= sluttV; fV++, index++) {
			tempTab[index] = a[fV];
		}

		
		for (; fH <= sluttH; fH++, index++) {
			tempTab[index] = a[fH];
		}

		
		for (index = forste; index <= siste; index++) {
			a[index] = tempTab[index];
		}
	}
	
	private static <T extends Comparable<? super T>> int partition(T[] a, int forste, int siste) {
		int midten = (forste + siste) / 2;

		
		sortFirstMiddleLast(a, forste, midten, siste);

		
		swap(a, midten, siste - 1);
		int pivotIndex = siste - 1;
		T pivotValue = a[pivotIndex];
		

		int fraVenstre = forste + 1;
		int fraHogre = siste - 2;

		boolean ferdig = false;
		while (!ferdig) {

			while (a[fraVenstre].compareTo(pivotValue) < 0) {
				fraVenstre++;
			}

			while (a[fraHogre].compareTo(pivotValue) > 0) {
				fraHogre--;
			}

			if (fraVenstre < fraHogre) {
				swap(a, fraVenstre, fraHogre);
				fraVenstre++;
				fraHogre--;
			} else {
				ferdig = true;
			}
		}

		
		swap(a, pivotIndex, fraVenstre);
		pivotIndex = fraVenstre;

		return pivotIndex;
	}


	private static <T extends Comparable<? super T>> void sortFirstMiddleLast(T[] a, int first, int mid, int last) {
		order(a, first, mid); 
		order(a, mid, last); 
		order(a, first, mid); 
	} 

	
	private static <T extends Comparable<? super T>> void order(T[] a, int i, int j) {
		if (a[i].compareTo(a[j]) > 0) {
			swap(a, i, j);
		}
	}
	
	
}
