/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redeSocialMTP;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author ifg
 */
public class FileParaByte {
    
    public static byte [] fileParaByte(File arquivo) throws FileNotFoundException{
       FileInputStream fis = null;
        
        byte[] bytesArray = new byte[(int) arquivo.length()];
        
        try{
            fis = new FileInputStream(arquivo);
           fis.read(bytesArray);
        fis.close();
        }
        catch(IOException ioExp){
            
        }
        
        return bytesArray;
    
    }
}