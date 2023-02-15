package com.example.student_management_system.Dto;

public class IssueBookRequestDto {

    // to issue Book to the student.
    private int bookId;
    private int cardId;

    public IssueBookRequestDto() {

    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }
}
