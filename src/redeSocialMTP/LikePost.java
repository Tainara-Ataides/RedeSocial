/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redeSocialMTP;

/**
 *
 * @author gilberto
 */
public class LikePost {
    
    private int id;
    private int nomeId;
    private int postId;
    private String nomeLike;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getNomeId() {
        return nomeId;
    }

    public void setNomeId(Integer nomeId) {
        this.nomeId = nomeId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getNomeLike() {
        return nomeLike;
    }

    public void setNomeLike(String nomeLike) {
        this.nomeLike = nomeLike;
    }
    
}
