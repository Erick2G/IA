package elementosframe;

import extras.Data;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class MostrarEnRed extends JPanel {
    public boolean respuesta =false;
    public ArrayList<Integer> nodosRespuesta;
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //impresión de lineas
        for (int i = 0; i < Data.conexionesIndividuales.size(); i++) {
            g.drawLine(Data.nodos.get(Data.conexionesIndividuales.get(i)[0])[0] + 4,
                    Data.nodos.get(Data.conexionesIndividuales.get(i)[0])[1] + 4,
                    Data.nodos.get(Data.conexionesIndividuales.get(i)[1])[0] + 4,
                    Data.nodos.get(Data.conexionesIndividuales.get(i)[1])[1] + 4);
        }
        //impresión de nodos
        for (int[] nodo : Data.nodos) {
            g.drawOval(nodo[0], nodo[1], 8, 8);
        }
        //impresion del resultado
        if(respuesta){
            g.setColor(Color.red);
            for(int i = 0;i<nodosRespuesta.size()-1;i++){
                g.drawLine(Data.nodos.get(nodosRespuesta.get(i))[0] + 4,
                    Data.nodos.get(nodosRespuesta.get(i))[1] + 4,
                    Data.nodos.get(nodosRespuesta.get(i+1))[0] + 4,
                    Data.nodos.get(nodosRespuesta.get(i+1))[1] + 4);
            }
        }
    }
    
    public void mostrarRespuesta(String cadena){
        nodosRespuesta = new ArrayList<>();
        String[] estaciones = cadena.split(",");
        //modificar lo de abajo
        for(int i=0;i<estaciones.length;i++){
            nodosRespuesta.add(Integer.parseInt(estaciones[i]));
        }
        respuesta = true;
    }
}
