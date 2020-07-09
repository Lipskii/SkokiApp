package sample;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "season")
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idseason")
    private int idSeason;

    @Column(name = "season")
    private int season;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "season", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Competition> competitions;

    public Season() {
    }

    public Season(int season) {
        this.season = season;
    }

    public int getIdSeason() {
        return idSeason;
    }

    public void setIdSeason(int idSeason) {
        this.idSeason = idSeason;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public List<Competition> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(List<Competition> competitions) {
        this.competitions = competitions;
    }

    public void addCompetition(Competition competition) {
        if (competitions == null) {
            competitions = new ArrayList<>();
        }

        competitions.add(competition);

        competition.setSeason(this);
    }

    @Override
    public String toString() {
        return "Season{" +
                "idseason=" + idSeason +
                ", season=" + season +
                '}';
    }
}
