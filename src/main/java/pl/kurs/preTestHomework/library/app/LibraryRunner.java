package pl.kurs.preTestHomework.library.app;

import pl.kurs.preTestHomework.library.service.Library;

public class LibraryRunner {
    public static void main(String[] args) {
        Library library = new Library();
        library.menu();
    }
}
