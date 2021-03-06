
package ArtHub.entities;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *test
 * @author Fayechi
 */
public class Evenement  extends RecursiveTreeObject<Evenement> implements Serializable {
    private int id;
    private User id_org;
    private LocalDate date_event;
    private String nom_event;
    private String type_event;
    private int categorie;
    private String description;
    int capacite_event;   
    public Evenement() {
    }

    public Evenement(User id_org, LocalDate date_event, String nom_event, String type_event, int categorie, String description) {
        this.id_org = id_org;
        this.date_event = date_event;
        this.nom_event = nom_event;
        this.type_event = type_event;
        this.categorie = categorie;
        this.description = description;
    }

    public Evenement(User id_org, LocalDate date_event, String nom_event, String type_event, int categorie, String description, int capacite_event) {
        this.id_org = id_org;
        this.date_event = date_event;
        this.nom_event = nom_event;
        this.type_event = type_event;
        this.categorie = categorie;
        this.description = description;
        this.capacite_event = capacite_event;
    }

    public int getCapacite_event() {
        return capacite_event;
    }

    public User getId_org() {
        return id_org;
    }

    public void setId_org(User id_org) {
        this.id_org = id_org;
    }
    

    public void setCapacite_event(int capacite_event) {
        this.capacite_event = capacite_event;
    }
    

    public int getId() {
        return id;
    }

  
    public LocalDate getDate_event() {
        return date_event;
    }

    public String getNom_event() {
        return nom_event;
    }

    public String getType_event() {
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

   

    public void setDate_event(LocalDate date_event) {
        this.date_event = date_event;
    }

    public void setNom_event(String nom_event) {
        this.nom_event = nom_event;
    }

    public void setType_event(String type_event) {
        this.type_event = type_event;
    }

    public void setCategorie(int categorie) {
        this.categorie = categorie;
    }

    public void setDescription(String description) {
        this.description = description;
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
 

  

  
    
    
}
