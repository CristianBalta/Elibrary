package ro.iteahome.eLibrary.service;

import ro.iteahome.eLibrary.dao.LoanWriterDao;


import java.io.IOException;


public class LoanWriter {


    LoanWriterDao loandaoui;

    public LoanWriter(LoanWriterDao loandaoui) throws IOException {
        this.loandaoui = loandaoui;
        this.loandaoui.loanToFile();


    }


}