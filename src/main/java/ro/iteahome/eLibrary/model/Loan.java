package ro.iteahome.eLibrary.model;

import java.util.Date;
import java.util.List;

public class Loan {

    private int loanId;
    private int userId;
    private Date loanDate;
    private List<Book> bookList;


    public Loan(int loanId, int userId, List<Book> bookList, Date loanDate) {
        this.loanId = loanId;
        this.userId = userId;
        this.bookList = bookList;
        this.loanDate = loanDate;

    }

    public Loan() {

    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

}