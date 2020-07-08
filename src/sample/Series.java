package sample;

import javax.persistence.*;

@Entity
@Table(name = "series")
public class Series {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idseries")
    private int idSeries;

    @Column(name = "series")
    private String series;

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

    @Override
    public String toString() {
        return "Series{" +
                "idseries=" + idSeries +
                ", series='" + series + '\'' +
                '}';
    }
}
