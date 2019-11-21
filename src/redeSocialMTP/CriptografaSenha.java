/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redeSocialMTP;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;

/**
 *
 * @author gilberto
 */
public class CriptografaSenha {

    public static String critografarSenha(String senha) {
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.update(senha.getBytes(), 0, senha.length());
            return new BigInteger(1, algorithm.digest()).toString(16);
        } catch (NoSuchAlgorithmException ex) {
            JOptionPane.showMessageDialog(null, "Algoritmo inexistente");
        }
        return null;
    }

}
