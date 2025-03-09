package no.hvl.dat102;

import java.util.Objects;

public class Person {
    private String navn;
    private MengdeADT<String> hobbyer;

    public Person(String navn, String ... hobbyer) {
        this.navn = navn;
        this.hobbyer = new TabellMengde<>();
        for (String hobby : hobbyer) {
            this.hobbyer.leggTil(hobby);
        }
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public MengdeADT<String> getHobbyer() {
        return hobbyer;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(navn, person.navn) && Objects.equals(hobbyer, person.hobbyer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(navn, hobbyer);
    }
}
