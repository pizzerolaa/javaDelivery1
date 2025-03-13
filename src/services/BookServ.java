/* 
** Add Books: Librarians can add new books to the library's inventory by entering details 
    such as the title, author, ISBN, and the number of copies available.
** Remove Books: Allows the removal of books from the inventory if they are no longer available or needed.
** Display Books: Users can view a list of all books in the library, including their details,
    helping to keep track of the collection.
** Edit books: Users can edit the book, finding it first by ISBN, show the current values of the book
    and then allow the user enter new values for the book. */

package services;

import models.Book;
import exceptions.BookExcep;
import java.util.ArrayList;
import java.util.List;

public class BookServ {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String isbn) throws BookExcep {
        Book book = findBook(isbn);
        if (book == null) {
            throw new BookExcep("Book not found");
        }
        books.remove(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book findBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public void editBook(String isbn, String title, String author, int copies) throws BookExcep {
        Book book = findBook(isbn);
        if (book == null) {
            throw new BookExcep("Book not found");
        }
        book.setTitle(title);
        book.setAuthor(author);
        book.setCopies(copies);
    }

    public void displayBooks() {
        List<Book> bookList = getBooks();
        for (Book book : bookList) {
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("ISBN: " + book.getIsbn());
            System.out.println("Copies: " + book.getCopies());
            System.out.println();
        }
    }
}
