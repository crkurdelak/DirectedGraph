import java.util.NoSuchElementException;

/**
 * An exception thrown when an attempt is made to access a vertex that does not exist.
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
     * Creates a new NoSuchVertexException with the given message.
     *
     * @param message the message of this exception
     */
    public NoSuchVertexException(String message) {
        super(message);
    }
}
