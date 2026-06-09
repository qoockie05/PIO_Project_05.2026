package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        boolean czyGraTrwa = true;

        while (czyGraTrwa) {
            int wybor = menu.pobierzPoprawnyWybor(scanner);

            switch(wybor) {
                case 1 -> System.out.println("-> (start gry)");
                case 2 -> System.out.println("-> (zarządzanie słownikiem)");
                case 3 -> {
                    System.out.println("Zamykanie gry. Do zobaczenia!");
                    czyGraTrwa = false;
                }
            }
        }
        scanner.close();
    }
}
