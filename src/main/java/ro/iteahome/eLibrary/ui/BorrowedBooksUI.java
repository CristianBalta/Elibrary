package ro.iteahome.eLibrary.ui;

import ro.iteahome.eLibrary.dao.BorrowedBooksDao;

import java.io.IOException;


public class BorrowedBooksUI {
    public int userid;

    public BorrowedBooksUI(int userid) throws IOException {
        this.userid = userid;
        BorrowedBooksDao borrowedBooksDao = new BorrowedBooksDao(userid);
        borrowedBooksDao.showBookList();
        System.out.println("The loan list for the user with the id "+userid+" is: \n");
        String books = String.valueOf(borrowedBooksDao.booksLoaned);
        System.out.println(books.substring(1,books.length()-1));
    }

}
