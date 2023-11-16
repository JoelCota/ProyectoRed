/**
* Encriptador.java
* Jul 3, 2023 3:33:38 PM
*/ 

package org.itson.utils;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * 
 * @author Joel Antonio Lopez Cota ID:228926 
 */
public class Encriptador {

    /**
     * 
     */
    public Encriptador(){
    }
     private  final String clave = "itson_nainary256";

    /**
     * Encripta una cadena de texto utilizando el algoritmo AES.
     *
     * @param texto La cadena de texto a encriptar.
     * @return La cadena de texto encriptada.
     */
    public String encriptar(String texto) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(clave.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] textoEnBytes = texto.getBytes("UTF-8");
            byte[] textoEncriptado = cipher.doFinal(textoEnBytes);
            return Base64.getEncoder().encodeToString(textoEncriptado);
        } catch (Exception e) {
            throw new RuntimeException("Error al encriptar el texto", e);
        }
    }

    /**
     * Desencripta una cadena de texto previamente encriptada con el algoritmo
     * AES.
     *
     * @param palabraEncriptada La cadena de texto encriptada.
     * @return La cadena de texto desencriptada.
     */
    public String desencriptar(String palabraEncriptada) throws Exception {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(clave.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] textoEncriptadoEnBytes = Base64.getDecoder().decode(palabraEncriptada);
            byte[] textoDesencriptadoEnBytes = cipher.doFinal(textoEncriptadoEnBytes);
            return new String(textoDesencriptadoEnBytes, "UTF-8");
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage(), e);
        }
    }

}
