package sample;

import javax.persistence.*;

@Entity
@Table(name = "season")
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idseason")
    private int idSeason;

    @Column(name = "season")
    private int season;

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

    @Override
    public String toString() {
        return "Season{" +
                "idseason=" + idSeason +
                ", season=" + season +
                '}';
    }
}
