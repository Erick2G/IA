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
    public static int temp = 0;
    public static void resolver(JFrame frame) {
        datosIniciales(30); //--------------------------------Aqui el numero de poblacion
        generarPoblacion();
     //Puras etiquetas para mostrar datos de la ejecucion  
        JLabel canion = new JLabel("Canion en x: "+xC+" y: "+yC);
        canion.setBounds(10,10,180,20);
        JLabel bala = new JLabel("Marca en x: "+xB+" y: "+yB);
        bala.setBounds(10,40,180,20);
        JLabel poblacionNum = new JLabel("Población: "+numPoblacion);
        poblacionNum.setBounds(10,70,180,20);
        JLabel distanciaCorta = new JLabel("Distancia más corta");
        distanciaCorta.setBounds(220,10,180,20);
        JLabel distanciaNum = new JLabel(" - ");
        distanciaNum.setBounds(250,40,180,20);
        frame.add(canion);
        frame.add(bala);
        frame.add(distanciaCorta);
        frame.add(distanciaNum);
        frame.add(poblacionNum);
        //mostrar datos
        
        while (indiceRespuesta == -1) {
            Evaluacion.evaluarPoblacion(); 
            Seleccion.seleccionar();
            RepMut.reproducir();
            mostrarTiros(frame);
            temp++;
            /*if(temp%1000==0){
                System.out.println("Iteracion: "+temp);
                mostrar();
            }*/
            try{//en caso de que la poblacion sea muy pequeña (1)
                distanciaNum.setText(String.valueOf(evaluacion.get(0)[0]));
            }catch(IndexOutOfBoundsException e){
                
            }
            
        }
        
        inferior.setTiro(evaluacion.get(0));
        inferior.repaint();
        System.out.println("NUMERO INTENTOS:  "+temp);
        mostrar();
        System.out.println("Finl ----- ngulo: "+binADec(poblacion.get(0)[2]));
        
        JLabel generaciones = new JLabel("Generaciones: "+temp);
        JLabel distancia = new JLabel("Distancia: "+evaluacion.get(0)[0]);
        generaciones.setBounds(400,10,180,20);
        distancia.setBounds(400,40,180,20);
        frame.add(generaciones);
        frame.add(distancia);
    }

    public static void mostrarTiros(JFrame frame) {
        try {
            for (int i = 0; i < evaluacion.size() && i<3; i++) {
                inferior.setTiro(evaluacion.get(i));
                inferior.repaint();
                TimeUnit.MILLISECONDS.sleep(200);
            }
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }

    public static void mostrar() {
        System.out.println("Poblacion: " + poblacion.size());
        System.out.println("Evaluaxion: " + evaluacion.size());
        for(int i = 0;i<evaluacion.size()&&i<5;i++){
            System.out.println(i+" "+evaluacion.get(i)[0]
                    +" -- "+evaluacion.get(i)[1]
                    +" ,"+evaluacion.get(i)[2]);
        }
        
    }
    /*public static void mostrarPoblacion() {
        //System.out.println("Poblacion: " + poblacion.size());
        //System.out.println("Evaluaxion: " + evaluacion.size());
        for(int i = 0;i<poblacion.size();i++){
            System.out.println(i+" "+binADec(poblacion.get(i)[0])
                    +" -- "+binADec(poblacion.get(i)[1])
                    +" ,"+binADec(poblacion.get(i)[2]));
        }
        System.out.println("PP --------- ");
    }*/
}
