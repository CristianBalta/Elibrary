package ro.iteahome.eLibrary.dao;


import java.io.*;
import java.util.*;


public class TopAuthorDao {

    //private static final String LOANS_FILE = "/Users/cristianbalta/Desktop/team-project-elibrary/src/main/java/ro/iteahome/eLibrary/loans.txt";
    File path = new File("./src/main/java/ro/iteahome/eLibrary/loans.txt");

    public ArrayList<String> topAuthorList = new ArrayList<>();



    public String topAuthor;

    public TopAuthorDao() {

    }


    public void computeTopAuthor() throws IOException {
        FileReader reader = new FileReader(path);
        BufferedReader br = new BufferedReader(reader);

        String line = null;

        while ((line = br.readLine()) != null) {


            String[] loanstringinfo = line.split("; ", 4);
            String rawLoan = loanstringinfo[3];
            rawLoan = rawLoan.substring(1, rawLoan.length() - 1);
            String[] rawBook = rawLoan.split("], ");

            for (String rawBookS : rawBook) {
                if (rawBookS.lastIndexOf("]") == rawBookS.length() - 1) {
                    rawBookS = rawBookS.substring(0, rawBookS.length() - 1);
                }
                rawBookS = rawBookS.substring(rawBookS.lastIndexOf("[") + 1);
                String[] almostAuthor = rawBookS.split(", ");
                for (String finalAuthor : almostAuthor) {
                    topAuthorList.add(finalAuthor);

                }

            }


        }

        br.close();

        Map<String, Integer> wordsMap = new HashMap<>();

        for (String bestAuthor : topAuthorList) {
            if (wordsMap.containsKey(bestAuthor)) {
                wordsMap.put(bestAuthor, wordsMap.get(bestAuthor) + 1);
            } else
                wordsMap.put(bestAuthor, 1);
        }

        Map.Entry<String, Integer> maxEntry = null;


        for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }

        topAuthor = maxEntry.getKey();

    }
}







