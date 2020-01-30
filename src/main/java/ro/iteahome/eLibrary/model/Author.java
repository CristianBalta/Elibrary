package ro.iteahome.eLibrary.model;

import java.util.List;

public class Author {
    private int authorId;
    private String name;
    private List<Book> bookList;

    public Author(int authorId, String name, List<Book> bookList) {
        this.authorId = authorId;
        this.name = name;
        this.bookList = bookList;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
