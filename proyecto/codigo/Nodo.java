import java.util.*;
import javafx.util.*;
public class Nodo{
    Pair <Integer, String> valor;
    Nodo Derecha;
    Nodo Izquierda;
    
    public static boolean testStudent(Nodo tree, String[] student){
        Integer key = tree.valor.getKey(); //c
        String value = tree.valor.getValue(); //c
        if(key == 10){ //c
            if(value.equals(student[key])){ //c [Acceso a arrays es O(1)]
                return true;
            }
            else {
                return false;
            }
        }
        else{
            if(student[key].equals(value)){
                return testStudent(tree.Derecha,student); //c+T(n-1) [n es el número de nodos del árbol]
            }
            else{
                return testStudent(tree.Izquierda,student); //c+T(n-1) [n es el número de nodos del árbol]
            }
            /*
             * T(n) es O(n) siendo n el número de nodos del árbol
             */
        }
    }

    public Nodo(String [][] m){
        valor=encontrarEnQuePosEstaLaMejorVariableYQueValorDeboCompararEnLaCondicion(m);
        Pair<String[][],String[][]> parejaDeMatrices =  dividirUnaMatrizEnDosMatrices(m, valor.getKey(), valor.getValue());
        String[][] izq=parejaDeMatrices.getValue();
        String[][] der=parejaDeMatrices.getKey();
        if(izq.length!=0&&der.length!=0){
            if(same(izq)){
                Izquierda = new Nodo(new Pair(10,izq[0][10])); 
            }
            else{
                Izquierda=new Nodo(izq); //c+T(n+1)
            }
            if(same(der)){
                Derecha = new Nodo(new Pair(10,izq[0][10]));
            }
            else{
                Derecha=new Nodo(der); //c+T(n+1)
            }
        }
        /*
         * T(n) es c1+c2+2T(n+1)
         * T(n) es O(2^(1-n))
         */
    }
    
    public boolean same(String [][] m){
        String value = m[0][10];
        for(int i = 1; i<m.length;i++){ //c*n+c [N es el número de filas de la matriz]
            if(!m[i][10].equals(value)){ //c*n
                return false;//c*n
            }
        }
        return true;//c*n
        //Complejidad: O(n)
    }
    
    public Nodo(Pair <Integer, String> v){
        valor = v; //O(1)
    }

    public TreeSet<String> sacarLosValoresDiferentesSinRepetirDeUnaVariable(String[][] m, int posVariable){
        TreeSet<String> respuesta = new TreeSet();
        for (int fila = 0; fila < m.length; fila++){ //c*n+c  [n es la cnatidad de filas de la matriz m]
            respuesta.add(m[fila][posVariable]); //n^2*v [v es la posición de la variable]
        }
        return respuesta; //c
        //O(n^2)
    }

    public  Pair<Integer,String> encontrarEnQuePosEstaLaMejorVariableYQueValorDeboCompararEnLaCondicion(String[][] m){
        float laImpurezaMenorDentreTodoElmundo = 1;
        String elMejorValorDentreTodoElMundo = "";
        int laPosDeLaVariableDondeEstaElMejorValor = -1;
        TreeSet<String> valores;
        float impurezaPonderadaDeEstaColumnaConEsteValor;
        for (int columna = 0; columna < m[0].length - 1; columna++){ //c*m+c [Siendo m la cnatidad de columnas que tiene la matriz m]
            valores = sacarLosValoresDiferentesSinRepetirDeUnaVariable(m, columna); //c*m
            for (String unValor : valores){ //m*(c*m+c) <--- OJO
                impurezaPonderadaDeEstaColumnaConEsteValor = calcularLaImpurezaPonderada(m, columna, unValor); //c*m
                if (impurezaPonderadaDeEstaColumnaConEsteValor <= laImpurezaMenorDentreTodoElmundo){ //c*m
                    laImpurezaMenorDentreTodoElmundo = impurezaPonderadaDeEstaColumnaConEsteValor; //c*m
                    elMejorValorDentreTodoElMundo = unValor; //c*m
                    laPosDeLaVariableDondeEstaElMejorValor = columna; //c*m
                }
            }
        }
        if(laPosDeLaVariableDondeEstaElMejorValor == -1){ //c
                    System.out.print(""); //c
                }
        Pair<Integer,String> respuesta = new Pair(laPosDeLaVariableDondeEstaElMejorValor, elMejorValorDentreTodoElMundo); //c
        return respuesta; //c
        //O(m^2)
    }

    // IG = 1 - (p0)^2 - (p1)^2. P0 = exito/total P1 = NoExito/total
    public float laImpurezaDeLosDatosDeUnaMatriz(String[][] m){
        int losQueTienenExito = 0;
        for (int fila = 0; fila < m.length; fila++) //c*n+c [Siendo n el número de filas]
            if (m[fila][m[0].length-1].equals("1")) //c*n
                losQueTienenExito++; //c*n
        int losQueNoTienenExito = m.length - losQueTienenExito; //c
        float proporcionDeLosQueTienenExito=0; //c
        float proporcionDeLosQueNoTieneExito=0; //c
        if(m.length!=0){ //c
            proporcionDeLosQueTienenExito = losQueTienenExito/m.length; //c
            proporcionDeLosQueNoTieneExito = losQueNoTienenExito/m.length; //c
        }
        float impureza = 1-proporcionDeLosQueTienenExito*proporcionDeLosQueTienenExito-proporcionDeLosQueNoTieneExito*proporcionDeLosQueNoTieneExito; //c
        return impureza; //c        
    }

    // IP = (Iizq*cuantosHayALaIzquierda + Ider*cuantosHayALaDerecha) / El numero total de datos 
    public  float calcularLaImpurezaPonderada(String[][] m, int posVariable, String valor){
        int enCuantosEstudiantesLaVariableEsIgualAlValor = 0; 
        for (int fila = 0; fila < m.length; fila++) //c*n+c [Siendo n la cantidad de filas de la matriz]
            if (valor.equals(m[fila][posVariable])) // por ejemplo, valor es 3, 10 SMLVM, Masculino
                enCuantosEstudiantesLaVariableEsIgualAlValor++;
        int enCuantosEstudiantesLaVariableNOEsIgualAlValor = m.length - enCuantosEstudiantesLaVariableEsIgualAlValor;
        String[][] matrizLaVariableEsIgualAlValor = new String[enCuantosEstudiantesLaVariableEsIgualAlValor][m[0].length];
        String[][] matrizLaVariableNOEsIgualAlValor = new String[enCuantosEstudiantesLaVariableNOEsIgualAlValor][m[0].length];
        // Copiar los datos a las matrices
        int fila = 0;
        int filaN1 = 0;
        int filaN2=0;
        while(fila<m.length) //c*n+c
        {
            if(valor.equals(m[fila][posVariable])) //c*n
            {
                matrizLaVariableEsIgualAlValor[filaN1]=m[fila]; //c*n
                fila++;filaN1++; //c*n
            }else
            {
                matrizLaVariableNOEsIgualAlValor[filaN2]=m[fila]; //c*n
                fila++;filaN2++; //c*n
            }
        }
        // ...
        float impurezaPonderada =((laImpurezaDeLosDatosDeUnaMatriz(matrizLaVariableEsIgualAlValor)*matrizLaVariableEsIgualAlValor.length)+(laImpurezaDeLosDatosDeUnaMatriz(matrizLaVariableNOEsIgualAlValor)*matrizLaVariableNOEsIgualAlValor.length))/m.length;
        return impurezaPonderada;
        //O(n)
    }

    public  Pair<String[][],String[][]> dividirUnaMatrizEnDosMatrices(String[][] m, int posVariable, String valor){
        int enCuantosEstudiantesLaVariableEsIgualAlValor = 0;
        for (int fila = 0; fila < m.length; fila++){ //c*n+c [Siendo n la cantidad de filas de la matriz m]
            if(fila==-1||posVariable==-1){ //c*n
                System.out.print("error"); //c*n
            }
            if (valor.equals(m[fila][posVariable])) // //c*n     por ejemplo, valor es 3, 10 SMLVM, Masculino
                enCuantosEstudiantesLaVariableEsIgualAlValor++;} //c*n
        int enCuantosEstudiantesLaVariableNOEsIgualAlValor = m.length - enCuantosEstudiantesLaVariableEsIgualAlValor; //c
        String[][] matrizLaVariableEsIgualAlValor = new String[enCuantosEstudiantesLaVariableEsIgualAlValor][m[0].length]; //c
        String[][] matrizLaVariableNOEsIgualAlValor = new String[enCuantosEstudiantesLaVariableNOEsIgualAlValor][m[0].length]; //c
        // Copiar los datos a las matrices
        int fila = 0; //c
        int filaN1 = 0; //c
        int filaN2=0; //c
        while(fila<m.length) //c*n+c
        {
            if(valor.equals(m[fila][posVariable])) //c*n
            {
                matrizLaVariableEsIgualAlValor[filaN1]=m[fila]; //c*n
                fila++;filaN1++; //c*n
            }else
            {
                matrizLaVariableNOEsIgualAlValor[filaN2]=m[fila]; //c*n
                fila++;filaN2++; //c*n
            }
        }
        // ...
        Pair<String[][],String[][]> parejaDeMatrices = new Pair(matrizLaVariableEsIgualAlValor,matrizLaVariableNOEsIgualAlValor); //c
        return parejaDeMatrices; //c
        //O(n)
    }
}