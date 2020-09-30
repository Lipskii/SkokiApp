package sample;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "type_of_hill")
public class TypeOfHill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtype_of_hill")
    private int idTypeOfHill;

    @Column(name = "type_of_hill")
    private String typeOfHill;

    @Column(name = "size_description")
    private String sizeDescription;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "typeOfHill", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<HillVersion> hillVersions;

    public TypeOfHill() {
    }

    public TypeOfHill(String typeOfHill, String sizeDescription) {
        this.typeOfHill = typeOfHill;
        this.sizeDescription = sizeDescription;
    }

    public int getIdTypeOfHill() {
        return idTypeOfHill;
    }

    public void setIdTypeOfHill(int idTypeOfHill) {
        this.idTypeOfHill = idTypeOfHill;
    }

    public String getTypeOfHill() {
        return typeOfHill;
    }

    public void setTypeOfHill(String typeOfHill) {
        this.typeOfHill = typeOfHill;
    }

    public String getSizeDescription() {
        return sizeDescription;
    }

    public void setSizeDescription(String sizeDescription) {
        this.sizeDescription = sizeDescription;
    }

    public List<HillVersion> getHillVersions() {
        return hillVersions;
    }

    public void setHillVersions(List<HillVersion> hillVersions) {
        this.hillVersions = hillVersions;
    }

    @Override
    public String toString() {
        return typeOfHill;
    }
}
