package sample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Test {
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
                .buildSessionFactory();

        try (factory; Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            Country country = session.get(Country.class, 166);

            System.out.println(country.getRegions());

            session.getTransaction().commit();


        }
    }
}
