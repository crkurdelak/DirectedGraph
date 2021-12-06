import java.util.Iterator;

/**
 * AN abstract class representing a directed graph.
 *
 * @param <V> the type of the vertex labels
 * @param <E> the type of the edge labels
 *
 * @author ckurdelak20@gorgefox.edu
 */
public abstract class DirectedGraph<V, E> {
    // TODO implement class

    /**
     * Adds a new vertex to this graph.
     *
     * @param v the label of the new vertex
     */
    public abstract void add(V v);


    /**
     * Returns true if this graph contains the given vertex label.
     *
     * @param v the vertex label
     * @return true if this graph contains the given vertex label
     */
    public abstract boolean contains(V v);


    /**
     * Returns the vertex with the given label.
     *
     * @param v the vertex label
     * @return the vertex with the given label
     */
    public abstract Vertex<V> get(V v);


    /**
     * Removes the vertex with the given label from this graph.
     *
     * @param v the vertex label
     * @return
     */
    public abstract V remove(V v);

    public abstract void addEdge(V u, V v, E label);

    public abstract boolean containsEdge(V u, V v);

    public abstract Edge<V, E> getEdge(V u, V v);

    public abstract E removeEdge(V u, V v);

    public abstract int size();

    public abstract int degree(V v);

    public abstract int edgeCount();

    public abstract Iterator<Vertex<V>> vertices();

    public abstract Iterator<Vertex<V>> adjacent(V u);

    public abstract Iterator<Edge<V,E>> edges();

    public abstract void clear();

    public abstract boolean isEmpty();
}

