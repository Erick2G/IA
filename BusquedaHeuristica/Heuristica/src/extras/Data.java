package extras;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
///de coordenadas_odos se le restó 6 a la x de l alinea 82 (el rosario)
public class Data {
    public static ArrayList<int[]> lineas = new ArrayList<>();
    public static ArrayList<String> nombres = new ArrayList<>();
    public static ArrayList<int[]> conexionesIndividuales = new ArrayList<>();
    public static ArrayList<String> conexiones = new ArrayList<>();
    public static ArrayList<String> distancias = new ArrayList<>();
    public static ArrayList<int[]> nodos = new ArrayList();
    
    public static void cargarData() {
        //System.getProperty("user.dir")
        try {
            //para los nombres
            File archivoNombre = new File("D:\\Usuarios\\Escritorio\\Tareas\\ia\\RutaCorta"+"\\nombres.data");
            Scanner reader = new Scanner(archivoNombre);
            while (reader.hasNextLine()) {
                nombres.add(reader.nextLine());
            }
            reader.close();
            //para las conexiones individuales
            File archivoConexiones = new File("D:\\Usuarios\\Escritorio\\Tareas\\ia\\RutaCorta"+"\\conexiones_individuales.data");
            Scanner reader2 = new Scanner(archivoConexiones);
            while (reader2.hasNextLine()) {
                String[] temp = reader2.nextLine().split(",");
                conexionesIndividuales.add(new int[]{Integer.parseInt(temp[0]),Integer.parseInt(temp[1])});
            }
            reader2.close();
            //para la matriz
            File archivoMatriz = new File("D:\\Usuarios\\Escritorio\\Tareas\\ia\\RutaCorta"+"\\conexiones.data");
            Scanner reader3 = new Scanner(archivoMatriz);
            while (reader3.hasNextLine()) {
                conexiones.add(reader3.nextLine());
            }
            reader3.close();
            File archivoNodos = new File("D:\\Usuarios\\Escritorio\\Tareas\\ia\\RutaCorta"+"\\coordenadas_nodos.data");
            Scanner reader4 = new Scanner(archivoNodos);
            while (reader4.hasNextLine()) {
                String[] temp = reader4.nextLine().split("-");
                double x = (Integer.parseInt(temp[0])*2.3)-200;
                double y = (Integer.parseInt(temp[1])*2.6)-100;
                nodos.add(new int[]{(int)x,(int)y});
            }
            reader4.close();
            File archivoDistancias = new File("D:\\Usuarios\\Escritorio\\Tareas\\ia\\RutaCorta"+"\\distancias.data");
            Scanner reader5 = new Scanner(archivoDistancias);
            while (reader5.hasNextLine()) {
                distancias.add(reader5.nextLine());
            }
            reader5.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("Error al abrir archivo");
        }
        organizarLineas();
        //cargarCoordenadasNodos();
    }
    public static void organizarLineas(){
        lineas.add(new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19}); //rosa
        lineas.add(new int[]{20,21,22,23,24,25,26,27,28,29,30,31,32,9,33,34,35,36,37,38,39,40,41,42}); //azul
        lineas.add(new int[]{43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,29,12}); //verde rancio
        lineas.add(new int[]{62,63,64,65,66,67,68,69,70,7}); //verde agua
        lineas.add(new int[]{71,72,73,74,75,76,77,78,79,80,46,67,0}); //amarilla
        lineas.add(new int[]{81,82,83,84,85,86,87,88,72,44,70}); //roja
        lineas.add(new int[]{89,90,91,92,93,94,95,96,97,98,99,81,22,18}); //naranja
        lineas.add(new int[]{100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,30,11,34,62}); //verde oscuro
        lineas.add(new int[]{115,116,117,118,119,120,121,18,52,34,63,0}); //cafe
        lineas.add(new int[]{122,123,124,125,126,127,128,129,130,0});//morada
        lineas.add(new int[]{131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,78,6,65,100,48});//gris
        lineas.add(new int[]{147,148,149,150,151,152,153,154,155,156,157,158,159,160,161,162,98,56,40,110});//dorada
    }
}
