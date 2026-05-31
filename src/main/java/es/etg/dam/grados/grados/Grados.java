package es.etg.dam.grados.grados;

public class Grados {
    
    public static double celsiusAFahren(double celsius){
        return(celsius * 9.0/5.0) +32;
        
    }
        public static double fahrenAcelsius(double farh){
        return(farh - 32) * 9.0/5.0;
    }
}
