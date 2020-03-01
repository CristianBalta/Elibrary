package ro.iteahome.eLibrary.ui;

import ro.iteahome.eLibrary.dao.UserDao;
import ro.iteahome.eLibrary.exception.LibraryException;
import ro.iteahome.eLibrary.exception.LibraryTechnicalException;
import ro.iteahome.eLibrary.exception.LibraryUserExistsAlready;
import ro.iteahome.eLibrary.exception.LibraryWrongCredentialException;
import ro.iteahome.eLibrary.model.Admin;
import ro.iteahome.eLibrary.model.Reader;
import ro.iteahome.eLibrary.model.User;
import ro.iteahome.eLibrary.service.*;
import ro.iteahome.eLibrary.ui.userValidator.UserValidator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Console {


    private UserDao userDao = new UserDao();
    private UserService userService = new UserService();
    private UserValidator userValidator = new UserValidator();
    public static String name;
    public User user1 = null;
    public Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
    File path = new File("./src/main/java/ro/iteahome/eLibrary/users.txt");
    public int userId;


    public void displaySignUp() throws IOException {
        System.out.println("SIGN UP");
        System.out.println("Enter the name :");
        String name = scanner.nextLine();
        System.out.println("Enter the email with which you want to register: ");
        String email = scanner.nextLine();
        System.out.println("Enter the password associated with the email: ");
        String password = scanner.nextLine();
        System.out.println("Enter role(1 for Admin/ 2 for User)");
        int role = scanner.nextInt();


        String lastLineIndex = null;

        FileReader reader = new FileReader(path);
        BufferedReader br = new BufferedReader(reader);

        {
            String line = null;

            while ((line = br.readLine()) != null) {
                lastLineIndex = line.split(";")[0];            }


            userId = Integer.parseInt(lastLineIndex) + 1;
        }
        br.close();




        try {


            //  userValidator.validateUserCredentials(email, password);



            User user2 = new User(userId, name, email, password, role);



            userService.signUp(user2);
            System.out.println("User " + email + " is successfully registered now!!! ");
            System.out.println("...................................................");
            MainUI mainUI = new MainUI();
            mainUI.showTitle();
            mainUI.start();

        } catch (LibraryUserExistsAlready e) {
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

    public void displayLogin() throws IOException {
        System.out.println("LOG IN");
        System.out.println("Login Name: ");
        name = scanner.nextLine();
        System.out.println("Login Password: ");
        String password = scanner.nextLine();

        User user = null;


        try {
            user = userService.login(name, password);
            System.out.println("User successfully logged in");
        } catch (LibraryWrongCredentialException e) {
            System.out.println("Wrong Credentials");
        } catch (LibraryTechnicalException e) {
            System.out.println("A system error appeared. Please contact your administrator; " + e.getMessage());
        } catch (LibraryException e) {
            e.printStackTrace();
        }

        user1 = user;

        if (user.isAdmin()) {
            showMenuAdmin();
        } else {
            showMenuReader();
        }

    }

    private void showMenuAdmin() throws IOException {
        System.out.println();
        System.out.println("Choose the desired action!");
        System.out.println();

        System.out.println("1. Top 5 books as per number of people who borrowed them.");
        System.out.println("2. The most read author.");
        System.out.println("3. Given the author name, search for his most popular books.");
        System.out.println("4. Show books list.");

        System.out.println("A4. The user which borrowed the most books in the last 6 months.");
        System.out.println("A5. Add a loan to the list of borrowed books.");
        System.out.println("A6. Given a user, show the most common day of the week when he borrowed books.");
        System.out.println("A7. Given a user, show the loans list for that user.");
        System.out.println("M. Menu");
        System.out.println();
        System.out.print("Choose an option: ");
        startConsole();
    }

    private void showMenuReader() throws IOException {
        System.out.println();
        System.out.println("Choose the desired action!");
        System.out.println();
        System.out.println("1. Top 5 books as per number of people who borrowed them.");
        System.out.println("2. The most read author.");
        System.out.println("3. Given the author name, search for his most popular books.");
        System.out.println("4. Show book list.");

        System.out.println("R4. User profile for the currently logged in user.");
        System.out.println("M. Menu");
        System.out.println();
        System.out.print("Choose an option: ");
        startConsole();
    }

    public void startConsole() throws IOException {

        etichetaWhile:
        while (true) {
            //displayLogin();




            String optiune = scanner.next();

            switch (optiune) {
                case "1":

                    if (user1.isAdmin()) {
                        Admin admin = new Admin(1);
                        admin.topFiveBooks();
                    } else {
                        Reader reader = new Reader(2);
                        reader.topFiveBooks();
                    }

                    if (user1.isAdmin()) {
                        showMenuAdmin();
                    } else {
                        showMenuReader();
                    }


                    break;
                case "2":

                    if (user1.isAdmin()) {
                        Admin admin = new Admin(1);
                        admin.topAuthor();
                    } else {
                        Reader reader = new Reader(2);
                        reader.topAuthor();
                    }


                    if (user1.isAdmin()) {
                        showMenuAdmin();
                    } else {
                        showMenuReader();
                    }
                    break;
                case "3":
                    if (user1.isAdmin()) {
                        Admin admin = new Admin(1);
                        admin.authorPoplarBooks();
                    } else {
                        Reader reader = new Reader(2);
                        reader.authorPoplarBooks();
                    }
                    if (user1.isAdmin()) {
                        showMenuAdmin();
                    } else {
                        showMenuReader();
                    }

                    break;
                case "4":
                    // in progress Given the author name, search for his most popular books
                    BookList bookList = new BookList();
                    if (user1.isAdmin()) {
                        showMenuAdmin();
                    } else {
                        showMenuReader();
                    }

                    break;
                case "A4":

                    Admin admin = new Admin(1);
                    admin.topUserInSixMonths();
                    showMenuAdmin();

                    break;
                case "A5":
                    Admin admin1 = new Admin(1);
                    admin1.loanWriter();
                    showMenuAdmin();

                    break;
                case "A6":
                    Admin admin2 = new Admin(1);
                    admin2.commonDay();
                    showMenuAdmin();

                    break;
                    case "A7":
                    Admin admin3 = new Admin(1);
                    admin3.borrowedBooks();
                    showMenuAdmin();

                    break;
                case "R4":
                    Reader reader1 = new Reader(2);
                    reader1.readerProfile();
                    showMenuReader();

                    break;

                case "M": MainUI mainUI = new MainUI();
                    mainUI.showTitle();
                mainUI.start();break;
                case "X": break etichetaWhile;



                default:
                    System.out.println("Invalid option !");
                    break;

            }
        }
    }


}