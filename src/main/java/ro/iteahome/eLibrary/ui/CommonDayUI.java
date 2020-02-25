package ro.iteahome.eLibrary.ui;

import java.io.*;

import java.util.Scanner;

import ro.iteahome.eLibrary.dao.CommonDayDao;


public class CommonDayUI {


    public CommonDayUI() throws IOException {

        CommonDayDao commonDayDao = new CommonDayDao();
        Scanner s = new Scanner(System.in);

        System.out.println("What is the id of the reader?");
        commonDayDao.useriddao = s.nextInt();
        s.nextLine();
        commonDayDao.computeCommonDay();
        System.out.println("The user with the id " + commonDayDao.useriddao + " borrowed more books on " + commonDayDao.theMostBusyDay + "!");


    }


}
