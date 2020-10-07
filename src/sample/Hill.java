package sample;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Entity
@Table(name = "hill")
public class Hill implements Comparable<Hill> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idhill")
    private int idHill;

    @Column(name = "hillname")
    private String hillName;

    @Column(name = "year_of_construction")
    private int yearOfConstruction;

    @Column(name = "last_reconstruction")
    private int lastReconstruction;

    @Column(name = "reconstructions")
    private String reconstructions;

    @Column(name = "plastic_matting")
    private boolean plasticMatting;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "fkvenue")
    private Venue venue;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "hill", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<HillVersion> hillVersions;

    public Hill() {
    }

    public Hill(String hillName, int yearOfConstruction, int lastReconstruction, String reconstructions, boolean plasticMatting, Venue venue) {
        this.hillName = hillName;
        this.yearOfConstruction = yearOfConstruction;
        this.lastReconstruction = lastReconstruction;
        this.reconstructions = reconstructions;
        this.plasticMatting = plasticMatting;
        this.venue = venue;
    }

    public int getIdHill() {
        return idHill;
    }

    public void setIdHill(int idHill) {
        this.idHill = idHill;
    }

    public String getHillName() {
        return hillName;
    }

    public void setHillName(String hillName) {
        this.hillName = hillName;
    }

    public int getYearOfConstruction() {
        return yearOfConstruction;
    }

    public void setYearOfConstruction(int yearOfConstruction) {
        this.yearOfConstruction = yearOfConstruction;
    }

    public int getLastReconstruction() {
        return lastReconstruction;
    }

    public void setLastReconstruction(int lastReconstruction) {
        this.lastReconstruction = lastReconstruction;
    }

    public String getReconstructions() {
        return reconstructions;
    }

    public void setReconstructions(String reconstructions) {
        this.reconstructions = reconstructions;
    }

    public boolean isPlasticMatting() {
        return plasticMatting;
    }

    public void setPlasticMatting(boolean plasticMatting) {
        this.plasticMatting = plasticMatting;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public List<HillVersion> getHillVersions() {
        return hillVersions;
    }

    public void setHillVersions(List<HillVersion> hillVersions) {
        this.hillVersions = hillVersions;
    }

    //    public void addHillVersion(HillVersion hillVersion){
//        if(hillVersions == null){
//            hillVersions = new ArrayList<>();
//        }
//
//    }
    @Override
    public String toString() {
        return venue + ": " + hillName;
    }

    @Override
    public int compareTo(Hill hill) {
        String s1 = this.venue + this.hillName;
        String s2 = hill.venue + hill.hillName;
        return s1.compareTo(s2);
    }
}
