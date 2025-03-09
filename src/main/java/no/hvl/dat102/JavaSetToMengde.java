package no.hvl.dat102;

import java.util.HashSet;
import java.util.Set;

public class JavaSetToMengde<T> implements MengdeADT<T> {
    private Set<T> mengde;

    public JavaSetToMengde() {
        mengde = new HashSet<>();
    }

    @Override
    public boolean erTom() {
        return mengde.isEmpty();
    }

    @Override
    public boolean inneholder(T element) {
        return mengde.contains(element);
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
        Set<T> set = Set.of(annenMengde.tilTabell());
        return set.containsAll(mengde);
    }

    @Override
    public boolean erLik(MengdeADT<T> annenMengde) {
        Set<T> set = Set.of(annenMengde.tilTabell());
        return set.equals(mengde);
    }

    @Override
    public boolean erDisjunkt(MengdeADT<T> annenMengde) {
        Set<T> set = new HashSet<>(Set.of(annenMengde.tilTabell()));
        set.retainAll(mengde);
        return set.isEmpty();
    }

    @Override
    public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
        MengdeADT<T> nyMengde = new JavaSetToMengde<>();
        Set<T> set = new HashSet<>(Set.of(annenMengde.tilTabell()));
        set.retainAll(mengde);
        for (T element : set) {
            nyMengde.leggTil(element);
        }
        return nyMengde;
    }

    @Override
    public MengdeADT<T> union(MengdeADT<T> annenMengde) {
        Set<T> set = new HashSet<>(Set.of(annenMengde.tilTabell()));
        set.addAll(mengde);
        MengdeADT<T> nyMengde = new JavaSetToMengde<>();
        for (T element : set) {
            nyMengde.leggTil(element);
        }
        return nyMengde;
    }

    @Override
    public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
        Set<T> set = new HashSet<>(Set.of(annenMengde.tilTabell()));
        Set<T> denneSet = new HashSet<>(mengde);
        denneSet.removeAll(set);
        MengdeADT<T> nyMengde = new JavaSetToMengde<>();

        for (T element : denneSet) {
            nyMengde.leggTil(element);
        }
        return nyMengde;
    }

    @Override
    public void leggTil(T element) {
        mengde.add(element);
    }

    @Override
    public void leggTilAlleFra(MengdeADT<T> annenMengde) {
        Set<T> set = new HashSet<>(Set.of(annenMengde.tilTabell()));
        mengde.addAll(set);
    }

    @Override
    public T fjern(T element) {
        if (!mengde.contains(element)) {
            return null;
        }

        mengde.remove(element);
        return element;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T[] tilTabell() {
        return (T[]) mengde.toArray();
    }

    @Override
    public int antallElementer() {
        return mengde.size();
    }
}
