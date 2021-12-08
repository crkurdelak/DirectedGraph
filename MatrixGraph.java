import java.util.Iterator;

/**
 * A directed graph backed by a matrix.
 *
 * @author ckurdelak20@gorgefox.edu
 */
public class MatrixGraph<V, E> extends DirectedGraph<V, E> {
    private Vertex<V>[] _vertices;
    private Edge<V, E>[][] _edges; // 2D array
    private int _size;
    private int _currentIndex;
    private int _edgeCount;

    private static int _DEFAULT_CAPACITY = 10;

    /**
     * Creates a new matrix graph with an initial capacity of 10.
     */
    public MatrixGraph() {
        this(_DEFAULT_CAPACITY);
    }


    /**
     * Creates a new matrix graph with the given initial capacity.
     *
     * @param initialCapacity the initial capacity of this matrix graph
     */
    @SuppressWarnings("unchecked")
    public MatrixGraph(int initialCapacity) {
        _vertices = (Vertex<V>[]) new Object[initialCapacity];
        _edges = (Edge<V, E>[][]) new Object[initialCapacity][initialCapacity];
        _size = 0;
        _currentIndex = 0;
        _edgeCount = 0;
    }


    // linear search rows to find source
    // linear search columns to find destination

    // remove vertex A:
    // null out vertex
    // null out all edges where A was source
    // null out every edge where A was destination

    // to remove a vertex: O(3|v| + 1) = O(|v|)
    // |v| =  "number of vertices"
    // |E| = "number of edges"
    // O(|v|) linear search of _vertices to determine index
    // O(1) remove vertex from _vertices
    // O(|v|) for-loop to remove edges from _edges where vertex is source
    // O(|v|) for-loop to remove edges from _edges where vertex is destination

    // add node:
    // linear search for first null position
    // if there isn't any, grow

    // growth strategy:
    // *2 growth
    // O(|v|^2) copy n*n items to new array, to save space
    // OR
    // grow by + 1, + k

    /**
     * Adds a new vertex to this graph.
     *
     * @param v the label of the new vertex
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
     */
    @Override
    public Vertex<V> get(V v) {
        return null;
    }

    /**
     * Removes the vertex with the given label from this graph.
     *
     * @param v the vertex label
     * @return
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


    /**
     * Returns the index of the vertex with the given label.
     *
     * @param label the label of the vertex to locate
     * @return the index of the vertex with the given label
     */
    private int findIndex(V label) {
        // TODO implement findIndex
    }
}
