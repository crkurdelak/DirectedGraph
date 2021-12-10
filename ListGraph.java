import java.util.HashMap;
import java.util.Iterator;

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


    /**
     * Adds a new vertex to this graph.
     *
     * @param v the label of the new vertex
     * @throws DuplicateVertexException if the specified vertex already exists
     */
    @Override
    public void add(V v) {

    }

    /**
     * Returns true if this graph contains the given vertex label.
     *
     * @param v the vertex label
     * @return true if this graph contains the given vertex label
     */
    @Override
    public boolean contains(V v) {
        return false;
    }

    /**
     * Returns the vertex with the given label.
     *
     * @param v the vertex label
     * @return the vertex with the given label
     * @throws NoSuchVertexException if the specified vertex does not exist
     */
    @Override
    public Vertex<V> get(V v) {
        return null;
    }

    /**
     * Removes the vertex with the given label from this graph.
     *
     * @param v the vertex label
     * @return the vertex with the given label
     * @throws NoSuchVertexException if the specified vertex does not exist
     */
    @Override
    public V remove(V v) {
        return null;
    }

    /**
     * Adds a new edge to this graph.
     *
     * @param u     the label of the source vertex
     * @param v     the label of the destination vertex
     * @param label the label of the new edge
     * @throws DuplicateEdgeException if the specified edge already exists
     */
    @Override
    public void addEdge(V u, V v, E label) {

    }

    /**
     * Returns true if this graph contains an edge with the given source and destination vertex
     * labels.
     *
     * @param u the label of the source vertex
     * @param v the label of the destination vertex
     * @return true if this graph contains an edge with the given source and destination vertex
     * labels.
     */
    @Override
    public boolean containsEdge(V u, V v) {
        return false;
    }

    /**
     * Returns the edge with the given source and destination labels.
     *
     * @param u the label of the source vertex
     * @param v the destination vertex
     * @return the edge with the given source and destination labels
     * @throws NoSuchEdgeException if the specified edge does not exist
     */
    @Override
    public Edge<V, E> getEdge(V u, V v) {
        return null;
    }

    /**
     * Removes the edge with the given source and destination labels.
     *
     * @param u the label of the source vertex
     * @param v the destination vertex
     * @return the label of the edge with the given source and destination labels
     * @throws NoSuchEdgeException if the specified edge does not exist
     */
    @Override
    public E removeEdge(V u, V v) {
        return null;
    }

    /**
     * Returns the degree of this vertex.
     *
     * @param v the label of this vertex
     * @return the degree of this vertex
     * @throws NoSuchVertexException if the specified vertex does not exist
     */
    @Override
    public int degree(V v) {
        return 0;
    }

    /**
     * Returns an iterator over the vertices of this graph.
     *
     * @return an iterator over the vertices of this graph
     */
    @Override
    public Iterator<Vertex<V>> vertices() {
        return null;
    }

    /**
     * Returns an iterator over all the destination vertices that are adjacent to the specified
     * source vertex.
     *
     * @param u the source vertex label
     * @return an iterator over all the destination vertices that are adjacent to the specified
     * source vertex.
     */
    @Override
    public Iterator<Vertex<V>> adjacent(V u) {
        return null;
    }

    /**
     * Returns an iterator over the edges in this graph.
     *
     * @return an iterator over the edges in this graph
     */
    @Override
    public Iterator<Edge<V, E>> edges() {
        return null;
    }

    /**
     * Clears this graph.
     */
    @Override
    public void clear() {

    }
}