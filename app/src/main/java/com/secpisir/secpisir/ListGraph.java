package com.secpisir.secpisir;

//The implementation of ListGraph belongs to Koffman and Wolfgang

import java.util.*;
/** A ListGraph is an extension of the AbstractGraph abstract class
 that uses an array of lists to represent the edges.
 */
public class ListGraph {
// Data Field
    /**
     * An array of Lists to contain the edges that
     * originate with each vertex.
     */
    private List<Edge>[] edges;
    private int numV;
    boolean directed;
    /**
     * Construct a graph with the specified number of vertices and directionality.
     *
     * @param numV     The number of vertices
     * @param directed The directionality flag
     */
    public ListGraph(int numV, boolean directed) {
        this.numV = numV;
        this.directed = directed;
        edges = new List[numV];
        for (int i = 0; i < numV; i++) {
            edges[i] = new LinkedList<Edge>();
        }
    }

    /** Determine whether an edge exists.
     @param source The source vertex
     @param dest The destination vertex
     @return true if there is an edge from source to dest
     */
    public boolean isEdge(int source, int dest) {
        return edges[source].contains(new Edge(source, dest));
    }

    /** Insert a new edge into the graph.
     @param edge The new edge
     */
    public void insert(Edge edge) {
        edges[edge.getSource()].add(edge);
        if (directed == false) {
            edges[edge.getDest()].add(new Edge(edge.getDest(), edge.getSource(),
                    edge.getWeight()));
        }
    }

    public void insert(int source, int destination, int weight){
        Edge edge = new Edge(source, destination, weight);
        insert(edge);
    }

    public Iterator<Edge> edgeIterator(int source) {
        return edges[source].iterator();
    }

    /** Get the edge between two vertices.
     @param source The source
     @param dest The destination
     @return the edge between these two vertices
     or null if an edge does not exist.
     */
    public Edge getEdge(int source, int dest) {
        Edge target = new Edge(source, dest, Integer.MAX_VALUE);
        for (Edge edge: edges[source]) {
            if (edge.equals(target))
                return edge; // Desired edge found, return it.
        }
        // Assert: All edges for source checked.
        return null; // Desired edge not found.
    }

    public List<Edge> getAdjacents(int source){
        return edges[source];
    }
}
