package no.hvl.dat102.oppgave4uke11;

import java.util.Arrays;
import java.util.HashSet;

public class HashSetSoking {
    static final int STORRELSE = 1000000;

    public static void main(String[] args) {
        Integer[] tab = new Integer[STORRELSE];
        HashSet<Integer> set  = new HashSet<>();
        genererTabOgSet(STORRELSE, tab, set);

        Arrays.sort(tab);

        System.out.println("Tabell: " + taTidPaaTab(tab) + "ms");
        System.out.println("HashSet: " + taTidPaaHashSet(set) + "ms");
    }

    private static long taTidPaaHashSet(HashSet<Integer> set) {
        int tall = 3;

        long startTid = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            tall = (tall + 45713) % STORRELSE;
            boolean funnet = set.contains(tall);
        }

        long sluttTid = System.currentTimeMillis();
        return sluttTid - startTid;
    }

    private static long taTidPaaTab(Integer[] tab) {
        int tall = 3;

        long startTid = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            tall = (tall + 45713) % STORRELSE;
            boolean funnet = binaertSokRekursiv(tab, tall);
        }

        long sluttTid = System.currentTimeMillis();
        return sluttTid - startTid;
    }

    private static void genererTabOgSet(int storrelse, Integer[] tab, HashSet<Integer> set) {
        int tall = 376;

        for (int i = 0; i < storrelse; i++) {
            tall = (tall + 45713) % storrelse;
            tab[i] = tall;
            set.add(tall);
        }
    }

    public static <T extends Comparable<T>> boolean binaertSokRekursiv(
            T[] tabell, T element) {
        return binaertSokRekursiv(tabell, element, 0, tabell.length - 1);
    }

    private static <T extends Comparable<T>> boolean binaertSokRekursiv(T[] tabell, T element, int venstre, int hoyre) {
        int midten = (venstre + hoyre) / 2;

        if (venstre > hoyre) {
            return false;
        }

        if (element.equals(tabell[midten])) {
            return true;
        }

        if (element.compareTo(tabell[midten]) < 0) {
            hoyre = midten - 1;
        } else {
            venstre = midten + 1;
        }
        return binaertSokRekursiv(tabell, element, venstre, hoyre);
    }
}
