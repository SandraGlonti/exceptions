package pl.kurs.preTestHomework.contacts.service;

import pl.kurs.preTestHomework.contacts.exception.EmptyFieldException;
import pl.kurs.preTestHomework.contacts.exception.WrongFieldException;
import pl.kurs.preTestHomework.contacts.model.Category;
import pl.kurs.preTestHomework.contacts.model.Contact;

import java.util.Scanner;

public class ContactList {
    private Contact[] contacts = new Contact[20];
    private int contactCounter = 0;
    private Scanner scanner = new Scanner(System.in);

    public void addContact() {
        if (contactCounter >= contacts.length) {
            expandContactList();
        }
        try {
            System.out.println("Podaj Imię:");
            String name = scanner.nextLine();
            System.out.println("Podaj Nazwisko:");
            String lastName = scanner.nextLine();
            System.out.println("Podaj numer telefonu:");
            String phoneNumber = scanner.nextLine();
            System.out.println("Podaj ades e-mail:");
            String mail = scanner.nextLine();
            System.out.println("Podaj kategorię kontaktu: PRACA, RODZINA, ZNAJOMI, INNE");
            String category = scanner.nextLine();

            contacts[contactCounter] = new Contact(name, lastName, phoneNumber, mail, category);
            System.out.println("Kontakt został dodany!");
            contactCounter++;
        } catch (EmptyFieldException e) {
            System.out.println("Błąd: " + e.getMessage());
        } catch (WrongFieldException e) {
            System.out.println(" Błąd: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeContact() {
        System.out.println("Podaj imię:");
        String name = scanner.nextLine();
        System.out.println("Podaj Nazwisko");
        String lastName = scanner.nextLine();

        for (int i = 0; i < contactCounter; i++) {
            if (contacts[i].matches(name, lastName)) {
                for (int j = 0; j < contactCounter - 1; j++) {
                    contacts[j] = contacts[j + 1];
                }
                contacts[--contactCounter] = null;
                System.out.println("Kontakt został usunięty");
                return;
            }
        }
        System.out.println("Nie znaleziono kontaktu.");
    }

    public void searchContact() {
        System.out.println("Podaj imię:");
        String name = scanner.nextLine();
        System.out.println("Podaj Nazwisko");
        String lastName = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < contactCounter; i++) {
            if (contacts[i].matches(name, lastName)) {
                System.out.println(contacts[i]);
                found = true;
            }
        }
        if (!(found)) {
            System.out.println("Nie znaleziono kontaktu.");
        }
    }

    public void showContactsByCategory() {
        System.out.println("Podaj kategorię kontaktu: PRACA, RODZINA, ZNAJOMI, INNE");
        try {
            String categoryType = scanner.nextLine();
            Category category = Category.fromString(categoryType);
            boolean found = false;
            for (int i = 0; i < contactCounter; i++) {
                if (contacts[i].getCategory() == category) {
                    System.out.println(contacts[i]);
                    found = true;
                }
            }
            if (!(found)) {
                System.out.println("Brak kontaktów w podanej kategorii.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Błąd: " + e.getMessage());
        }
    }

    public void showAll() {
        if (contactCounter == 0) {
            System.out.println("Brak kontaktów do wyświetlenia.");
        } else {
            for (int i = 0; i < contactCounter; i++) {
                System.out.println(contacts[i]);
            }
        }
    }

    public void expandContactList() {
        Contact[] newContacts = new Contact[contacts.length + contacts.length / 2];
        System.arraycopy(contacts, 0, newContacts, 0, contacts.length);
        contacts = newContacts;
    }
    public void menu(){
        int choice;
        do{
            System.out.println("Lista kontaktów:");
            System.out.println("1. Dodaj kontakt.");
            System.out.println("2. Usuń kontakt. ");
            System.out.println("3. Wyszukaj kontakt.");
            System.out.println("4. Wyszukaj kontakty według kategorii.");
            System.out.println("5. Wyświetl wszystkie książki. ");
            System.out.println("0. Zakończ program.");
            System.out.println("Podaj swój wybór:");
            try{
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        addContact();
                        break;
                    case 2:
                        removeContact();
                        break;
                    case 3:
                        searchContact();
                        break;
                    case 4:
                        showContactsByCategory();
                        break;
                    case 5:
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
}
