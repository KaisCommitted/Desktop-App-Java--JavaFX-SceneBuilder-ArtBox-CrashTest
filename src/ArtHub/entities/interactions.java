/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.entities;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.io.Serializable;

/**
 *
 * @author Adam Khalfaoui
 */
public class interactions extends RecursiveTreeObject<Post> implements Serializable{
   
   private int id_inter;
   private Post id_post;

    public interactions(Post id_post, User id_user) {
        this.id_post = id_post;
        this.id_user = id_user;
    }
   private User id_user;
   private int like_check;
   
   
    public int getId_inter() {
        return id_inter;
    }

    public void setId_inter(int id_inter) {
        this.id_inter = id_inter;
    }

    public Post getId_post() {
        return id_post;
    }

    public void setId_post(Post id_post) {
        this.id_post = id_post;
    }

    public User getId_user() {
        return id_user;
    }

    public void setId_user(User id_user) {
        this.id_user = id_user;
    }

    public int getLike_check() {
        return like_check;
    }

    public void setLike_check(int like_check) {
        this.like_check = like_check;
    }
    
   
    
}
