package elementosframe;

import extras.Data;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import rutaCorta.RutaCorta;

public class PedirDatos {
    //los combobox para pedir los datos
    private static final JComboBox comboPartidaLinea = new JComboBox();
    private static JComboBox comboDestinoLinea = new JComboBox();
    private static JComboBox comboPartidaEstacion = new JComboBox();
    private static JComboBox comboDestinoEstacion = new JComboBox();

    public static void pedirDatos(JFrame frame) {
        //agregar lineas al combobox 1
        comboPartidaLinea.addItem("Rosa");
        comboPartidaLinea.addItem("Azul");
        comboPartidaLinea.addItem("Verde rancio");
        comboPartidaLinea.addItem("Verde agua");
        comboPartidaLinea.addItem("Amarillo");
        comboPartidaLinea.addItem("Rojo");
        comboPartidaLinea.addItem("Naranja");
        comboPartidaLinea.addItem("Verde oscuro");
        comboPartidaLinea.addItem("Café");
        comboPartidaLinea.addItem("Morado");
        comboPartidaLinea.addItem("Gris");
        comboPartidaLinea.addItem("Dorada");
        //agregar lineas al combobox 2
        comboDestinoLinea.addItem("Rosa"); //0
        comboDestinoLinea.addItem("Azul");  //1
        comboDestinoLinea.addItem("Verde rancio");  //2
        comboDestinoLinea.addItem("Verde agua");    //3
        comboDestinoLinea.addItem("Amarillo");  //4
        comboDestinoLinea.addItem("Rojo");  //5
        comboDestinoLinea.addItem("Naranja");   //6
        comboDestinoLinea.addItem("Verde oscuro");  //7
        comboDestinoLinea.addItem("Café");  //8
        comboDestinoLinea.addItem("Morado");    //9
        comboDestinoLinea.addItem("Gris");  //10
        comboDestinoLinea.addItem("Dorada");    //11
        //etiquetas de indicaciones
        JLabel labelPartida = new JLabel("Punto de partida");
        JLabel labelDestino = new JLabel("Punto destino");
        labelPartida.setBounds(5, 5, 120, 15);
        labelDestino.setBounds(230, 5, 120, 15);
        //ubicacion y dimension de comboboxes
        comboPartidaLinea.setBounds(10, 25, 100, 20);
        comboDestinoLinea.setBounds(230, 25, 100, 20);
        comboPartidaEstacion.setBounds(120, 25, 100, 20);
        comboDestinoEstacion.setBounds(340, 25, 100, 20);
        //boton para capturar datos de comboboxes y mandar a llamar metodos de procesamiento
        JButton button = new JButton("Buscar ruta");
        button.setBounds(450, 25, 110, 20);
        //listeners de combobox de lineas, sirven para agregar contenido a los boxes de esstaciones
        comboPartidaLinea.addActionListener((ActionEvent ae) -> {
            comboPartidaEstacion.removeAllItems();
            inicioComboEstaciones(comboPartidaLinea.getSelectedIndex(), true);
            frame.repaint();
        });
        comboDestinoLinea.addActionListener((ActionEvent ae) -> {
            comboDestinoEstacion.removeAllItems();
            inicioComboEstaciones((int) comboDestinoLinea.getSelectedIndex(), false);
            frame.repaint();
        });
        //listener del boton
        button.addActionListener((ActionEvent ae) -> {
            try {// obtenemos los numeros de las estaciones seleccionadas
                int partida = Data.lineas.get(comboPartidaLinea.getSelectedIndex())[comboPartidaEstacion.getSelectedIndex()];
                int destino = Data.lineas.get(comboDestinoLinea.getSelectedIndex())[comboDestinoEstacion.getSelectedIndex()];
                //le mandamos los numeros de estacion al metodo que saca la ruta mas corta
                RutaCorta.calcularRuta(partida,destino);
            } catch (ArrayIndexOutOfBoundsException e) {

            }
            frame.repaint();
        });

        frame.add(comboDestinoLinea);
        frame.add(comboPartidaLinea);
        frame.add(comboDestinoEstacion);
        frame.add(comboPartidaEstacion);
        frame.add(labelDestino);
        frame.add(labelPartida);
        frame.add(button);
        frame.repaint();
    }
    public static void inicioComboEstaciones(int lineaSeleccionada, boolean partida) {
        //con el for accedemos a las lineas y sus estaciones para mostrarlas
        if (partida) {
            for (int i = 0; i < Data.lineas.get(lineaSeleccionada).length; i++) {
                comboPartidaEstacion.addItem(Data.nombres.get(Data.lineas.get(lineaSeleccionada)[i]));
            }
        } else {
            for (int i = 0; i < Data.lineas.get(lineaSeleccionada).length; i++) {
                comboDestinoEstacion.addItem(Data.nombres.get(Data.lineas.get(lineaSeleccionada)[i]));
            }
        }
    }
}
