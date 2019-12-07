package nl.robnoort.classes;

public class ClassDesign {

    static class Nested {
        public static int price = 6;
        private int privPrice = 7;
    }

    public static void main(String[] args) {
        testStatic();
        checkInstanceOf();
        Season.testEnums();
        InnerClasses.start();
    }

    private static void testStatic() {
        System.out.println("static price nested class: " + Nested.price);
        Nested nested = new Nested();
        System.out.println("instance price: " + nested.privPrice);

    }

    private static void checkInstanceOf() {
        SubClassDesign md = null;
        boolean io = md instanceof SubClassDesign;  //false
        System.out.println("empty MD " + io);
        SubClassDesign md2 = new SubClassDesign();
        io = md2 instanceof SubClassDesign; //true
        System.out.println("instantiated MD " + io);
        io = md2 instanceof ClassDesign; //true
        System.out.println("also super CD?  " + io);
    }
}

class SubClassDesign extends ClassDesign {
}

enum Season {
    WINTER("Low") {
        public void printHours() {
            System.out.println("10am-3pm");
        }
    },
    SPRING("Medium") {
        public void printHours() {
            System.out.println("9am-4pm");
        }
    },
    SUMMER("High") {
        public void printHours() {
            System.out.println("8am-8pm");
        }
    },
    FALL("Medium") {
        public void printHours() {
            System.out.println("9am-3pm");
        }
    };

    public void printHours() { //needed otherwise not seen  Could also be abstract
    };

    private String expectedVisitors;

    Season(String expectedVisitors) {   //constructor
        this.expectedVisitors = expectedVisitors;
    }

    private void printSeasonDetails() {
        System.out.printf("\n in season %s visitors expected %s", this.name(), expectedVisitors);
        System.out.printf("\n in season %s opening hours are : ", this.name());
        this.printHours();
    }
    public static void testEnums() {
        Season.SPRING.printSeasonDetails();
    }

}

class InnerClasses {

    //innerclasses can see private variables of super
    private int x = 10;

    class B {
        private int x = 20;

        class C {
            private int x = 30;

            public void allTheX() {
                System.out.println("Class variable: x " + x); // 30
                System.out.println("Class variable: this.x " + this.x); // 30
                System.out.println("SuperClass private variable: B.this.x " + B.this.x); // 20
                System.out.println("SuperSuperClass private variable: A.this.x " + InnerClasses.this.x); // 10
            }
        }
    }

    public static void start() {
        InnerClasses a = new InnerClasses();
        InnerClasses.B b = a.new B();
        InnerClasses.B.C c = b.new C();
        c.allTheX();
    }
}