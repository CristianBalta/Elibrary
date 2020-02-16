package ro.iteahome.eLibrary;


import ro.iteahome.eLibrary.service.LoanWriter;
import ro.iteahome.eLibrary.ui.MainUI;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {

        LoanWriter loanWriter = new LoanWriter(); //unde initializam clasa LoanWriter acolo va incepe un UI care in fucntie de detaliile introduse va creea un imprumut

        MainUI mainUI = new MainUI();
        mainUI.showTitle();
        mainUI.start();

    }
}
