
package ArtHub.entities;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.io.Serializable;
import java.sql.Date;

/**
 *test
 * @author Fayechi
 */
public class Participant  extends RecursiveTreeObject<Participant> implements Serializable {
    private int id_participation;
    private int id_user;
    private int id_event;
    private String name_user;
    private String name_event;

    public Participant(int id_participation, int id_user, int id_event, String name_user, String name_event) {
        this.id_participation = id_participation;
        this.id_user = id_user;
        this.id_event = id_event;
        this.name_user = name_user;
        this.name_event = name_event;
    }
   
     
    public Participant() {
    }

    public int getId_participation() {
        return id_participation;
    }

    public int getId_user() {
        return id_user;
    }

    public int getId_event() {
        return id_event;
    }

    public String getName_user() {
        return name_user;
    }

    public String getName_event() {
        return name_event;
    }

    public void setId_participation(int id_participation) {
        this.id_participation = id_participation;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public void setName_user(String name_user) {
        this.name_user = name_user;
    }

    public void setName_event(String name_event) {
        this.name_event = name_event;
    }

    
  
    
    
}
