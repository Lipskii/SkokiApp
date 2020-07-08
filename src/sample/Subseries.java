package sample;

import javax.persistence.*;

@Entity
@Table(name = "subseries")
public class Subseries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idsubseries;

    @Column(name="subseries")
    private int subseries;

    public Subseries() {
    }

    public Subseries(int subseries) {
        this.subseries = subseries;
    }

    public int getIdsubseries() {
        return idsubseries;
    }

    public void setIdsubseries(int idsubseries) {
        this.idsubseries = idsubseries;
    }

    public int getSubseries() {
        return subseries;
    }

    public void setSubseries(int subseries) {
        this.subseries = subseries;
    }

    @Override
    public String toString() {
        return "Subseries{" +
                "idsubseries=" + idsubseries +
                ", subseries=" + subseries +
                '}';
    }
}
