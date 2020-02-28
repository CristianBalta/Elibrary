package ro.iteahome.eLibrary.ui;

import java.io.IOException;
import java.util.Scanner;

public class MainUI {

    Console console = new Console();

    public void showTitle() {
        System.out.println("........eLibrary.......");
        System.out.println();
    }

    public void start() throws IOException {

        System.out.println("1.SignUp");
        System.out.println("2.LogIn");
        System.out.println("3.Exit");
        System.out.println();
        System.out.println("Choose an option:");

        Scanner scanner = new Scanner(System.in);

        // infinite loop
        for (; ; ) {
            String option = scanner.nextLine();

            if (option.equalsIgnoreCase("1")) {
                console.displaySignUp();
                break;
            }

            if (option.equalsIgnoreCase("2")) {
                console.displayLogin();
                break;
            }

            if (option.equalsIgnoreCase("3")) {
                break;
            } else {
                System.out.println("This option is invalid ! Choose a valid option (1 , 2 , 3) !");
            }

        }
    }
}
