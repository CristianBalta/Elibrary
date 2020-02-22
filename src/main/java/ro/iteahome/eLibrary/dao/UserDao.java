package ro.iteahome.eLibrary.dao;
import ro.iteahome.eLibrary.exception.LibraryFileException;
import ro.iteahome.eLibrary.exception.LibraryTechnicalException;
import ro.iteahome.eLibrary.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDao {

    private static final String USERS_FILE = "D:\\ITeaHome\\eLibrary\\src\\main\\java\\ro\\iteahome\\eLibrary\\users.txt";

    public List<User> readAllUsers() throws LibraryTechnicalException {
        List<User> userList = new ArrayList<>();
        Scanner scannerText=null;
        try {
            scannerText=new Scanner(new BufferedReader(new FileReader(USERS_FILE)));
            String userLine="";
            while(scannerText.hasNextLine()){
                userLine = scannerText.nextLine();
                String[] userValues = userLine.split(";");

                userList.add(new User(Integer.valueOf(userValues[0].trim()), userValues[1].trim(), userValues[2].trim(), userValues[3].trim(), Integer.parseInt(userValues[4].trim())));
            }
        } catch (IOException e) {
            throw new LibraryFileException("Error reading users", e);
        }
        return userList;
    }

    public void writeUserToFile(User user) throws LibraryTechnicalException {

        try (FileWriter fileWriter = new FileWriter(USERS_FILE, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.newLine();
            String userId = String.valueOf(user.getUserId());
            bufferedWriter.write(userId);
            bufferedWriter.write(";");
            bufferedWriter.write(user.getName());
            bufferedWriter.write(";");
            bufferedWriter.write(user.getEmail());
            bufferedWriter.write(";");
            bufferedWriter.write(user.getPassword());
            bufferedWriter.write(";");
            bufferedWriter.write(String.valueOf(user.getRole()));
            bufferedWriter.write(";");
        } catch (IOException e) {
            throw new LibraryFileException("Error writing user to file", e);
        }
    }
}
