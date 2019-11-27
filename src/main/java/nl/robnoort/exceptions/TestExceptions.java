package nl.robnoort.exceptions;

public class TestExceptions {
    public void testExceptions() {
        try {
            throw new CannotSwimException(" kan niet zwemmen ");

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex.getMessage());
        }

    }

   public class CannotSwimException  extends Exception {

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
