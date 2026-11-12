/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nutricionalappfx.utilidades;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javax.management.RuntimeErrorException;

/**
 *
 * @author cinth
 */
public class Utilidades {
    
    public static String generarCifradoSHA256(String dato)throws RuntimeException{
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(dato.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash){
                String hexadecimal = Integer.toHexString(0xff & b);
                if(hexadecimal.length() == 1){
                    hexString.append('0');
                }
                hexString.append(hexadecimal);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            throw new RuntimeException("Error al cifrar la información.");
        }
    }
    
    public static void mostrarAlertaSimple(String titulo, String contenido, Alert.AlertType tipo){
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }
}
