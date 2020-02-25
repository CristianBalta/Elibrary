package ro.iteahome.eLibrary.dao;


import ro.iteahome.eLibrary.model.Loan;


import java.io.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class CommonDayDao {

    private static final String LOANS_FILE = "/Users/cristianbalta/Desktop/team-project-elibrary/src/main/java/ro/iteahome/eLibrary/loans.txt";


    public int useriddao = 0;
    public String dateread;
    public List<Loan> loanlistdao = new ArrayList<>();
    public Date date;
    int[] busyday = new int[7];
    public String theMostBusyDay;

    public CommonDayDao() {

    }

    public CommonDayDao(int useriddao, String dataread) throws FileNotFoundException, IOException {

        this.useriddao = useriddao;
        this.dateread = dataread;

    }

    public void computeCommonDay() throws IOException {
        FileReader reader = new FileReader(LOANS_FILE);
        BufferedReader br = new BufferedReader(reader);

        String line = null;

        while ((line = br.readLine()) != null) {

            String[] loanstringinfo = line.split("; ", 3);

            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YYYY");
            String dateInString = loanstringinfo[2];

            try {
                date = formatter.parse(dateInString);

            } catch (ParseException e) {
                e.printStackTrace();
            }

            Loan loaninfo = new Loan(Integer.parseInt(loanstringinfo[0]), Integer.parseInt(loanstringinfo[1]), date);
            loanlistdao.add(loaninfo);

        }

        br.close();


        for (Loan loaninfo : loanlistdao) {
            SimpleDateFormat simpleDateformat = new SimpleDateFormat("E");
            simpleDateformat = new SimpleDateFormat("EEEE"); // the day of the week spelled out completely
            String weekDay = simpleDateformat.format(loaninfo.getLoanDate());

            switch (weekDay) {
                case "Monday":
                    busyday[0]++;
                    break;
                case "Tuesday":
                    busyday[1]++;
                    break;
                case "Wednesday":
                    busyday[2]++;
                    break;
                case "Thursday":
                    busyday[3]++;
                    break;
                case "Friday":
                    busyday[4]++;
                    break;
                case "Saturady":
                    busyday[5]++;
                    break;
                case "Sunday":
                    busyday[6]++;
                    break;
                default:
                    break;

            }

            IntSummaryStatistics stat = Arrays.stream(busyday).summaryStatistics();
            int max = stat.getMin();

            for (int i = 0; i <= 6; i++) {
                if (busyday[i] == max)
                    max = i;
            }

            switch (max) {
                case 0:
                    theMostBusyDay = "Monday";
                    break;
                case 1:
                    theMostBusyDay = "Tuesday";
                    break;
                case 2:
                    theMostBusyDay = "Wednesday";
                    break;
                case 3:
                    theMostBusyDay = "Thursday";
                    break;
                case 4:
                    theMostBusyDay = "Friday";
                    break;
                case 5:
                    theMostBusyDay = "Saturday";
                    break;
                case 6:
                    theMostBusyDay = "Sunday";
                    break;
                default:
                    theMostBusyDay = "isn't one";
                    break;

            }


        }


    }


    private CharSequence toString(int useriddao) {
        return useriddao + "";
    }


}


