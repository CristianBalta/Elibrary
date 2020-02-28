package ro.iteahome.eLibrary.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static java.util.Comparator.reverseOrder;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;



public class TopFiveBooksDao {

    File path = new File("./src/main/java/ro/iteahome/eLibrary/loans.txt");


    public Map<String, String> booksMap = new HashMap<>();
    public List<String> bookList = new ArrayList<>();
    public List<String> resultList = new ArrayList<>();


    public TopFiveBooksDao() {

    }


    public void computeTopAuthorBooks() throws IOException {


        FileReader reader = new FileReader(path);
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

        }

        List<String> result =
                bookList.stream()
                        .map(String::toLowerCase)
                        .collect(groupingBy(identity(), counting()))
                        .entrySet().stream()
                        .sorted(Map.Entry.<String, Long>comparingByValue(reverseOrder()).thenComparing(Map.Entry.comparingByKey()))
                        .limit(5)
                        .map(Map.Entry::getKey)
                        .collect(toList());
        resultList = result;

    }
}