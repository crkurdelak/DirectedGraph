/**
 * TODO write description
 *
 * @author ckurdelak20@gorgefox.edu
 */
public class MatrixGraph<V, E> extends DirectedGraph<V, E> {
    private Vertex<V>[] _vertices;
    private Edge<V, E>[][] _edges; // 2D array

    /**
     *
     */
    public MatrixGraph() {
        // TODO implement ctors
    }


    /**
     *
     * @param initialCapacity
     */
    public MatrixGraph(int initialCapacity) {

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
}
