package sample;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "jury_type")
public class JuryType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idjury_type")
    private int idJuryType;

    @Column(name = "jury_type")
    private String juryType;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "juryType", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Jury> juries;

    public JuryType() {
    }

    public JuryType(String juryType) {
        this.juryType = juryType;
    }

    public int getIdJuryType() {
        return idJuryType;
    }

    public void setIdJuryType(int idJuryType) {
        this.idJuryType = idJuryType;
    }

    public String getJuryType() {
        return juryType;
    }

    public void setJuryType(String juryType) {
        this.juryType = juryType;
    }

    public List<Jury> getJuries() {
        return juries;
    }

    public void setJuries(List<Jury> juries) {
        this.juries = juries;
    }

    @Override
    public String toString() {
        return "JuryType{" +
                "idJuryType=" + idJuryType +
                ", juryType='" + juryType + '\'' +
                '}';
    }
}
