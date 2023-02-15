package com.example.student_management_system.Dto;

import com.example.student_management_system.Enums.Genre;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class BookRequestDto {

    // To enter book details in to the database.
    private String name;
    private int pages;
    private Genre genre;
    private boolean issued;
    private int authorId;

    public BookRequestDto() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public boolean isIssued() {
        return issued;
    }

    public void setIssued(boolean issued) {
        this.issued = issued;
    }

    public void setAuthorId(int id) {
        this.authorId = id;
    }

    public int getAuthorId() {
        return this.authorId;
    }
}
