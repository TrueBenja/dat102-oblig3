package no.hvl.dat102;

public class JavaSetToMengdeTest extends AbstractMengdeADTTest {
    @Override
    MengdeADT<String> opprettNyMengdeOfString() {
        return new JavaSetToMengde<>();
    }
}
