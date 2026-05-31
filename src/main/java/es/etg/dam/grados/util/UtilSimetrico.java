package es.etg.dam.grados.util;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class UtilSimetrico {

    private static final String ALOGRITMO = "AES";
    private static final String PASS = "1234567890123456";
    public static final String UTF = "UTF-8";
    private static final String AES = "AES/ECB/PKCS5Padding";

    public static String cifrar(String mensaje) throws Exception {
        Key key = new SecretKeySpec(PASS.getBytes(UTF), 0, 16, ALOGRITMO);
        Cipher aes = Cipher.getInstance(AES);
        aes.init(Cipher.ENCRYPT_MODE, key);
        byte[] cifrado = aes.doFinal(mensaje.getBytes(UTF));
        return Base64.getEncoder().encodeToString(cifrado);

    }

    public static String descifrar(String mensajeCifrado) throws Exception {
        Key key = new SecretKeySpec(PASS.getBytes(UTF), 0, 16, ALOGRITMO);
        Cipher aes = Cipher.getInstance(AES);
        aes.init(Cipher.DECRYPT_MODE, key);
        byte[] cifrado = Base64.getDecoder().decode(mensajeCifrado);
        byte[] descifrado = aes.doFinal(cifrado);
        return new String(descifrado, UTF);

    }
}
