package exercice_2;

public class MyDate {

	private int _day;
	private int _month;
	private int _year;

	/**
	 *  	* Constructs a date.  
	 * 		* @param      day   the day.
	 *  	* @param      month   the month.  
	 * 		* @param      year   the year.  
	 */
	public MyDate(int day, int month, int year) {
		setDay(day);
		setMonth(month);
		setYear(year);
	}

	/**
	 *      * Determines if a given (day, month, year) represents a valid date.
	 *      * @param      day   the day.
	 *      * @param      month   the month.      
	 * 		* @param      year   the year.
	 *      * @return true if (day, month, year) represents a valid date, false else.
	 *      
	 */
	public static boolean isValidDate(int day, int month, int year) {
		return checkDay(day) && checkMonth(month) && checkYear(year) && checkDayLimits(day, month, year);
	}

	/**
	 *      * Determines if this object represents a valid date.
	 *      * @return true if this object represents a valid date, false else.      
	 */
	public boolean isValidDate() {
		return isValidDate(_day, _month, _year);
	}

	private static boolean checkDay(int day) {
		return day > 0 && day < 32;
	}
	
	private static boolean checkMonth(int month) {
		return month > 0 && month < 13;
	}
	
	// Conditions sur l'année fixées arbitrairement par l'énoncé.
	private static boolean checkYear(int year) {
		return year >= 1000 && year <= 3000;
	}
	
	private static boolean checkDayLimits(int day, int month, int year) {
		return day <= maxDayOfMonth(month, year);
	}
	
	/**
	 *      * Get the last day given a month and a year.
	 *      * @param      month   the month.      
	 * 		* @param      year   the year.
	 *      * @return the last day of (month, year), (should be 28, 29, 30 or 31)
	 *      
	 */
	
	// C1 : l'année est divisible par 4 sans être divisible par 100 (cas des années qui ne sont pas des multiples de 100) ;
    // C2 : l'année est divisible par 400 (cas des années multiples de 100).
	public static int maxDayOfMonth(int month, int year) {
		int result = 31;
		if (month == 2) {
			result = 28;
			if ( (year%4 == 0 && year%100 != 0) || (year%100 == 0 && year%400 == 0) ) {
				result = 29;
			}
		}
		if (month == 4 || month == 6 || month == 9 || month == 11)
			result = 30;
		return result;
	}

	public static int maxDayOfMonth(int month) throws IllegalArgumentException {
		if(month == 2) {
			throw new IllegalArgumentException("Year needed to tell maxDayOf February");
		}
		return maxDayOfMonth(month, 2000);
	}

	
	// nextDay() methods
	
	/**
	 *      * Updates the day, month and year) attributes of this object
	 *      * to the next day (tomorrow).      *       
	 * 		* @return this (my)date      
	 */
	public MyDate nextDay() throws IllegalArgumentException {
		if (!isValidDate()) {
			throw new IllegalArgumentException("Il faut partir d'une date valide");
		}
		MyDate nextDay = new MyDate(_day+1, _month, _year);
		if (!nextDay.isValidDate()) {
			nextDay.setDay(1);
			nextDay.setMonth(_month+1);
		}
		if (!nextDay.isValidDate()) {
			nextDay.setMonth(1);
			nextDay.setYear(_year+1);
		}
		return nextDay;
	}

	/**
	 *      * Allocates a <code>MyDate</code> object and initializes it to represent 
	 *      * the day (tomorrow) which follows the provided day, month and year.
	 *      *       * @param      day   the day.
	 *      *		* @param      month   the month.      
	 * 		*		* @param      year   the year.
	 *      * @return a (my)date object initialized to next day of (day, month, year)
	 *      
	 */
	public static MyDate nextDay(int day, int month, int year) {
		MyDate date = new MyDate(day, month, year);
		return date.nextDay();
	}

	
	// Getters & setters

	public int getDay() {
		return _day;
	}

	private void setDay(int jour) {
		this._day = jour;
	}

	public int getMonth() {
		return _month;
	}

	private void setMonth(int month) {
		this._month = month;
	}
	
	public int getYear() {
		return _year;
	}

	private void setYear(int year) {
		this._year = year;
	}
}
