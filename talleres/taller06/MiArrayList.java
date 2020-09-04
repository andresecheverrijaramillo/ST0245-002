import java.util.Arrays;

/**
 * La clase MiArrayList tiene la intención de representar un objeto que simule el comportamiento
 * de la clase ya implementada "ArrayList"
 * es claro que no se puede utilizar dicha estructura ya utilizada dentro de este ejercicio. 
 * Para más información de la clase ArrayList:
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html"> Ver documentacion ArrayList </a>
 * 
 * 
 * @author Mauricio Toro, Andres Paez
 * @version 1
 */

public class MiArrayList <T>{
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private T elements[]; 

    /**
     * El metodo constructor se utiliza para incializar
     * variables a valores neutros como 0 o null.
     * El contructor no lleva parámetros en este caso.
     */
    public MiArrayList() {
        elements=(T[])new Object[DEFAULT_CAPACITY];
        size=0;
    }

    /**
     * Tiene la intención de retornar la longitud del objeto
     * @return longitud del objeto
     *
     * El size esta influenciado por las funciones add y del
     */
    public int size() {
        return size;
    }   

    /** 
     * @param e el elemento a guardar
     * Agrega un elemento e a la última posición de la lista
     *
     */
    public void add(T e) {
        add(size, e);
    }    

    /** 
     * @param i es un íncide donde se encuentra el elemento posicionado
     * Retorna el elemento que se encuentra en la posición i de la lista.
     *
     */
    public T get(int i) {
        if (i<size && i>0) 
        return elements[i];
        else 
        throw new IndexOutOfBoundsException("Index: "+i);
    }

    /**
     * @param index es la posicion en la cual se va agregar el elemento
     * @param e el elemento a guardar
     * Agrega un elemento e en la posición index de la lista
     *
     */
    public void add(int index, T e) {
        if (index<size && index>=0){
            for(int i=0; i<=size; i++){
                if(i==size && size==elements.length) {
                extend();
            }
            if(i==index){
                    T swap=elements[i];
                    elements[index]=e;
                    elements[i+1]=swap;
                    i++;
                    size++;
                }
            }
        } else if (index==size){
            elements[index]=e;
            size++;
            if(size==elements.length) extend();
        }
    }

    private void extend(){
        T[] elements2=(T[]) new Object[elements.length+10];
        for(int i=0; i<size; i++){ 
        elements2[i]=elements[i];}
        elements=elements2;
    }

    /**
     * @param index es la posicion en la cual se va eliminar el elemento
     *
     * ELimina el elemento  en la posición index de la lista
     *
     */
    public void del(int index){
        elements[index]=null;
     }
}