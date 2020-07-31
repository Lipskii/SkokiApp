package sample;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "series")
public class Series {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idseries")
    private int idSeries;

    @Column(name = "series")
    private String series;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "series", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Competition> competitions;

    public Series() {
    }

    public Series(String series) {
        this.series = series;
    }

    public int getIdSeries() {
        return idSeries;
    }

    public void setIdSeries(int idSeries) {
        this.idSeries = idSeries;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public void addCompetition(Competition competition) {
        if (competitions == null) {
            competitions = new ArrayList<>();
        }
        competitions.add(competition);

        competition.setSeries(this);
    }

    @Override
    public String toString() {
        return series;
    }
}
