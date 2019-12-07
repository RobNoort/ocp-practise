package nl.robnoort;

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

        try {
        FlatMapExamples.main(null);
        }
        catch (IOException ex){
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
