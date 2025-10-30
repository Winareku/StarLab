package com.espol.edd;

// Nodo.java
// Nodo para lista simplemente enlazada

public class Nodo<E> {
    E data;           // dato almacenado
    Nodo<E> next;     // referencia al siguiente

    public Nodo(E data) {
        this.data = data;
        this.next = null;
    }

    public Nodo(E data, Nodo<E> next) {
        this.data = data;
        this.next = next;
    }

    // Getters/Setters simples (opcionales si quieren mantener los campos package-private)
    public E getData() { return data; }
    public void setData(E data) { this.data = data; }
    public Nodo<E> getNext() { return next; }
    public void setNext(Nodo<E> next) { this.next = next; }
}