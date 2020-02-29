package ro.iteahome.eLibrary.model;

import ro.iteahome.eLibrary.dao.LoanWriterDao;
import ro.iteahome.eLibrary.service.*;
import ro.iteahome.eLibrary.ui.LoanWriterUI;

import java.io.IOException;
import java.util.Scanner;

public class Admin extends Role {

    public Admin(int roleId) {
        super(roleId);
    }


    @Override
    public void topFiveBooks() throws IOException {
        TopFiveBooks topFiveBooks = new TopFiveBooks();
    }

    @Override
    public void topAuthor() throws IOException {
        TopAuthor topAuthor = new TopAuthor();
    }

    @Override
    public void authorPoplarBooks() throws IOException {
        AuthorPopularBooks authorPopularBooks = new AuthorPopularBooks();

    }


    public void mostCommonDay(int userid){}
    public void topUserInSixMonths() throws IOException {
        TopUserInSixMonths topUserInSixMonth = new TopUserInSixMonths();

    }
    public void loanWriter() throws IOException {
        LoanWriterUI loanWriterUI = new LoanWriterUI();
    }
    public void commonDay() throws IOException {
        CommonDay commonDay = new CommonDay();
    }
    public void borrowedBooks() throws IOException {

        Scanner s = new Scanner(System.in);

        System.out.println("What is the id of the user?");
        int userid = s.nextInt();
        s.nextLine();
        BorrowedBooks borrowedBooks = new BorrowedBooks(userid);
    }

}