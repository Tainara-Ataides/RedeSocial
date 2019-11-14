/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redeSocialMTP;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author gilberto
 */
public class CriptografaSenha {

    public static String critografarSenha(String senha) {
        try {
            MessageDigest algorithm = MessageDigest.getInstance("SHA");
            byte messageDigest[] = algorithm.digest(senha.getBytes("unicode"));
            return new String(messageDigest);
        } catch (NoSuchAlgorithmException ex) {
            JOptionPane.showMessageDialog(null, "Algoritmo inexistente");
        } catch (UnsupportedEncodingException ex) {
            JOptionPane.showMessageDialog(null, "Codificação não suportada");
        }
        return null;
    }

}
