import java.util.NoSuchElementException;

/**
 * An exception thrown when an attempt is made to access an edge that does not exist.
 *
 * @author ckurdelak20@gmail.com
 */
public class NoSuchEdgeException extends NoSuchElementException {
    /**
     * Creates a new NoSuchEdgeException
     */
    public NoSuchEdgeException() {
        super();
    }


    /**
     * Creates a new NoSuchEdgeException with the given message.
     *
     * @param message the message of this exception
     */
    public NoSuchEdgeException(String message) {
        super(message);
    }
}
