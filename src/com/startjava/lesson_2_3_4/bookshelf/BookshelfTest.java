package com.startjava.lesson_2_3_4.bookshelf;

import java.util.Scanner;

public class BookshelfTest {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Bookshelf bookshelf = new Bookshelf();

        do {
            showBooks(bookshelf);
            showMenu();
        } while (doAction(bookshelf, selectAction()));
    }

    private static void showBooks(Bookshelf bookshelf) {
        int booksNumber = bookshelf.getNumberBooks();
        int emptyShelves = bookshelf.calculateEmptyShelves();

        if (booksNumber == 0) {
            System.out.println("Шкаф пуст. Вы можете добавить в него первую книгу.");
            return;
        }

        System.out.printf("В шкафу %d книги. Свободно %d полок.%n",
                booksNumber, emptyShelves);

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

        if (booksNumber > 0 && emptyShelves > 0) {
            String title = " ".repeat(bookshelfLength);
            System.out.printf(shelfSample, title, shelfBottom);
        }
    }

    private static void showMenu() {
        System.out.print("""
                1. Удалить книгу
                2. Положить книгу
                3. Найти книгу
                4. Очистить полку
                5. Выйти
                """);
    }

    private static String selectAction() {
        System.out.print("Выберите пункт меню: ");
        return scanner.nextLine().strip();
    }

    private static boolean doAction(Bookshelf bookshelf, String action) {
        switch (action) {
            case "1" -> {
                System.out.print("Введите название удаляемой книги: ");
                try {
                    bookshelf.delete(scanner.nextLine().strip());
                } catch (UnsupportedOperationException e) {
                    System.out.println(e.getMessage());
                }
            }
            case "2" -> {
                System.out.print("Какую книгу положите (автор, название, год издания)?: ");
                try {
                    bookshelf.add(new Book(scanner.nextLine().strip()));
                } catch (UnsupportedOperationException e) {
                    System.out.println(e.getMessage());
                }
            }
            case "3" -> {
                System.out.print("Введите название искомой книги: ");
                try {
                    System.out.println(bookshelf.find(scanner.nextLine().strip()));
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
                return false;
            }
            default -> System.out.println("Некорректная операция.");
        }

        System.out.println("Для продолжения нажмите Enter.");
        scanner.nextLine();
        return true;
    }
}
