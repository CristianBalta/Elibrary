package ro.iteahome.eLibrary.dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class BookListDao {

    File path = new File("./src/main/java/ro/iteahome/eLibrary/books.txt");
    public List<String> bookList=new ArrayList<>();
    private int id;
    public String hasKey;
    public String author;
    public String bookname;

    public BookListDao() {

    }
    public  void showBookList() throws IOException{
        FileReader reader = new FileReader(path);
        BufferedReader br = new BufferedReader(reader);

        String line = null;

        while ((line = br.readLine()) != null) {


            String[] bookStringInfo = line.split(";");

           String concatenateString="Name: "+bookStringInfo[3]+"\n"+"Author: "+bookStringInfo[2]+"\n";
            System.out.println(concatenateString);
            bookList.add(concatenateString);

        }
        br.close();

    }
    public void addBook() throws IOException{
        FileReader reader = new FileReader(path);
        BufferedReader br = new BufferedReader(reader);

        String line = null;

        while ((line = br.readLine()) != null) {

            String[]bookStringInfo= line.split("; ");
            id=Integer.parseInt(bookStringInfo[0]);

        }
        br.close();
        FileWriter writer = new FileWriter(path, true);
        BufferedWriter bw = new BufferedWriter(writer);

        {

            String newBookInfo = String.valueOf(id + 1) + "; " + hasKey + "; " + author + "; " + bookname + "\n";

            bw.write(newBookInfo);

        }
        bw.close();

    }

}
