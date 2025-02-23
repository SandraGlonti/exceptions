package pl.kurs.preTestHomework.library.service;

import pl.kurs.preTestHomework.library.exception.EmptyFieldException;
import pl.kurs.preTestHomework.library.model.Book;

import java.util.Scanner;

public class Library {
    private Book[] books = new Book[100];
    private int bookCounter = 0;
    private Scanner scanner = new Scanner(System.in);

    public void addBook() {
        ensureArrayCapacity();
        try {
            System.out.println("Podaj tytuł: ");
            String title = scanner.nextLine();
            System.out.println("Podaj autora: ");
            String author = scanner.nextLine();
            System.out.println("Podaj liczbę stron: ");
            int pages = Integer.parseInt(scanner.nextLine());
            System.out.println("Podaj numer ISBN: ");
            String isbn = scanner.nextLine();
            System.out.println("Podaj kategorię: FANTASY, ROMANS, THILLER, DOKUMENT.");
            String category = scanner.nextLine();

            books[bookCounter] = new Book(title, author, pages, isbn, category);
            System.out.println("Książka została dodana.");
            bookCounter++;

        } catch (EmptyFieldException exception) {
            System.out.println("Błąd: " + exception.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Błąd: Liczba stron musi być liczbą całkowitą.");
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public void removeBook() {
        System.out.println("Podaj tytuł książki: ");
        String title = scanner.nextLine();
        System.out.println("Podaj autora książki: ");
        String author = scanner.nextLine();

        for (int i = 0; i < bookCounter; i++) {
            if (books[i].matches(title, author)) {
                for (int j = 0; j < bookCounter - 1; j++) {
                    books[j] = books[j + 1];
                }
                books[--bookCounter] = null;
                System.out.println("Książka została usunięta.");
                return;
            }
        }
        System.out.println("Nie znaleziono książki.");
    }

    public void searchBook() {
        System.out.println("Podaj tytuł wyszukiwanej książki: ");
        String title = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < bookCounter; i++) {
            if (books[i].titleMatches(title)) {
                System.out.println(books[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Nie znaleziono książki o podanym tytule.");
        }
    }

    public void showAll() {
        if (bookCounter == 0) {
            System.out.println("Brak książek w bibliotece.");
        } else {
            System.out.println("Lista książek w bibliotece:");
            for (int i = 0; i < bookCounter; i++) {
                System.out.println(books[i]);
            }
        }
    }


    public void menu(){
        int choice;
        do{
            System.out.println("Biblioteka:");
            System.out.println("1. Dodaj książkę.");
            System.out.println("2. Usuń książkę. ");
            System.out.println("3. Wyszukaj książkę.");
            System.out.println("4. Wyświetl wszystkie książki. ");
            System.out.println("0. Zakończ program.");
            System.out.println("Podaj swój wybór:");

            try{
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        addBook();
                        break;
                    case 2:
                        removeBook();
                        break;
                    case 3:
                        searchBook();
                        break;
                    case 4:
                        showAll();
                        break;
                    default:
                        System.out.println("Niepoprawny wybór. Spróbuj jeszcze raz.");
                }
            }catch (NumberFormatException e){
                System.out.println("Błąd: Wybór musi być liczbą");
                choice = -1;
            }
        }while (choice != 0);
        scanner.close();
    }

    private void ensureArrayCapacity() {
        if (bookCounter >= books.length) {
            Book[] newBooks = new Book[books.length + books.length / 2];
            System.arraycopy(books, 0, newBooks, 0, books.length);
            books = newBooks;
        }

    }

}
