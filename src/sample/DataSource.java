package sample;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class DataSource {

    private final SessionFactory factory;
    //Session session;
    ObservableList<Region> regionObservableList;
    ObservableList<Country> countryObservableList;

    public DataSource() {
        factory = new Configuration().configure()
                .addAnnotatedClass(Subseries.class)
                .addAnnotatedClass(Series.class)
                .addAnnotatedClass(Season.class)
                .addAnnotatedClass(Country.class)
                .addAnnotatedClass(Region.class)
                .addAnnotatedClass(Competition.class)
                .addAnnotatedClass(City.class)
                .addAnnotatedClass(Venue.class)
                .addAnnotatedClass(Hill.class)
                .addAnnotatedClass(TypeOfHill.class)
                .addAnnotatedClass(HillVersion.class)
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(SkiJumper.class)
                .addAnnotatedClass(Disqualification.class)
                .addAnnotatedClass(EventCom.class)
                .addAnnotatedClass(JuryType.class)
                .addAnnotatedClass(Jury.class)
                .addAnnotatedClass(Result.class)
                .buildSessionFactory();

    }

    public void addCity(Region region, String cityName) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        City city = new City(cityName, region);
        session.save(city);
        session.getTransaction().commit();
        session.close();
    }

    public Venue addVenue(String venueName, int yearOfOpening, int capacity, City city) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Venue venue = new Venue(venueName, yearOfOpening, capacity, city);
        session.save(venue);
        session.getTransaction().commit();
        session.close();
        return venue;
    }

    public ObservableList<Region> getRegionList() {
        Session session = factory.getCurrentSession();
        regionObservableList = FXCollections.observableArrayList();
        session.beginTransaction();
        List<Region> regions = session.createQuery("FROM Region").getResultList();
        session.getTransaction().commit();
        regionObservableList.addAll(regions);
        session.close();
        return regionObservableList;
    }

    public ObservableList<Country> getCountryList() {
        Session session = factory.getCurrentSession();
        countryObservableList = FXCollections.observableArrayList();
        session.beginTransaction();
        List<Country> countries = session.createQuery("FROM Country").getResultList();
        session.getTransaction().commit();
        session.close();
        countryObservableList.addAll(countries);
        session.close();
        return countryObservableList;
    }

    public ObservableList<Region> getRegionsByCountry(Country country) {
        List<Region> regions;

        if (country != null) {
            regions = country.getRegions();
        } else {
            regions = Collections.emptyList();
        }

        return FXCollections.observableList(regions);
    }

    public ObservableList<City> getCityByCountry(Country country) {
        List<Region> regions = getRegionsByCountry(country);
        List<City> cityList = new ArrayList<>();

        for (Region region : regions) {
            cityList.addAll(region.getCities());
        }

        ObservableList<City> cities = FXCollections.observableArrayList(cityList);
        cities.sort(City::compareTo);
        return cities;
    }

    public ObservableList<Venue> getVenueByCity(City city) {
        List<Venue> venues;
        if (city != null) {
            venues = city.getVenues();
        } else {
            venues = Collections.emptyList();
        }

        ObservableList<Venue> venueObservableList = FXCollections.observableArrayList(venues);
        venueObservableList.sort(Venue::compareTo);
        return venueObservableList;
    }

    public ObservableList<Hill> getHillByVenue(Venue venue) {
        List<Hill> hills;

        if (venue != null) {
            hills = venue.getHills();

        } else {
            hills = Collections.emptyList();
        }
        return FXCollections.observableArrayList(hills);
    }

    public ObservableList<HillVersion> getHillVersionByHill(Hill hill) {
        List<HillVersion> hillVersions;

        if (hill != null) {
            hillVersions = hill.getHillVersions();
        } else {
            hillVersions = Collections.emptyList();
        }

        hillVersions.sort(HillVersion::compareTo);
        return FXCollections.observableArrayList(hillVersions);
    }

    public ObservableList getSeriesList() {
        Session session = factory.getCurrentSession();
        ObservableList<Series> series = FXCollections.observableArrayList();
        session.beginTransaction();
        List<Series> seriesList = session.createQuery("FROM Series").getResultList();
        session.getTransaction().commit();
        series.addAll(seriesList);
        session.close();
        return series;
    }

    public ObservableList getSubSeriesList() {
        Session session = factory.getCurrentSession();
        ObservableList<Subseries> subseries = FXCollections.observableArrayList();
        session.beginTransaction();
        List<Subseries> subSeriesList = session.createQuery("FROM Subseries").getResultList();
        session.getTransaction().commit();
        subseries.addAll(subSeriesList);
        session.close();
        return subseries;
    }

    public ObservableList<Hill> getHillByCountry(Country country) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<Hill> hills = session.createQuery("FROM Hill h JOIN FETCH h.venue.city.region.country Country " +
                "WHERE h.venue.city.region.country.id = " + country.getIdCountry()).getResultList();
        session.getTransaction().commit();

        if (hills == null) {
            hills = Collections.emptyList();
        }

        hills.sort(Hill::compareTo);
        session.close();
        return FXCollections.observableArrayList(hills);
    }

    public void addHill(String hillName,
                        int yearOfConstruction,
                        int lastReconstruction,
                        String reconstructions,
                        boolean plasticMatting, Venue venue) {

        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Hill hill = new Hill(hillName, yearOfConstruction, lastReconstruction, reconstructions, plasticMatting, venue);
        session.save(hill);
        session.getTransaction().commit();
        session.close();

    }

    public ObservableList<TypeOfHill> getTypeOfHills() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<TypeOfHill> typeOfHillList = session.createQuery("FROM TypeOfHill").getResultList();
        session.getTransaction().commit();
        session.close();

        return FXCollections.observableArrayList(typeOfHillList);
    }

    public void addHillVersion(int firstYear, int lastYear, BigDecimal inrunLength, BigDecimal inrunAngle,
                               BigDecimal takeOffLength, BigDecimal takeOffAngle, BigDecimal takeOffHeight,
                               BigDecimal kPoint, BigDecimal hillSize, BigDecimal versionRecord, TypeOfHill typeOfHill, Hill hill) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        HillVersion hillVersion = new HillVersion(firstYear, lastYear, inrunLength, inrunAngle, takeOffLength, takeOffAngle, takeOffHeight,
                kPoint, hillSize, versionRecord, hill, typeOfHill);
        session.save(hillVersion);
        session.getTransaction().commit();
        session.close();
    }

    public ObservableList<Person> getPeople() {
        Session session = factory.getCurrentSession();
        ObservableList<Person> people = FXCollections.observableArrayList();
        session.beginTransaction();
        List<Person> personList = session.createQuery("FROM Person").getResultList();
        session.getTransaction().commit();
        session.close();
        people.addAll(personList);
        people.sort(Person::compareTo);
        return people;
    }

    public void addPerson(String firstName, String lastName, LocalDate birthday, Country country, City city) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Person person;

        if (city != null)
            person = new Person(firstName, lastName, birthday, country, city);
        else
            person = new Person(firstName, lastName, birthday, country);

        session.save(person);
        session.getTransaction().commit();
        session.close();

    }
}
