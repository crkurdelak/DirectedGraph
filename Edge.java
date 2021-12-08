/**
 * An edge between two vertices in a directed graph.
 *
 * @param <V> the type of the vertex labels
 * @param <E> the type of the edge labels
 *
 * @author ckurdelak20@gmail.com
 */
public class Edge<V, E> {
    private V _src;
    private V _dest;
    private E _label;


    /**
     * Creates a new edge from the given source vertex to the given destination vertex.
     *
     * @param u the label of the source vertex
     * @param v the label of the destination vertex
     * @param label the label of this edge
     */
    public Edge(V u, V v, E label) {
        // TODO implement ctor
    }


    /**
     * Returns the source vertex of this edge.
     *
     * @return the source vertex of this edge
     */
    public V getU() {
        // TODO implement getU
    }


    /**
     * Returns the destination vertex of this edge.
     *
     * @return the destination vertex of this edge
     */
    public V getV() {
        // TODO implement getV
    }


    /**
     * Returns the label of this edge.
     *
     * @return the label of this edge
     */
    public E getLabel() {
        // TODO implement getLabel
    }


    /**
     * Sets the label of this edge to the given value.
     *
     * @param label the new label of this edge
     */
    public void setLabel(E label) {
        // TODO implement setLabel
    }


    /**
     * Returns true if this edge is equal to the given edge.
     *
     * Edges are considered equal if their source and destination labels are equal.
     *
     * @param o the edge to compare this edge to
     * @return true if this edge is equal to the given edge
     */
    public boolean equals(Edge<V,E> o) {
        // TODO implement equals
    }
}
