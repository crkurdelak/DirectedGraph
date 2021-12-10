/**
 * An exception thrown when an attempt is made to create a vertex that already exists.
 *
 * @author ckurdelak20@gmail.com
 */
public class DuplicateVertexException extends RuntimeException {
    /**
     * Creates a new DuplicateVertexException
     */
    public DuplicateVertexException() {
        super();
    }


    /**
     * Creates a new DuplicateVertexException with the given message.
     *
     * @param message the message of this exception
     */
    public DuplicateVertexException(String message) {
        super(message);
    }
}
