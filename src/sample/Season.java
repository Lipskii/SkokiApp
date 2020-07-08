package sample;

import javax.persistence.*;

@Entity
@Table(name = "season")
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idseason")
    private int idseason;

    @Column(name = "season")
    private int season;

    public Season() {
    }

    public Season(int season) {
        this.season = season;
    }

    public int getIdseason() {
        return idseason;
    }

    public void setIdseason(int idseason) {
        this.idseason = idseason;
    }

    @Override
    public String toString() {
        return "Season{" +
                "idseason=" + idseason +
                ", season=" + season +
                '}';
    }
}
