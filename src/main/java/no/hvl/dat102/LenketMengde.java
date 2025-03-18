package no.hvl.dat102;

public class LenketMengde<T> implements MengdeADT<T> {
    /* ------------------------------------- */
    private class Node {
        private T data;
        private Node neste;

        private Node(T data) {
            this.data = data;
            this.neste = null;
        }
    }
    /* ------------------------------------- */

    private Node forste;
    private int antall;

    public LenketMengde() {
        forste = null;
        antall = 0;
    }

    @Override
    public boolean erTom() {
        return antall == 0;
    }

    @Override
    public boolean inneholder(T element) {
        Node current = forste;

        while (current != null) {
            if (current.data.equals(element)) {
                return true;
            }
            current = current.neste;
        }
        return false;
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
        Node current = forste;
        while (current != null) {
            if (!annenMengde.inneholder(current.data)) {
                return false;
            }
            current = current.neste;
        }
        return true;
    }

    @Override
    public boolean erLik(MengdeADT<T> annenMengde) {
        return antall == annenMengde.antallElementer() && erDelmengdeAv(annenMengde);
    }

    @Override
    public boolean erDisjunkt(MengdeADT<T> annenMengde) {
        if (erTom() || annenMengde.erTom()) {
            return false;
        }

        Node current = forste;
        while (current != null) {
            if (annenMengde.inneholder(current.data)) {
                return false;
            }
            current = current.neste;
        }
        return true;
    }

    @Override
    public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
        MengdeADT<T> nyMengde = new LenketMengde<>();

        Node current = forste;
        while (current != null) {
            if (annenMengde.inneholder(current.data)) {
                nyMengde.leggTil(current.data);
            }
            current = current.neste;
        }

        return nyMengde;
    }

    @Override
    public MengdeADT<T> union(MengdeADT<T> annenMengde) {
        MengdeADT<T> nyMengde = new LenketMengde<>();

        nyMengde.leggTilAlleFra(this);
        nyMengde.leggTilAlleFra(annenMengde);

        return nyMengde;
    }

    @Override
    public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
        MengdeADT<T> nyMengde = new LenketMengde<>();

        Node current = forste;

        while (current != null) {
            if (!annenMengde.inneholder(current.data)) {
                nyMengde.leggTil(current.data);
            }
            current = current.neste;
        }
        return nyMengde;
    }

    @Override
    public void leggTil(T element) {
        if (!inneholder(element)) {
            Node nyNode = new Node(element);
            nyNode.neste = forste;
            forste = nyNode;
            antall++;
        }
    }

    @Override
    public void leggTilAlleFra(MengdeADT<T> annenMengde) {
        T[] annenMengdeTab = annenMengde.tilTabell();

        for (int i = 0; i < annenMengde.antallElementer(); i++) {
            leggTil(annenMengdeTab[i]);
        }
    }

    @Override
    public T fjern(T element) {
        if (forste.data.equals(element)) {
            T data = forste.data;
            forste = forste.neste;
            antall--;
            return data;
        }

        Node current = forste.neste;
        Node forrige = forste;
        T data = null;

        while (current != null) {
            if (current.data.equals(element)) {
                data = current.data;
                forrige.neste = current.neste;
                antall--;
            }
            current = current.neste;
            forrige = forrige.neste;
        }
        return data;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T[] tilTabell() {
        T[] tabell = (T[]) new Object[antall];

        Node current = forste;

        for (int i = 0; current != null; i++) {
            tabell[i] = current.data;
            current = current.neste;
        }

        return tabell;
    }

    @Override
    public int antallElementer() {
        return antall;
    }
}
