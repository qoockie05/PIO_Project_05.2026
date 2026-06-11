package src;

import java.util.Scanner;

public class Menu {

    public void wyswietlOpcje() {
        System.out.println("\n--- GRA WISIELEC ---");
        System.out.println("1. Graj");
        System.out.println("2. Zarządzaj słownikiem");
        System.out.println("3. Wyjście");
        System.out.print("Twój wybór: ");
    }

    public int przetworzWybor(String input) {
        try {
            int choice = Integer.parseInt(input.trim());
            if (choice >= 1 && choice <= 3) {
                return choice;
            }
        }
        catch (NumberFormatException ignored) {
        }
        return -1;
    }

    public int pobierzPoprawnyWybor(Scanner scanner) {
        wyswietlOpcje();
        String input = scanner.nextLine();
        int choice = przetworzWybor(input);

        while (choice == -1) {
            System.out.println("Błąd! Wpisz poprawną cyfrę (1, 2 lub 3).");
            wyswietlOpcje();
            input = scanner.nextLine();
            choice = przetworzWybor(input);
        }
        return choice;
    }

}
