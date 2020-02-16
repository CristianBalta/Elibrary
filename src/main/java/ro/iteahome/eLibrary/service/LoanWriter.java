package ro.iteahome.eLibrary.service;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import ro.iteahome.eLibrary.model.Author;
import ro.iteahome.eLibrary.model.Book;
import ro.iteahome.eLibrary.model.Loan;


public class LoanWriter {

    private static final String LOANS_FILE = "/Users/cristianbalta/Desktop/team-project-elibrary/src/main/java/ro/iteahome/eLibrary/loans.txt";


    public LoanWriter() throws IOException {

        Loan loan = new Loan();
        loan.setLoanDate(new Date());

        Scanner s = new Scanner(System.in);

        int index = 0;
        String lastLineIndex = null;
        try (
                FileReader reader = new FileReader(LOANS_FILE);
                BufferedReader br = new BufferedReader(reader)) {
            String line = null;

            while ((line = br.readLine()) != null) {
                lastLineIndex = line.substring(0, 1);
            }


            index = Integer.parseInt(lastLineIndex);
        } catch (
                IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        loan.setLoanId(index + 1);

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

        try (
                FileWriter writer = new FileWriter(LOANS_FILE, true);
                BufferedWriter bw = new BufferedWriter(writer)) {


            DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
            String strDate = dateFormat.format(loan.getLoanDate());


            String loanToRegister = String.valueOf(loan.getLoanId()) + "; " + loan.getUserId() + "; " + strDate + "; " + loan.getBookList() + "\n";
            bw.write(loanToRegister);

        } catch (
                IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }




}
