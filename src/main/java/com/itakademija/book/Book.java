package com.itakademija.book;

import com.itakademija.publisher.Publisher;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

//many books on one publisher
public class Book implements Serializable {
    private Long id;
    private String title;
    private int pages;
    private String author;
    private Publisher publisher;

    public Book() {
    }

    public Book(String title, int pages, String author, Publisher publisher) {
        this.title = title;
        this.pages = pages;
        this.author = author;
        this.publisher = publisher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Book.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("title='" + title + "'")
                .add("pages=" + pages)
                .add("author='" + author + "'")
                .add("publisher=" + publisher)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
