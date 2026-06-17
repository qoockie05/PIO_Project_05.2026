package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Slowa {
    private final List<String> listaSlow = new ArrayList<>(Arrays.asList(
            "komputer", "program", "java", "wisielec", "terminal", "klawiatura", "projekt", "student", "uczelnia", "algorytm"

    ));
    public String losujSlowo() {
        Random random = new Random();
        int indeks = random.nextInt(this.listaSlow.size());
        return this.listaSlow.get(indeks);

    }
    public boolean dodajSlowo(String slowo) {
        listaSlow.add(slowo);
        return true;

    }

    public boolean czyZawiera(String slowo) {
        return listaSlow.contains(slowo);
    }
}
