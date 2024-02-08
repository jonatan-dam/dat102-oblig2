package no.hvl.dat102.parenteser_test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import no.hvl.dat102.parenteser.ParentesSjekker;

class ParentesTest {

	@Test
	void parentesTest() {
		
		String s1 = "{ [ ( ) ] }"; //er korrekt
		String s2 = "{ [ ( ) }";   //er ikke korrekt. Mangler sluttparentes ]
		String s3 =	"[ ( ) ] }";   //er ikke korrekt. Mangler startparentes {
		String s4 = "{ [ ( ] ) }";  //er ikke korrekt. Sluttparentes ] kommer for tidlig.

		String s5 = """
			class HelloWorld {
			    public static void main(String[] args) {
			        System.out.println("Hello World!");
			    }
			} """; //er korrekt
		
		String s6 = "";
		String s7 = "()";
		
		//TODO Test om ParentesSjekkeren virker korrekt for eksemplene s1-s7 over.
		assertTrue(ParentesSjekker.sjekkParenteser(s1));
		
		assertFalse(ParentesSjekker.sjekkParenteser(s2));
		
		assertFalse(ParentesSjekker.sjekkParenteser(s3));
		
		assertFalse(ParentesSjekker.sjekkParenteser(s4));
		
		assertTrue(ParentesSjekker.sjekkParenteser(s5));
		
		assertTrue(ParentesSjekker.sjekkParenteser(s6));
		
		assertTrue(ParentesSjekker.sjekkParenteser(s7));
		
	}

}