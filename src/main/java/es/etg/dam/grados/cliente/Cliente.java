package es.etg.dam.grados.cliente;


import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.etg.dam.grados.conexion.Conexion;
import es.etg.dam.grados.excepcion.ClienteException;
import es.etg.dam.grados.server.Servidor;
import es.etg.dam.grados.util.LogUtil;

public class Cliente {
    

    private static final String FICHERO_LOG ="cliente.log";
    private static final String SEPARADOR =" ";
    private static final int NUM_ARG =2;
    private static final int INDEX_GRADOS= 0;
    private static final int INDEX_CONVERSOR=1;
    private static final String MSG_RESPUESTA = "Respuesta del server: %s mensaje: %s";

    public static void main(String[] args) throws ClienteException{

        Logger logger = null;

        try (Socket socket = new Socket(Servidor.HOST,Servidor.PUERTO)) {
            logger= LogUtil.crearLog(FICHERO_LOG);

            Conexion conn = new Conexion();

            String mensaje = args[INDEX_GRADOS]+ SEPARADOR+ args[INDEX_CONVERSOR];
            conn.escribir(mensaje, socket);

            String respuesta = conn.leer(socket);
            LogUtil.escribirLog(logger, Level.INFO,String.format(MSG_RESPUESTA, respuesta, mensaje));

            

        } catch (Exception e) {
            LogUtil.escribirLog(logger, Level.SEVERE, e.getMessage(), e);
            throw new ClienteException(e.getMessage(), e);
        } 
        
    }
}
