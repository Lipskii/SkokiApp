package sample;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subseries")
public class Subseries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsubseries")
    private int idSubseries;

    @Column(name = "subseries")
    private int subseries;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "subseries", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Competition> competitions;

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

    public void addCompetition(Competition competition) {
        if (competitions == null) {
            competitions = new ArrayList<>();
        }
        competitions.add(competition);

        competition.setSubseries(this);
    }

    @Override
    public String toString() {
        return "Subseries{" +
                "idsubseries=" + idSubseries +
                ", subseries=" + subseries +
                '}';
    }
}
