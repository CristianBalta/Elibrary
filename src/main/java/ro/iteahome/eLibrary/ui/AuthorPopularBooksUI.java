package ro.iteahome.eLibrary.ui;

import ro.iteahome.eLibrary.dao.AuthorPopularBooksDao;
import ro.iteahome.eLibrary.dao.CommonDayDao;

import java.io.IOException;
import java.util.Scanner;

public class AuthorPopularBooksUI {


    public AuthorPopularBooksUI() throws IOException {


        Scanner s = new Scanner(System.in);

        System.out.println("What is the name of the author?");

        String authorname = s.nextLine();
        AuthorPopularBooksDao authorPopularBooksDao = new AuthorPopularBooksDao(authorname);
        authorPopularBooksDao.computeTopAuthorBooks();
        System.out.println("The the top book for " + authorname + " is " + authorPopularBooksDao.topBook + "!");


    }

}
