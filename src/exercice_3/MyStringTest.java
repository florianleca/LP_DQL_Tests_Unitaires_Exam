package exercice_3;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyStringTest {

//		Incrémentalement, pour (les accesseurs et) chaque fonctionnalité func<i> :
//		1. définir une méthode de test testFunc<i> dans la classe MyStringTest  (ce qui devrait aider à définir l'interface de la méthode func<i> à tester)
//		2. implémenter la méthode func<i> dans la classe MyString (de la façon la plus simple possible!)
//		3. tester
//		4. optimiser éventuellement l'implémentation de func<i> dans la classe MyString
//		5. revenir au point 3.
	
	private MyString ms;
	private MyString ms2;
	
	@Before
	public void setUp() throws Exception {
		ms = new MyString("azerty");
		ms2 = new MyString("A!z!E!r!T!y");
	}

	@After
	public void tearDown() throws Exception {
		ms = null;
		ms2 = null;
	}

	@Test
	public void testGetString() {
		assertEquals("azerty", ms.getString());
	}
	
	@Test
	public void testSetString() {
		ms.setString("qsdfgh");
		assertEquals("qsdfgh", ms.getString());
	}
	
	@Test
	public void testToUpperCaseWhenAllLowerCase() {
		ms.toUpperCase();
		assertEquals("AZERTY", ms.getString());
	}
	
	@Test
	public void testToUpperCaseWhenMixed() {
		ms2.toUpperCase();
		assertEquals("A!Z!E!R!T!Y", ms2.getString());
	}
	
	@Test
	public void testNumberOfChar() {
		assertEquals(5, ms2.numberOfChar('!'));
	}
	
	@Test
	public void testNumberOfCharNotHere() {
		assertEquals(0, ms.numberOfChar('!'));
	}
	
	@Test
	public void testNumberOfVoyelles() {
		assertEquals(2, ms.numberOfVoyelles());
		assertEquals(2, ms2.numberOfVoyelles());
	}
	
	@Test
	public void testNumberOfVoyellesWhenNone() {
		MyString noVoyelle = new MyString("cc mdr sv?");
		assertEquals(0, noVoyelle.numberOfVoyelles());
	}
	
	@Test
	public void testGetFirstWordOneWord() {
		assertEquals("azerty", ms.getFirstWord());
	}
	
	@Test
	public void testGetFirstWordSeveralWords() {
		MyString sentence = new MyString("Bonjour à tous !");
		assertEquals("Bonjour", sentence.getFirstWord());
	}

}
