package com.secpisir.secpisir;

import java.io.Serializable;

public class IkiliAramaAgaci<E> implements SearchTree<E>{
    Node<E> root;

    @Override
    public boolean add(E item) {
        return false;
    }

    @Override
    public boolean contains(E target) {
        return false;
    }

    @Override
    public E find(E target) {
        //return find(root,target);
        return null;
    }


    @Override
    public E delete(E target) {
        return null;
    }

    @Override
    public boolean remove(E target) {
        return false;
    }

    protected static class Node<E>
            implements Serializable/*, Comparable<Node<MDStree.Multidimensional>> */{
        protected E data;
        protected Node<E> left ;
        protected Node<E> right ;

        public Node() {
            data = null;
            left = null;
            right = null;
        }
        public Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }
        public Node(Node<E> copy) {
            this.data = copy.data;
            left = copy.left;
            right = copy.right;
        }

        public String toString() {
            return data.toString();
        }

        @Override
        public boolean equals(Object o) {
            return ((Node<E>)o).data == this.data ;
        }
    }


}
