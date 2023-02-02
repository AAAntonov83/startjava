package com.startjava.lesson_2_3_4.bookshelf;

import java.util.Scanner;

public class BookshelfTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Bookshelf bookshelf = new Bookshelf();

        while (true) {
            int booksNumber = bookshelf.getNumberBooks();

            if (booksNumber == 0) {
                System.out.println("Шкаф пуст. Вы можете добавить в него первую книгу.");
            } else {
                System.out.printf("В шкафу %d книги. Свободно %d полок.%n",
                        booksNumber, bookshelf.getNumberFreeShelves());
            }

            showBooks(bookshelf);
            showMenu();

            System.out.print("Выберите пункт меню: ");

            switch (scanner.nextLine().strip()) {
                case "1" -> {
                    System.out.print("Введите название книги: ");
                    try {
                        bookshelf.takeBook(scanner.nextLine().strip());
                    } catch (UnsupportedOperationException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case "2" -> {
                    System.out.print("Какую книгу положите (автор, название, год издания)?: ");
                    try {
                        bookshelf.addBook(new Book(scanner.nextLine().strip()));
                    } catch (UnsupportedOperationException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case "3" -> {
                    System.out.print("Введите название книги: ");
                    try {
                        System.out.println(bookshelf.findBook(scanner.nextLine().strip()));
                    } catch (UnsupportedOperationException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case "4" -> {
                    try {
                        bookshelf.clear();
                    } catch (UnsupportedOperationException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case "5" -> {
                    return;
                }
                default -> System.out.println("Некорректная операция.");

            }

            System.out.println("Для продолжения нажмите Enter.");
            scanner.nextLine();
        }
    }

    private static void showMenu() {
        String menu = """
                1. Взять книгу
                2. Положить книгу
                3. Найти книгу
                4. Убрать все книги
                5. Выйти
                """;
        System.out.print(menu);
    }

    private static void showBooks(Bookshelf bookshelf) {
        int bookshelfLength = bookshelf.getLength();
        Book[] books = bookshelf.getBooks();
        String shelfBottom = "-".repeat(bookshelfLength);
        String shelfSample = """
                |%s|
                |%s|
                """;

        for (Book book : books) {
            String title = book + " ".repeat(bookshelfLength - book.getDescriptionLength());
            System.out.printf(shelfSample, title, shelfBottom);
        }

        if (books.length > 0 && bookshelf.getNumberFreeShelves() > 0) {
            String title = " ".repeat(bookshelfLength);
            System.out.printf(shelfSample, title, shelfBottom);
        }
    }
}
