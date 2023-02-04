package com.startjava.lesson_2_3_4.bookshelf;

import java.util.Arrays;

public class Bookshelf {

    private final int MAX_BOOKS = 10;
    private int numberBooks;
    private int length;
    private final Book[] books = new Book[MAX_BOOKS];

    public int getNumberBooks() {
        return numberBooks;
    }

    public int getLength() {
        return length;
    }

    public Book[] getBooks() {
        return Arrays.copyOf(books, numberBooks);
    }

    public void add(Book book) {
        if (calculateEmptyShelves() == 0) {
            throw new UnsupportedOperationException("В шкафу нет свободных мест.");
        }

        books[numberBooks] = book;
        numberBooks++;
        length = Math.max(length, book.getDescriptionLength());
    }

    public String find(String title) {
        if (numberBooks == 0) {
            throw new UnsupportedOperationException("Шкаф пуст.");
        }

        return books[findPosition(title)].toString();
    }

    public void delete(String title) {
        int bookIndex = findPosition(title);
        int bookLength = books[bookIndex].getDescriptionLength();
        books[bookIndex] = null;

        if (bookIndex < books.length - 1) {
            System.arraycopy(books, bookIndex + 1, books, bookIndex, --numberBooks - bookIndex);
        }

        if (length == bookLength) {
            calculateLength();
        }
    }

    public void clear() {
        if (numberBooks == 0) {
            throw new UnsupportedOperationException("Шкаф уже пуст.");
        }

        Arrays.fill(books, 0, numberBooks, null);
        numberBooks = 0;
        calculateLength();
    }

    public int calculateEmptyShelves() {
        return MAX_BOOKS - numberBooks;
    }

    private void calculateLength() {
        length = 0;
        if (numberBooks == 0) {
            return;
        }

        for (int i = 0; i < numberBooks; i++) {
            length = Math.max(length, books[i].getDescriptionLength());
        }
    }

    private int findPosition(String title) {
        for (int i = 0; i < numberBooks; i++) {
            if (books[i].getTitle().equals(title)) {
                return i;
            }
        }

        throw new UnsupportedOperationException("Книги с таким названием в шкафу нет.");
    }
}
