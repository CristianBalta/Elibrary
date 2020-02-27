package ro.iteahome.eLibrary.ui;

import ro.iteahome.eLibrary.dao.ReaderProfileDao;

import java.io.IOException;

public class ReaderProfileUI {
    public ReaderProfileUI() throws IOException {
        ReaderProfileDao readerProfileDao=new ReaderProfileDao();
        readerProfileDao.computeReaderProfile();

    }
}
