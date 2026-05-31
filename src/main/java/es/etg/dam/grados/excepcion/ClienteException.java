package es.etg.dam.grados.excepcion;

public class ClienteException extends Exception {
    
    private static final String MSG = "ERROR en el clinete: %s";

    public ClienteException(String detalle){
        super(String.format(MSG, detalle));
    }
     public ClienteException(String detalle, Throwable causa){
        super(String.format(MSG, detalle), causa);
    }
}
