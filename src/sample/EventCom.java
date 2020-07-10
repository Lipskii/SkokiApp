package sample;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

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

    @Column(name = "gate_factor")
    private BigDecimal gateFactor;

    @Column(name = "wind_factor_head")
    private BigDecimal windFactorHead;

    @Column(name = "wind_factor_tail")
    private BigDecimal windFactorTail;

    @Column(name = "first_round_start_time")
    private Time firstRoundStartTime;

    @Column(name = "first_round_end_time")
    private Time firstRoundEndTime;

    @Column(name = "second_round_start_time")
    private Time secondRoundStartTime;

    @Column(name = "second_round_end_time")
    private Time secondRoundEndTime;

    @Column(name = "third_round_start_time")
    private Time thirdRoundStartTime;

    @Column(name = "third_round_end_time")
    private Time thirdRoundEndTime;

    @Column(name = "fourth_round_start_time")
    private Time fourthRoundStartTime;

    @Column(name = "fourth_round_end_time")
    private Time fourthRoundEndTime;

    @Column(name = "base_gate")
    private int baseGate;

    @Column(name = "weather")
    private String weather;

    @Column(name = "temp_air_start")
    private BigDecimal tempAirStart;

    @Column(name = "temp_air_end")
    private BigDecimal tempAirEnd;

    @Column(name = "temp_snow_start")
    private BigDecimal tempSnowStart;

    @Column(name = "temp_snow_end")
    private BigDecimal tempSnowEnd;

    @Column(name = "humidity_start")
    private int humidityStart;

    @Column(name = "humidity_end")
    private int humidityEnd;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "fkcompetition")
    private Competition competition;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "fkhill_version")
    private HillVersion hillVersion;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "fkrace_director")
    private Jury raceDirector;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "fktechnical_delegate")
    private Jury technicalDelegate;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "fkchief_of_competition")
    private Jury chiefOfCompetition;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "fkassistant_td")
    private Jury assistant_td;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "fkassistant_rd")
    private Jury assistant_rd;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "fkequipment_control1")
    private Jury equipmentControl1;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "fkequipment_control2")
    private Jury equipmentControl2;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "fkjudge_a")
    private Jury judgeA;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "fkjudge_b")
    private Jury judgeB;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "fkjudge_c")
    private Jury judgeC;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "fkjudge_d")
    private Jury judgeD;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "fkjudge_e")
    private Jury judgeE;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "fkstart_controller")
    private Jury startController;

    public EventCom() {
    }

    public EventCom(Date dateOfEvent1, Date dateOfEvent2, boolean isKo, boolean isTeam, BigDecimal gateFactor, BigDecimal windFactorHead, BigDecimal windFactorTail, Time firstRoundStartTime, Time firstRoundEndTime, Time secondRoundStartTime, Time secondRoundEndTime, Time thirdRoundStartTime, Time thirdRoundEndTime, Time fourthRoundStartTime, Time fourthRoundEndTime, int baseGate, String weather, BigDecimal tempAirStart, BigDecimal tempAirEnd, BigDecimal tempSnowStart, BigDecimal tempSnowEnd, int humidityStart, int humidityEnd, Competition competition, HillVersion hillVersion, Jury raceDirector, Jury technicalDelegate, Jury chiefOfCompetition, Jury assistant_td, Jury assistant_rd, Jury equipmentControl1, Jury equipmentControl2, Jury judgeA, Jury judgeB, Jury judgeC, Jury judgeD, Jury judgeE, Jury startController) {
        this.dateOfEvent1 = dateOfEvent1;
        this.dateOfEvent2 = dateOfEvent2;
        this.isKo = isKo;
        this.isTeam = isTeam;
        this.gateFactor = gateFactor;
        this.windFactorHead = windFactorHead;
        this.windFactorTail = windFactorTail;
        this.firstRoundStartTime = firstRoundStartTime;
        this.firstRoundEndTime = firstRoundEndTime;
        this.secondRoundStartTime = secondRoundStartTime;
        this.secondRoundEndTime = secondRoundEndTime;
        this.thirdRoundStartTime = thirdRoundStartTime;
        this.thirdRoundEndTime = thirdRoundEndTime;
        this.fourthRoundStartTime = fourthRoundStartTime;
        this.fourthRoundEndTime = fourthRoundEndTime;
        this.baseGate = baseGate;
        this.weather = weather;
        this.tempAirStart = tempAirStart;
        this.tempAirEnd = tempAirEnd;
        this.tempSnowStart = tempSnowStart;
        this.tempSnowEnd = tempSnowEnd;
        this.humidityStart = humidityStart;
        this.humidityEnd = humidityEnd;
        this.competition = competition;
        this.hillVersion = hillVersion;
        this.raceDirector = raceDirector;
        this.technicalDelegate = technicalDelegate;
        this.chiefOfCompetition = chiefOfCompetition;
        this.assistant_td = assistant_td;
        this.assistant_rd = assistant_rd;
        this.equipmentControl1 = equipmentControl1;
        this.equipmentControl2 = equipmentControl2;
        this.judgeA = judgeA;
        this.judgeB = judgeB;
        this.judgeC = judgeC;
        this.judgeD = judgeD;
        this.judgeE = judgeE;
        this.startController = startController;
    }

    public int getIdEventCom() {
        return idEventCom;
    }

    public void setIdEventCom(int idEventCom) {
        this.idEventCom = idEventCom;
    }

    public Date getDateOfEvent1() {
        return dateOfEvent1;
    }

    public void setDateOfEvent1(Date dateOfEvent1) {
        this.dateOfEvent1 = dateOfEvent1;
    }

    public Date getDateOfEvent2() {
        return dateOfEvent2;
    }

    public void setDateOfEvent2(Date dateOfEvent2) {
        this.dateOfEvent2 = dateOfEvent2;
    }

    public boolean isKo() {
        return isKo;
    }

    public void setKo(boolean ko) {
        isKo = ko;
    }

    public boolean isTeam() {
        return isTeam;
    }

    public void setTeam(boolean team) {
        isTeam = team;
    }

    public BigDecimal getGateFactor() {
        return gateFactor;
    }

    public void setGateFactor(BigDecimal gateFactor) {
        this.gateFactor = gateFactor;
    }

    public BigDecimal getWindFactorHead() {
        return windFactorHead;
    }

    public void setWindFactorHead(BigDecimal windFactorHead) {
        this.windFactorHead = windFactorHead;
    }

    public BigDecimal getWindFactorTail() {
        return windFactorTail;
    }

    public void setWindFactorTail(BigDecimal windFactorTail) {
        this.windFactorTail = windFactorTail;
    }

    public Time getFirstRoundStartTime() {
        return firstRoundStartTime;
    }

    public void setFirstRoundStartTime(Time firstRoundStartTime) {
        this.firstRoundStartTime = firstRoundStartTime;
    }

    public Time getFirstRoundEndTime() {
        return firstRoundEndTime;
    }

    public void setFirstRoundEndTime(Time firstRoundEndTime) {
        this.firstRoundEndTime = firstRoundEndTime;
    }

    public Time getSecondRoundStartTime() {
        return secondRoundStartTime;
    }

    public void setSecondRoundStartTime(Time secondRoundStartTime) {
        this.secondRoundStartTime = secondRoundStartTime;
    }

    public Time getSecondRoundEndTime() {
        return secondRoundEndTime;
    }

    public void setSecondRoundEndTime(Time secondRoundEndTime) {
        this.secondRoundEndTime = secondRoundEndTime;
    }

    public Time getThirdRoundStartTime() {
        return thirdRoundStartTime;
    }

    public void setThirdRoundStartTime(Time thirdRoundStartTime) {
        this.thirdRoundStartTime = thirdRoundStartTime;
    }

    public Time getThirdRoundEndTime() {
        return thirdRoundEndTime;
    }

    public void setThirdRoundEndTime(Time thirdRoundEndTime) {
        this.thirdRoundEndTime = thirdRoundEndTime;
    }

    public Time getFourthRoundStartTime() {
        return fourthRoundStartTime;
    }

    public void setFourthRoundStartTime(Time fourthRoundStartTime) {
        this.fourthRoundStartTime = fourthRoundStartTime;
    }

    public Time getFourthRoundEndTime() {
        return fourthRoundEndTime;
    }

    public void setFourthRoundEndTime(Time fourthRoundEndTime) {
        this.fourthRoundEndTime = fourthRoundEndTime;
    }

    public int getBaseGate() {
        return baseGate;
    }

    public void setBaseGate(int baseGate) {
        this.baseGate = baseGate;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public BigDecimal getTempAirStart() {
        return tempAirStart;
    }

    public void setTempAirStart(BigDecimal tempAirStart) {
        this.tempAirStart = tempAirStart;
    }

    public BigDecimal getTempAirEnd() {
        return tempAirEnd;
    }

    public void setTempAirEnd(BigDecimal tempAirEnd) {
        this.tempAirEnd = tempAirEnd;
    }

    public BigDecimal getTempSnowStart() {
        return tempSnowStart;
    }

    public void setTempSnowStart(BigDecimal tempSnowStart) {
        this.tempSnowStart = tempSnowStart;
    }

    public BigDecimal getTempSnowEnd() {
        return tempSnowEnd;
    }

    public void setTempSnowEnd(BigDecimal tempSnowEnd) {
        this.tempSnowEnd = tempSnowEnd;
    }

    public int getHumidityStart() {
        return humidityStart;
    }

    public void setHumidityStart(int humidityStart) {
        this.humidityStart = humidityStart;
    }

    public int getHumidityEnd() {
        return humidityEnd;
    }

    public void setHumidityEnd(int humidityEnd) {
        this.humidityEnd = humidityEnd;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public HillVersion getHillVersion() {
        return hillVersion;
    }

    public void setHillVersion(HillVersion hillVersion) {
        this.hillVersion = hillVersion;
    }

    public Jury getRaceDirector() {
        return raceDirector;
    }

    public void setRaceDirector(Jury raceDirector) {
        this.raceDirector = raceDirector;
    }

    public Jury getTechnicalDelegate() {
        return technicalDelegate;
    }

    public void setTechnicalDelegate(Jury technicalDelegate) {
        this.technicalDelegate = technicalDelegate;
    }

    public Jury getChiefOfCompetition() {
        return chiefOfCompetition;
    }

    public void setChiefOfCompetition(Jury chiefOfCompetition) {
        this.chiefOfCompetition = chiefOfCompetition;
    }

    public Jury getAssistant_td() {
        return assistant_td;
    }

    public void setAssistant_td(Jury assistant_td) {
        this.assistant_td = assistant_td;
    }

    public Jury getAssistant_rd() {
        return assistant_rd;
    }

    public void setAssistant_rd(Jury assistant_rd) {
        this.assistant_rd = assistant_rd;
    }

    public Jury getEquipmentControl1() {
        return equipmentControl1;
    }

    public void setEquipmentControl1(Jury equipmentControl1) {
        this.equipmentControl1 = equipmentControl1;
    }

    public Jury getEquipmentControl2() {
        return equipmentControl2;
    }

    public void setEquipmentControl2(Jury equipmentControl2) {
        this.equipmentControl2 = equipmentControl2;
    }

    public Jury getJudgeA() {
        return judgeA;
    }

    public void setJudgeA(Jury judgeA) {
        this.judgeA = judgeA;
    }

    public Jury getJudgeB() {
        return judgeB;
    }

    public void setJudgeB(Jury judgeB) {
        this.judgeB = judgeB;
    }

    public Jury getJudgeC() {
        return judgeC;
    }

    public void setJudgeC(Jury judgeC) {
        this.judgeC = judgeC;
    }

    public Jury getJudgeD() {
        return judgeD;
    }

    public void setJudgeD(Jury judgeD) {
        this.judgeD = judgeD;
    }

    public Jury getJudgeE() {
        return judgeE;
    }

    public void setJudgeE(Jury judgeE) {
        this.judgeE = judgeE;
    }

    public Jury getStartController() {
        return startController;
    }

    public void setStartController(Jury startController) {
        this.startController = startController;
    }

    @Override
    public String toString() {
        return "EventCom{" +
                "idEventCom=" + idEventCom +
                ", dateOfEvent1=" + dateOfEvent1 +
                ", dateOfEvent2=" + dateOfEvent2 +
                ", isKo=" + isKo +
                ", isTeam=" + isTeam +
                ", gateFactor=" + gateFactor +
                ", windFactorHead=" + windFactorHead +
                ", windFactorTail=" + windFactorTail +
                ", firstRoundStartTime=" + firstRoundStartTime +
                ", firstRoundEndTime=" + firstRoundEndTime +
                ", secondRoundStartTime=" + secondRoundStartTime +
                ", secondRoundEndTime=" + secondRoundEndTime +
                ", thirdRoundStartTime=" + thirdRoundStartTime +
                ", thirdRoundEndTime=" + thirdRoundEndTime +
                ", fourthRoundStartTime=" + fourthRoundStartTime +
                ", fourthRoundEndTime=" + fourthRoundEndTime +
                ", baseGate=" + baseGate +
                ", weather='" + weather + '\'' +
                ", tempAirStart=" + tempAirStart +
                ", tempAirEnd=" + tempAirEnd +
                ", tempSnowStart=" + tempSnowStart +
                ", tempSnowEnd=" + tempSnowEnd +
                ", humidityStart=" + humidityStart +
                ", humidityEnd=" + humidityEnd +
                ", competition=" + competition +
                ", hillVersion=" + hillVersion +
                ", raceDirector=" + raceDirector +
                ", technicalDelegate=" + technicalDelegate +
                ", chiefOfCompetition=" + chiefOfCompetition +
                ", assistant_td=" + assistant_td +
                ", assistant_rd=" + assistant_rd +
                ", equipmentControl1=" + equipmentControl1 +
                ", equipmentControl2=" + equipmentControl2 +
                ", judgeA=" + judgeA +
                ", judgeB=" + judgeB +
                ", judgeC=" + judgeC +
                ", judgeD=" + judgeD +
                ", judgeE=" + judgeE +
                ", startController=" + startController +
                '}';
    }
}
