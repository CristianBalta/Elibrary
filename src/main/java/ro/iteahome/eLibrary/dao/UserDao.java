package ro.iteahome.eLibrary.dao;
import ro.iteahome.eLibrary.exception.LibraryFileException;
import ro.iteahome.eLibrary.exception.LibraryTechnicalException;
import ro.iteahome.eLibrary.model.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private static final String USERS_FILE = "D:\\ITeaHome\\eLibrary\\src\\main\\java\\ro\\iteahome\\eLibrary\\users.txt";

    public List<User> readAllUsers() throws LibraryTechnicalException {
        List<User> userList = new ArrayList<>();
        try (BufferedReader userReader = new BufferedReader(new FileReader(USERS_FILE))) {
            String userLine = userReader.readLine();
            String[] userValues = userLine.split(";");

            userList.add(new User(userValues[0], userValues[1], userValues[2], userValues[3], userValues[4]));
        } catch (IOException e) {
            throw new LibraryFileException("Error reading users", e);
        }

        return userList;
    }
}
