/*
 * Pendiente: Ajustar el main a las clases creadas y probar con los datos de 
 * muestra de GitHub.
 * Duda: ¿Es necesario agregarle un lector de archivos?
 */
public class Main {

    public static void main(String[] args) {
        Contador c = new Contador("test");
        for (int i = 0; i < 10; ++i)
            c.incrementar();
        // 10
        System.out.println(c);

        System.out.println();

        Punto p = new Punto(-1, 1);//Punto uno
        // 0,0
        System.out.printf("Punto: {%f, %f}\n", p.x(), p.y());
        // 1*sqrt(2)
        System.out.println("Radio Polar: " + p.radioPolar());
        // -45
        System.out.println("Angulo Polar: " + Math.toDegrees(p.anguloPolar()));
        // 2
        System.out.println("Distancia euclideana: " + p.distanciaEuclidiana(new Punto(1, 1)));//Punto dos :)

        System.out.println();

        Fecha f1 = new Fecha(1, 8, 2017);
        Fecha f2 = new Fecha(2, 5, 2016);
        f1.toString();
        f2.toString();
        // 1
        System.out.println(f1.comparar(f2));
    }

}