package nl.robnoort.classes.interfacetrial;

public class AnimalInterface {
    private String species;
    private boolean canHop;
    private boolean canSwim;

    public AnimalInterface(String speciesName, boolean hopper, boolean swimmer) {
        species = speciesName;
        canHop = hopper;
        canSwim = swimmer;
    }
    
    public static void main(String[] args) {
        print(new AnimalInterface("fish", false, true), a -> a.canHop());
        print(new AnimalInterface("kangaroo", true, false), a -> a.canHop());

        AnimalInterface ai = new AnimalInterface("aalscholver", true, true);

        // met declared ai 
        print(ai, a->a.canHop );

        // met declared checktrait
        CheckTrait ct = new CheckTrait(){
            @Override
            public boolean test(AnimalInterface a) {
                return a.canHop && a.canSwim;
            }
        };

        print(ai,ct);
    }


    public boolean canHop() {
        return canHop;
    }

    public boolean canSwim() {
        return canSwim;
    }

    public String toString() {
        return species;
    }

    private static void print(AnimalInterface animal, CheckTrait trait) {
        if (trait.test(animal))
        System.out.println(animal);
    }

}
