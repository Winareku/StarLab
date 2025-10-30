package com.espol.edd;

// MyArrayList.java

public class MyArrayList<E> {
    // Arreglo interno y cantidad de elementos válidos
    private E[] data; // Arreglo genérico
    private int size; // Cantidad de elementos válidos

    // Capacidad inicial por defecto
    private static final int DEFAULT_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        // Creamos un arreglo de Object y casteamos a E[]
        this.data = (E[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public int size() {return size;}

    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    public void set(int index, E value) {
        checkIndex(index);
        data[index] = value;
    }

    private void checkIndex(int index) {if (index < 0 || index >= size) throw new IndexOutOfBoundsException("index=" + index);}

    // Asegura capacidad: si está lleno, crece en 50% (capNueva = capVieja + capVieja/2)
    @SuppressWarnings("unchecked")
    private void ensureCapacityForAdd() {
        int length = data.length; // Tamaño del arreglo actual
        if (size == length) { // Comparo si los tamaños coinciden, es decir, si el último elemento no está vacío
            int newCapacity = length + (length / 2); // Crece 50% de capacidad
            E[] newData = (E[]) new Object[newCapacity]; // Creo un nuevo array para reemplazar al anterior
            for (int i = 0; i < size; i++) {newData[i] = data[i];} // Lleno de nuevo este array con los datos del anterior
            this.data = newData; // Reemplazo el array
        }
    }

    /**
     * Ejercicio 1:
     * Implementa el método add(E elemento):
     *  - Verificar si hay capacidad; si no, llamar a ensureCapacityForAdd()
     *  - Insertar el elemento al final
     *  - Incrementar size
     */
    
    public void add(E elemento) {
        ensureCapacityForAdd(); // Llama al método para asegurarse de que la lista no esté llena
        data[size] = elemento; // Añade el elemento al final del array
        size++; // Aumenta el size (número de elementos) de la lista
    }
}


