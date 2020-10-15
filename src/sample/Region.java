package sample;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "region")
public class Region implements Comparable<Region> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idregion")
    private int idRegion;

    @Column(name = "region")
    private String region;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "fkcountry")
    private Country country;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "region", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    //@Fetch(value = FetchMode.SUBSELECT)
    private List<City> cities;


    public Region() {
    }

    public Region(String region, Country country) {
        this.region = region;
        this.country = country;
    }

    public int getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public void addCity(City city) {
        if (cities == null) {
            cities = new ArrayList<>();
        }

        city.setRegion(this);

        cities.add(city);
    }

    @Override
    public String toString() {
        return region;
    }

    @Override
    public int compareTo(Region region) {
        return this.region.compareTo(region.region);
    }
}
