package procesamiento;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static procesamiento.Data.evaluacion;
import static procesamiento.Data.generarPoblacion;
import static procesamiento.Data.numPoblacion;
import static procesamiento.Data.poblacion;
import static procesamiento.Procesar.binADec;

public class RepMut {

    public static List<String[]> nuevaPoblacion = new ArrayList<>();
    public static Random rnd = new Random();

    public static void reproducir() {
        nuevaPoblacion = new ArrayList<>();
        if (poblacion.size() > 1) {
            double temp = porcentaje(evaluacion.get(0)[0]);
            temp *= evaluacion.size();
            int posiblesPadres = (int) temp;
            if (posiblesPadres < 1) {
                posiblesPadres++;
            }
            //double siguenVivos = posiblesPadres;
            double siguenVivos = 1 + (evaluacion.size()-1) * .20;// la poblacion que seguira viva
            nuevaPoblacion = poblacion.subList(0, (int) siguenVivos);
            int restantes = numPoblacion - (int) siguenVivos;
            while (restantes > 0) {
                int indice1 = rnd.nextInt(posiblesPadres);
                int indice2 = rnd.nextInt(posiblesPadres);
                letsMakeABaby(poblacion.get(indice1), poblacion.get(indice2));
                restantes--;
            }
            poblacion = new ArrayList<>();
            poblacion.addAll(nuevaPoblacion);
            //---------- Aqui para cuando solo hay un individuo 
        } else if (poblacion.size() == 1) {
            int restantes = numPoblacion-1;
            if (restantes == 0) {
                //System.out.println("opcion1 - "+numPoblacion);
                letsMakeABaby(poblacion.get(0), poblacion.get(0));
                poblacion = new ArrayList<>();
                poblacion.addAll(nuevaPoblacion);
            } else {
                //System.out.println("opcion2 "+restantes);
                nuevaPoblacion.add(poblacion.get(0));
                while (restantes > 0) {
                    letsMakeABaby(poblacion.get(0), poblacion.get(0));
                    restantes--;
                }
                poblacion = new ArrayList<>();
                poblacion.addAll(nuevaPoblacion);
            }

        } else {
            generarPoblacion();
        }
    }

    public static void letsMakeABaby(String[] ind1, String[] ind2) {
        nuevaPoblacion.add(mutar(ind2[0], ind1[1], ind2[2]));
    }

    public static String[] mutar(String F, String T1, String T2) {
        int mutaciones = rnd.nextInt(3);
        mutaciones++; //para evitar que salgan con 0 mutaciones
        //System.out.println("\t mutaciones: "+mutaciones);
        String temp = F + T1 + T2;
        String[] temp2 = temp.split("");
        int mutacion;
        while (mutaciones != 0) {
            mutacion = rnd.nextInt(temp2.length);
            if (Integer.parseInt(temp2[mutacion]) == 1) {
                temp2[mutacion] = "0";
            } else {
                temp2[mutacion] = "1";
            }
            mutaciones--;
        }
        return new String[]{pegarString(temp2, 0, F.length()),
            pegarString(temp2, F.length(), (F.length() + T1.length())),
            pegarString(temp2, (F.length() + T1.length()), (F.length() + T1.length() + T2.length()))};
    }

    public static String pegarString(String[] s, int inicio, int fin) {
        String temp = "";
        for (int i = inicio; i < fin; i++) {
            temp += s[i];
        }
        return temp;
    }

    public static void mostrar(ArrayList<String[]> muestra) {
        for (int i = 0; i < muestra.size(); i++) {
            int F = binADec(muestra.get(i)[0]);
            int T1 = binADec(muestra.get(i)[1]);
            int T2 = binADec(muestra.get(i)[2]);
            System.out.println("\t" + " " + F + " " + T1 + " " + T2);
        }
    }

    public static double porcentaje(int distancia) {
        if (distancia < 20) {
            return .30;
        } else if (distancia < 50) {
            return .40;
        } else if (distancia < 100) {
            return .50;
        } else {
            return .80;
        }
    }
}
