import java.util.Iterator;
import java.util.Objects;

/**
 * A directed graph backed by a matrix.
 *
 * @author ckurdelak20@gorgefox.edu
 */
public class MatrixGraph<V, E> extends DirectedGraph<V, E> {
    private Vertex<V>[] _vertices;
    private Edge<V, E>[][] _edges; // 2D array
    private int _size; // the actual number of vertices in the graph
    private int _edgeCount;

    private static final int DEFAULT_CAPACITY = 10;
    private static final int GROWTH_FACTOR = 10;
    private static final int NOT_FOUND = -1;

    /**
     * Creates a new matrix graph with an initial capacity of 10.
     */
    public MatrixGraph() {
        this(DEFAULT_CAPACITY);
    }


    /**
     * Creates a new matrix graph with the given initial capacity.
     *
     * @param initialCapacity the initial capacity of this matrix graph
     */
    @SuppressWarnings({"unchecked"})
    public MatrixGraph(int initialCapacity) {
        _vertices = (Vertex<V>[]) new Object[initialCapacity];
        _edges = (Edge<V, E>[][]) new Object[initialCapacity][initialCapacity];
        _size = 0;
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
     * @throws DuplicateVertexException if the specified vertex already exists
     */
    @Override
    public void add(V v) {
        if (this.contains(v)) {
            // add node:
            // linear search for first null position
            int index = indexOf(null);
            // if there isn't any, grow
            if (index == NOT_FOUND) {
                int oldLast = _vertices.length;
                this.growArray();
                index = oldLast + 1;
            }

            Vertex<V> newVertex = new Vertex<V>(v);
            _vertices[index] = newVertex;

            _size++;
        }
        else {
            throw new DuplicateVertexException();
        }
    }


    /**
     * Returns true if this graph contains the given vertex label.
     *
     * @param v the vertex label
     * @return true if this graph contains the given vertex label
     */
    @Override
    public boolean contains(V v) {
        return this.indexOf(v) != NOT_FOUND;
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
        if (this.contains(v)) {
            return _vertices[indexOf(v)];
        }
        else {
            throw new NoSuchVertexException();
        }
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
        if (this.contains(v)) {
            Vertex<V> oldVertex = this.get(v);
            _vertices[this.indexOf(v)] = null;

            for (int i = 0; i < _edges.length; i++) {
                _edges[0][i] = null;
            }
            for (int i = 0; i < _edges.length; i++) {
                _edges[i][0] = null;
            }

            _size--;

            return v;
        }
        else {
            throw new NoSuchVertexException();
        }
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
        if (!this.containsEdge(u, v)) {
            Edge<V, E> newEdge = new Edge<V, E>(u, v, label);
            int srcIndex = this.indexOf(u);
            int destIndex = this.indexOf(v);

            _edges[srcIndex][destIndex] = newEdge;

            _edgeCount++;
        }
        else {
            throw new DuplicateEdgeException();
        }
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
        int srcIndex = this.indexOf(u);
        int destIndex = this.indexOf(v);

        return srcIndex != NOT_FOUND && destIndex != NOT_FOUND;
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
        if (this.containsEdge(u, v)) {
            int srcIndex = indexOf(u);
            int destIndex = indexOf(v);

            return _edges[srcIndex][destIndex];
        }
        else {
            throw new NoSuchEdgeException();
        }
    }


    /**
     * Removes the edge with the given source and destination labels.
     *
     * @param u the label of the source vertex
     * @param v the destination vertex
     * @return the label of the edge with the given source and destination labels
     * @throws NoSuchEdgeException if the given edge does not exist
     */
    @Override
    public E removeEdge(V u, V v) {
        if (this.containsEdge(u, v)) {
            int srcIndex = this.indexOf(u);
            int destIndex = this.indexOf(v);

            Edge<V, E> oldEdge = _edges[srcIndex][destIndex];
            _edges[srcIndex][destIndex] = null;

            _edgeCount--;

            return oldEdge.getLabel();
        }
        else {
            throw new NoSuchEdgeException();
        }
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
        // TODO implement degree
        if (this.contains(v)) {
            int index = this.indexOf(v);
            int count = 0;

            for (int i = 0; i < _edges.length; i++) {
                if (_edges[0][i].equals(v)) {
                    count++;
                }
            }

            return count;
        }
        else {
            throw new NoSuchVertexException();
        }
    }


    /**
     * Returns an iterator over the vertices of this graph.
     *
     * @return an iterator over the vertices of this graph
     */
    @Override
    public Iterator<Vertex<V>> vertices() {
        // TODO implement vertices
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
        // TODO implement adjacent
        return null;
    }


    /**
     * Returns an iterator over the edges in this graph.
     *
     * @return an iterator over the edges in this graph
     */
    @Override
    public Iterator<Edge<V, E>> edges() {
        // TODO implement edges
        return null;
    }


    /**
     * Clears this graph.
     */
    @Override
    public void clear() {
        for (int i = 0; i < _vertices.length; i++) {
            _vertices[i] = null;
        }
        for (int i = 0; i < _edges.length; i++) {
            _edges[0][i] = null;
        }
        for (int i = 0; i < _edges.length; i++) {
            _edges[i][0] = null;
        }
    }


    /**
     * Returns the index of the vertex with the given label, or -1 if no such vertex exists.
     *
     * @param label the label of the vertex to locate
     * @return the index of the vertex with the given label
     *         -1 if no such vertex exists
     */
    private int indexOf(V label) {
        int index = NOT_FOUND;
        boolean isFound = false;
        int i = 0;
        while (!isFound && i < _vertices.length) {
            if (Objects.equals(label, _vertices[i])) {
                index = i;
                isFound = true;
            }
            i++;
        }
        return index;
    }


    /**
     * Grows the backing array of vertices by increasing its capacity by 10.
     */
    @SuppressWarnings({"unchecked"})
    private void growArray() {
        if (_vertices.length < Integer.MAX_VALUE) {
            Vertex<V>[] newArray = (Vertex<V>[]) new Object[_size + GROWTH_FACTOR];
            for (int i = 0; i < _vertices.length; i++) {
                newArray[i] = _vertices[i];
            }
            _vertices = newArray;
        }
        else {
            throw new OutOfMemoryError();
        }
    }


    /**
     * Grows the backing matrix of edges by increasing its capacity by 10.
     */
    @SuppressWarnings({"unchecked"})
    private void growMatrix() {
        if (_edges.length < Integer.MAX_VALUE) {
            Edge<V, E>[][] newMatrix =
                    (Edge<V, E>[][]) new Object[_size + GROWTH_FACTOR][_size + GROWTH_FACTOR];
            // for each row
            for (int i = 0; i < _edges.length; i++) {
                // for each column
                for (int j = 0; j < _edges.length; j++) {
                    newMatrix[i][j] = _edges[i][j];
                }
            }
            _edges = newMatrix;
        }
        else {
            throw new OutOfMemoryError();
        }
    }
}
