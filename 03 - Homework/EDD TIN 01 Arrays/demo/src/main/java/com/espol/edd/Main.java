package com.espol.edd;

public class Main {
    public static void main(String[] args) {

        // Ejercicio 1: Prueba de ArrayList
        title("Ejercicio 1: Prueba de ArrayList");
        MyArrayList<Dog> arraylist = new MyArrayList<>(); // Creo la lista

        String[] dogNames = {"ChowChow", "Husky", "PugDog", "BullDog"}; // Nombres de perros (Ejemplo de Objetos)
        for (String name : dogNames) {arraylist.add(new Dog(name));} // Añado perros a la lista a partir del arreglo

        for (int i = 0; i < dogNames.length; i++) {
            Dog dogAL = arraylist.get(i);
            System.out.println("Elemento en la posición " + i + ": " + dogAL);
        }



        // Ejercicio 2: Prueba de LinkedList
        title("Ejercicio 2: Prueba de LinkedList");
        MyLinkedList<Dog> linkedlist = new MyLinkedList<>(); // Creo la lista

        for (String dogName : dogNames) {
            linkedlist.addLast(new Dog(dogName));
            System.out.println("Último elemento: " + linkedlist.getLast()); // Reviso si el perro se guardó
            System.out.println("Tamaño de la lista: " + linkedlist.size()); // Reviso el tamaño de la lista
        }



        // Ejercicio 3: Crear clase Nodo [Ya implementado]
        title("Ejercicio 3: Crear clase Nodo");
        System.out.println("[Convalidado]");



        // Ejercicio 4: Crear nodos
        title("Ejercicio 4: Prueba de Nodos");
        Nodo<Integer> head = null; // Cabeza de la linked list
        Nodo<Integer> tail = null; // Cola de la linked list

        // 4.1 Crear nodos del 1 al 30
        for (int i = 1; i <= 30; i++) { // Creo nodos del 1 al 30
            Nodo<Integer> nuevoNodo = new Nodo<>(i); // Creo el nodo
            if (head == null) {head=tail=nuevoNodo;} // Si es el primer nodo, cabeza y cola apuntan a él
            else { // Si no, añado el nodo al final y actualizo la cola
                tail.next = nuevoNodo;
                tail = nuevoNodo;
            }
        }

        // 4.2 Imprimir la linked list
        Nodo<Integer> actual = head; // Empiezo desde la cabeza
        while (actual != null) { // Recorre hasta el final (null significa que no hay más nodos)
            System.out.print(actual.data); // Imprime el dato del nodo actual
            actual = actual.next; // Mueve al siguiente nodo
            if (actual != null) System.out.print(" -> "); // Imprime el separador si no es el último nodo
            else System.out.println(); // Salto de línea al final
        }

        // Ejercicio 5: Crear Clase DoublyNode (Nodo Doblemente Enlazado)
        title("Ejercicio 5: Crear Clase DoublyNode");
        System.out.println("[Convalidado]");
    }

    // Métodos Extra
    public static void title(String title) {System.out.println("\n=== " + title + " ===");}
}