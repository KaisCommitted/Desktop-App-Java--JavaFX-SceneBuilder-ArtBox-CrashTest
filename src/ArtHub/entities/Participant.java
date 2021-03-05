
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

    public Participant(int id_user, int id_event) {
        this.id_user = id_user;
        this.id_event = id_event;
    }

    public Participant(int id_participation, int id_user, int id_event) {
        this.id_participation = id_participation;
        this.id_user = id_user;
        this.id_event = id_event;
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

    public void setId_participation(int id_participation) {
        this.id_participation = id_participation;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    @Override
    public String toString() {
        return "Participant{" + "id_participation=" + id_participation + ", id_user=" + id_user + ", id_event=" + id_event + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id_participation;
        hash = 97 * hash + this.id_user;
        hash = 97 * hash + this.id_event;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Participant other = (Participant) obj;
        if (this.id_user != other.id_user) {
            return false;
        }
        if (this.id_event != other.id_event) {
            return false;
        }
        return true;
    }
  

    
  
    
    
}
