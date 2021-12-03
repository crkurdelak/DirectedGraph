import java.util.HashMap;

/**
 * TODO write description
 *
 * @author ckurdelak20@gorgefox.edu
 */
public class ListGraph<V, E> {
    private HashMap<V, Vertex<V>> _vertices;
    // vertex label -> Vertex object
    private HashMap<V, HashMap<V, Edge<V, E>>> _edges;
    // outer HashMap: source vertex label -> inner map
    //      inner HashMap: destination vertex label -> Edge from source to destination
}
