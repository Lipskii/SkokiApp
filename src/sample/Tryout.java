package sample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class Tryout {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure()
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

        try (factory; Session session = factory.getCurrentSession()) {
            DataSource dataSource = new DataSource();
            session.beginTransaction();

            //      Country country = session.get(Country.class, 166);

            //  System.out.println(country.getRegions());

            //        List<Country> countries = session.createQuery("from Country").getResultList();
            //    System.out.println(Arrays.toString(countries.toArray()));


//            //   dataSource.getRegionList();
//            List<Country> countries1 = dataSource.getCountryList();
//            dataSource.getCityByCountry(countries1.get(176));

            //"FROM Hill h JOIN FETCH h.venue.city.region.country Country " +
            //                "WHERE h.venue.city.region.country.id = " + country.getIdCountry()).getResultList()

            Set<Country> countries = new HashSet<>();

            List<Venue> venues = session.createQuery("FROM Venue v JOIN FETCH v.city.region.country Country").getResultList();

            for (Venue venue : venues) {
                City city = venue.getCity();
                Region region = city.getRegion();
                Country country = region.getCountry();
                countries.add(country);
            }

            for (Country country : countries) {
                System.out.println(country);
            }


        }
    }
}
