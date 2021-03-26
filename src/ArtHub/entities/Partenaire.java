
package ArtHub.entities;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.io.Serializable;

/**
 *
 * @author Fayechi
 */
public class Partenaire  extends RecursiveTreeObject<Partenaire> implements Serializable {
    private int id_part;
    private String nom;
    private String adresse;
    private String logo;
    private String rib;
    private String tel;
   
     
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

    public Partenaire(String nom, String adresse, String logo, String rib, String tel) {
        this.nom = nom;
        this.adresse = adresse;
        this.logo = logo;
        this.rib = rib;
        this.tel = tel;
    }

    /**
     *
     * @param id
     * @param name
     * @param type
     */
   
    
}
