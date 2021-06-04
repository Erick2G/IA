package procesamiento;

import java.util.ArrayList;
import static procesamiento.Data.evaluacion;
import static procesamiento.Data.hTablero;
import static procesamiento.Data.poblacion;
import static procesamiento.Data.wTablero;
import static procesamiento.Data.xB;
import static procesamiento.Data.xC;
import static procesamiento.Data.yB;
import static procesamiento.Data.yC;

public class Evaluacion {

    public static void evaluarPoblacion() {
        evaluacion = new ArrayList<>();
        for (int i = 0; i < poblacion.size(); i++) {
            evaluar(poblacion.get(i));
        }
    }

    public static void evaluar(String[] individuo) {
        double g = 9.81;
        int F = Procesar.binADec(individuo[0]);
        int T1 = Procesar.binADec(individuo[1]);
        int T2 = Procesar.binADec(individuo[2]);

        double A = (Math.pow(F, 2) * Math.sin(2 * T1)) / g;

        //double cte = .00208875, div = T2 % 90, temp = cte * Math.pow(2, div / 10) * (div / 10);

        //Double m = Math.toRadians(div) + temp;
        double m = Math.toRadians(T2); // +temp
        m = Math.tan(m);
        int x = (int) (Math.sqrt(A * A / (1 + m * m)));
        double tempy = m * x;
        int y = (int) (Math.sqrt((A*A) / (1 + 1/m*1/m)));;
        if (y < 0) {
            y *= -1;
        }
        caidaDeBala(x, y, T2);
    }
    //acomodar la bala respoecto a la posición del cañón
    public static void caidaDeBala(int x, int y, int T2) {
        int xB, yB;
        int temp;
        if (T2 < 90) {
            xB = xC + x;
            yB = yC + y;
        } else if (T2 < 180) {
            temp = x;
            xB = xC - x;
            yB = yC + y;
        } else if (T2 < 270) {
            xB = xC - x;
            yB = yC - y;
        } else {
            temp = x;
            xB = xC + x;
            yB = yC - y;
        }
        rankear(xB, yB);
    }

    public static void rankear(int x, int y) {
        if (x > wTablero || y > hTablero || x < 0 || y < 0) {
            evaluacion.add(new int[]{-1, x, y});
        } else {
            int temp = distancia(x, xB, y, yB);
            evaluacion.add(new int[]{temp, x, y});
        }
    }

    public static int distancia(int x1, int x2, int y1, int y2) {
        int rX = x2 - x1, rY = y2 - y1;
        int d = (int) Math.sqrt(Math.pow(rX, 2) + Math.pow(rY, 2));
        if (d < 0) {
            d *= -1;
        }
        return d;
    }
}
