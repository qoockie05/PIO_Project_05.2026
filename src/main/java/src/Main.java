package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        Slowa slowa = new Slowa();
        boolean czyGraTrwa = true;

        while (czyGraTrwa) {
            int wybor = menu.pobierzPoprawnyWybor(scanner);

            switch(wybor) {
                case 1 -> {
                    System.out.println("\n--- URUCHAMIANIE NOWEJ ROZGRYWKI ---");

                    Gracz gracz = new Gracz();
                    gracz.wczytajNick();

                    String tajneSlowo = slowa.losujSlowo();

                    Gra gra = new Gra(tajneSlowo);
                    Wisielec wisielec = new Wisielec();

                    boolean partiaZakonczona = false;

                    while (!partiaZakonczona) {
                        System.out.println(wisielec.rysujWisielca(gra.getLives()));
                        System.out.println("Hasło: ");
                        gra.printCurrentStateForWord();
                        System.out.println("Pozostałe życia: " + gra.getLives());

                        System.out.println("Podaj literę (lub wpisz całe hasło): ");
                        String strzal = scanner.nextLine().trim();

                        if (strzal.isEmpty()) continue;

                        if (strzal.length() > 1) {
                            gra.enterWord(strzal);
                        }
                        else {
                            gra.guessLetter(strzal.charAt(0));
                        }

                        boolean czyOdgatniete = true;
                        for (char c : gra.getGuessedState()) {
                            if (c == '_') {
                                czyOdgatniete = false;
                                break;
                            }
                        }
                        if (czyOdgatniete || gra.isLost()) {
                            partiaZakonczona = true;
                            System.out.println(wisielec.rysujWisielca(gra.getLives()));
                            if (czyOdgatniete) {
                                gra.updateWinCount();
                            }
                            else {
                                System.out.println("Przegrałeś! Hasło to: " + tajneSlowo);
                            }
                        }
                    }
                }

                case 2 -> {
                    boolean czyZarzadzanieTrwa = true;
                    while (czyZarzadzanieTrwa) {
                        System.out.println("\n--- ZARZĄDZANIE SŁOWNIKIEM ---");
                        System.out.println("1. Wyświetl wszystkie słowa");
                        System.out.println("2. Dodaj nowe słowo");
                        System.out.println("3. Usuń słowo");
                        System.out.println("4. Powrót do menu głównego");
                        System.out.print("Twój wybór: ");

                        String opcjaSlownika = scanner.nextLine().trim();

                        switch(opcjaSlownika) {
                            case "1" -> {
                                System.out.println("\nAktualne słowa w bazie:");
                                slowa.wyswietlWszystkie(); 
                            }
                            case "2" -> {
                                System.out.print("\nPodaj nowe słowo do dodania: ");
                                String noweSlowo = scanner.nextLine().trim().toLowerCase();

                                if (noweSlowo.isEmpty()) {
                                    System.out.println("Błąd! Nie wpisano słowa.");
                                }
                                else if (!noweSlowo.matches("[a-zżźćńółęą]+")) {
                                    System.out.println("Błąd! Słowo może zawierać tylko polskie litery.");
                                }
                                else {
                                    boolean dodano = slowa.dodajSlowo(noweSlowo);
                                    if (dodano) {
                                        System.out.println("Sukces! Dodano słowo: " + noweSlowo);
                                    } else {
                                        System.out.println("Błąd! Słowo '" + noweSlowo + "' już istnieje w bazie.");
                                    }
                                }
                            }
                            case "3" -> {
                                System.out.print("\nPodaj słowo, które chcesz usunąć: ");
                                String slowoDoUsuniecia = scanner.nextLine().trim().toLowerCase();

                                if (slowoDoUsuniecia.isEmpty()) {
                                    System.out.println("Błąd! Nie wpisano słowa.");
                                }
                                else {
                                    boolean usunieto = slowa.usunSlowo(slowoDoUsuniecia); 
                                    if (usunieto) { 
                                        System.out.println("Sukces! Usunięto słowo: " + slowoDoUsuniecia); 

                                    } else { 
                                        System.out.println("Błąd! Nie znaleziono słowa '" + slowoDoUsuniecia + "' w bazie."); 
                                    } 
                                }
                            }
                            case "4" -> {
                                czyZarzadzanieTrwa = false;
                            }
                            default -> System.out.println("Błąd! Wybierz opcję od 1 do 4.");
                        }
                    }
                }
                case 3 -> {
                    System.out.println("Zamykanie gry. Do zobaczenia!");
                    czyGraTrwa = false;
                }
            }
        }
        scanner.close();
    }
}
