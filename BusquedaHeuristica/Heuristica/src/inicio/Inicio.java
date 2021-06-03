package inicio;

import elementosframe.MostrarEnRed;
import elementosframe.PedirDatos;
import extras.Data;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class Inicio {
    public static  MostrarEnRed mostrar = new MostrarEnRed();
    public static void main(String args[]) {
        //Creacion de frame
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Heurística");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
       
        mostrar.setPreferredSize(new Dimension(700, 700));

        JScrollPane scroll = new JScrollPane(mostrar);
        scroll.setBounds(0, 50, 580, 500);
        //Otros procesos
        Data.cargarData(); //cargar nombres, colores y matriz de distancias
        PedirDatos.pedirDatos(frame); //mostrar opciones y pedir a usuario
        frame.add(scroll);
        frame.repaint();
    }
}
