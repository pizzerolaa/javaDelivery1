/*
** Borrow Books: Patrons can borrow books from the library, and the system will track which 
books are currently checked out and which are available.
** Return Books: Patrons can return books they have borrowed, updating the inventory accordingly 
and allowing other patrons to borrow those books.
** Books per Patron: this option will show the number of current (borrowed-returned) books borrowed 
by Patron and which are those books. */

package services;

import models.Borrow;
import models.Book;
import models.Patron;
import exceptions.BorrowExcep;
import java.util.ArrayList;
import java.util.List;

public class BorrowServ {
    private List<Borrow> borrows = new ArrayList<>();

    public void borrowBook(Book book, Patron patron, String date) {
        borrows.add(new Borrow(book, patron, date));
    }

    public void returnBook(Book book, Patron patron) throws BorrowExcep {
        Borrow borrow = findBorrow(book, patron);
        if (borrow == null) {
            throw new BorrowExcep("Borrow not found");
        }
        borrows.remove(borrow);
    }

    public List<Borrow> getBorrows() {
        return borrows;
    }

    public Borrow findBorrow(Book book, Patron patron) {
        for (Borrow borrow : borrows) {
            if (borrow.getBook().equals(book) && borrow.getPatron().equals(patron)) {
                return borrow;
            }
        }
        return null;
    }

    public void viewBorrows() {
        List<Borrow> borrowList = getBorrows();
        for (Borrow borrow : borrowList) {
            System.out.println("Book: " + borrow.getBook().getTitle());
            System.out.println("Patron: " + borrow.getPatron().getName());
            System.out.println("Date: " + borrow.getDate());
            System.out.println();
        }
    }

    public void booksPerPatron(Patron patron) {
        List<Borrow> borrowList = getBorrows();
        int count = 0;
        for (Borrow borrow : borrowList) {
            if (borrow.getPatron().equals(patron)) {
                count++;
                System.out.println("Book: " + borrow.getBook().getTitle());
            }
        }
        System.out.println("Total books borrowed: " + count);
    }

}
