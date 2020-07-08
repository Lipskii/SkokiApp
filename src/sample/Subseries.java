package sample;

import javax.persistence.*;

@Entity
@Table(name = "subseries")
public class Subseries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsubseries")
    private int idSubseries;

    @Column(name = "subseries")
    private int subseries;

    public Subseries() {
    }

    public Subseries(int subseries) {
        this.subseries = subseries;
    }

    public int getIdSubseries() {
        return idSubseries;
    }

    public void setIdSubseries(int idSubseries) {
        this.idSubseries = idSubseries;
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
                "idsubseries=" + idSubseries +
                ", subseries=" + subseries +
                '}';
    }
}
