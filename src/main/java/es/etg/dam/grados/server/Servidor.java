package es.etg.dam.grados.server;


import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.etg.dam.grados.excepcion.ServidorException;
import es.etg.dam.grados.grados.GestionarCliente;
import es.etg.dam.grados.util.LogUtil;

public class Servidor {
    public static final int PUERTO = 8888;
    public static final String HOST = "localhost";
    private static final String FICHERO_LOG ="server.log";
    private static final String MSG_PUERTO_ESCUCHA ="Servidor escuchanndo en el puerto %d";


    public static void main(String[] args) throws ServidorException{
        Logger logger =null;

        try (ServerSocket server = new ServerSocket(PUERTO)) {
            logger =LogUtil.crearLog(FICHERO_LOG);

            LogUtil.escribirLog(logger,Level.INFO,String.format(MSG_PUERTO_ESCUCHA, PUERTO));

            while (true) {
                Socket cliente = server.accept();
                Thread hilo= new Thread(new GestionarCliente(cliente));
                hilo.start();

            }


        } catch (Exception e) {
            LogUtil.escribirLog(logger, Level.SEVERE, e.getMessage(), e);
            throw new ServidorException(e.getMessage(), e);
        }


    }
}
