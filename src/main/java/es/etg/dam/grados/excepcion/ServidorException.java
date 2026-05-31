package es.etg.dam.grados.excepcion;

public class ServidorException extends Exception {
    
    private static final String MSG = "ERROR en el clinete: %s";

    public ServidorException(String detalle){
        super(String.format(MSG, detalle));
    }
     public ServidorException(String detalle, Throwable causa){
        super(String.format(MSG, detalle), causa);
    }
}


