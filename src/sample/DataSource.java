package sample;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class DataSource {

    SessionFactory factory;
    Session session;
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
        session = factory.getCurrentSession();
    }

    public ObservableList<Region> getRegionList() {
        regionObservableList = FXCollections.observableArrayList();
        session.beginTransaction();
        List<Region> regions = session.createQuery("from Region").getResultList();
        session.getTransaction().commit();
        for (Region region : regions) {
            regionObservableList.add(region);
        }
        return regionObservableList;
    }

    public ObservableList<Country> getCountryList() {
        countryObservableList = FXCollections.observableArrayList();
        session.beginTransaction();
        List<Country> countries = session.createQuery("from Country").getResultList();
        session.getTransaction().commit();
        for (Country country : countries) {
            countryObservableList.add(country);
        }
        return countryObservableList;
    }
}
