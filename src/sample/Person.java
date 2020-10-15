package sample;

import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "person")
public class Person implements Comparable<Person> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idperson")
    private int idPerson;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birthday")
    private LocalDate birthday;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "fkcity")
    private City city;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "fkcountry")
    private Country country;

    public Person() {
    }

    public Person(String firstName, String lastName, LocalDate birthday, Country country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.country = country;
    }

    public Person(String firstName, String lastName, LocalDate birthday, Country country, City city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.country = country;
        this.city = city;

    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName.toUpperCase() + " (" + country + ") ";
    }

    @Override
    public int compareTo(Person person) {
        if (!this.lastName.toLowerCase().equals(person.lastName.toLowerCase()))
            return this.lastName.toLowerCase().compareTo(person.lastName.toLowerCase());
        else
            return this.firstName.toLowerCase().compareTo(person.firstName.toLowerCase());
    }
}
