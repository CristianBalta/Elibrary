package ro.iteahome.eLibrary.model;

public class Reader extends Role {
    Reader(int roleId, String name) {
        super(roleId, name);
    }

    @Override
    public void searchBook() {

    }

    @Override
    public void top5Books() {

    }

    @Override
    public void mostReadAuthor() {

    }

    @Override
    public void popularBook(Author author) {

    }

    public void showBorrowedBooks(){}
    public void showUserProfile(){}
}
