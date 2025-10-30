package com.espol.edd;

// NodoDE.java
// Nodo para lista doblemente enlazada

public class DoublyNode<E> {
    E data; // dato almacenado
    DoublyNode<E> next; // referencia al siguiente
    DoublyNode<E> prev; // referencia al anterior

    public DoublyNode(E data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public DoublyNode(E data, DoublyNode<E> next, DoublyNode<E> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    // Getters/Setters simples (opcionales si quieren mantener los campos package-private)
    public E getData() { return data; }
    public void setData(E data) { this.data = data; }
    public DoublyNode<E> getNext() { return next; }
    public void setNext(DoublyNode<E> next) { this.next = next; }
    public DoublyNode<E> getPrev() { return prev; }
    public void setPrev(DoublyNode<E> prev) { this.prev = prev; }
}