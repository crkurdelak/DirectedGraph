import java.util.NoSuchElementException;

/**
 *
 *
 * @author ckurdelak20@gmail.com
 */
public class NoSuchVertexException extends NoSuchElementException {
    /**
     * Creates a new NoSuchVertexException
     */
    public NoSuchVertexException() {
        super();
    }


    /**
     * Creates
     *
     * @param message
     */
    public NoSuchVertexException(String message) {
        super(message);
    }
}
