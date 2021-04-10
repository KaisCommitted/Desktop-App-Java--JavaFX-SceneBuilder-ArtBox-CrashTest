/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.entities;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Kais
 */
public class E_Comment extends RecursiveTreeObject<Rating> implements Serializable{
     private int id;
    private User id_user;
    private Evenement id_event;
    private String content;
    private LocalDate commentDate;

    public E_Comment() {
    }

    public E_Comment(User id_user, Evenement id_event, String content, LocalDate commentDate) {
        this.id_user = id_user;
        this.id_event = id_event;
        this.content = content;
        this.commentDate = commentDate;
    }

    public E_Comment(int id, User id_user, Evenement id_event, String content, LocalDate commentDate) {
        this.id = id;
        this.id_user = id_user;
        this.id_event = id_event;
        this.content = content;
        this.commentDate = commentDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getId_user() {
        return id_user;
    }

    public void setId_user(User id_user) {
        this.id_user = id_user;
    }

    public Evenement getId_event() {
        return id_event;
    }

    public void setId_event(Evenement id_event) {
        this.id_event = id_event;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(LocalDate commentDate) {
        this.commentDate = commentDate;
    }
    
    
    
    
    
}
