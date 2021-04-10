
package ArtHub.entities;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.io.Serializable;


/**
 *test
 * @author Fayechi
 */
    public class Categorie  extends RecursiveTreeObject<Categorie> implements Serializable {
    private int id;
    private String categorie_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategorie_name() {
        return categorie_name;
    }

    public void setCategorie_name(String categorie_name) {
        this.categorie_name = categorie_name;
    }

    public Categorie(int id) {
        this.id = id;
    }

    public Categorie() {
    }

    public Categorie(int id, String categorie_name) {
        this.id = id;
        this.categorie_name = categorie_name;
    }
  

    
   

    
  
    
    
}
