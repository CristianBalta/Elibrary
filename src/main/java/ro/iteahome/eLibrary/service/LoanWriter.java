package ro.iteahome.eLibrary.service;

import ro.iteahome.eLibrary.dao.LoanDao;


import java.io.IOException;


public class LoanWriter {


    LoanDao loandaoui;

    public LoanWriter(LoanDao loandaoui) throws IOException {
        this.loandaoui = loandaoui;
        this.loandaoui.loanToFile();


    }


}