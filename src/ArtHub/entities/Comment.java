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
public class Comment extends RecursiveTreeObject<Post> implements Serializable {
  
    private Post id_post;
    private User id_user;
    private String Comment;
    private String Comment_analys;
    private int id_comment ;
    

    public Comment(Post id_post, User id_user, String Comment, String Comment_analys) {
        this.id_post = id_post;
        this.id_user = id_user;
        this.Comment = Comment;
        this.Comment_analys = Comment_analys;
        
    }

   

    public int getId_comment() {
        return id_comment;
    }

    public void setId_comment(int id_comment) {
        this.id_comment = id_comment;
    }

    public Post getId_post() {
        return id_post;
    }

    public Comment(Post id_post) {
        this.id_post = id_post;
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

    public String getComment() {
        return Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }

    public String getComment_analys() {
        return Comment_analys;
    }

    public void setComment_analys(String Comment_analys) {
        this.Comment_analys = Comment_analys;
    }
    
    

    
    
}
