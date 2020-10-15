package sample;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "city")
public class City implements Comparable<City> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcity")
    private int idCity;

    @Column(name = "city")
    private String city;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "fkregion")
    private Region region;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "city", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Venue> venues;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "city", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Person> people;

    public City() {
    }

    public City(String city, Region region) {
        this.city = city;
        this.region = region;
    }

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public List<Venue> getVenues() {
        return venues;
    }

    public void setVenues(List<Venue> venues) {
        this.venues = venues;
    }

    public void addVenue(Venue venue) {
        if (venues == null) {
            venues = new ArrayList<>();
        }

        venue.setCity(this);

        venues.add(venue);
    }

    @Override
    public String toString() {
        return city;
    }

    @Override
    public int compareTo(City city) {
        return this.city.compareTo(city.city);
    }
}
