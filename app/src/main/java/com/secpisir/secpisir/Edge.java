package com.secpisir.secpisir;

class Edge<E> {
    private int weight;
    private E source, destination;
    Edge(E source, E destination, int weight){
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
    public E getDestination() {
        return destination;
    }
    public E getSource() {
        return source;
    }
    public int getWeight() {
        return weight;
    }
}
