//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.util.Scanner;

public class Gracz {
    private String nick;

    public void wczytajNick() {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print("Podaj nick gracza: ");
            this.nick = scanner.nextLine().trim();
            if (this.nick.length() > 0) {
                System.out.println("Hej " + this.nick + "!");
                return;
            }

            System.out.println("Błąd! Nick musi zawierać przynajmniej jeden znak.");
        }
    }

    public String getNick() {
        return this.nick;
    }
}
