/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.entities;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.io.Serializable;
import javafx.collections.ObservableList;

/**
 *
 * @author Yasmine
 */
public class Candidat extends RecursiveTreeObject<Annonce> implements Serializable{
    private int id_cand;
    private int id_user;
    private int id_ann;
    private String cv;
    
    public Candidat (int id_user, int id_ann, String cv) {
        this.id_user = id_user;
        this.id_ann = id_ann;
        this.cv = cv;
    }

    public Candidat(String rCv) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getId_cand() {
        return id_cand;
    }

    public int getId_user() {
        return id_user;
    }

    public int getId_ann() {
        return id_ann;
    }

    public String getCv() {
        return cv;
    }
    
    public Candidat () {
    }
    
    public void setId_cand(int id_cand) {
        this.id_cand = id_cand;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setId_ann(int id_ann) {
        this.id_ann = id_ann;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }


}
