package com.cst236.zacksalzandroid;

import java.io.Serializable;
import java.util.Date;

public class BookRequestDetails implements Serializable {
    private String requestingPersonName;
    private String requestMadeDate;
    private String isbn;
    private String bookTitle;
    private String author;

    public BookRequestDetails(String requestingPersonName, String requestMadeDate, String isbn, String bookTitle, String author) {
        this.requestingPersonName = requestingPersonName;
        this.requestMadeDate = requestMadeDate;
        this.isbn = isbn;
        this.bookTitle = bookTitle;
        this.author = author;
    }

    public String getRequestingPersonName() {
        return requestingPersonName;
    }

    public void setRequestingPersonName(String requestingPersonName) {
        this.requestingPersonName = requestingPersonName;
    }

    public String getRequestMadeDate() {
        return requestMadeDate;
    }

    public void setRequestMadeDate(String requestMadeDate) {
        this.requestMadeDate = requestMadeDate;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
