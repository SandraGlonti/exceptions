package pl.kurs.lesson1.app;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionWhileRunner {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean valid = false;

        do {
            try {
                System.out.println("Podaj liczbę całkowitą: ");
                int number = scanner.nextInt();
                System.out.println(number);
                valid = true;
            } catch (InputMismatchException exception) {
                System.out.println("Błędne dane");
                scanner.nextLine();
            }

        }while (!valid);


        scanner.close();
    }

}
