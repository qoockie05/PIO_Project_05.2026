package src;
final class MainGracz {
    public static void main(String[] args) {
        Gracz gracz = new Gracz();
        gracz.wczytajNick();
        Slowa slowa = new Slowa();
        String tajneSlowo = slowa.losujSlowo();
        System.out.println("Gracz: " + gracz.getNick());
        System.out.println("Wylosowane słowo: " + tajneSlowo);
    }
}
