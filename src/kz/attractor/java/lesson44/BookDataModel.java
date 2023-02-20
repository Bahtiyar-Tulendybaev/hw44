package kz.attractor.java.lesson44;

import java.util.ArrayList;
import java.util.List;



public class BookDataModel {
    private List<Book> books= new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public BookDataModel() {
            books.add(new Book("Celestial Bodies","Jokha Alharthi","Detective", "was taken by Peter Jackson"));
            books.add(new Book("Cheque book","Vasdev Mohi","Romantic", "was taken by Alex Smith"));
            books.add(new Book("The Overstory","TRichard Powers","History", "was taken by John Doe"));
            books.add(new Book("Viswanathan Anand and Susan Ninan","Mind-Master","MakeSelf", "was taken by Alex Smith"));
        }

}

