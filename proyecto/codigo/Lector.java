import java.io.*;
import java.util.*;
public class Lector {
    Nodo root;
    public void main (String args[]) throws FileNotFoundException{
        List<String[]> rowList = new ArrayList<String[]>();
        try (BufferedReader br = new BufferedReader(new FileReader("1_train_balanced_45000.csv"))) {
            String line;
            while ((line = br.readLine()) != null) { //c*n+c [n ->cantidad de líneas del txt]
                String[] lineItems = line.split(","); //c*n
                rowList.add(lineItems); // p*n [Siendo p los nodods previamente insertados al arraylist]
            }
            br.close();
        }
        catch(Exception e){
            System.out.print("no se encontro");
        }
        String[][] matrix = new String[rowList.size()][];
        for (int i = 0; i < rowList.size(); i++) { //n*c+c [n se mantiene y pasa a ser también el número de filas de la matriz]
            String[] row = rowList.get(i); //p*n [la búsqueda en rowlist equivale en el peor de los casos a p posiciones]
            matrix[i] = row; //c*n
            /*
             * No es n*m ni exponencial porquelamatriz sólo es recorrida "en el eje y"
             */
        }
        ArrayList<Nodo> arboles= new ArrayList<Nodo>();
        int spacer=500;
        String[][] submatrix;
        for(int i =0; i<matrix.length;i+=500){//c*n+c
            if(i+spacer>matrix.length){ //c*n
                spacer=matrix.length-i; //c*n
            }
            submatrix= new String[spacer][]; //c*n
            for(int j=0;j<spacer;j++){ //(c*m+c)n [m es space]
                submatrix[j]=matrix[i+j]; //(c*m)*n
            }
            arboles.add(new Nodo(submatrix)); //p*n [la complejidad de arbol es n por n del for]
        }
        //ENTRENAMIENTO HASTA AQUÍ
        

        List<String[]> rowList2 = new ArrayList<String[]>(); //ArrayList de arrays -> 2n
        try (BufferedReader br2 = new BufferedReader(new FileReader("1_test_balanced_15000.csv"))) {
            String line;
            while ((line = br2.readLine()) != null) { //b^2+c [b ->cantidad de líneas del txt]
                String[] lineItems2 = line.split(","); //c*b
                rowList2.add(lineItems2); //O(p)*b [p es el número de elementos del ArrayList]
            }
            br2.close(); //c*b
        }
        catch(Exception e){
            // Handle any I/O problems
        }
        String[][] matrix2 = new String[rowList2.size()][];
        for (int i = 0; i < rowList2.size(); i++) { //b*c+c [n se mantiene y pasa a ser también el número de filas de la matriz]
            String[] row2 = rowList2.get(i); //b^2 [la búsqueda en rowlist equivale en el peor de los casos a n]
            matrix2[i] = row2; //c*b
        }    

        int countpasa=0;
        int countnopasa=0;
        boolean encuentro=true;
        for(int i = 0; i < matrix2.length; i++){ //c*b+c
            if(test(arboles,matrix2[i])){ //Memoria:c*b^2 Tiempo:c*b
                countpasa++; //c*b
            }
            else {
                countnopasa++; //c*b
            }
        }

        System.out.println(countpasa);
        System.out.println(countnopasa);
    }

    public boolean test(ArrayList<Nodo> arboles, String[] student){
        int yes = 0;
        int no = 0;
        for(Nodo arbol: arboles){ //Espacio:c*n+c Tiempo:c+c
            if(Nodo.testStudent(arbol,student)){ //c*n 
                yes++; //c*n
            }
            else {
                no++; //c*n
            }
        }
        if(yes > no){ //c
            return true; //c
        }
        return false; //c
        
        //T(n) es O(n) (Memoria)
        //Tiempo O(1)
    }
}