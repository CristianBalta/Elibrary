package ro.iteahome.eLibrary.model;

import java.util.List;

public class Book {
    private int BookId;
    private String name;
    private List<Author> authorList;
    private int numberOf;

    public Book(int bookId, String name, List<Author> authorList, int numberOf) {
        BookId = bookId;
        this.name = name;
        this.authorList = authorList;
        this.numberOf = numberOf;
    }

    public Book() {

    }

    public int getBookId() {
        return BookId;
    }

    public void setBookId(int bookId) {
        BookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    public int getNumberOf() {
        return numberOf;
    }

    public void setNumberOf(int numberOf) {
        this.numberOf = numberOf;
    }
}