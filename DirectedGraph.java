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

    /**
     * Adds a new vertex to this graph.
     *
     * @param v the label of the new vertex
     * @throws DuplicateVertexException if the specified vertex already exists
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
     * @throws NoSuchVertexException if the specified vertex does not exist
     */
    public abstract Vertex<V> get(V v);


    /**
     * Removes the vertex with the given label from this graph.
     *
     * @param v the vertex label
     * @return the vertex with the given label
     * @throws NoSuchVertexException if the specified vertex does not exist
     */
    public abstract V remove(V v);


    /**
     * Adds a new edge to this graph.
     *
     * @param u the label of the source vertex
     * @param v the label of the destination vertex
     * @param label the label of the new edge
     * @throws DuplicateEdgeException if the specified edge already exists
     * @throws NoSuchVertexException if the specified source or destination does not exist
     */
    public abstract void addEdge(V u, V v, E label);


    /**
     * Returns true if this graph contains an edge with the given source and destination vertex
     * labels.
     *
     * @param u the label of the source vertex
     * @param v the label of the destination vertex
     * @return true if this graph contains an edge with the given source and destination vertex
     * labels.
     * @throws NoSuchVertexException if the specified source or destination does not exist
     */
    public abstract boolean containsEdge(V u, V v);


    /**
     * Returns the edge with the given source and destination labels.
     *
     * @param u the label of the source vertex
     * @param v the destination vertex
     * @return the edge with the given source and destination labels
     * @throws NoSuchEdgeException if the specified edge does not exist
     * @throws NoSuchVertexException if the specified source or destination does not exist
     */
    public abstract Edge<V, E> getEdge(V u, V v);


    /**
     * Removes the edge with the given source and destination labels.
     *
     * @param u the label of the source vertex
     * @param v the destination vertex
     * @return the label of the edge with the given source and destination labels
     * @throws NoSuchEdgeException if the specified edge does not exist
     * @throws NoSuchVertexException if the specified source or destination does not exist
     */
    public abstract E removeEdge(V u, V v);


    /**
     * Returns the size of this graph.
     *
     * @return the size of this graph
     */
    public abstract int size();


    /**
     * Returns the degree of this vertex.
     *
     * @param v the label of this vertex
     * @return the degree of this vertex
     * @throws NoSuchVertexException if the specified vertex does not exist
     */
    public abstract int degree(V v);


    /**
     * Returns the number of edges in this graph.
     *
     * @return the number of edges in this graph
     */
    public abstract int edgeCount();


    /**
     * Returns an iterator over the vertices of this graph.
     *
     * @return an iterator over the vertices of this graph
     */
    public abstract Iterator<Vertex<V>> vertices();


    /**
     * Returns an iterator over all the destination vertices that are adjacent to the specified
     * source vertex.
     *
     * @param u the source vertex label
     * @return an iterator over all the destination vertices that are adjacent to the specified
     * source vertex.
     * @throws NoSuchVertexException if the specified vertex does not exist
     */
    public abstract Iterator<Vertex<V>> adjacent(V u);


    /**
     * Returns an iterator over the edges in this graph.
     *
     * @return an iterator over the edges in this graph
     */
    public abstract Iterator<Edge<V,E>> edges();


    /**
     * Clears this graph.
     */
    public abstract void clear();


    /**
     * Returns true if this graph is empty.
     *
     * @return true if this graph is empty
     */
    public boolean isEmpty() {
        return this.size() == 0;
    }
}

