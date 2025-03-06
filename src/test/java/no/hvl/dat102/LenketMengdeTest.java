package no.hvl.dat102;

public class LenketMengdeTest extends AbstractMengdeADTTest {

    @Override
    MengdeADT<String> opprettNyMengdeOfString() {
        return new LenketMengde<String>();
    }
}
