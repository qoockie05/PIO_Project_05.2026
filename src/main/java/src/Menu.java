package src;

public class Menu {

    public int parseChoice(String input) {
        try {
            int choice = Integer.parseInt(input.trim());
            if (choice >= 1 && choice <= 3) {
                return choice;
            }
        }
        catch (NumberFormatException e) {
        }
        return -1;
    }

}
