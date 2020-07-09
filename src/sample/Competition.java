package sample;

import javax.persistence.*;

@Entity
@Table(name = "competition")
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcompetition")
    private int idCompetition;

    @Column(name = "series_round")
    private int seriesRound;

    @Column(name = "subseries_round")
    private int subseriesRound;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "fkseason")
    private Season season;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "fkseries")
    private Series series;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "fksubseries")
    private Subseries subseries;

    public Competition() {
    }

    public Competition(int seriesRound, int subseriesRound, Season season, Series series, Subseries subseries) {
        this.seriesRound = seriesRound;
        this.subseriesRound = subseriesRound;
        this.season = season;
        this.series = series;
        this.subseries = subseries;
    }

    public int getIdCompetition() {
        return idCompetition;
    }

    public void setIdCompetition(int idCompetition) {
        this.idCompetition = idCompetition;
    }

    public int getSeriesRound() {
        return seriesRound;
    }

    public void setSeriesRound(int seriesRound) {
        this.seriesRound = seriesRound;
    }

    public int getSubseriesRound() {
        return subseriesRound;
    }

    public void setSubseriesRound(int subseriesRound) {
        this.subseriesRound = subseriesRound;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public Subseries getSubseries() {
        return subseries;
    }

    public void setSubseries(Subseries subseries) {
        this.subseries = subseries;
    }

    @Override
    public String toString() {
        return "Competition{" +
                "idcompetition=" + idCompetition +
                ", seriesRound=" + seriesRound +
                ", subseriesRound=" + subseriesRound +
                ", season=" + season +
                ", series=" + series +
                ", subseries=" + subseries +
                '}';
    }
}
