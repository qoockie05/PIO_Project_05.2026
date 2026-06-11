//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

final class Main {
    public static void main(String[] args) {
        Gracz gracz = new Gracz();
        gracz.wczytajNick();
        Slowa slowa = new Slowa();
        String tajneSlowo = slowa.losujSlowo();
        System.out.println("Gracz: " + gracz.getNick());
        System.out.println("Wylosowane słowo: " + tajneSlowo);
    }
}
