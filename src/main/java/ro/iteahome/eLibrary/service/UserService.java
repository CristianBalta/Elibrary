package ro.iteahome.eLibrary.service;

import ro.iteahome.eLibrary.dao.UserDao;
import ro.iteahome.eLibrary.exception.LibraryException;
import ro.iteahome.eLibrary.exception.LibraryUserExistsAlready;
import ro.iteahome.eLibrary.exception.LibraryWrongCredentialException;
import ro.iteahome.eLibrary.model.User;

public class UserService {

    private UserDao userDao = new UserDao();

    public User login(String inputName, String inputPassword) throws LibraryException {
        for (User user: userDao.readAllUsers()) {
            if (inputName.equals(user.getName()) && inputPassword.equals(user.getPassword())) {
                return user;
            }
        }

        throw new LibraryWrongCredentialException();
    }

    public void signUp(User addedUser) throws LibraryException {

        boolean userExists = false;
        for (User user : userDao.readAllUsers()) {
            if (addedUser.getEmail().equalsIgnoreCase(user.getEmail())) {
                userExists = true;
                throw new LibraryUserExistsAlready();
            }
        }

        if (!userExists) {
            userDao.writeUserToFile(addedUser);
        }
    }
}
