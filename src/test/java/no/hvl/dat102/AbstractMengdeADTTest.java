package no.hvl.dat102;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractMengdeADTTest {
    private MengdeADT<String> tomMengde;
    private MengdeADT<String> mengdeMed3Element;
    private MengdeADT<String> mengdeMed4Element;
    private MengdeADT<String> mengdeMed3ElementLik;
    private MengdeADT<String> mengdeMed3ElementUlik;
    private MengdeADT<String> mengdeMed5Element;

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

        mengdeMed3ElementUlik = opprettNyMengdeOfString();
        mengdeMed3ElementUlik.leggTil("Stein");
        mengdeMed3ElementUlik.leggTil("Jord");
        mengdeMed3ElementUlik.leggTil("Tre");

        mengdeMed4Element = opprettNyMengdeOfString();
        mengdeMed4Element.leggTil("Eple");
        mengdeMed4Element.leggTil("Appelsin");
        mengdeMed4Element.leggTil("Druer");
        mengdeMed4Element.leggTil("Ananas");

        mengdeMed5Element = opprettNyMengdeOfString();
        mengdeMed5Element.leggTil("Eple");
        mengdeMed5Element.leggTil("Appelsin");
        mengdeMed5Element.leggTil("Banan");
        mengdeMed5Element.leggTil("Pære");
        mengdeMed5Element.leggTil("Stjernefrukt");
    }

    @Test
    public void testInneholder() {
        assertTrue(mengdeMed3Element.inneholder("Eple"));
        assertFalse(mengdeMed3Element.inneholder("Ananas"));
        assertFalse(mengdeMed3ElementUlik.inneholder("Banan"));
    }

    @Test
    public void testErDelmengdeAv() {
        assertTrue(mengdeMed3Element.erDelmengdeAv(mengdeMed4Element));
        assertFalse(mengdeMed4Element.erDelmengdeAv(mengdeMed3Element));
        assertTrue(tomMengde.erDelmengdeAv(mengdeMed3Element));
        assertTrue(mengdeMed3Element.erDelmengdeAv(mengdeMed3ElementLik));
    }

    @Test
    public void testErLik() {
        assertTrue(mengdeMed3Element.erLik(mengdeMed3ElementLik));
        assertFalse(mengdeMed3Element.erLik(mengdeMed4Element));
        assertFalse(mengdeMed3Element.erLik(tomMengde));
    }

    @Test
    public void testErDisjunkt() {
        assertTrue(mengdeMed3Element.erDisjunkt(mengdeMed3ElementUlik));
        assertFalse(mengdeMed3Element.erDisjunkt(mengdeMed3ElementLik));
        assertFalse(mengdeMed3Element.erDisjunkt(mengdeMed4Element));
    }

    @Test
    public void testSnitt() {
        MengdeADT<String> testMengde = opprettNyMengdeOfString();
        testMengde.leggTil("Eple");
        testMengde.leggTil("Appelsin");

        MengdeADT<String> snittMengde = mengdeMed3Element.snitt(mengdeMed5Element);
        MengdeADT<String> snittMengdeTom = mengdeMed3Element.snitt(mengdeMed3ElementUlik);

        assertTrue(testMengde.erLik(snittMengde));
        assertTrue(tomMengde.erLik(snittMengdeTom));
    }

    @Test
    public void testUnion() {
        MengdeADT<String> testMengde = opprettNyMengdeOfString();
        testMengde.leggTil("Eple");
        testMengde.leggTil("Appelsin");
        testMengde.leggTil("Druer");
        testMengde.leggTil("Stein");
        testMengde.leggTil("Jord");
        testMengde.leggTil("Tre");

        MengdeADT<String> unionMengde = mengdeMed3Element.union(mengdeMed3ElementUlik);
        assertTrue(testMengde.erLik(unionMengde));
    }

    @Test
    public void testFjern() {
        assertEquals("Eple", mengdeMed3Element.fjern("Eple"));
        assertEquals(2, mengdeMed3Element.antallElementer());

        assertNull(mengdeMed3ElementLik.fjern("Stjernefrukt"));
        assertEquals(3, mengdeMed3ElementLik.antallElementer());
    }

    @Test
    public void testMinus() {
        MengdeADT<String> testMengde = opprettNyMengdeOfString();
        testMengde.leggTil("Banan");
        testMengde.leggTil("Pære");
        testMengde.leggTil("Stjernefrukt");

        MengdeADT<String> minusMengde = mengdeMed5Element.minus(mengdeMed3Element);
        assertTrue(minusMengde.erLik(testMengde));
    }
}
