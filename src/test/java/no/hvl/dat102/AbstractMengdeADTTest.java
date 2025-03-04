package no.hvl.dat102;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class AbstractMengdeADTTest {
    private MengdeADT<String> tomMengde;
    private MengdeADT<String> mengdeMed3Element;
    private MengdeADT<String> mengdeMed4Element;
    private MengdeADT<String> mengdeMed3ElementLik;

    abstract MengdeADT<String> opprettNyMengdeOfString();

    @BeforeEach
    public void nullstill() {
        tomMengde = opprettNyMengdeOfString();

        mengdeMed3Element = opprettNyMengdeOfString();
        mengdeMed3Element.leggTil("Eple");
        mengdeMed3Element.leggTil("Appelsin");
        mengdeMed3Element.leggTil("Druer");

        mengdeMed3ElementLik = opprettNyMengdeOfString();
        mengdeMed3ElementLik.leggTil("Eple");
        mengdeMed3ElementLik.leggTil("Appelsin");
        mengdeMed3ElementLik.leggTil("Druer");

        mengdeMed4Element = opprettNyMengdeOfString();
        mengdeMed4Element.leggTil("Eple");
        mengdeMed4Element.leggTil("Appelsin");
        mengdeMed4Element.leggTil("Druer");
        mengdeMed4Element.leggTil("Ananas");
    }

    @Test
    public void testInneholder() {
        assertTrue(mengdeMed3Element.inneholder("Eple"));
        assertFalse(mengdeMed3Element.inneholder("Ananas"));
    }
}
