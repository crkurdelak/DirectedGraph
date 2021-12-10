/**
 * An exception thrown when an attempt is made to create an edge that already exists.
 *
 * @author ckurdelak20@gmail.com
 */
public class DuplicateEdgeException extends RuntimeException {
    /**
     * Creates a new DuplicateEdgeException
     */
    public DuplicateEdgeException() {
        super();
    }


    /**
     * Creates a new DuplicateEdgeException with the given message.
     *
     * @param message the message of this exception
     */
    public DuplicateEdgeException(String message) {
        super(message);
    }
}
