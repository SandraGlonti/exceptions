package pl.kurs.lesson1.app;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Podaj liczbę całkowitą: ");
            int number = scanner.nextInt();
            System.out.println(number);
        } catch(InputMismatchException | IllegalArgumentException exception){
            System.out.println("Błędne dane");
        } catch (NullPointerException exception){
            System.out.println("Błędny kod");
            throw exception;
        } finally {
            scanner.close();
        }

        System.out.println("aaaa");

    }
}
