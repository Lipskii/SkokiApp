package sample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

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
            session.beginTransaction();

            Country country = session.get(Country.class, 166);

            //  System.out.println(country.getRegions());

            List<Country> countries = session.createQuery("from Country").getResultList();
            //    System.out.println(Arrays.toString(countries.toArray()));
            session.getTransaction().commit();

            DataSource dataSource = new DataSource();
            //   dataSource.getRegionList();
            List<Country> countries1 = dataSource.getCountryList();
            dataSource.getCityByCountry(countries1.get(176));


        }
    }
}
