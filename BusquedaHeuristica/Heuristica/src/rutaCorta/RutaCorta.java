package rutaCorta;

import extras.Data;
import inicio.Inicio;
import java.util.ArrayList;

public class RutaCorta {

    //35,000, formato de pesos 0 0,2,1,5,4
    public static ArrayList<Integer> porExaminar = new ArrayList<>();
    public static String[] cadenas = new String[163];
    public static int[][] pesos = new int[163][2]; // 0 es g y 1 es h
    public static int contador;
    private static boolean destinoAlcanzado;

    public static void calcularRuta(int partida, int destino) {
        destinoAlcanzado=false;
        contador = 0;//para llevar la cuenta de las itereaciones
        //llenar de valores predeterminados a pesos
        for (int i = 0; i < pesos.length; i++) {
            pesos[i][0] = 35000;//como no tenemos infinito puse un valor superior a la distancia mas larga
        }
        //el valor del punto de partida es 0
        pesos[partida][0] = 0;
        cadenas[partida] = String.valueOf(partida);
        pesos[partida][1] = 0;
        porExaminar.add(partida);
        // recorrer todo lo de la lista 
        while (!porExaminar.isEmpty()&&!destinoAlcanzado) {
            //buscar el de menor
            int menor = 0;
            for(int i = 1;i<porExaminar.size();i++){
                if(pesos[porExaminar.get(i)][1]<pesos[porExaminar.get(menor)][1]){ // g(n) + h(n)
                    menor = i;
                }
            }
            // ejecucion de la menor g(n) + h(n)
            procesarLetra(porExaminar.get(menor), cadenas[porExaminar.get(menor)],destino);
            porExaminar.remove(menor);
        }
        //llamar al metodo para mostrar respuesta
        System.out.println("Iteraciones:" + contador);
        System.out.println("Ruta: " + cadenas[destino] + ", con distancia de: " + pesos[destino][0]);
        Inicio.mostrar.mostrarRespuesta(cadenas[destino]);
    }

    public static void procesarLetra(int letra, String cadena,int destino) {
        String[] temp = Data.conexiones.get(letra).split(",");
        String[] tempDist = Data.distancias.get(letra).split(",");
        for (int i = 0; i < temp.length; i++) {
            int adyacente = Integer.parseInt(temp[i]);
            int suma = pesos[letra][0] + Integer.parseInt(tempDist[adyacente]);
            //comparar con el peso actual de la letra
            if (suma < pesos[adyacente][0]) {
                pesos[adyacente][0] = suma;
                cadenas[adyacente] = cadena + "," + temp[i];
                // g(n) + h(n)
                String[] tempH = Data.distancias.get(adyacente).split(",");
                int f = suma + Integer.parseInt(tempH[destino]);
                pesos[adyacente][1] = f;
                if (!estaEnExaminar(adyacente)) {
                    porExaminar.add(adyacente);
                }
                if(adyacente==destino){
                destinoAlcanzado = true;
            }
            }
        }
        contador++;
    }
    public static boolean estaEnExaminar(int letra) {
        for (int i = 0; i < porExaminar.size(); i++) {
            if (letra == porExaminar.get(i)) {
                return true;
            }
        }
        return false;
    }
}
