package ro.iteahome.eLibrary.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TopUserInSixMonthsDao {
   // private static final String LOANS_FILE = "C:\\Users\\Patrick\\IdeaProjects\\team-project-elibrary\\src\\main\\java\\ro\\iteahome\\eLibrary\\loans.txt";
    File pathLoans = new File("./src/main/java/ro/iteahome/eLibrary/loans.txt");
    File pathUsers = new File("./src/main/java/ro/iteahome/eLibrary/users.txt");
    public String idUserString;
    public String bookLoansString;
    public Calendar sixMonthsAgo=new GregorianCalendar();
    public Calendar loanDate;
    public String loanDateString;
    public Map<Integer,Integer> loansInfo = new HashMap<Integer,Integer>();
    public Date date;
    public int sum=0;
    public int idUser=0;
    public String topUser ;
    public int id=0;
    public String idString;

    public TopUserInSixMonthsDao(){

    }

    public void computeTopUserInSixMonths() throws IOException {
        FileReader reader = new FileReader(pathLoans);
        BufferedReader br = new BufferedReader(reader);

        String line = null;


        while ((line = br.readLine()) != null) {

            String[] stringInfo = line.split("; ", 4);
            idUserString = stringInfo[1];
            idUser = Integer.parseInt(idUserString);
            loanDateString = stringInfo[2];
            bookLoansString = stringInfo[3];

            SimpleDateFormat sfd = new SimpleDateFormat("dd-M-yyyy");
            String[] dateTokens = loanDateString.split("-");
            int year = Integer.parseInt(dateTokens[2]);
            int month = Integer.parseInt(dateTokens[1]);
            int day = Integer.parseInt(dateTokens[0]);
            loanDate = new GregorianCalendar(year,month-1,day);
            sixMonthsAgo.getInstance();
            sixMonthsAgo.add(Calendar.MONTH, -6);
            if (loanDate.after(sixMonthsAgo)) {
                String[] bookLoans = bookLoansString.split(":");
                if (loansInfo.containsKey(idUser)) {
                    loansInfo.put(idUser, loansInfo.get(idUser) +(bookLoans.length+1)/2);
                } else {
                    loansInfo.put(idUser,(bookLoans.length+1)/2);
                }

            }
            sixMonthsAgo.add(Calendar.MONTH,+6);
        }

        br.close();

        Map.Entry<Integer, Integer> maxEntry=null;
        for (Map.Entry<Integer, Integer> entry : loansInfo.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }

        id = maxEntry.getKey();
        idString=Integer.toString(id);


        FileReader reader1 = new FileReader(pathUsers);
        BufferedReader br1 = new BufferedReader(reader1);

        String line1 = null;


        while ((line1 = br1.readLine()) != null) {

            String[] stringInfo = line1.split("; ");
            if(idString.equals(stringInfo[0]))
            {
               topUser=stringInfo[1];
                break;
            }

        }
        br1.close();


    }
}

