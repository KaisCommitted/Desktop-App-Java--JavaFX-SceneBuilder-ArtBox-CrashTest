
package ArtHub.entities;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.Serializable;
import java.sql.Date;




public class Signalisation extends RecursiveTreeObject<Signalisation> implements Serializable {
    private int id_signal;
    private String contenu_signal;
    private String type_signal;
    private String etat_signal;
    private Date date_signal;
     
    public Signalisation() {
    }

    public Signalisation(int id_signal, String contenu_signal, String type_signal, String etat_signal, Date date_signal) {
        this.id_signal = id_signal;
        this.contenu_signal =contenu_signal;
        this.type_signal = type_signal;
        this.etat_signal = etat_signal;
        this.date_signal = date_signal;
    }


    public int getId_signal() {
        return id_signal;
    }

    public String getContenu_signal() {
        return contenu_signal;
    }

    public String getType_signal() {
        return type_signal;
    }

    public String getEtat_signal() {
        return etat_signal;
    }

    public Date getDate_signal() {
        return date_signal;
    }

    public void setId_signal(int id_signal) {
        this.id_signal = id_signal;
    }

    public void setContenu_signal(String contenu_signal) {
        this.contenu_signal = contenu_signal;
    }

    public void setType_signal(String type_signal) {
        this.type_signal = type_signal;
    }

    public void setEtat_signal(String etat_signal) {
        this.etat_signal = etat_signal;
    }

    public void setDate_signal(Date date_signal) {
        this.date_signal = date_signal;
    }

    @Override
    public String toString() {
        return "Signalisation{" + "id_signal=" + id_signal + ", contenu_signal=" + contenu_signal + ", type_signal=" + type_signal + ", etat_signal=" + etat_signal + ", date_signal=" + date_signal + '}';
    }

    

  

  
    
    
}


