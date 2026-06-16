package src;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

public class SlowaTest {

    @Test
    void powinnoLosowacSlowoZListy() {
        Slowa slowa = new Slowa();
        List<String> dozwoloneSlowa = Arrays.asList(
                "komputer",
                "program",
                "java",
                "wisielec",
                "terminal",
                "klawiatura",
                "projekt",
                "student",
                "uczelnia",
                "algorytm"
        );

        String wynik = slowa.losujSlowo();
        assertTrue(dozwoloneSlowa.contains(wynik));
    }

    @Test
    void wylosowaneSlowoNiePowinnoBycNullem() {
        Slowa slowa = new Slowa();
        String wynik = slowa.losujSlowo();
        assertNotNull(wynik);
    }

    @Test
    void wylosowaneSlowoNiePowinnoBycPuste() {
        Slowa slowa = new Slowa();
        String wynik = slowa.losujSlowo();
        assertFalse(wynik.isEmpty());
    }
}