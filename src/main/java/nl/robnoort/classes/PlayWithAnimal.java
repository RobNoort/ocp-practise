package nl.robnoort.classes;

abstract class Animal {
    String name = "???";

    public void printName() {
        System.out.println(name);
    }

    public void careFor() {
        play();
    }

    public void play() {
        System.out.println("pet animal");
    }
}

class Lion extends Animal {
    //  String name = "Leo";  // Now taken from parent

    @Override
    public void printName() {
        System.out.println(name);
    }

    @Override
    public void play() {
        System.out.println("toss in meat");
    }
}

public class PlayWithAnimal {
    public static void main(String... args) {
        // Animal determines which methods are available // from Lion up java looks for first METHOD
        // where it finds the method, the variables are taken. If not found lookup at Super
        Animal animal = new Lion();
        animal.printName(); // ???   instance variable are not overridden but hidden
        animal.careFor();
    }
}

