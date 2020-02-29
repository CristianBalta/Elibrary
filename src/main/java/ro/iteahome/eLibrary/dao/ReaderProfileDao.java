package ro.iteahome.eLibrary.dao;

import ro.iteahome.eLibrary.service.BorrowedBooks;
import ro.iteahome.eLibrary.ui.Console;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReaderProfileDao {

    private String name;
    public static String id;
    public static String nameReader;
    public static String email;

    File path = new File("./src/main/java/ro/iteahome/eLibrary/users.txt");
    public ReaderProfileDao() {
    }
    public void computeReaderProfile()throws IOException{
        name =Console.name;
        FileReader reader = new FileReader(path);
        BufferedReader br = new BufferedReader(reader);

        String line = null;


        while ((line = br.readLine()) != null) {

            String[] stringInfo = line.split(";");
                        if(name.equals(stringInfo[1]))
            {
                System.out.println();
                System.out.println("Reader ID is: "+stringInfo[0]+"\n");
                System.out.println("Reader name is: "+stringInfo[1]+"\n");
                System.out.println("Reader email is: "+stringInfo[3]+"\n");
                BorrowedBooks borrowedBooks = new BorrowedBooks(Integer.parseInt(stringInfo[0]));
                break;
            }

        }

        br.close();
    }

}
