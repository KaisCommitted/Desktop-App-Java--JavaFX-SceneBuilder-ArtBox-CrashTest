
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
    private User id_user;
    private Evenement id_event;

    public Participant(User id_user, Evenement id_event) {
        this.id_user = id_user;
        this.id_event = id_event;
    }

    public Participant() {
    }
    
    public Participant(int id_participation) {
        this.id_participation = id_participation;
    }

    public int getId_participation() {
        return id_participation;
    }

    public User getId_user() {
        return id_user;
    }

    public Evenement getId_event() {
        return id_event;
    }

    public void setId_participation(int id_participation) {
        this.id_participation = id_participation;
    }

    public void setId_user(User id_user) {
        this.id_user = id_user;
    }

    public void setId_event(Evenement id_event) {
        this.id_event = id_event;
    }

    

    
  
    
    
}
