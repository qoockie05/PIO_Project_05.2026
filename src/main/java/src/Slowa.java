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
        if (!listaSlow.contains(slowo)) {
            listaSlow.add(slowo);
            return true; // Sukces
        }
        return false; // Słowo już istnieje
    }

    public boolean czyZawiera(String slowo) {
        return listaSlow.contains(slowo);
    }

    public boolean usunSlowo(String slowo) { 
        return listaSlow.remove(slowo);  
    } 

    public void wyswietlWszystkie() { 
        for (int i = 0; i < listaSlow.size(); i++) { 
            System.out.println((i + 1) + ". " + listaSlow.get(i)); 
        } 
    } 
}
