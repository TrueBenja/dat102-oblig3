package no.hvl.dat102;

public class TabellMendgeTest extends AbstractMengdeADTTest {
    @Override
    public MengdeADT<String> opprettNyMengdeOfString() {
        return new TabellMengde<>();
    }

    @Override
    public MengdeADT<Integer> opprettNyMengdeOfInteger() {
        return new TabellMengde<Integer>();
    }
}
