package com.secpisir.secpisir;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

final class MapGraph<E> implements WeightedGraph<E>{
    int numberOfVertices;
    Map<E,Edge> edges;

    public MapGraph(){
        numberOfVertices = 0;
        edges = new HashMap<>(50);
    }

    @Override
    public int getNumV() {
        return numberOfVertices;
    }

    @Override
    public boolean isDirected() {
        return false;
    }

    @Override
    public void insert(Edge<E> edge) {
        edges.put(edge.getSource(), edge);
    }

    public void insert(E source, E destination, int weight){
        Edge<E> edge = new Edge(source, destination, weight);
        insert(edge);
    }

    @Override
    public boolean isEdge(E source, E dest) {
        return edges.containsKey(source) && edges.containsValue(dest);
    }

    @Override
    public Edge getEdge(E source, E dest) {
        if(isEdge(source, dest))
            return null;
        else
            return edges.get(source);
    }

    @Override
    public Iterator<Edge> edgeIterator(E source) {
        return null;
    }
}
