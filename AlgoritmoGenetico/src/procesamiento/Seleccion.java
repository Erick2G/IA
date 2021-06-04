package procesamiento;

import java.util.ArrayList;
//import static procesamiento.Data.coordSeleccionados;
import static procesamiento.Data.evaluacion;
import static procesamiento.Data.indiceRespuesta;
import static procesamiento.Data.numPoblacion;
import static procesamiento.Data.poblacion;
//import static procesamiento.Data.seleccionados;

public class Seleccion {

    public static void seleccionar() {
        //mostrar();
        ordenarMenores();
        llenarSeleccionados();
        //mostrar();
    }

    public static void ordenarMenores() {
        for (int i = 1; i < poblacion.size(); i++) {
            int[] aux = evaluacion.get(i);
            String[] temp = poblacion.get(i);
            int j;
            for (j = i - 1; j >= 0 && evaluacion.get(j)[0] > aux[0]; j--) {
                evaluacion.set(j + 1, evaluacion.get(j));
                poblacion.set(j + 1, poblacion.get(j));
            }
            evaluacion.set(j + 1, aux);
            poblacion.set(j + 1, temp);
        }
    }

    public static void llenarSeleccionados() {
        /*seleccionados = new ArrayList<>();
        coordSeleccionados = new ArrayList<>();
        int i = 0;
        while (seleccionados.size() < numPoblacion / 2 && i < numPoblacion) {
            if (evaluacion.get(i)[0] != -1) {
                seleccionados.add(poblacion.get(i));
                coordSeleccionados.add(evaluacion.get(i));
            }
            if (evaluacion.get(i)[0] <= 10 && evaluacion.get(i)[0] != -1) {
                indiceRespuesta = i;
            }
            i++;
        }*/
        //System.out.println("Evaliacion: " + evaluacion.size() + " p: " + poblacion.size());
        for (int i = 0; i < evaluacion.size(); i++) {
            //System.out.println("---- " + i);
            if (evaluacion.get(i)[0] == -1) {
                //System.out.println("Borrado " + evaluacion.get(i)[0] + " " + evaluacion.get(i)[1] + " " + evaluacion.get(i)[2]);
                poblacion.remove(i);
                evaluacion.remove(i);
                i--;
            } else if(evaluacion.get(i)[0] <= 10){
                indiceRespuesta = i;
                //System.out.println("No borrado: " + evaluacion.get(i)[0] + " " + evaluacion.get(i)[1] + " " + evaluacion.get(i)[2]);
            }
        }
    }

    public static void mostrar() {
        for (int i = 0; i < poblacion.size(); i++) {
            System.out.println(i + " " + evaluacion.get(i)[0]
                    + " -- " + evaluacion.get(i)[1]
                    + " ," + evaluacion.get(i)[2]);
        }
    }
}
