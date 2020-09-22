package sample;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class DataSource {

    SessionFactory factory;
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
    }

    public Venue addVenue(String venueName, int yearOfOpening, int capacity, City city) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Venue venue = new Venue(venueName, yearOfOpening, capacity, city);
        session.save(venue);
        session.getTransaction().commit();
        return venue;
    }

    public ObservableList<Region> getRegionList() {
        Session session = factory.getCurrentSession();
        regionObservableList = FXCollections.observableArrayList();
        session.beginTransaction();
        List<Region> regions = session.createQuery("FROM Region").getResultList();
        session.getTransaction().commit();
        regionObservableList.addAll(regions);
        return regionObservableList;
    }

    public ObservableList<Country> getCountryList() {
        Session session = factory.getCurrentSession();
        countryObservableList = FXCollections.observableArrayList();
        session.beginTransaction();
        List<Country> countries = session.createQuery("FROM Country").getResultList();
        session.getTransaction().commit();
        countryObservableList.addAll(countries);
        return countryObservableList;
    }

    public ObservableList<Region> getRegionsByCountry(Country country) {
        List<Region> regions = country.getRegions();
        ObservableList<Region> regionObservableList = FXCollections.observableList(regions);
        return regionObservableList;
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
        List<Venue> venues = city.getVenues();
        ObservableList<Venue> venueObservableList = FXCollections.observableArrayList(venues);
        venueObservableList.sort(Venue::compareTo);
        return venueObservableList;
    }

    public ObservableList<Hill> getHillByVenue(Venue venue) {
        List<Hill> hills = venue.getHills();
        ObservableList<Hill> hillObservableList = FXCollections.observableArrayList(hills);
        return hillObservableList;
    }

    public ObservableList<HillVersion> getHillVersionByHill(Hill hill) {
        List<HillVersion> hillVersions = hill.getHillVersions();
        return FXCollections.observableArrayList(hillVersions);
    }

    public ObservableList getSeriesList() {
        Session session = factory.getCurrentSession();
        ObservableList<Series> series = FXCollections.observableArrayList();
        session.beginTransaction();
        List<Series> seriesList = session.createQuery("FROM Series").getResultList();
        session.getTransaction().commit();
        series.addAll(seriesList);
        return series;
    }

    public ObservableList getSubSeriesList() {
        Session session = factory.getCurrentSession();
        ObservableList<Subseries> subseries = FXCollections.observableArrayList();
        session.beginTransaction();
        List<Subseries> subSeriesList = session.createQuery("FROM Subseries").getResultList();
        session.getTransaction().commit();
        subseries.addAll(subSeriesList);
        return subseries;
    }

    public ObservableList<Hill> getHillByCountry(Country country) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List hills = session.createQuery("FROM Hill h JOIN FETCH h.venue.city.region.country Country " +
                "WHERE h.venue.city.region.country.id = " + country.getIdCountry()).getResultList();
        session.getTransaction().commit();

        return FXCollections.observableArrayList(hills);
    }
}
