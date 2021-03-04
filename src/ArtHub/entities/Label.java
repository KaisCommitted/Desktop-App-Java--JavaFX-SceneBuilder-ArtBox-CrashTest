
package ArtHub.entities;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Fayechi
 */
public class Label  extends RecursiveTreeObject<Label> implements Serializable {
    private int id;
    private String name;
    private String type;
     
    public Label() {
    }

    /**
     *
     * @param id
     * @param name
     * @param type
     */
    public Label(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public int getid() {
        return id;
    }


    public String getname() {
        return name;
    }

    public String gettype() {
        return type;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setname(String name) {
        this.name = name;
    }

    public void settype(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Label{" + "id=" + id + ", name=" + name + ", type=" + type + '}';
    }
   
    
}
