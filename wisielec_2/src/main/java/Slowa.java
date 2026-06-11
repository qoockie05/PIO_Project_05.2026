//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.util.Random;

public class Slowa {
    private String[] listaSlow = new String[]{"komputer", "program", "java", "wisielec", "terminal", "klawiatura", "projekt", "student", "uczelnia", "algorytm"};

    public String losujSlowo() {
        Random random = new Random();
        int indeks = random.nextInt(this.listaSlow.length);
        return this.listaSlow[indeks];
    }
}
