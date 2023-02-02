package com.startjava.lesson_2_3_4.bookshelf;

public class Book {
    private final String author;
    private final String title;
    private final String year;
    private final int descriptionLength;

    public Book(String description) {
        String[] bookInfo = description.split(", ");
        this.author = bookInfo[0];
        this.title = bookInfo[1];
        this.year = bookInfo[2];
        this.descriptionLength = toString().length();
    }

    public String getTitle() {
        return title;
    }

    public int getDescriptionLength() {
        return descriptionLength;
    }

    @Override
    public String toString() {
        return author + ", " + title + ", " + year;
    }
}
