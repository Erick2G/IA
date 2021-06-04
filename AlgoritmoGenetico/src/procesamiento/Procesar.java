package procesamiento;

import static procesamiento.Data.longF;

public class Procesar {
    public static String decABin(int dec, int type){
        String binario = "";
        int sob;
        while(dec!=0){
            sob = dec%2;
            dec = (int) dec/2;
            binario = sob + binario;
        }
        //en caso de que el dec sea pequeño, acompletamos el binario para tener la misma longitud
        switch (type){
            case 0:
                while(binario.length()<longF){
                    binario = "0"+binario;
                }
            break;
            case 1:
                while(binario.length()<7){
                    binario = "0"+binario;
                }
            break;
            case 2:
                while(binario.length()<9){
                    binario = "0"+binario;
                }
            break;
        }
        return binario;
    }
    public static String decABinLong(int dec){
        String binario = "";
        int sob;
        while(dec!=0){
            sob = dec%2;
            dec = (int) dec/2;
            binario = sob + binario;
        }
        return binario;
    }
    public static int binADec(String bin){
        int dec = 0;
        int tam = bin.length();
        int pot = 0;
        int j = tam -1 ;
        String[] binario = bin.split("");
        for(int i = 0; i<tam;i++){
            dec += Math.pow(2,pot)*Integer.parseInt(binario[j]);
            pot += 1;
            j -= 1;
        }
        return dec;
    }
}
