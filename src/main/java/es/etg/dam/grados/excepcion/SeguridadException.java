package es.etg.dam.grados.excepcion;

public class SeguridadException extends Exception {
     public SeguridadException(String mensaje){
        super(String.format(mensaje));
    }
}
