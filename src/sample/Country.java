package sample;

import javafx.collections.ObservableList;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "country")
public class Country implements Comparable<Country> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcountry")
    private int idCountry;

    @Column(name = "country_name")
    private String countryName;

    @Column(name = "country_code")
    private String countryCode;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "country", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Region> regions;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "country", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Person> people;

    public Country() {
    }

    public Country(String countryName, String countryCode) {
        this.countryName = countryName;
        this.countryCode = countryCode;
    }

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    @Override
    public String toString() {
        return countryName;
    }

    @Override
    public int compareTo(Country country) {
        return this.countryName.compareTo(country.countryName);
    }
}
