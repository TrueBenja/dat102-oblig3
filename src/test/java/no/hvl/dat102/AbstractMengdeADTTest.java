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

    private MengdeADT<Integer> mengdeMed10Tall;
    private MengdeADT<Integer> mengdeMed5Tall;
    private MengdeADT<Integer> mengdeMed5TallLik;
    private MengdeADT<Integer> mengdeMed5TallUlik;
    private MengdeADT<Integer> tomTallMengde;

    abstract MengdeADT<String> opprettNyMengdeOfString();
    abstract MengdeADT<Integer> opprettNyMengdeOfInteger();

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

        mengdeMed10Tall = opprettNyMengdeOfInteger();
        for (int i = 0; i < 10; i++) {
            mengdeMed10Tall.leggTil(i);
        }
        mengdeMed5Tall = opprettNyMengdeOfInteger();
        mengdeMed5TallLik = opprettNyMengdeOfInteger();
        for (int i = 0; i < 5; i++) {
            mengdeMed5Tall.leggTil(i);
            mengdeMed5TallLik.leggTil(i);
        }
        mengdeMed5TallUlik = opprettNyMengdeOfInteger();
        for (int i = 5; i < 10; i++) {
            mengdeMed5TallUlik.leggTil(i);
        }

        tomTallMengde = opprettNyMengdeOfInteger();
    }

    @Test
    public void testInneholder() {
        assertTrue(mengdeMed3Element.inneholder("Eple"));
        assertFalse(mengdeMed3Element.inneholder("Ananas"));
        assertFalse(mengdeMed3ElementUlik.inneholder("Banan"));

        assertTrue(mengdeMed5Tall.inneholder(3));
        assertFalse(mengdeMed5Tall.inneholder(5));
    }

    @Test
    public void testErDelmengdeAv() {
        assertTrue(mengdeMed3Element.erDelmengdeAv(mengdeMed4Element));
        assertFalse(mengdeMed4Element.erDelmengdeAv(mengdeMed3Element));
        assertTrue(tomMengde.erDelmengdeAv(mengdeMed3Element));
        assertTrue(mengdeMed3Element.erDelmengdeAv(mengdeMed3ElementLik));

        assertTrue(mengdeMed5Tall.erDelmengdeAv(mengdeMed10Tall));
        assertFalse(mengdeMed10Tall.erDelmengdeAv(mengdeMed5Tall));
        assertFalse(mengdeMed5Tall.erDelmengdeAv(mengdeMed5TallUlik));
    }

    @Test
    public void testErLik() {
        assertTrue(mengdeMed3Element.erLik(mengdeMed3ElementLik));
        assertFalse(mengdeMed3Element.erLik(mengdeMed4Element));
        assertFalse(mengdeMed3Element.erLik(tomMengde));

        assertTrue(mengdeMed5Tall.erLik(mengdeMed5TallLik));
        assertFalse(mengdeMed5Tall.erLik(mengdeMed5TallUlik));
        assertFalse(mengdeMed5Tall.erLik(mengdeMed10Tall));
        assertTrue(mengdeMed10Tall.erLik(mengdeMed10Tall));
    }

    @Test
    public void testErDisjunkt() {
        assertTrue(mengdeMed3Element.erDisjunkt(mengdeMed3ElementUlik));
        assertFalse(mengdeMed3Element.erDisjunkt(mengdeMed3ElementLik));
        assertFalse(mengdeMed3Element.erDisjunkt(mengdeMed4Element));

        assertFalse(tomMengde.erDisjunkt(mengdeMed3Element));
        assertFalse(mengdeMed3Element.erDisjunkt(tomMengde));

        assertTrue(mengdeMed5Tall.erDisjunkt(mengdeMed5TallUlik));
        assertFalse(mengdeMed10Tall.erDisjunkt(mengdeMed5Tall));
        assertFalse(mengdeMed10Tall.erDisjunkt(mengdeMed5TallUlik));
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

        MengdeADT<Integer> testTallMengde = mengdeMed5Tall.snitt(mengdeMed5TallUlik);
        assertTrue(testTallMengde.erTom());

        testTallMengde = mengdeMed5Tall.snitt(mengdeMed10Tall);
        assertTrue(testTallMengde.erLik(mengdeMed5Tall));
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

        assertTrue(mengdeMed5Tall.union(mengdeMed5TallUlik).erLik(mengdeMed10Tall));
    }

    @Test
    public void testFjern() {
        assertEquals("Eple", mengdeMed3Element.fjern("Eple"));
        assertEquals(2, mengdeMed3Element.antallElementer());

        assertNull(mengdeMed3ElementLik.fjern("Stjernefrukt"));
        assertEquals(3, mengdeMed3ElementLik.antallElementer());

        assertEquals(4, mengdeMed5Tall.fjern(4));
        assertEquals(4, mengdeMed5Tall.antallElementer());
    }

    @Test
    public void testMinus() {
        MengdeADT<String> testMengde = opprettNyMengdeOfString();
        testMengde.leggTil("Banan");
        testMengde.leggTil("Pære");
        testMengde.leggTil("Stjernefrukt");

        MengdeADT<String> minusMengde = mengdeMed5Element.minus(mengdeMed3Element);
        assertTrue(minusMengde.erLik(testMengde));

        assertTrue(mengdeMed5Tall.minus(mengdeMed5TallLik).erTom());
        assertTrue(mengdeMed10Tall.minus(mengdeMed5Tall).erLik(mengdeMed5TallUlik));
        assertFalse(mengdeMed5Tall.minus(mengdeMed5TallUlik).erTom());
    }

    @Test
    public void testLeggTilAlleFra() {
        tomTallMengde.leggTilAlleFra(mengdeMed5Tall);
        assertTrue(tomTallMengde.erLik(mengdeMed5Tall));

        mengdeMed5Tall.leggTilAlleFra(mengdeMed5TallUlik);
        assertTrue(mengdeMed5Tall.erLik(mengdeMed10Tall));
    }
}
