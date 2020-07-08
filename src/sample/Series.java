package sample;

import javax.persistence.*;

@Entity
@Table(name = "series")
public class Series {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idseries")
    private int idseries;

    @Column(name = "series")
    private String series;

    public Series() {
    }

    public Series(String series) {
        this.series = series;
    }

    public int getIdseries() {
        return idseries;
    }

    public void setIdseries(int idseries) {
        this.idseries = idseries;
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
                "idseries=" + idseries +
                ", series='" + series + '\'' +
                '}';
    }
}
