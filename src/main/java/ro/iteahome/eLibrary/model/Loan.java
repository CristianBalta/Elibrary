package ro.iteahome.eLibrary.model;

import java.util.Date;
import java.util.List;

public class Loan {

    private int loanId;
    private List<Book> bookList;
    private Date loanDate;
    private Date returnDate;
    private String status;

    public Loan(int loanId, List<Book> bookList, Date loanDate, Date returnDate, String status) {
        this.loanId = loanId;
        this.bookList = bookList;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
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

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}