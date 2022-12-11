package exercice_2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyDateNextDayTest {
	
	/**
	 * Testing the non-static nextDay() method.
	 */
	@Test
	public void testNextDayNonStatic() {
		MyDate day = new MyDate(1,1,2000);
		MyDate nextDay = day.nextDay();
		assertEquals(2, nextDay.getDay());
		assertEquals(1, nextDay.getMonth());
		assertEquals(2000, nextDay.getYear());
	}
	
	/**
	 * Testing the static nextDay method in different cases.
	 */
	@Test
	public void testNextDayMiddleOfMonth() {
		MyDate nextDay = MyDate.nextDay(1,1,2000);
		assertEquals(2, nextDay.getDay());
		assertEquals(1, nextDay.getMonth());
		assertEquals(2000, nextDay.getYear());
	}
	
	@Test
	public void testNextDayEndOf30DaysMonth() {
		MyDate nextDay = MyDate.nextDay(30,4,2000);
		assertEquals(1, nextDay.getDay());
		assertEquals(5, nextDay.getMonth());
		assertEquals(2000, nextDay.getYear());
	}
	
	@Test
	public void testNextDayEndOf31DaysMonth() {
		MyDate nextDay = MyDate.nextDay(31,1,2000);
		assertEquals(1, nextDay.getDay());
		assertEquals(2, nextDay.getMonth());
		assertEquals(2000, nextDay.getYear());
	}
	
	@Test
	public void testNextDayEndOfFebruaryNonBissextile() {
		MyDate nextDay = MyDate.nextDay(28,2,1999);
		assertEquals(1, nextDay.getDay());
		assertEquals(3, nextDay.getMonth());
		assertEquals(1999, nextDay.getYear());
	}
	
	@Test
	public void testNextDayEndOfFebruaryBissextile() {
		MyDate nextDay = MyDate.nextDay(28,2,2000);
		assertEquals(29, nextDay.getDay());
		assertEquals(2, nextDay.getMonth());
		assertEquals(2000, nextDay.getYear());
	}
	
	@Test
	public void testNextDayEndOfYear() {
		MyDate nextDay = MyDate.nextDay(31,12,2000);
		assertEquals(1, nextDay.getDay());
		assertEquals(1, nextDay.getMonth());
		assertEquals(2001, nextDay.getYear());
	}
	
	/**
	 * Testing the Exception throw for an invalid date parameter.
	 * No need to test different cases of invalid dates because 
	 * the isValidDate() method is supposed to be fully tested.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testNextDateFromNonValidDay() {
		MyDate.nextDay(34,12,2000);
	}


}
