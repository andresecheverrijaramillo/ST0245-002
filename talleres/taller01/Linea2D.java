
/**
 * Write a description of class Linea2D here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Linea2D
{
    // instance variables - replace the example below with your own
    private static Punto a, b;

    /**
     * Constructor for objects of class Linea2D
     */
    public Linea2D(Punto a, Punto b)
    {
        this.a=a;
        this.b=b;
    }
    public Punto a(){
     return this.a;
    }
    public Punto b(){
     return this.b;
    }
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public double pendiente()
    {
        return (b.y()-a.y())/(b.x()-a.x());
    }
    
    public void Valores(){
     System.out.println("Punto inicial: ("+ a.x()+", "+a.y()+")");
     double x=a.x();
     double y=a.y();
     System.out.println("Puntos intermedios:");
     for (int i=0; i<b.x()-1; i++){
        x++;
        y+= pendiente();
        System.out.println("("+x+","+y+")");
        }
     System.out.println("Punto final: ("+ b.x()+", "+b.y()+")");   
    }
}

