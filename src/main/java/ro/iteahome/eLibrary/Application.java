package ro.iteahome.eLibrary;


import ro.iteahome.eLibrary.service.TopAuthor;
import ro.iteahome.eLibrary.service.TopFiveBooks;
import ro.iteahome.eLibrary.ui.MainUI;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {

        MainUI mainUI = new MainUI();
        mainUI.showTitle();
        mainUI.start();

    }
}
