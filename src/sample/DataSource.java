package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class DataSource {

    private final SessionFactory factory;

    ObservableList<Region> regionObservableList;

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

    public City addCityReturnCity(Region region, String cityName) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        City city = new City(cityName, region);
        session.save(city);
        session.getTransaction().commit();
        session.close();
        return city;
    }

    public void addVenue(String venueName, int yearOfOpening, int capacity, City city) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Venue venue = new Venue(venueName, yearOfOpening, capacity, city);
        session.save(venue);
        session.getTransaction().commit();
        session.close();
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
        session.beginTransaction();
        List<Country> countries = session.createQuery("FROM Country").getResultList();
        session.getTransaction().commit();
        session.close();
        return FXCollections.observableList(countries);
    }

    //TEMPORARY SOLUTION, FIX LATER WITH HIBERNATE (MultipleBagFetchException)!!!!
    public ObservableList<Country> getCountryWithVenuesList() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Set<Country> countries = new HashSet<>();
        List<Venue> venues = session.createQuery("FROM Venue").getResultList();

        for (Venue venue : venues) {
            City city = venue.getCity();
            Region region = city.getRegion();
            Country country = region.getCountry();
            countries.add(country);
        }

        session.getTransaction().commit();
        session.close();
        List<Country> countryList = new ArrayList<>(countries);
        countryList.sort(Country::compareTo);
        return FXCollections.observableList(countryList);
    }

    //TEMPORARY SOLUTION, FIX LATER WITH HIBERNATE (MultipleBagFetchException)!!!!
    public ObservableList<Country> getCountryWithHillsList() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Set<Country> countries = new HashSet<>();
        List<Hill> hills = session.createQuery("FROM Hill").getResultList();
        for (Hill hill : hills) {
            Venue venue = hill.getVenue();
            City city = venue.getCity();
            Region region = city.getRegion();
            Country country = region.getCountry();
            countries.add(country);
        }
        session.getTransaction().commit();
        session.close();
        List<Country> countryList = new ArrayList<>(countries);
        countryList.sort(Country::compareTo);
        return FXCollections.observableList(countryList);
    }


    public ObservableList<Region> getRegionsByCountry(Country country) {
        List<Region> regions;

        if (country != null) {
            regions = country.getRegions();
        } else {
            regions = Collections.emptyList();
        }

        regions.sort(Region::compareTo);
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

    public ObservableList<Series> getSeries() {
        Session session = factory.getCurrentSession();
        ObservableList<Series> series = FXCollections.observableArrayList();
        session.beginTransaction();
        List<Series> seriesList = session.createQuery("FROM Series").getResultList();
        session.getTransaction().commit();
        series.addAll(seriesList);
        session.close();
        return series;
    }

    public ObservableList<Subseries> getSubSeries() {
        Session session = factory.getCurrentSession();
        ObservableList<Subseries> subseries = FXCollections.observableArrayList();
        session.beginTransaction();
        List<Subseries> subSeriesList = session.createQuery("FROM Subseries").getResultList();
        session.getTransaction().commit();
        subseries.addAll(subSeriesList);
        session.close();
        subseries.sort(Subseries::compareTo);
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

    public Person addPerson(String firstName, String lastName, LocalDate birthday, Country country, City city) {
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

        return person;
    }

    public void addSkiJumper(Person person, boolean isActive) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        SkiJumper skiJumper = new SkiJumper(person, isActive);
        session.save(skiJumper);
        session.getTransaction().commit();
        session.close();
    }

    public ObservableList<City> getCityWithVenuesByCountry(Country country) {
        ObservableList<City> citiesByCountry = getCityByCountry(country);

        citiesByCountry.removeIf(city -> city.getVenues().isEmpty());

        return citiesByCountry;
    }

    public void addRegion(String regionName, Country country) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Region region = new Region(regionName, country);
        session.save(region);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteRecord(Object obj) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.delete(obj);
        session.getTransaction().commit();
        session.close();
    }

    public void addSeasons() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        for (int i = 1924; i < 2024; i++) {
            Season season = new Season(i);
            session.save(season);
        }
        session.getTransaction().commit();
        session.close();
    }

    public ObservableList<Season> getSeasons() {
        Session session = factory.getCurrentSession();
        ObservableList<Season> seasons = FXCollections.observableArrayList();
        session.beginTransaction();
        List<Season> seasonList = session.createQuery("FROM Season").getResultList();
        session.getTransaction().commit();
        seasons.addAll(seasonList);
        session.close();
        return seasons;
    }
}
