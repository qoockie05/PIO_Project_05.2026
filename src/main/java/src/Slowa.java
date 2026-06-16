package src;

import java.util.Random;

public class Slowa {
    private final String[] listaSlow = new String[]{"komputer", "program", "java", "wisielec", "terminal", "klawiatura", "projekt", "student", "uczelnia", "algorytm"};

    public String losujSlowo() {
        Random random = new Random();
        int indeks = random.nextInt(this.listaSlow.length);
        return this.listaSlow[indeks];
    }
}
