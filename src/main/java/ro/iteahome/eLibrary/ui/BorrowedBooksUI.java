package ro.iteahome.eLibrary.ui;

import ro.iteahome.eLibrary.dao.BorrowedBooksDao;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class BorrowedBooksUI {
    public int userid;

    public BorrowedBooksUI(int userid) throws IOException {
        this.userid = userid;
        BorrowedBooksDao borrowedBooksDao = new BorrowedBooksDao(userid);
        borrowedBooksDao.showBookList();
        System.out.println("The loan list for the user with the id "+userid+" is: \n");
        System.out.println(borrowedBooksDao.booksLoaned);
    }

}
