import java.util.HashMap;

/**
 * TODO write description
 *
 * @author ckurdelak20@gorgefox.edu
 */
public class ListGraph<V, E> extends DirectedGraph<V, E> {
    private HashMap<V, Vertex<V>> _vertices;
    // vertex label -> Vertex object

    private HashMap<V, HashMap<V, Edge<V, E>>> _edges;
    // outer HashMap: source vertex label -> inner map
    //      inner HashMap: destination vertex label -> Edge from source to destination


    // G.addEdge(B, C)
    // check for duplicate edges
    // create entry of outer map if necessary
    // create entry of inner map
    // create edge


    /*
    G.removeEdge(A, B)
    find source vertex in outer layer
    find entry in inner map, remove it
     */

    /*
    G.removeVertex(B)
    remove B
    remove any edges with B as source
    remove any edges with B as destination
     */

    /*
    G.add(D)
    create vertex
    maybe add entry of outer map, but NOT of inner maps
     */
}
