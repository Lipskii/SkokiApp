package sample;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "venue")
public class Venue implements Comparable<Venue> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvenue")
    private int idVenue;

    @Column(name = "venue")
    private String venue;

    @Column(name = "year_of_opening")
    private int yearOfOpening;

    @Column(name = "capacity")
    private int capacity;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "fkcity")
    private City city;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "venue", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Hill> hills;

    public Venue() {
    }

    public Venue(String venue, int yearOfOpening, int capacity, City city) {
        this.venue = venue;
        this.yearOfOpening = yearOfOpening;
        this.capacity = capacity;
        this.city = city;
    }

    public int getIdVenue() {
        return idVenue;
    }

    public void setIdVenue(int idVenue) {
        this.idVenue = idVenue;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public int getYearOfOpening() {
        return yearOfOpening;
    }

    public void setYearOfOpening(int yearOfOpening) {
        this.yearOfOpening = yearOfOpening;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Hill> getHills() {
        return hills;
    }

    public void setHills(List<Hill> hills) {
        this.hills = hills;
    }

    public void addHill(Hill hill) {
        if (hills == null) {
            hills = new ArrayList<>();
        }
        hill.setVenue(this);

        hills.add(hill);
    }

    @Override
    public String toString() {
        return venue;
    }

    @Override
    public int compareTo(Venue venue) {
        return this.venue.compareTo(venue.venue);
    }
}
