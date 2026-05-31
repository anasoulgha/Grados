package es.etg.dam.grados.conexion;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.etg.dam.grados.util.LogUtil;
import es.etg.dam.grados.util.UtilSeguridad;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Conexion {
 
    private static final Logger logger =Logger.getLogger("Logger");

    public void escribir(String msg, Socket soket)throws Exception{
        DataOutputStream dos = new DataOutputStream(soket.getOutputStream());
        dos.writeUTF(UtilSeguridad.prepararPaquete(msg));;
    }
    
    public String leer(Socket socket) throws Exception{
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        String paqueteBruto = dis.readUTF();
        LogUtil.escribirLog(logger,Level.INFO, "cifrado:hash:"+ paqueteBruto);
        return UtilSeguridad.desempaquetar(paqueteBruto);
        
    }
}
