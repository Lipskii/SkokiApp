package sample;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subseries")
public class Subseries implements Comparable<Subseries> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsubseries")
    private int idSubseries;

    @Column(name = "subseries")
    private String subseries;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "subseries", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Competition> competitions;

    public Subseries() {
    }

    public Subseries(String subseries) {
        this.subseries = subseries;
    }

    public int getIdSubseries() {
        return idSubseries;
    }

    public void setIdSubseries(int idSubseries) {
        this.idSubseries = idSubseries;
    }

    public String getSubseries() {
        return subseries;
    }

    public void setSubseries(String subseries) {
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
        return subseries;
    }

    @Override
    public int compareTo(Subseries subseries) {
        return this.subseries.compareTo(subseries.subseries);
    }
}
