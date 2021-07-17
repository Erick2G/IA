
package procesamiento;

import static inicio.Inicio.inferior;
import java.util.ArrayList;
import java.util.Random;
import static procesamiento.Procesar.decABin;
import static procesamiento.Procesar.decABinLong;

public class Data {
    public static int wTablero = 600, hTablero = 400, numPoblacion, xC, yC, xB, yB;
    public static int Fmax = 34, T1MAX=89,T2MAX = 360, indiceRespuesta = -1, seMantienen=0, longF;
    public static ArrayList<String[]> poblacion = new ArrayList<>();
    public static ArrayList<int[]> evaluacion = new ArrayList<>();
    //public static ArrayList<String[]> seleccionados = new ArrayList<>();
    //public static ArrayList<int[]> coordSeleccionados = new ArrayList<>();
    
    public static void datosIniciales( int poblacion){
        numPoblacion = poblacion;    
        Fmax = calcularF(wTablero,hTablero);
        //System.out.println("Fuerza maxima: "+Fmax);
        colocarCanionBala();
        longF = decABinLong(Fmax).length();
        inferior.reajustarCoordenadas();
    }
     public static void generarPoblacion() {
        poblacion = new ArrayList<>();
        Random rn = new Random();
        int F, T1, T2;
        for (int i = 0; i < numPoblacion; i++) {
            F = rn.nextInt(Fmax);
            T1 = rn.nextInt(T1MAX);
            T2 = rn.nextInt(T2MAX);
            poblacion.add(new String[]{decABin(F, 0), decABin(T1, 1), decABin(T2, 2)});
        }
    }
    public static void colocarCanionBala(){
        Random rnd = new Random();
         xC = rnd.nextInt(wTablero);
         yC = rnd.nextInt(hTablero);
         xB = rnd.nextInt(wTablero);
         yB = rnd.nextInt(hTablero);
         /*xC = 15;
         yC = 198;
         xB = 521;
         yB = 174;*/
         /*xC = 145;
         yC = 44;
         xB = 454;
         yB = 362;*/
         System.out.println("Datos canion: "+xC+" "+yC);
         System.out.println("Datos bala: "+xB+" "+yB);
    }
    public static int calcularF(int w, int h){
        double g =  9.81;
        int mayor = (int) Math.sqrt(w*w + h*h);//hipotenusa
        return (int)Math.sqrt((mayor*g)/Math.sin(178)); //89*2 = 178
        
    }
}
