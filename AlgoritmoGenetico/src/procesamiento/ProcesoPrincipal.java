package procesamiento;

import static inicio.Inicio.inferior;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static procesamiento.Data.datosIniciales;
import static procesamiento.Data.evaluacion;
import static procesamiento.Data.generarPoblacion;
import static procesamiento.Data.indiceRespuesta;
import static procesamiento.Data.numPoblacion;
import static procesamiento.Data.poblacion;
import static procesamiento.Data.xB;
import static procesamiento.Data.xC;
import static procesamiento.Data.yB;
import static procesamiento.Data.yC;
import static procesamiento.Procesar.binADec;

public class ProcesoPrincipal {

    //dimensiones del tablero 600 y 400, 6 ,7, 9
    public static void resolver(JFrame frame) {
        datosIniciales(30); //--------------------------------Aqui el numero de poblacion
        generarPoblacion();
        //Puras etiquetas para mostrar datos de la ejecucion  
        JLabel canion = new JLabel("Canion en x: " + xC + " y: " + yC);
        canion.setBounds(10, 10, 180, 20);
        JLabel bala = new JLabel("Marca en x: " + xB + " y: " + yB);
        bala.setBounds(10, 40, 180, 20);
        JLabel poblacionNum = new JLabel("Población: " + numPoblacion);
        poblacionNum.setBounds(10, 70, 180, 20);
        JLabel distanciaCorta = new JLabel("Distancia promedio ");
        distanciaCorta.setBounds(220, 10, 180, 20);
        JLabel distanciaNum = new JLabel(" - ");
        distanciaNum.setBounds(250, 40, 180, 20);
        frame.add(canion);
        frame.add(bala);
        frame.add(distanciaCorta);
        frame.add(distanciaNum);
        frame.add(poblacionNum);
        //mostrar datos
        int genT = 0;

        while (genT < 25000) {
            genT++;
            Evaluacion.evaluarPoblacion();
            Seleccion.seleccionar();
            RepMut.reproducir();
            if (genT % 2000 == 0) {
                try {//en caso de que la poblacion sea muy pequeña (1)
                    distanciaNum.setText(String.valueOf(promedio()));
                    mostrarTiros(frame);
                    frame.repaint();
                } catch (IndexOutOfBoundsException e) {
                }
            }
        }
        //inferior.setTiro(evaluacion.get(0));
        //inferior.repaint();
        // System.out.println("NUMERO INTENTOS:  "+temp);
        mostrar();
        // System.out.println("Finl ----- ngulo: "+binADec(poblacion.get(0)[2]));

        JLabel distancia = new JLabel("Distancia min: " + evaluacion.get(0)[0]);
        distancia.setBounds(400, 40, 180, 20);
        frame.add(distancia);
    }

    public static void mostrarTiros(JFrame frame) {
        /*try {
            for (int i = 0; i < evaluacion.size() && i < 3; i++) {
                inferior.setTiro(evaluacion.get(i));
                inferior.repaint();
                TimeUnit.MILLISECONDS.sleep(200);
            }
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }*/
        inferior.setTiro(evaluacion);
        inferior.repaint();
    }

    public static void mostrar() {
        for (int i = 0; i < evaluacion.size(); i++) {
            System.out.println(i + " - " + evaluacion.get(i)[0]);
        }
    }

    public static float promedio() {
        float prom = 0;
        for (int i = 0; i < evaluacion.size(); i++) {
            prom += evaluacion.get(i)[0];
        }
        prom /= 30;
        return prom;
    }
}
