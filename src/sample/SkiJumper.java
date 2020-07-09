package sample;

import javax.persistence.*;

@Entity
@Table(name = "ski_jumper")
public class SkiJumper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idski_jumper")
    private int idSkiJumper;

    @Column(name = "is_active")
    private boolean isActive;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fkperson")
    private Person person;

    public SkiJumper() {
    }

    public SkiJumper(boolean isActive, Person person) {
        this.isActive = isActive;
        this.person = person;
    }

    public int getIdSkiJumper() {
        return idSkiJumper;
    }

    public void setIdSkiJumper(int idSkiJumper) {
        this.idSkiJumper = idSkiJumper;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "SkiJumper{" +
                "idSkiJumper=" + idSkiJumper +
                ", isActive=" + isActive +
                ", person=" + person +
                '}';
    }
}
