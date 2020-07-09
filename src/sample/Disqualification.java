package sample;

import javax.persistence.*;

@Entity
@Table(name = "disqualification")
public class Disqualification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddisqualification")
    private int idDisqualification;

    @Column(name = "disqualification")
    private String disqualification;

    public Disqualification() {
    }

    public Disqualification(String disqualification) {
        this.disqualification = disqualification;
    }

    public int getIdDisqualification() {
        return idDisqualification;
    }

    public void setIdDisqualification(int idDisqualification) {
        this.idDisqualification = idDisqualification;
    }

    public String getDisqualification() {
        return disqualification;
    }

    public void setDisqualification(String disqualification) {
        this.disqualification = disqualification;
    }

    @Override
    public String toString() {
        return "Disqualification{" +
                "idDisqualification=" + idDisqualification +
                ", disqualification='" + disqualification + '\'' +
                '}';
    }
}
