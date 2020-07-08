package sample;

import javax.persistence.*;

@Entity
@Table(name = "competition")
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcompetition")
    private int idcompetition;

    @Column(name = "series_round")
    private int seriesRound;

    @Column(name = "subseries_round")
    private int subseriesRound;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "fkseason")
    private Season season;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "fkseries")
    private Series series;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
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

    public int getIdcompetition() {
        return idcompetition;
    }

    public void setIdcompetition(int idcompetition) {
        this.idcompetition = idcompetition;
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
                "idcompetition=" + idcompetition +
                ", seriesRound=" + seriesRound +
                ", subseriesRound=" + subseriesRound +
                ", season=" + season +
                ", series=" + series +
                ", subseries=" + subseries +
                '}';
    }
}
