/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redeSocialMTP;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author ifg
 */
public class Post {

    private int id;
    private String texto;
    private byte[] imagem;
    private Date dataPost;
    private int pessoaId;

    public void setPessoaId(int pessoaId) {
        this.pessoaId = pessoaId;
    }

  public int getPessoaId() {
        return pessoaId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public Date getDataPost() {
        return dataPost;
    }

    public void setDataPost(Date dataPost) {
        this.dataPost = dataPost;
    }


    public int getId() {
        return id;
    }

    public String getTexto() {
        return texto;
    }

    public byte[] getImagem() {
        return imagem;
    }
}
