package com.startjava.lesson_2_3_4.bookshelf;

import java.util.Arrays;

public class Bookshelf {

    private final int MAX_BOOKS = 10;
    private int numberBooks;
    private int numberFreeShelves = MAX_BOOKS;
    private int length;
    private final Book[] books = new Book[MAX_BOOKS];

    public int getNumberBooks() {
        return numberBooks;
    }

    public int getNumberFreeShelves() {
        return numberFreeShelves;
    }

    public int getLength() {
        return length;
    }

    public Book[] getBooks() {
        return Arrays.copyOf(books, numberBooks);
    }

    public void addBook(Book book) {
        if (numberFreeShelves == 0) {
            throw new UnsupportedOperationException("В шкафу нет свободных мест.");
        }

        books[books.length - numberFreeShelves] = book;
        numberBooks++;
        countNumberFreeShelves();

        if (length < book.getDescriptionLength()) {
            countLength();
        }
    }

    public String findBook(String title) {
        if (numberBooks == 0) {
            throw new UnsupportedOperationException("Шкаф пуст.");
        }

        return books[determineShelfIndex(title)].toString();
    }

    public void takeBook(String title) {
        int bookIndex = determineShelfIndex(title);
        int bookLength = books[bookIndex].getDescriptionLength();
        books[bookIndex] = null;

        if (bookIndex < books.length - 1) {
            System.arraycopy(books, bookIndex + 1, books, bookIndex, --numberBooks - bookIndex);
        }

        countNumberFreeShelves();

        if (length == bookLength) {
            countLength();
        }
    }

    public void clear() {
        if (numberBooks == 0) {
            throw new UnsupportedOperationException("Шкаф уже пуст.");
        }

        Arrays.fill(books, 0, numberBooks, null);
        numberBooks = 0;
        countLength();
    }

    private void countNumberFreeShelves() {
        numberFreeShelves = books.length - numberBooks;
    }

    private void countLength() {
        length = 0;
        if (numberBooks == 0) {
            return;
        }

        for (int i = 0; i < numberBooks; i++) {
            length = Math.max(length, books[i].getDescriptionLength());
        }
    }

    private int determineShelfIndex(String title) {
        for (int i = 0; i < numberBooks; i++) {
            if (books[i].getTitle().equals(title)) {
                return i;
            }
        }

        throw new UnsupportedOperationException("Книги с таким названием в шкафу нет.");
    }
}
