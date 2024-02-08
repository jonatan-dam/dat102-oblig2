package no.hvl.dat102.parenteser;

import java.util.Set;

public class ParentesSjekker {
	
	private static final Set<Character> STARTPARENTESER = Set.of('{', '(', '[', '<');
	private static final Set<Character> SLUTTPARENTESER = Set.of('}', ')', ']', '>');
	private static final Set<String>    PARENTESPAR = Set.of("{}", "()", "[]", "<>");
	
	public static boolean sjekkParenteser(String s) {
		
		ArrayStack<Character> stabel = new ArrayStack<>();
		char[] tegn = s.toCharArray();
		
		for(char c : tegn) {
			if(erStartParentes(c)) {
				
				stabel.push(c);
			}else if(erSluttParentes(c)) {
				
				if(stabel.isEmpty()) {
					
					return false; // Det er flere sluttparenteser enn startparenteser
				}
				
				if(!erParentesPar(stabel.pop(), c)) {
					return false; // Sluttparentesen matcher ikke startparentesen
				}
			}
		} //end for-løkke
		
		return stabel.isEmpty();
	}

	private static boolean erStartParentes(char c) {
		return STARTPARENTESER.contains(c);
	}
	
	private static boolean erSluttParentes(char c) {
		return SLUTTPARENTESER.contains(c);
	}
	
	private static boolean erParentesPar(char start, char slutt) {
		return PARENTESPAR.contains(String.valueOf(start) + slutt);
	}
}