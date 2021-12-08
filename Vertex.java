/**
 * A vertex in a directed graph.
 *
 * @param <V> the type of the vertex labels
 *
 * @author ckurdelak20@gmail.com
 */
public class Vertex<V> {
    private V _label;

    /**
     * Creates a new vertex with the given label.
     *
     * @param label the label for this vertex
     */
    public Vertex(V label) {
        _label = label;
    }


    /**
     * Returns the label of this vertex.
     *
     * @return the label of this vertex
     */
    public V getLabel() {
        return _label;
    }


    /**
     * Returns true if this vertex is equal to the given vertex.
     *
     * Vertices are considered equal if and only if their labels are equal.
     *
     * @param o the vertex to compare to this vertex
     * @return true if this vertex is equal to the given vertex
     */
    public boolean equals(Vertex<V> o) {
        return this.getLabel().equals(o.getLabel());
    }
}
