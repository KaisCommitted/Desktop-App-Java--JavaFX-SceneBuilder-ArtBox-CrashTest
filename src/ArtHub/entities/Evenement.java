package ArtHub.entities;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;





/**
 * test
 *
 * @author Fayechi
 */
public class Evenement extends RecursiveTreeObject<Evenement> implements Serializable {

    private int id;
    private User id_org;
    private LocalDate date_event;
    private String nom_event;
    private String type_event;
    private String categorie;
    private String description;
    private int capacite_event;
    private int nb_max;
    private String image_event;
    private String location_event;
    

    public Evenement() {
    }

    public Evenement(User id_org, LocalDate date_event, String nom_event, String type_event, String categorie, String description, int capacite_event, int nb_max, String image_event) {
        this.id_org = id_org;
        this.date_event = date_event;
        this.nom_event = nom_event;
        this.type_event = type_event;
        this.categorie = categorie;
        this.description = description;
        this.capacite_event = capacite_event;
        this.nb_max = nb_max;
        this.image_event = image_event;
    }

    public Evenement(User id_org, LocalDate date_event, String nom_event, String type_event, String categorie, String description, int capacite_event, int nb_max) {
        this.id_org = id_org;
        this.date_event = date_event;
        this.nom_event = nom_event;
        this.type_event = type_event;
        this.categorie = categorie;
        this.description = description;
        this.capacite_event = capacite_event;
        this.nb_max = nb_max;
    }

    public String getImage_event() {
        return image_event;
    }

    public void setImage_event(String image_event) {
        this.image_event = image_event;
    }

    public Evenement(User id_org, LocalDate date_event, String nom_event, String type_event, String categorie, String description, int capacite_event, int nb_max, String image_event, String location_event) {
        this.id_org = id_org;
        this.date_event = date_event;
        this.nom_event = nom_event;
        this.type_event = type_event;
        this.categorie = categorie;
        this.description = description;
        this.capacite_event = capacite_event;
        this.nb_max = nb_max;
        this.image_event = image_event;
        this.location_event = location_event;
    }

    public String getLocation_event() {
        return location_event;
    }

    public void setLocation_event(String location_event) {
        this.location_event = location_event;
    }
    

    public int getNb_max() {
        return nb_max;
    }

    public void setNb_max(int nb_max) {
        this.nb_max = nb_max;
    }

    public Evenement(User id_org, LocalDate date_event, String nom_event, String type_event, String categorie, String description) {
        this.id_org = id_org;
        this.date_event = date_event;
        this.nom_event = nom_event;
        this.type_event = type_event;
        this.categorie = categorie;
        this.description = description;
    }

    public Evenement(User id_org, LocalDate date_event, String nom_event, String type_event, String categorie, String description, int capacite_event) {
        this.id_org = id_org;
        this.date_event = date_event;
        this.nom_event = nom_event;
        this.type_event = type_event;
        this.categorie = categorie;
        this.description = description;
        this.capacite_event = capacite_event;
    }

    public Evenement(int id) {
        this.id = id;
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

    public String getCategorie() {
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

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public static boolean isNotInteger(String str) {
    if (str == null) {
        return true;
    }
    int length = str.length();
    if (length == 0) {
        return true;
    }
    int i = 0;
    if (str.charAt(0) == '-') {
        if (length == 1) {
            return true;
        }
        i = 1;
    }
    for (; i < length; i++) {
        char c = str.charAt(i);
        if (c < '0' || c > '9') {
            return true;
        }
    }
    return false;
}

}
