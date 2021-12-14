import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/**
 * A directed graph backed by a hashmap
 *
 * @author ckurdelak20@gorgefox.edu
 */
public class ListGraph<V, E> extends DirectedGraph<V, E> {
    private HashMap<V, Vertex<V>> _vertices;
    // vertex label -> Vertex object

    private HashMap<V, HashMap<V, Edge<V, E>>> _edges;
    // outer HashMap: source vertex label -> inner map
    //      inner HashMap: destination vertex label -> Edge from source to destination
    private int _size;
    private int _edgeCount;

    /**
     * Creates a new list graph.
     */
    public ListGraph() {
        _vertices = new HashMap<V, Vertex<V>>();
        _edges = new HashMap<V, HashMap<V, Edge<V, E>>>();
    }


    /**
     * Adds a new vertex to this graph.
     *
     * @param v the label of the new vertex
     * @throws DuplicateVertexException if the specified vertex already exists
     */
    @Override
    public void add(V v) {
        if (!this.contains(v)) {
            Vertex<V> newVertex = new Vertex<V>(v);
            _vertices.put(v, newVertex);
            _size ++;
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
        return _vertices.containsKey(v);
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
            return _vertices.get(v);
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
            Vertex<V> oldVertex = _vertices.remove(v);
            _edgeCount -= _edges.remove(v).size(); // TODO update _edgeCount

            for (V key : _edges.keySet()) {
                HashMap<V, Edge<V, E>> inner = _edges.get(key);
                inner.remove(v);
                _edgeCount --;
            }

            _size --;
            return oldVertex.getLabel();
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
     * @throws NoSuchVertexException  if the specified source or destination does not exist
     */
    @Override
    public void addEdge(V u, V v, E label) {
        if (this.contains(u) && this.contains(v)) {
            if (!this.containsEdge(u, v)) {
                Edge<V, E> newEdge = new Edge<V, E>(u, v, label);

                if (!_edges.containsKey(u)) {
                    _edges.put(u, new HashMap<V, Edge<V, E>>());
                }

                _edges.get(u).put(v, newEdge);
                _edgeCount ++;
            }
            else {
                throw new DuplicateEdgeException();
            }
        }
        else {
            throw new NoSuchVertexException();
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
     * @throws NoSuchVertexException if the specified source or destination does not exist
     */
    @Override
    public boolean containsEdge(V u, V v) {
        if (this.contains(u) && this.contains(v)) {
            return _edges.containsKey(u) && _edges.get(u).containsKey(v);
        }
        else {
            throw new NoSuchVertexException();
        }
    }


    /**
     * Returns the edge with the given source and destination labels.
     *
     * @param u the label of the source vertex
     * @param v the destination vertex
     * @return the edge with the given source and destination labels
     * @throws NoSuchEdgeException   if the specified edge does not exist
     * @throws NoSuchVertexException if the specified source or destination does not exist
     */
    @Override
    public Edge<V, E> getEdge(V u, V v) {
        if (this.contains(u) && this.contains(v)) {
            if (this.containsEdge(u, v)) {
                return _edges.get(u).get(v);
            }
            else {
                throw new NoSuchEdgeException();
            }
        }
        else {
            throw new NoSuchVertexException();
        }
    }


    /**
     * Removes the edge with the given source and destination labels.
     *
     * @param u the label of the source vertex
     * @param v the destination vertex
     * @return the label of the edge with the given source and destination labels
     * @throws NoSuchEdgeException   if the specified edge does not exist
     * @throws NoSuchVertexException if the specified source or destination does not exist
     */
    @Override
    public E removeEdge(V u, V v) {
        if (this.contains(u) && this.contains(v)) {
            if (this.containsEdge(u, v)) {
                Edge<V, E> oldEdge = _edges.get(u).remove(v);

                _edgeCount --;
                return oldEdge.getLabel();
            }
            else {
                throw new NoSuchEdgeException();
            }
        }
        else {
            throw new NoSuchVertexException();
        }
    }


    /**
     * Returns the size of this graph.
     *
     * @return the size of this graph
     */
    public int size() {
        return _size;
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
        if (this.contains(v)) {
            Collection<Vertex<V>> vertices = _vertices.values();
            int count = 0;
            for (Vertex<V> vertex : vertices) {
                V srcVertexLabel = vertex.getLabel();
                if (_edges.containsKey(srcVertexLabel)) {
                    count += _edges.get(srcVertexLabel).size(); // TODO fix this part
                }
            }

            return count;
        }
        else {
            throw new NoSuchVertexException();
        }
    }


    /**
     * Returns the number of edges in this graph.
     *
     * @return the number of edges in this graph
     */
    public int edgeCount() {
        return _edgeCount;
    }


    /**
     * Returns an iterator over the vertices of this graph.
     *
     * @return an iterator over the vertices of this graph
     */
    @Override
    public Iterator<Vertex<V>> vertices() {
        Collection<Vertex<V>> vertices = _vertices.values();
        return vertices.iterator();
    }


    /**
     * Returns an iterator over all the destination vertices that are adjacent to the specified
     * source vertex.
     *
     * @param u the source vertex label
     * @return an iterator over all the destination vertices that are adjacent to the specified
     * source vertex.
     * @throws NoSuchVertexException if the specified vertex does not exist
     */
    @Override
    public Iterator<Vertex<V>> adjacent(V u) {
        if (this.contains(u)) {
            Collection<Vertex<V>> vertices = _vertices.values();
            Collection<Vertex<V>> adjacentVertices = new ArrayList<Vertex<V>>();
            if (_edges.containsKey(u)) {
                Collection<Edge<V, E>> edges = _edges.get(u).values();
                for (Edge<V, E> edge : edges) {
                    adjacentVertices.add(this.get(edge.getV()));
                }
            }

            return adjacentVertices.iterator();
        }
        else {
            throw new NoSuchVertexException();
        }
    }


    /**
     * Returns an iterator over the edges in this graph.
     *
     * @return an iterator over the edges in this graph
     */
    @Override
    public Iterator<Edge<V, E>> edges() {
        Collection<HashMap<V, Edge<V, E>>> maps = _edges.values();
        Collection<Edge<V, E>> edges = new ArrayList<Edge<V, E>>();
        for (HashMap<V, Edge<V, E>> map : maps) {
            Collection<Edge<V, E>> values = map.values();
            edges.addAll(values);
        }

        return edges.iterator();
    }


    /**
     * Clears this graph.
     */
    @Override
    public void clear() {
        _vertices.clear();
        _edges.clear();
        _size = 0;
        _edgeCount = 0;
    }
}