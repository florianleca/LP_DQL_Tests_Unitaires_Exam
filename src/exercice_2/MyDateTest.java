package exercice_2;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MyDateTest {

	MyDate md;
	
	@Before
	public void setUp() {
		md = new MyDate(31, 12, 2006);
	}

	@After
	public void tearDown() {
		md = null;
	}

	/**
     * Test getters methods 
     */
	@Test
	public void testGetters() {
		assertEquals(31, md.getDay());
		assertEquals(12, md.getMonth());
		assertEquals(2006, md.getYear());
	}
	
	/**
	 * Test non-static isValidDate method 
     */
	@Test
	public void testIsValidDate() {
		assertTrue(md.isValidDate());
	}

	/**
	 * Test simple valid dates (a1)
     */
	@Test
	public void testSimpleValidDates() {
		assertTrue(MyDate.isValidDate(1, 1, 2000));
		assertTrue(MyDate.isValidDate(31, 12, 2000));
	}

	/**
     * Test simple invalid dates (b1, b2, b3, b4, b5, b6)
     */
	@Test
	public void testSimpleInvalidDates() {
		assertFalse(MyDate.isValidDate(0, 1, 2000));
		assertFalse(MyDate.isValidDate(32, 1, 2000));
		assertFalse(MyDate.isValidDate(1, 0, 2000));
		assertFalse(MyDate.isValidDate(1, 13, 2000));
		assertFalse(MyDate.isValidDate(1, 1, 999));
		assertFalse(MyDate.isValidDate(1, 1, 3001));
	}

	/**
     * Test valid for 31 days months
     */
	@Test
	public void testValidLimitDates() {
		assertTrue(MyDate.isValidDate(31, 1, 2000));
		assertTrue(MyDate.isValidDate(31, 3, 2000));
		assertTrue(MyDate.isValidDate(31, 5, 2000));
		assertTrue(MyDate.isValidDate(31, 7, 2000));
		assertTrue(MyDate.isValidDate(31, 8, 2000));
		assertTrue(MyDate.isValidDate(31, 10, 2000));
		assertTrue(MyDate.isValidDate(31, 12, 2000));
	}

	/**
     * Test invalid for 31 days months
     */
	@Test
	public void testInvalidLimitDates() {
		assertFalse(MyDate.isValidDate(31, 2, 2000));
		assertFalse(MyDate.isValidDate(31, 4, 2000));
		assertFalse(MyDate.isValidDate(31, 6, 2000));
		assertFalse(MyDate.isValidDate(31, 9, 2000));
		assertFalse(MyDate.isValidDate(31, 11, 2000));
	}

	/**
     * Test February valid limit dates (a3, a4)
     */
	@Test
	public void testFebruaryValidLimitDates() {
		assertTrue(MyDate.isValidDate(28, 2, 1999));
		assertTrue(MyDate.isValidDate(29, 2, 2000)); // (year%100 == 0 && year%400 == 0)
		assertTrue(MyDate.isValidDate(29, 2, 2004)); // (year%4 == 0 && year%100 != 0)


	}

	/**
     * Test February invalid limit dates (b8, b9)
     */
	@Test
	public void testFebruaryInvalidLimitDates() {
		assertFalse(MyDate.isValidDate(29, 2, 1999));
		assertFalse(MyDate.isValidDate(29, 2, 2100));
		assertFalse(MyDate.isValidDate(30, 2, 2000));

	}
	
	/**
	 * Test maxDayOfMonth static method with one parameter only
	 */
	@Test
	public void testMaxDayOfMonthOneParameter() {
		assertEquals(31, MyDate.maxDayOfMonth(1));
	}
	
	/**
	 * Test maxDayOfMonth static method exception when only giving February as parameter
	 */
	
	@Test (expected = IllegalArgumentException.class)
	public void testMaxDayOfMonthOneParameterException() throws IllegalArgumentException{
		MyDate.maxDayOfMonth(2);
	}
	
	

	
}
