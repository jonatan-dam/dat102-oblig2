package no.hvl.dat102.sortering;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		long sum = 0;
		int n = 5;
		
		
		for(int i = 0; i < n; i++) {
			Integer[] tabell = createRandom();
			
			
			
			long startMillis = System.currentTimeMillis();
			
			SortArray.insertionSort(tabell);
			
		
			long kjoreTid = System.currentTimeMillis() - startMillis;
			sum = sum + kjoreTid;
			//System.out.println("Kjøretid er: " + kjoreTid + "ms");
			
		}
		
		double snittTid = (double) sum/n;
		System.out.println("Gjennomsnittlig kjøretid over " + n + " kjøringer er: " + snittTid + "ms");
		
		
		
		
		
		
	
		
		
	}
	
	public static Integer[] createRandom(){
		
		Integer[] tabell = new Integer[100000];
		int n = tabell.length;
		Random tilfeldig = new Random();
		
		for(int i = 0; i < n; i++) {
			tabell[i] = tilfeldig.nextInt();
		}
		
		return tabell;
	}

}
