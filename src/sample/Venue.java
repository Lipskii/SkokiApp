package sample;

import javax.persistence.*;

@Entity
@Table(name = "venue")
public class Venue {

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

    @Override
    public String toString() {
        return "Venue{" +
                "idVenue=" + idVenue +
                ", venue='" + venue + '\'' +
                ", yearOfOpening=" + yearOfOpening +
                ", capacity=" + capacity +
                ", city=" + city +
                '}';
    }
}
