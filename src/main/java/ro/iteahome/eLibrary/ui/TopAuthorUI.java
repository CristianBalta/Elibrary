package ro.iteahome.eLibrary.ui;

import ro.iteahome.eLibrary.dao.TopAuthorDao;

import java.io.IOException;

public class TopAuthorUI {

    public TopAuthorUI() throws IOException {

        TopAuthorDao topAuthorDao = new TopAuthorDao();
        topAuthorDao.computeTopAuthor();
        System.out.println("The most read author is: " + topAuthorDao.topAuthor);
    }
}
