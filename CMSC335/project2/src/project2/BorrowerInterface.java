/**
 * Author: Justin Smith
 * Course: CMSC335.6380
 * Date: Jul 10, 2010
 * Project: Project 2
 * File: BorrowerInterface.java
 * Development Environment:  Apple Mac OS X 10.6.4
 *                           Eclipse 3.6 / Java 1.6.0_20
 */
package project2;

import java.util.Calendar;

public interface BorrowerInterface {
	// Getters
	public String 		getClientName();
	public Calendar		getBorrowDate();
	public Calendar		getDueDate();
	public long			getLongDueDate();
	public long			getLongBorrowDate();
	public long			getID();
	public String		toString();
}
