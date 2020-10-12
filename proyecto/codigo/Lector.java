import java.io.*;
import java.util.*;
public class Lector {
    public static void main (String args[]) throws FileNotFoundException{
        String[] datos =new String[125000];
        Scanner s=new Scanner(System.in);
        String n=s.nextLine();
        File archivo=new File(n);
        int i=0;
        while (s.hasNextLine()){
            String texto=s.nextLine();
            datos[i]=texto;
            i++;
        }
    }
  public float laImpurezaDeLosDatosDeUnaMatriz(String[][] m){
        int losQueTienenExito = 0;
        for (int fila = 0; fila < m.length; fila++)
            if (m[fila][m[0].length-1].equals("1"))
                losQueTienenExito++;
        int losQueNoTienenExito = m.length - losQueTienenExito;
        float proporcionDeLosQueTienenExito = losQueTienenExito/m.length;
        float proporcionDeLosQueNoTieneExito = losQueNoTienenExito/m.length;
        float impureza = 1-proporcionDeLosQueTienenExito*proporcionDeLosQueTienenExito-proporcionDeLosQueNoTieneExito*proporcionDeLosQueNoTieneExito;
        return impureza;        
    }

    // IP = (Iizq*cuantosHayALaIzquierda + Ider*cuantosHayALaDerecha) / El numero total de datos 
  public  float calcularLaImpurezaPonderada(String[][] m, int posVariable, String valor){
    int enCuantosEstudiantesLaVariableEsIgualAlValor = 0;
    for (int fila = 0; fila < m.length; fila++)
        if (m[fila][posVariable] == valor) // por ejemplo, valor es 3, 10 SMLVM, Masculino
            enCuantosEstudiantesLaVariableEsIgualAlValor++;
    int enCuantosEstudiantesLaVariableNOEsIgualAlValor = m.length - enCuantosEstudiantesLaVariableEsIgualAlValor;
    String[][] matrizLaVariableEsIgualAlValor = new String[enCuantosEstudiantesLaVariableEsIgualAlValor][m[0].length];
    String[][] matrizLaVariableNOEsIgualAlValor = new String[enCuantosEstudiantesLaVariableNOEsIgualAlValor][m[0].length];
    // Copiar los datos a las matrices
    int fila = 0;
    int filaN1 = 0;
    int filaN2=0;
    while(fila<m.length)
    {
        if(m[fila][posVariable]==valor)
        {
            matrizLaVariableEsIgualAlValor[filaN1]=m[fila];
            fila++;filaN1++;
        }else
        {
            matrizLaVariableNOEsIgualAlValor[filaN2]=m[fila];
            fila++;filaN2++;
        }
    }
    // ...
    float impurezaPonderada =((laImpurezaDeLosDatosDeUnaMatriz(matrizLaVariableEsIgualAlValor)*matrizLaVariableEsIgualAlValor.length)+(laImpurezaDeLosDatosDeUnaMatriz(matrizLaVariableNOEsIgualAlValor)*matrizLaVariableNOEsIgualAlValor.length))/m.length;
        return impurezaPonderada;
   }
}