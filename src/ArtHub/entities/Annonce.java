
package ArtHub.entities;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.io.Serializable;
import java.sql.Date;

/**
 *test
 * @author Fayechi
 */
public class Annonce  extends RecursiveTreeObject<Annonce> implements Serializable {
    private int id_ann;
    private String titre_ann;
    private String desc_ann;
    private int pay;
    private String competences;
    private int categorie;
    private String ddl_ann;
     
    public Annonce() {
    }

    public Annonce(String titre_ann, String desc_ann, int pay, String competences, int categorie, String ddl_ann) {
        this.titre_ann = titre_ann;
        this.desc_ann = desc_ann;
        this.pay = pay;
        this.competences = competences;
        this.categorie = categorie;
        this.ddl_ann = ddl_ann;
    }

    public int getId_ann() {
        return id_ann;
    }

    public String getTitre_ann() {
        return titre_ann;
    }

    public String getDesc_ann() {
        return desc_ann;
    }

    public int getPay() {
        return pay;
    }

    public String getCompetences() {
        return competences;
    }

    public int getCategorie() {
        return categorie;
    }

    public String getDdl_ann() {
        return ddl_ann;
    }

    public void setId_ann(int id_ann) {
        this.id_ann = id_ann;
    }

    public void setTitre_ann(String titre_ann) {
        this.titre_ann = titre_ann;
    }

    public void setDesc_ann(String desc_ann) {
        this.desc_ann = desc_ann;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public void setCompetences(String competences) {
        this.competences = competences;
    }

    public void setCategorie(int categorie) {
        this.categorie = categorie;
    }

    public void setDdl_ann(String ddl_ann) {
        this.ddl_ann = ddl_ann;
    }

    @Override
    public String toString() {
        return "Annonce{" + "id_ann=" + id_ann + ", titre_ann=" + titre_ann + ", desc_ann=" + desc_ann + ", pay=" + pay + ", competences=" + competences + ", categorie=" + categorie + ", ddl_ann=" + ddl_ann + '}';
    }

    
}
