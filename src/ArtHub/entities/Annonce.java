
package ArtHub.entities;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.io.Serializable;
import java.sql.Date;

/**
 *test
 * @author Fayechi
 */
public class Annonce  extends RecursiveTreeObject<Annonce> implements Serializable {
    private int id;
    private int id_org;
    private String date_event;
    private String nom_event;
    private int type_event;
    private int categorie;
    private String description;
     
    public Annonce() {
    }

    /**
     *
     * @param id_org
     * @param date_event
     * @param nom_event
     * @param type_event
     * @param categorie
     * @param description
     */
    public Annonce(int id_org, String date_event, String nom_event, int type_event, int categorie, String description) {
        this.id_org = id_org;
        this.date_event = date_event;
        this.nom_event = nom_event;
        this.type_event = type_event;
        this.categorie = categorie;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public int getId_org() {
        return id_org;
    }

    public String getDate_event() {
        return date_event;
    }

    public String getNom_event() {
        return nom_event;
    }

    public int getType_event() {
        return type_event;
    }

    public int getCategorie() {
        return categorie;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_org(int id_org) {
        this.id_org = id_org;
    }

    public void setDate_event(String date_event) {
        this.date_event = date_event;
    }

    public void setNom_event(String nom_event) {
        this.nom_event = nom_event;
    }

    public void setType_event(int type_event) {
        this.type_event = type_event;
    }

    public void setCategorie(int categorie) {
        this.categorie = categorie;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Evenement{" + "id=" + id + ", id_org=" + id_org + ", date_event=" + date_event + ", nom_event=" + nom_event + ", type_event=" + type_event + ", categorie=" + categorie + ", description=" + description + '}';
    }

  

  
    
    
}
