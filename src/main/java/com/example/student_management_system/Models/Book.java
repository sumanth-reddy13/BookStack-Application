package com.example.student_management_system.Models;

import com.example.student_management_system.Enums.Genre;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int pages;
    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    private boolean issued;

    @ManyToOne
    @JoinColumn
    private Author author;    // unidirectional relation with Author Entity   // book is the child entity

    @ManyToOne
    @JoinColumn
    private Card card;        // unidirectional relation with Card. // book is the child entity

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)  // bidirectional mapping with Transaction model.
    List<Transaction> transactionsList = new ArrayList<>();    // book is the parent entity.

    public Book() {

    }
    public Book(int id, String name, int pages, Author author, Card card, Genre genre, boolean issued) {
        this.id = id;
        this.name = name;
        this.pages = pages;
        this.author = author;
        this.card = card;
        this.genre = genre;
        this.issued = issued;
    }

    public List<Transaction> getTransactionsList() {
        return transactionsList;
    }

    public void setTransactionsList(List<Transaction> transactionsList) {
        this.transactionsList = transactionsList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Genre getGenre() {return genre;}

    public void setGenre(Genre genre) {this.genre = genre;}

    public boolean isIssued() { return issued;}

    public void setIssued(boolean issued) { this.issued = issued;}
}
