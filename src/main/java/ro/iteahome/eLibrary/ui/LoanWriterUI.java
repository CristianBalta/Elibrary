package ro.iteahome.eLibrary.ui;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import ro.iteahome.eLibrary.dao.LoanWriterDao;
import ro.iteahome.eLibrary.model.Author;
import ro.iteahome.eLibrary.model.Book;
import ro.iteahome.eLibrary.model.Loan;


public class LoanWriterUI {


    public LoanWriterUI() throws IOException {

        Loan loan = new Loan();
        loan.setLoanDate(new Date());


        Scanner s = new Scanner(System.in);

        System.out.println("What is the id of the reader?");
        loan.setUserId(s.nextInt());
        s.nextLine();
        System.out.println("How many books will be in this loan?");
        int numberOfBooks = s.nextInt();
        s.nextLine();

        List<Book> bookList = new ArrayList<>();

        for (
                int i = 0;
                i < numberOfBooks; i++) {
            Book book = new Book();

            System.out.println("What is the name of the book?");
            String bookName = s.nextLine();
            book.setName(bookName);

            System.out.println("How many authors does this book have?");
            int numberOfAuthors = s.nextInt();
            s.nextLine();
            List<Author> authors = new ArrayList<>();

            for (int j = 0; j < numberOfAuthors; j++) {
                Author author = new Author();
                System.out.println("What is the name of the author?");
                String authorName = s.nextLine();
                author.setName(authorName);
                authors.add(author);
            }
            book.setAuthorList(authors);
            bookList.add(book);
        }
        loan.setBookList(bookList);

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
        String strDate = dateFormat.format(loan.getLoanDate());

        LoanWriterDao loanui = new LoanWriterDao(loan.getUserId(), strDate, loan.getBookList());

        loanui.loanToFile();


    }


}
