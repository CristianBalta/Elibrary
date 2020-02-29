package ro.iteahome.eLibrary.model;

import ro.iteahome.eLibrary.service.AuthorPopularBooks;
import ro.iteahome.eLibrary.service.ReaderProfile;
import ro.iteahome.eLibrary.service.TopAuthor;
import ro.iteahome.eLibrary.service.TopFiveBooks;

import java.io.IOException;

public class Reader extends Role {
    public Reader(int roleId) {
        super(roleId);
    }



    @Override
    public void topFiveBooks() throws IOException {
        TopFiveBooks topFiveBooks = new TopFiveBooks();
    }

    @Override
    public void topAuthor() throws IOException {
        TopAuthor topAuthor = new TopAuthor();
    }

    @Override
    public void authorPoplarBooks() throws IOException {
        AuthorPopularBooks authorPopularBooks = new AuthorPopularBooks();

    }


    public void readerProfile() throws IOException {
        ReaderProfile readerProfile = new ReaderProfile();
    };
}