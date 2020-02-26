package ro.iteahome.eLibrary.ui;

import ro.iteahome.eLibrary.dao.TopUserInSixMonthsDao;

import java.io.IOException;

public class TopUserInSixMonthsUI {
    public TopUserInSixMonthsUI() throws IOException {
        TopUserInSixMonthsDao topUserInSixMonthsDao=new TopUserInSixMonthsDao();
        topUserInSixMonthsDao.computeTopUserInSixMonths();
        System.out.println("The user who borrowed the most books in the last 6 months is: "+topUserInSixMonthsDao.topUser);
    }
}
