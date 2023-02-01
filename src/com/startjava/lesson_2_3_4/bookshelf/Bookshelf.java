package com.startjava.lesson_2_3_4.bookshelf;

import java.util.Arrays;

public class Bookshelf {

    private int numberBooks;
    private final Book[] books = new Book[10];
    private int length;

    public int getNumberBooks() {
        return numberBooks;
    }

    public Book[] getBooks() {
        return Arrays.copyOf(books, numberBooks);
    }

    public int getLength() {
        return length;
    }

    public void addBook(Book book) {
        if (calculateNumberFreeShelves() == 0) {
            throw new UnsupportedOperationException("В шкафу нет свободных мест.");
        }

        books[books.length - calculateNumberFreeShelves()] = book;
        numberBooks++;
        length = Math.max(length, book.getDescriptionLength());
    }

    public String findBook(String title) {
        if (numberBooks == 0) {
            throw new UnsupportedOperationException("Шкаф пуст.");
        }

        return books[determineShelfIndex(title)].toString();
    }

    public void takeBook(String title) {
        int shelfIndex = determineShelfIndex(title);
        int bookLength = books[shelfIndex].getDescriptionLength();
        books[shelfIndex] = null;

        if (shelfIndex < books.length - 1) {
            System.arraycopy(books, shelfIndex + 1, books, shelfIndex, --numberBooks - shelfIndex);
        }

        if (length == bookLength) {
            recalculateLength();
        }
    }

    public void clear() {
        if (numberBooks == 0) {
            throw new UnsupportedOperationException("Шкаф уже пуст.");
        }

        Arrays.fill(books, 0, numberBooks, null);
        numberBooks = 0;
        recalculateLength();
    }

    public int calculateNumberFreeShelves() {
        return books.length - numberBooks;
    }

    private void recalculateLength() {
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
