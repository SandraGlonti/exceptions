package pl.kurs.preTestHomework.contacts.model;


import pl.kurs.preTestHomework.contacts.exception.EmptyFieldException;
import pl.kurs.preTestHomework.contacts.exception.WrongFieldException;

public class Contact {
    private String name;
    private String lastName;
    private String phoneNumber;
    private String mail;
    private Category category;

    public Contact(String name, String lastName, String phoneNumber, String mail, String category) throws WrongFieldException, EmptyFieldException {
        validateContact(name,lastName,phoneNumber,mail,category);
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.category = Category.fromString(category);
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Kontakt {" +
                "Imię: '" + name + '\'' +
                ", Nazwisko: '" + lastName + '\'' +
                ", Numer Telefonu: '" + phoneNumber + '\'' +
                ", Adres e-mail: '" + mail + '\'' +
                ", Kategoria: " + category +
                '}';
    }

    public boolean matches(String name, String lastName) {
        return this.name.equalsIgnoreCase(name) && this.lastName.equalsIgnoreCase(lastName);
    }

    private boolean validatePhoneNumber(String phoneNumber) {
        return phoneNumber != null && phoneNumber.matches("\\d{9}");
    }
    private void validateContact(String name, String lastName, String phoneNumber, String mail, String category) throws EmptyFieldException, WrongFieldException {
        if (name == null || name.isEmpty()) {
            throw new EmptyFieldException("Pole Imię nie może być puste!");
        }
        if (lastName == null || lastName.isEmpty()) {
            throw new EmptyFieldException("Pole nazwisko nie może być puste!");
        }
        if (!validatePhoneNumber(phoneNumber)) {
            throw new WrongFieldException("Niepoprawny numer telefonu!");
        }
        if (mail == null || mail.isEmpty()) {
            throw new EmptyFieldException("Pole adres e-mail nie może być puste!");
        }
        if (!(mail.contains("@"))) {
            throw new WrongFieldException("Niepoprawny adres e-mail!");
        }
        if (category == null || category.isEmpty()) {
            throw new EmptyFieldException("Pole Kategoria nie może być pusta!");
        }
    }
}



