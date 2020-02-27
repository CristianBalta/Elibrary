package ro.iteahome.eLibrary.dao;


import ro.iteahome.eLibrary.service.AuthorPopularBooks;

import java.io.*;
import java.util.*;


public class AuthorPopularBooksDao {

    private static final String LOANS_FILE = "/Users/cristianbalta/Desktop/team-project-elibrary/src/main/java/ro/iteahome/eLibrary/loans.txt";


    public Map<String, String> booksMap = new HashMap<>();
    public List<String[]> authorsListMap = new ArrayList<>();
    public List<String> bookList = new ArrayList<>();
    public String authorName;
    public String topBook;


    public AuthorPopularBooksDao(String authorname) {
        this.authorName = authorname;
    }


    public void computeTopAuthorBooks() throws IOException {


        FileReader reader = new FileReader(LOANS_FILE);
        BufferedReader br = new BufferedReader(reader);

        String line = null;

        while ((line = br.readLine()) != null) {


            String[] loanstringinfo = line.split("; ");

            String rawLoan = loanstringinfo[3];
            rawLoan = rawLoan.substring(1, rawLoan.length() - 1);

            String[] rawBook = rawLoan.split("], ");
            String[] rawBookA = rawBook;

            for (String rawBookAS : rawBookA) {
                rawBookAS = rawBookAS.substring(0, rawBookAS.lastIndexOf(":"));
                booksMap.put(rawBookAS, null);
                bookList.add(rawBookAS);

            }

            for (String rawBookS : rawBook) {
                if (rawBookS.lastIndexOf("]") == rawBookS.length() - 1) {
                    rawBookS = rawBookS.substring(0, rawBookS.length() - 1);
                }

                String rawBookS2 = rawBookS;
                rawBookS = rawBookS.substring(rawBookS.lastIndexOf("[") + 1);
                String[] almostAuthor = rawBookS.split(", ");
                rawBookS2 = rawBookS2.substring(0, rawBookS2.lastIndexOf(":"));


                String authorN = almostAuthor[0];

                if (almostAuthor.length > 1) {
                    for (int i = 1; i < almostAuthor.length; i++) {

                        authorN = authorN + ", " + almostAuthor[i];
                    }

                }
                booksMap.put(rawBookS2, authorN);
            }


        }

        br.close();



        for (String bookFromList : bookList) {

            String[] autDet = new String[2];
            autDet[0] = booksMap.get(bookFromList);
            autDet[1] = bookFromList;
            authorsListMap.add(autDet);

        }


        Map<String, Integer> authorPopularBookMap = new HashMap<>();


        for (String[] authors : authorsListMap) {
            if (authorName.equals(authors[0])) {
                if (authorPopularBookMap.containsKey(authors[1])) {
                    authorPopularBookMap.put(authors[1], authorPopularBookMap.get(authors[1]) + 1);
                } else
                    authorPopularBookMap.put(authors[1], 1);
            }
        }


        Map.Entry<String, Integer> maxEntry = null;


        for (Map.Entry<String, Integer> entry : authorPopularBookMap.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }


        topBook = maxEntry.getKey();


    }
}







