package ro.iteahome.eLibrary.dao;

import ro.iteahome.eLibrary.ui.Console;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderProfileDao {

    private String name;
    public static String id;
    public static String nameReader;
    public static String email;
    private static final String userFile = "C:\\Users\\Patrick\\IdeaProjects\\team-project-elibrary\\src\\main\\java\\ro\\iteahome\\eLibrary\\users.txt";
    public ReaderProfileDao() {
    }
    public void computeReaderProfile()throws IOException{
        name =Console.name;
        FileReader reader = new FileReader(userFile);
        BufferedReader br = new BufferedReader(reader);

        String line = null;


        while ((line = br.readLine()) != null) {

            String[] stringInfo = line.split("; ");
                        if(name.equals(stringInfo[1]))
            {
                System.out.println("Reader ID is: "+stringInfo[0]+"\n");
                System.out.println("Reader name is: "+stringInfo[1]+"\n");
                System.out.println("Reader email is: "+stringInfo[3]+"\n");
                break;
            }

        }

        br.close();

    }

}
