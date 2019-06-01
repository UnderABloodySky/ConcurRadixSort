package threadPool;

public class PoisonException extends Exception {
    public PoisonException(String s) {
        super(s);
    }
}
