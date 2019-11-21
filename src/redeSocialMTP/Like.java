/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redeSocialMTP;

import java.util.Date;

/**
 *
 * @author gilberto
 */
public class Like {
    
    private String nomePessoa;
    private Date dataLike;
    private byte[] foto;

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public Date getDataLike() {
        return dataLike;
    }

    public void setDataLike(Date dataLike) {
        this.dataLike = dataLike;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    
}
