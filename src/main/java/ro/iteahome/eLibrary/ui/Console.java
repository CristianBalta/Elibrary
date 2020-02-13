package ro.iteahome.eLibrary.ui;

import ro.iteahome.eLibrary.dao.UserDao;
import ro.iteahome.eLibrary.exception.LibraryUserExistsAlready;
import ro.iteahome.eLibrary.service.Top5Books;
import ro.iteahome.eLibrary.exception.LibraryException;
import ro.iteahome.eLibrary.exception.LibraryTechnicalException;
import ro.iteahome.eLibrary.exception.LibraryWrongCredentialException;
import ro.iteahome.eLibrary.model.User;
import ro.iteahome.eLibrary.service.UserService;
import ro.iteahome.eLibrary.ui.userValidator.UserValidator;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Console {

    //private static final AtomicInteger count = new AtomicInteger(1);

    private UserDao userDao = new UserDao();
    private UserService userService = new UserService();
    private UserValidator userValidator = new UserValidator();

    public Scanner scanner = new Scanner(System.in).useDelimiter("\\n");

    public void displaySignUp() {
        System.out.println("SIGN UP");
        System.out.println("Enter the name :");
        String name = scanner.nextLine();
        System.out.println("Enter the email with which you want to register: ");
        String email = scanner.nextLine();
        System.out.println("Enter the password associated with the email: ");
        String password = scanner.nextLine();
        System.out.println("Enter role");
        int role = scanner.nextInt();


        try {
            //userValidator.validateUserCredentials(email, password);
           // User user2 = new User((userDao.readAllUsers().size())+1,name,email,password,role);
            //User user2 = new User(count.incrementAndGet(),name,email,password,role);
            User user2 = new User(0,name,email,password,role);
            //userValidator.validateUserCredentials(user2.getName(), user2.getPassword());
            userService.signUp(user2);
            System.out.println("User " + email +" is successfully registered now!!! ");
            System.out.println("...................................................");
            //System.out.println(user2.getUserId() + user2.getName() +user2.getEmail()+user2.getPassword()+user2.getRole());
        } catch (LibraryUserExistsAlready e){
            System.out.println("User already exists! ");
        } catch (LibraryWrongCredentialException e) {
            System.out.println("Invalid credentials ! ");
        } catch (LibraryTechnicalException e) {
            e.printStackTrace();
            System.out.println("A system error appeared. Please contact your administrator");
        } catch (LibraryException e) {
            e.printStackTrace();
        }
    }

    public void displayLogin() {
        System.out.println("LOG IN");
        System.out.println("Login Name: ");
        String name = scanner.nextLine();
        System.out.println("Login Password: ");
        String password = scanner.nextLine();

        User user = null;

        try {
            user = userService.login(name, password);
            System.out.println("User successfully logged in");
        } catch (LibraryWrongCredentialException e) {
            System.out.println("Wrong Credentials");
        } catch (LibraryTechnicalException e) {
           // e.printStackTrace();
            System.out.println("A system error appeared. Please contact your administrator; "+e.getMessage());
        } catch (LibraryException e) {
            e.printStackTrace();
        }


        if (user.isAdmin()) {
            showMenuAdmin();
        } else {
            showMenuReader();
        }

    }

    private void showMenuAdmin() {
        System.out.println();
        System.out.println("1. Top 5 books as per number of people who borrowed them ");
        System.out.println("2. The most read author");
        System.out.println("3. Given the author name, search for his most popular books");

        System.out.println("A4. The user who borrowed the most books in the last 6 months");
        System.out.println("A5. Add a loan to the list of borrowed books");
        System.out.println("A6. Given a user, show thh most common day of the week when he borrowed books");
        System.out.println("x. Exit");
        System.out.println();
        System.out.print("Choose an option: ");
        startConsole();
    }

    private void showMenuReader() {
        System.out.println();
        System.out.println("1. Top 5 books as per number of people who borrowed them ");
        System.out.println("2. The most read author");
        System.out.println("3. Given the author name, search for his most popular books");

        System.out.println("R4. User profile for the currently logged in user");
        System.out.println("x. Exit");
        System.out.println();
        System.out.print("Choose an option: ");
    }

    public void startConsole() {

        etichetaWhile:
        while (true) {
            //displayLogin();

            String optiune = scanner.next();
            switch (optiune) {
                case "1":
                    System.out.println("Ai ales optiunea 1");
                    new Top5Books().executa();
                    // in progress Top 5 books as per number of people who borrowed them
                    break;
                case "2":
                    // in progress The most read author
                    break;
                case "3":
                    // in progress Given the author name, search for his most popular books
                    break;
                case "A4":
                    // A4. The user who borrowed the most books in the last 6 months
                    break;
                case "A5":
                    // A5. Add a loan to the list of borrowed books
                    break;
                case "A6":
                    // A6. Given a user, show thh most common day of the week when he borrowed books
                    break;
                case "R4":
                    // R4. User profile for the currently logged in user
                    break;

                case "x":
                case "X":
                    break etichetaWhile;

                default:
                    System.out.println("Invalid option !");
                    break;

            }
        }
    }


}
