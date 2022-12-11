package exercice_1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StringBufferTest {
	
	private StringBuffer sb;

	@Before
	public void setUp() throws Exception {
		sb = new StringBuffer("Hello!");
	}

	@After
	public void tearDown() throws Exception {
		sb = null;
	}
	
	// charAt() method
	
	@Test
	public void testCharAt() {
		assertEquals('H', sb.charAt(0));
		assertEquals('!', sb.charAt(sb.length()-1));
	}
	
	@Test(expected = StringIndexOutOfBoundsException.class)
	public void testCharAtWithInvalidIndexesNegative() {
		sb.charAt(-1);
	}
	
	@Test(expected = StringIndexOutOfBoundsException.class)
	public void testCharAtWithInvalidIndexesEqualLength() {
		sb.charAt(sb.length());
	}
	
	@Test(expected = StringIndexOutOfBoundsException.class)
	public void testCharAtWithInvalidIndexesGreaterThanLength() {
		sb.charAt(sb.length()+1);
	}
	
	// setCharAt() method
	
	@Test
	public void testSetCharAtClassicUse() {
		sb.setCharAt(5, '?');
		assertSame(sb.charAt(5), '?');
	}
	
	@Test
	public void testSetCharAtDoesntChangeObject() {
		StringBuffer tempSb = sb;
		sb.setCharAt(0, sb.charAt(0));
		assertSame(tempSb, sb);
	}
	
	@Test(expected = StringIndexOutOfBoundsException.class)
	public void testSetCharAtOutOfBoundsNegative() {
		sb.setCharAt(-1, 'a');
	}
	
	@Test(expected = StringIndexOutOfBoundsException.class)
	public void testSetCharAtOutOfBoundsEqualToLength() {
		sb.setCharAt(sb.length(), 'a');
	}
	
	@Test(expected = StringIndexOutOfBoundsException.class)
	public void testSetCharAtOutOfBoundsGreaterThanLength() {
		sb.setCharAt(sb.length()+1, 'a');
	}
	
	// append(String str) method

	@Test
	public void testAppendLength(){
		String addedString = "Goodbye?";
		int previousLength = sb.length();
		sb.append(addedString);
		assertSame(previousLength + addedString.length(), sb.length());
	}
	
	@Test
	public void testAppendClassicUse(){
		sb.append("Goodbye?");
		assertEquals("Hello!Goodbye?", sb.toString());
	}
	
	@Test
	public void testAppendNothing(){
		StringBuffer temp = sb;
		sb.append("");
		assertEquals(temp, sb);
	}
	
	@Test
	public void testAppendWithNullString() {
		StringBuffer sbNull = null;
		sb.append(sbNull);
		assertEquals("Hello!null", sb.toString());
	}
}

