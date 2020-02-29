package ro.iteahome.eLibrary.dao;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BorrowedBooksDao {


    File path = new File("./src/main/java/ro/iteahome/eLibrary/loans.txt");

    public int userid;
    public List<String> booksLoaned = new ArrayList<>();

    public BorrowedBooksDao(int userid) {
        this.userid = userid;

    }

    public void showBookList() throws IOException {

        FileReader reader = new FileReader(path);
        BufferedReader br = new BufferedReader(reader);

        String line = null;

        while ((line = br.readLine()) != null) {


            String[] loanstringinfo = line.split("; ");

            String rawLoan = loanstringinfo[3];

            if (Integer.parseInt(loanstringinfo[1]) == userid) {
                rawLoan = rawLoan.substring(1, rawLoan.length() - 1);

                booksLoaned.add(rawLoan);
            }

        }

        br.close();

    }

}
