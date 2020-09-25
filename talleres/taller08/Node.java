public class Node 
{
    public int numero;
    public String nombre;
    public Node next;
    public Node(int numero, String nombre)
    {
        next = null;
    this.numero = numero;
    this.nombre = nombre;
    }
}