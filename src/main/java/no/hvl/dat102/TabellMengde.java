package no.hvl.dat102;

import java.util.Arrays;

public class TabellMengde<T> implements MengdeADT<T> {
    private final int INITIAL_CAPACITY = 5;
    private T[] tab;
    private int antall;

    @SuppressWarnings("unchecked")
    public TabellMengde() {
        tab = (T[]) new Object[INITIAL_CAPACITY];
        antall = 0;
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
        // En mengde er lik en annen hvis den er delmengde av annenMengde, og har likt antall elementer
        return antall == annenMengde.antallElementer() && erDelmengdeAv(annenMengde);
    }

    @Override
    public boolean erDisjunkt(MengdeADT<T> annenMengde) {
        if (erTom() || annenMengde.erTom()) {
            return false;
        }

        for (int i = 0; i < antall; i++) {
            if (annenMengde.inneholder(tab[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
        MengdeADT<T> nyMengde = new TabellMengde<>();
        for (int i = 0; i < antall; i++) {
            if (annenMengde.inneholder(tab[i])) {
                nyMengde.leggTil(tab[i]);
            }
        }
        return nyMengde;
    }

    @Override
    public MengdeADT<T> union(MengdeADT<T> annenMengde) {
        MengdeADT<T> nyMengde = new TabellMengde<>();
        
        nyMengde.leggTilAlleFra(this);
        nyMengde.leggTilAlleFra(annenMengde);
        return nyMengde;
    }

    @Override
    public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
        MengdeADT<T> nyMengde = new TabellMengde<>();
        for (int i = 0; i < antall; i++) {
            if (!annenMengde.inneholder(tab[i])) {
                nyMengde.leggTil(tab[i]);
            }
        }
        return nyMengde;
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
        T[] tabAnnenMengde = annenMengde.tilTabell();
        for (int i = 0; i < annenMengde.antallElementer(); i++) {
            leggTil(tabAnnenMengde[i]);
        }
    }

    @Override
    public T fjern(T element) {
        int indeks = -1;
        for (int i = 0; i < antall; i++) {
            if (tab[i].equals(element)) {
                indeks = i;
            }
        }

        T data = null;
        if (indeks > -1) {
            data = tab[indeks];
            tab[indeks] = tab[antall];
            tab[antall] = null;
            antall--;
        }

        return data;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T[] tilTabell() {
        T[] tabell = (T[]) new Object[antall];
        for (int i = 0; i < antall; i++) {
            tabell[i] = tab[i];
        }
        return tabell;
    }

    @Override
    public int antallElementer() {
        return antall;
    }

    // utvider tabell når den er full
    private void utvid() {
        tab = Arrays.copyOf(tab, tab.length * 2);
    }
}
