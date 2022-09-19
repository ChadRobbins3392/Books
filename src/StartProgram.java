/**
 * @author chadrobbins - cerobbins@dmacc.edu
 * CIS 175 - Spring 2022
 * Sep 9, 2022
 */

/**
 * @author chadrobbins
 *
 */


import java.util.List;
import java.util.Scanner;

import Controller.ListBooksHelper;
import Model.ListBooks;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static ListBooksHelper lih = new ListBooksHelper();

		private static void addABook() {
			// TODO Auto-generated method stub
			System.out.print("Enter the title of the book: ");
			String title = in.nextLine();
			System.out.print("Enter the author of " + title + ": ");
			String author = in.nextLine();
			System.out.print("Enter the genre of " + title + ": ");
			String genre = in.nextLine();
			System.out.print("How many pages was " + title + ": ");
			int pageCount = in.nextInt();
			ListBooks toAdd = new ListBooks(title, author, genre, pageCount);
			lih.insertItem(toAdd);

		}

		private static void deleteABook() {
			// TODO Auto-generated method stub
			System.out.print("Enter the title of the book to remove from the shelf: ");
			String title = in.nextLine();
			System.out.print("Enter the author of " + title + ": ");
			String author = in.nextLine();
			System.out.print("Enter the genre of " + title + ": ");
			String genre = in.nextLine();
			System.out.print("How many pages was " + title + ": ");
			int pageCount = in.nextInt();
			ListBooks toDelete = new ListBooks(title, author, genre, pageCount);
			lih.removeBook(toDelete);

		}

		private static void editABook() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Title");
			System.out.println("2 : Search by Author");
			System.out.println("3 : Search by Genre");
			System.out.println("4 : Search by PageCount");
			int searchBy = in.nextInt();
			in.nextLine();
			
			List<ListBooks> foundBooks = null;
			
			if (searchBy == 1) {
				System.out.print("Enter the Title: ");
				String title = in.nextLine();
				foundBooks = lih.searchForItemByTitle(title);
				for(ListBooks singleBook : foundBooks) {
					System.out.println(singleBook.returnBookDetails());
				}
				
			} else if (searchBy == 2) {
				System.out.print("Enter the Author: ");
				String author = in.nextLine();
				foundBooks = lih.searchForItemByAuthor(author);
				for(ListBooks singleBook : foundBooks) {
					System.out.println(singleBook.returnBookDetails());
				}
				
			} else if (searchBy == 3) {
				System.out.print("Enter the Genre: ");
				String genre = in.nextLine();
				foundBooks = lih.searchForItemByGenre(genre);
				for(ListBooks singleBook : foundBooks) {
					System.out.println(singleBook.returnBookDetails());
				}
				
			} else if (searchBy == 4){
				System.out.print("Enter the PageCount: ");
				int pageCount = in.nextInt();
				foundBooks = lih.searchForItemByPageCount(pageCount);
				for(ListBooks singleBook : foundBooks) {
					System.out.println(singleBook.returnBookDetails());
				}
				
			} else {
				System.out.print("---Invalid Option----");
			}
			
			
			System.out.print("Enter the Book ID: ");
			int idToEdit = in.nextInt();
			
			ListBooks toEdit = lih.searchBookByID(idToEdit);;
			System.out.println("Retrieved " + toEdit.getName());
			System.out.println("1 : Update Title");
			System.out.println("2 : Update Author");
			System.out.println("3 : Update Genre");
			System.out.println("4 : Update Page Count");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Title: ");
				String newTitle = in.nextLine();
				toEdit.setName(newTitle);;
			} else if (update == 2) {
				System.out.print("New Author: ");
				String newAuthor = in.nextLine();
				toEdit.setAuthor(newAuthor);
			} else if (update == 3) {
				System.out.print("New Genre: ");
				String newGenre = in.nextLine();
				toEdit.setGenre(newGenre);
			} else if (update == 4) {
				System.out.print("New Page Count: ");
				int newPageCount = in.nextInt();
				toEdit.setPageCount(newPageCount);
			}

			lih.updateItem(toEdit);
			

			}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to my Bookshelf! ---");
			while (goAgain) {
				System.out.println("*  What would you like to do:");
				System.out.println("*  1 -- Add a book to the bookshelf");
				System.out.println("*  2 -- Edit an item");
				System.out.println("*  3 -- Remove a book");
				System.out.println("*  4 -- View the whole bookshelf");
				System.out.println("*  5 -- Exit");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addABook();
				} else if (selection == 2) {
					editABook();
				} else if (selection == 3) {
					deleteABook();
				} else if (selection == 4) {
					viewTheList();
				} else {
					lih.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			// TODO Auto-generated method stub
			List<ListBooks> allBooks = lih.showAllBooks();
			for(ListBooks singleBook : allBooks) {
				System.out.println(singleBook.returnBookDetails());
			}

		}

	}
