package no.hvl.dat102;

import java.util.Arrays;

public class TabellMengde<T> implements MengdeADT<T> {
    private final int INITIAL_CAPACITY = 10;
    private T[] tab;
    private int antall;

    @SuppressWarnings("unchecked")
    public TabellMengde() {
        tab = (T[]) new Object[INITIAL_CAPACITY];
    }

    @Override
    public boolean erTom() {
        return antall == 0;
    }

    @Override
    public boolean inneholder(T element) {
        int i = 0;
        while (i < antall) {
            if (tab[i].equals(element)) {
                return true;
            }
            i++;
        }
        return false;
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
        // Alle tomme mengder er delmengde av alle andre mengder
        if (annenMengde.erTom()) {
            return true;
        }

        // Sjekker om annenMengde inneholder alle elementene i denne mengden
        for (int i = 0; i < antall; i++) {
            if (!annenMengde.inneholder(tab[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean erLik(MengdeADT<T> annenMengde) {
        return antall == annenMengde.antallElementer() && erDelmengdeAv(annenMengde);
    }

    @Override
    public boolean erDisjunkt(MengdeADT<T> annenMengde) {
        return false;
    }

    @Override
    public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
        return null;
    }

    @Override
    public MengdeADT<T> union(MengdeADT<T> annenMengde) {
        return null;
    }

    @Override
    public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
        return null;
    }

    @Override
    public void leggTil(T element) {
        if (!inneholder(element)) {
            tab[antall] = element;
            antall++;
        }

        if (antall == tab.length) {
            utvid();
        }
    }

    @Override
    public void leggTilAlleFra(MengdeADT<T> annenMengde) {

    }

    @Override
    public T fjern(T element) {
        return null;
    }

    @Override
    public T[] tilTabell() {
        return null;
    }

    @Override
    public int antallElementer() {
        return 0;
    }

    // utvider tabell når den er full
    private void utvid() {
        tab = Arrays.copyOf(tab, tab.length * 2);
    }
}
