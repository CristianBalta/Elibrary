package ro.iteahome.eLibrary;

import ro.iteahome.eLibrary.ui.MainUI;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {

       // LoanWriterUI loanWriterUI = new LoanWriterUI(); //doar de test aici! unde o sa creeam un obiect de tip LoanWriter, CommonDay sau TopAuthor,
        // acolo putem initializa loan-ul deci o sa fie o optiune a adminuli mai incolo

        // CommonDay commonDay = new CommonDay();
       // TopAuthor topAuthor = new TopAuthor();
       // TopUserInSixMonthsUI topUserInSixMonthsUI  =new TopUserInSixMonthsUI();
        MainUI mainUI = new MainUI();
        mainUI.showTitle();
        mainUI.start();

    }
}
