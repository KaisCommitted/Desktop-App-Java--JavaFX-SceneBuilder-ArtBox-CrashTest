package ArtHub.entities;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.io.Serializable;

/**
 *
 * @author Fayechi
 */
public class Partenaire extends RecursiveTreeObject<Partenaire> implements Serializable {

    private int id_part;
    private String nom;
    private String adresse;
    private String logo;
    private String rib;
    private String tel;
    private int status;
    private User id_user;

    public Partenaire() {
    }

    public int getId_part() {
        return id_part;
    }

    public void setId_part(int id_part) {
        this.id_part = id_part;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User getId_user() {
        return id_user;
    }

    public void setId_user(User id_user) {
        this.id_user = id_user;
    }

    public Partenaire(String nom, String adresse, String logo, String rib, String tel, int status, User id_user) {
        this.nom = nom;
        this.adresse = adresse;
        this.logo = logo;
        this.rib = rib;
        this.tel = tel;
        this.status = status;
        this.id_user = id_user;
    }

    public Partenaire(String nom, String adresse, String logo, String rib, String tel, int status) {
        this.nom = nom;
        this.adresse = adresse;
        this.logo = logo;
        this.rib = rib;
        this.tel = tel;
        this.status = status;
    }

    public Partenaire(String nom, String adresse, String rib, String tel, int status) {
        this.nom = nom;
        this.adresse = adresse;

        this.rib = rib;
        this.tel = tel;
        this.status = status;
    }

    public Partenaire(int id_part, String nom, String adresse, String rib, String tel, int status) {

        this.id_part = id_part;
        this.nom = nom;
        this.adresse = adresse;
        this.rib = rib;
        this.tel = tel;
        this.status = status;
    }

    @Override
    public String toString() {
        return nom;
    }

    /**
     *
     * @param id
     * @param name
     * @param type
     */
}
