package es.etg.dam.grados.util;

import es.etg.dam.grados.excepcion.SeguridadException;

public class UtilSeguridad {
    
    public static String prepararPaquete(String msg) throws Exception{
        String cifrado =UtilSimetrico.cifrar(msg);
        byte[] hash= UtilHash.generarHash(msg.getBytes(UtilSimetrico.UTF));
        String hashStr = UtilHash.bytesToHex(hash);
        return cifrado + ":" + hashStr;
    }
    public static String desempaquetar(String paquete) throws Exception{
        String[] partes = paquete.split(":");
        String msgDescifrado = UtilSimetrico.descifrar(partes[0]);
        byte[] hashCalc= UtilHash.generarHash(msgDescifrado.getBytes(UtilSimetrico.UTF));
        String hasCalcStr = UtilHash.bytesToHex(hashCalc);

        if (!hasCalcStr.equals(partes[1])) {
            throw new SeguridadException("Error hash:");
            
        }

        return msgDescifrado;
    }


}
