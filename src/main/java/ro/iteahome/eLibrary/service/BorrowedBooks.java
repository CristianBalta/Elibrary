package ro.iteahome.eLibrary.service;

import ro.iteahome.eLibrary.ui.BorrowedBooksUI;

import java.io.IOException;

public class BorrowedBooks {
    public int userid;
    public BorrowedBooks(int userid) throws IOException {
        this.userid = userid;
        BorrowedBooksUI borrowedBooksUI = new BorrowedBooksUI(userid);

    }
}
