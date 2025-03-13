/* este archivo representa el modelo del registro de los prestamos de libros */

package models;

public class Borrow {
    private Book book;
    private Patron patron;
    private String date;

    public Borrow(Book book, Patron patron, String date) {
        this.book = book;
        this.patron = patron;
        this.date = date;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Patron getPatron() {
        return patron;
    }

    public void setPatron(Patron patron) {
        this.patron = patron;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
