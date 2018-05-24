package com.secpisir.secpisir;

import java.util.Iterator;

public interface WeightedGraph<E> {
    // Accessor Methods
    /** Return the number of vertices.
     @return The number of vertices
     */
    int getNumV();
    /** Determine whether this is a directed graph.
     @return true if this is a directed graph
     */
    boolean isDirected();
    /** Insert a new edge into the graph.
     @param edge The new edge
     */
    void insert(Edge<E> edge);
    /** Determine whether an edge exists.
     @param source The source vertex
     @param dest The destination vertex
     @return true if there is an edge from source to dest
     */
    boolean isEdge(E source, E dest);
    /** Get the edge between two vertices.
     @param source The source vertex
     @param dest The destination vertex
     @return The Edge between these two vertices
     or null if there is no edge
     */
    Edge getEdge(E source, E dest);
    /** Return an iterator to the edges connected to a given vertex.
     @param source The source vertex
     @return An Iterator<Edge> to the vertices connected to source
     */
    Iterator<Edge> edgeIterator(E source);
}