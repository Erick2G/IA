package panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;
import static procesamiento.Data.evaluacion;
import static procesamiento.Data.xB;
import static procesamiento.Data.xC;
import static procesamiento.Data.yB;
import static procesamiento.Data.yC;

public class Inferior extends JPanel {

    public int XC, YC, XB, YB, angle = 0;
    public boolean respuesta = false;
    public static ArrayList<int[]> individuo;

    public void reajustarCoordenadas() {
        XC = xC;
        YC = yC;
        XB = xB;
        YB = yB;
    }

    public void setTiro(ArrayList<int[]> ind) {
        individuo = ind;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //bala
        g.setColor(Color.RED);
        g.drawLine(XB - 5, YB - 5, XB + 5, YB + 5);
        g.drawLine(XB + 5, YB - 5, XB - 5, YB + 5);
        //canion
        Graphics2D g2d = (Graphics2D) g;
        //g2d.rotate(angle);
        
        g2d.drawRect(XC, YC, 10, 5);
        g.setColor(Color.GRAY);
        try {
            //System.out.println("- XB: " + individuo[1] + " YB: " + individuo[2]);
            //g.drawOval(individuo[1]-5, individuo[2]-5, 10, 10);
            for (int i = 0; i < individuo.size(); i++) {
                g.drawOval(individuo.get(i)[1]-5, individuo.get(i)[2]-5, 10, 10);
            }
            //angle = individuo[0];
        } catch (NullPointerException e) {

        }

    }
}
