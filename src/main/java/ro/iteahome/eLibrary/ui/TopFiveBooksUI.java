package ro.iteahome.eLibrary.ui;

import ro.iteahome.eLibrary.dao.TopFiveBooksDao;

import java.io.IOException;

public class TopFiveBooksUI {

    public TopFiveBooksUI() throws IOException {
        TopFiveBooksDao topBooks = new TopFiveBooksDao();
        topBooks.computeTopAuthorBooks();

        String f = topBooks.resultList.get(0);
        String f1 = topBooks.resultList.get(1);
        String f2 = topBooks.resultList.get(2);
        String f3 = topBooks.resultList.get(3);
        String f4 = topBooks.resultList.get(4);

        System.out.println("\tThe top five books are: ");
        System.out.println("The most read book is: " + f);
        System.out.println("The second most read book is: " + f1);
        System.out.println("The third most read book is: " + f2);
        System.out.println("The fourth most read book is: " + f3);
        System.out.println("The fifth most read book is: " + f4);


    }
}
