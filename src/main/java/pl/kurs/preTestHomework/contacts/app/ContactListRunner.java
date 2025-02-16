package pl.kurs.preTestHomework.contacts.app;

import pl.kurs.preTestHomework.contacts.service.ContactList;

public class ContactListRunner {
    public static void main(String[] args) {
        ContactList contactList = new ContactList();
        contactList.menu();
    }
}
