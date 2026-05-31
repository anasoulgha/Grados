package es.etg.dam.grados.excepcion;

public class GestionClienteException extends RuntimeException {
        private static final String MSG = "ERROR en el clinete: %s";

       public GestionClienteException(String detalle){
        super(String.format(MSG, detalle));
    }
     public GestionClienteException(String detalle, Throwable causa){
        super(String.format(MSG, detalle), causa);
    }
}
