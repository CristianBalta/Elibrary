package ro.iteahome.eLibrary.model;

public class Admin extends Role {

    public Admin(int roleId, String name) {
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

    public void updateBook(){}
    public void updateLoan(){}
    public void searchBook(User user){}
    public void mostCommonDay(User user){}
    public void topUserHalfYear(){}

}
