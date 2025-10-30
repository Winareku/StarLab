package com.espol.edd;

// MyLinkedList.java
// Lista simplemente enlazada genérica SIN usar java.util.LinkedList

public class MyLinkedList<E> {

    private Nodo<E> head;  // primero
    private Nodo<E> tail;  // último (opcional pero útil)


    public MyLinkedList() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {return head == null;}

    // Inserta al final (ayuda para pruebas)
    public void addLast(E value) {
        Nodo<E> nuevo = new Nodo<>(value);
        if (isEmpty()) {head = tail = nuevo;}
        else {
            tail.next = nuevo;
            tail = nuevo;
        }
    }

    public E getFirst() {
        if (isEmpty()) throw new IllegalStateException("Lista vacía");
        return head.data;
    }

    public E getLast() {
        if (isEmpty()) throw new IllegalStateException("Lista vacía");
        return tail.data;
    }

    public Nodo<E> getHead() {return head;}

    /**
     * Ejercicio 2:
     * Implementa size() sin usar estructuras auxiliares:
     *  - Recorre desde head usando un puntero temporal
     *  - Cuenta los nodos hasta llegar a null
     *  - Devuelve el conteo
     */

    public int size() {
        int count = 0; // Cuenta los elementos que hay en la lista

        Nodo<E> actual = head; // Nodo que usaré, empieza desde head

        while (actual != null) { // Itera hasta llegar a null (indica el final de la lista)
            actual = actual.next; // Mueve al siguiente nodo
            count++; // Incrementa el conteo
        }

        return count; // Devuelve el conteo final
    }

    // (Opcional) método para imprimir la lista: útil para debug
    public void print() {
        Nodo<E> curr = head;
        while (curr != null) {
            System.out.print(curr.data);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }
}
