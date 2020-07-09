package sample;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "eventcom")
public class EventCom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ideventcom")
    private int idEventCom;

    @Column(name = "date_of_event1")
    private Date dateOfEvent1;

    @Column(name = "data_of_event2")
    private Date dateOfEvent2;

    @Column(name = "is_ko")
    private boolean isKo;

    @Column(name = "is_team")
    private boolean isTeam;

}
