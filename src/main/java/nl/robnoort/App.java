package nl.robnoort;

import nl.robnoort.exceptions.TestExceptions;

import java.io.IOException;

import nl.robnoort.streams.FlatMapExamples;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        App app = new App();
        
   //     app.startTestExceptions();
        app.testEquals();

        try {
        FlatMapExamples.main(null);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }

    }

    public void startTestExceptions () {
        try {
            this.testExceptions();
        } catch (CannotSwimException e) {
            e.printStackTrace();
            throw new RuntimeException("hier");
        }
    }
    public void testExceptions() throws CannotSwimException {
        try {
            throw new CannotSwimException(" kan niet zwemmen ");
           
        } catch (Exception ex) {
             ex.printStackTrace();
            throw new RuntimeException(ex.getMessage());
        }

    }
    public void testEquals() {

        String s1 = "lion";
        String s2 = "lion";
        System.out.println(s1.equals(s2));       // true equal method checks content
        StringBuilder sb1 = new StringBuilder("lion");
        StringBuilder sb2 = new StringBuilder("lion");
        System.out.println(sb1.equals(sb2));   // false equals method from Object, so checks reference
    }

    class CannotSwimException  extends Error {
        
        public CannotSwimException(String message) {
            super(message);
        }

        private static final long serialVersionUID = 1L;
    }

    class DangerInTheWater extends RuntimeException {
        private static final long serialVersionUID = 1L;
    }

    class SharkInTheWaterException extends DangerInTheWater {
        private static final long serialVersionUID = 1L;
    }


}
