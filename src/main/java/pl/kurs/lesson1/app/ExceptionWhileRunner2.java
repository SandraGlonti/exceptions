package pl.kurs.lesson1.app;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionWhileRunner2 {
    public static void main(String[] args) {
        String[] names = {"Adam", "Ewa"};

        Scanner scanner = new Scanner(System.in);
        boolean valid = false;

        do {
            try {
                System.out.println("Podaj liczbę całkowitą: ");
                int number = scanner.nextInt();
                System.out.println("Podana liczba to: " + number);
                System.out.println("A teraz podaj index dowolnego imienia z tablicy:");
                int index = scanner.nextInt();
                String name = names[index];
                System.out.println("Wybrane imię:" + name);
                valid = true;
            } catch (InputMismatchException exception) {
                System.out.println("Błędne dane");
                scanner.nextLine();
                //logger.log(exception);
            } catch (ArrayIndexOutOfBoundsException exception){
                System.out.println("Błędny index");
                //logger.log(exception);
            } finally {
                System.out.println("Blok finally");
            }

        }while (!valid);


        scanner.close();
    }
}
