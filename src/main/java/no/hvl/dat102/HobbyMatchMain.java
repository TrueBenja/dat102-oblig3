package no.hvl.dat102;

public class HobbyMatchMain {
    public static void main(String[] args) {
        Person arne = new Person("Arne", "jakt", "sykling", "venner", "data");
        Person kari = new Person("Kari", "sykling", "strikking", "venner", "trening");
        Person ola = new Person("Ola", "venner", "trening", "klatring", "jakt", "data");

        System.out.println(match(arne, kari));
        System.out.println(match(kari, arne));
        System.out.println(match(arne, ola));
        System.out.println(match(ola, arne));
        System.out.println(match(kari, ola));
        System.out.println(match(ola, kari));
        System.out.println(match(arne, arne));
    }

    static double match(Person a, Person b) {
        double snittAntall = a.getHobbyer().snitt(b.getHobbyer()).antallElementer();
        double aAntall = a.getHobbyer().antallElementer();
        double bAntall = b.getHobbyer().antallElementer();
        double antallTotalt = a.getHobbyer().union(b.getHobbyer()).antallElementer();
        return snittAntall - (aAntall + bAntall) / antallTotalt;
    }
}
