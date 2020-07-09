package sample;

import javax.persistence.*;

@Entity
@Table(name = "race_director")
public class RaceDirector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrace_director")
    private int idRaceDirector;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fkperson")
    private Person person;
}
