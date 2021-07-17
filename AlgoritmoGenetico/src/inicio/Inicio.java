package inicio;

import java.awt.Color;
import javax.swing.JFrame;
import panels.Lateral;
import panels.Inferior;
import procesamiento.ProcesoPrincipal;

public class Inicio {
    public static Inferior inferior = new Inferior();
    public static Lateral lateral = new Lateral();
    public static void main(String args[]) { 
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(700, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Tiro de canion");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.darkGray);
        

        inferior.setBounds(0, 120, 680, 420);
        //lateral.setBounds(400, 0, 280, 120);
        frame.add(inferior);
        //frame.add(lateral);
        ProcesoPrincipal.resolver(frame);
        frame.repaint();
        
        
        
    }
}
