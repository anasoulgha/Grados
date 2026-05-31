package es.etg.dam.grados.grados;

import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.etg.dam.grados.conexion.Conexion;
import es.etg.dam.grados.excepcion.GestionClienteException;
import es.etg.dam.grados.util.LogUtil;


public class GestionarCliente implements Runnable {
    private static final String SEPARADOR =" ";
    private static final Logger logger = Logger.getLogger("Logger");
    private static final String MSG_ERROR_TIPO = "ERROR: Tipo no reconocido";

    
    private Socket socket;


    public GestionarCliente(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run(){
        Conexion conn =new Conexion();

        try {
            String mensaje= conn.leer(socket);
            String[] partes = mensaje.split(SEPARADOR);

            
            String tipo = partes[1];
            double valor= Double.parseDouble(partes[0]);
            String resultado;

            if (tipo.equals("FtC")) {
                resultado= String.valueOf(Grados.fahrenAcelsius(valor));
        }else if (tipo.equals("CtF")) {
                resultado= String.valueOf(Grados.celsiusAFahren(valor));
            
        }else{
            resultado= MSG_ERROR_TIPO;
        }
        LogUtil.escribirLog(logger, Level.INFO, "Resultado: " + resultado);
        conn.escribir(resultado, socket);
        //socket.close();

        } catch (Exception e) {
            throw new GestionClienteException(e.getMessage(),e);
        }
        
    }
}
