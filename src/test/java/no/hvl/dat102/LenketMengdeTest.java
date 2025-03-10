package no.hvl.dat102;

public class LenketMengdeTest extends AbstractMengdeADTTest {

    @Override
    public MengdeADT<String> opprettNyMengdeOfString() {
        return new LenketMengde<String>();
    }

    @Override
    public MengdeADT<Integer> opprettNyMengdeOfInteger() {
        return new LenketMengde<Integer>();
    }
}
