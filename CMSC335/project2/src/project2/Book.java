/**
 * Author: Justin Smith
 * Course: CMSC335.6380
 * Date: Jun 25, 2010
 * Project: Project 2
 * File: Book.java
 * Development Environment:  Apple Mac OS X 10.6.4
 *                           Eclipse 3.6 / Java 1.6.0_20
 */
package project2;

import java.util.ArrayList;
import java.util.List;

public class Book implements BookInterface {
	
	private Title title;
	
	private int numberOfBooks,
				remainingBooks;
	
	private List<Borrower> borrowersList = new ArrayList<Borrower>();
	
	public Book(String a, String t, String i) {
		title = new Title(a, t, i);
	}

	public String[] getBookInfo(String isbn) {
		String[] str = new String[3];
		str[0] = title.getAuthor();
		str[1] = title.getTitle();
		str[2] = title.getISBN();
		return str;
	}

	public String getISBN() {
		return title.getISBN();
	}
	
	public String getAuthor() {
		return title.getAuthor();
	}
	
	public String getTitle() {
		return title.getTitle();
	}
	
	public int getNumberOfBooks() {
		return this.numberOfBooks;
	}

	public int getRemainingBooks() {
		return this.remainingBooks;
	}

	public void setNumberOfBooks(int i) {
		this.numberOfBooks = i;
	}

	public void setRemainingBooks(int i) {
		this.remainingBooks = i;
	}
	
	public boolean hasBorrowers() {
		if(this.borrowersList.size() > 0)
			return true;
		
		return false;
	}

	public boolean borrowBook(String n, int days) {
		if(getRemainingBooks() > 0) {
			Borrower client = new Borrower(n, days);
			this.borrowersList.add(client);
			this.remainingBooks--;
			return true;
		}	
		return false;
	}
	
	public ArrayList<String> getBorrowers() {
		ArrayList<String> arrl = new ArrayList<String>();
		for(Borrower b : borrowersList) {
			arrl.add(b.getClientName());
		}
		return arrl;
	}
	
	public boolean returnBook(int i) {
		if(i < borrowersList.size()) {
			this.borrowersList.remove(i);
			this.remainingBooks++;
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		return(getAuthor()+":"+getTitle()+":"+getRemainingBooks()+":"+getNumberOfBooks()+":"+getISBN());
	}
	
	public void debugBorrowersList() {
		System.out.println("Borrowers List for UID: "+getISBN());
		for(Borrower b : this.borrowersList) {
			System.out.println(b.toString());
		}
	}
}