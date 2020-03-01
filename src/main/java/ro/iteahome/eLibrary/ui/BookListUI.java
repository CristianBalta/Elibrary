package ro.iteahome.eLibrary.ui;

import ro.iteahome.eLibrary.dao.BookListDao;

import java.io.IOException;

public class BookListUI {
    public BookListUI() throws IOException {
        BookListDao bookListDao=new BookListDao();
        bookListDao.showBookList();
    }
}
