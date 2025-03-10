package no.hvl.dat102;

public class JavaSetToMengdeTest extends AbstractMengdeADTTest {
    @Override
    public MengdeADT<String> opprettNyMengdeOfString() {
        return new JavaSetToMengde<String>();
    }

    @Override
    public MengdeADT<Integer> opprettNyMengdeOfInteger() {
        return new JavaSetToMengde<Integer>();
    }
}
