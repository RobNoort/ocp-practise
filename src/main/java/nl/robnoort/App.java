package nl.robnoort;

import nl.robnoort.exceptions.TestExceptions;

import java.io.IOException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        App app = new App();
        app.testExceptions();

    }
    public void testExceptions(){

        try {
            TestExceptions testExceptions = new TestExceptions();
            testExceptions.testExceptions();
//        } catch (TestExceptions.CannotSwimException e) {
//            e.printStackTrace();
//            throw new RuntimeException("hier niet");
        } catch (RuntimeException ex) {
            System.out.println("hier wel");
        }
    }

}

