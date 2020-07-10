package sample;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "result")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idresult")
    private int idResult;

    @Column(name = "gate1")
    private int gate1;

    @Column(name = "gate_points_1")
    private BigDecimal gatePoints1;

    @Column(name = "speed1")
    private BigDecimal speed1;

    @Column(name = "distance1")
    private BigDecimal distance1;

    @Column(name = "distance_points1")
    private BigDecimal distancePoints1;

    @Column(name = "wind1")
    private BigDecimal wind1;

    @Column(name = "wind_points1")
    private BigDecimal windPoints1;

    @Column(name = "judge_score_a1")
    private BigDecimal judgeScoreA1;

    @Column(name = "judge_score_b1")
    private BigDecimal judgeScoreB1;

    @Column(name = "judge_score_c1")
    private BigDecimal judgeScoreC1;

    @Column(name = "judge_score_d1")
    private BigDecimal judgeScoreD1;

    @Column(name = "judge_score_e1")
    private BigDecimal judgeScoreE1;

    @Column(name = "judge_overall_score1")
    private BigDecimal judgeOverallScore1;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "dsq1")
    private Disqualification dsq1;

    @Column(name = "round_total_score1")
    private BigDecimal roundTotalScore1;

    @Column(name = "gate2")
    private int gate2;

    @Column(name = "gate_points_2")
    private BigDecimal gatePoints2;

    @Column(name = "speed2")
    private BigDecimal speed2;

    @Column(name = "distance2")
    private BigDecimal distance2;

    @Column(name = "distance_points2")
    private BigDecimal distancePoints2;

    @Column(name = "wind2")
    private BigDecimal wind2;

    @Column(name = "wind_points2")
    private BigDecimal windPoints2;

    @Column(name = "judge_score_a2")
    private BigDecimal judgeScoreA2;

    @Column(name = "judge_score_b2")
    private BigDecimal judgeScoreB2;

    @Column(name = "judge_score_c2")
    private BigDecimal judgeScoreC2;

    @Column(name = "judge_score_d2")
    private BigDecimal judgeScoreD2;

    @Column(name = "judge_score_e2")
    private BigDecimal judgeScoreE2;

    @Column(name = "judge_overall_score2")
    private BigDecimal judgeOverallScore2;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "dsq2")
    private Disqualification dsq2;

    @Column(name = "round_total_score2")
    private BigDecimal roundTotalScore2;

    @Column(name = "gate3")
    private int gate3;

    @Column(name = "gate_points_3")
    private BigDecimal gatePoints3;

    @Column(name = "speed3")
    private BigDecimal speed3;

    @Column(name = "distance3")
    private BigDecimal distance3;

    @Column(name = "distance_points3")
    private BigDecimal distancePoints3;

    @Column(name = "wind3")
    private BigDecimal wind3;

    @Column(name = "wind_points3")
    private BigDecimal windPoints3;

    @Column(name = "judge_score_a3")
    private BigDecimal judgeScoreA3;

    @Column(name = "judge_score_b3")
    private BigDecimal judgeScoreB3;

    @Column(name = "judge_score_c3")
    private BigDecimal judgeScoreC3;

    @Column(name = "judge_score_d3")
    private BigDecimal judgeScoreD3;

    @Column(name = "judge_score_e3")
    private BigDecimal judgeScoreE3;

    @Column(name = "judge_overall_score3")
    private BigDecimal judgeOverallScore3;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "dsq3")
    private Disqualification dsq3;

    @Column(name = "round_total_score3")
    private BigDecimal roundTotalScore3;

    @Column(name = "gate4")
    private int gate4;

    @Column(name = "gate_points_4")
    private BigDecimal gatePoints4;

    @Column(name = "speed4")
    private BigDecimal speed4;

    @Column(name = "distance4")
    private BigDecimal distance4;

    @Column(name = "distance_points4")
    private BigDecimal distancePoints4;

    @Column(name = "wind4")
    private BigDecimal wind4;

    @Column(name = "wind_points4")
    private BigDecimal windPoints4;

    @Column(name = "judge_score_a4")
    private BigDecimal judgeScoreA4;

    @Column(name = "judge_score_b4")
    private BigDecimal judgeScoreB4;

    @Column(name = "judge_score_c4")
    private BigDecimal judgeScoreC4;

    @Column(name = "judge_score_d4")
    private BigDecimal judgeScoreD4;

    @Column(name = "judge_score_e4")
    private BigDecimal judgeScoreE4;

    @Column(name = "judge_overall_score4")
    private BigDecimal judgeOverallScore4;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "dsq4")
    private Disqualification dsq4;

    @Column(name = "round_total_score4")
    private BigDecimal roundTotalScore4;

    @Column(name = "overall_score")
    private BigDecimal overallScore;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "fkeventcom")
    private EventCom eventCom;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "fkski_jumper")
    private SkiJumper skiJumper;

    public Result() {
    }

    public Result(int gate1, BigDecimal gatePoints1, BigDecimal speed1, BigDecimal distance1, BigDecimal distancePoints1, BigDecimal wind1, BigDecimal windPoints1, BigDecimal judgeScoreA1, BigDecimal judgeScoreB1, BigDecimal judgeScoreC1, BigDecimal judgeScoreD1, BigDecimal judgeScoreE1, BigDecimal judgeOverallScore1, Disqualification dsq1, BigDecimal roundTotalScore1, int gate2, BigDecimal gatePoints2, BigDecimal speed2, BigDecimal distance2, BigDecimal distancePoints2, BigDecimal wind2, BigDecimal windPoints2, BigDecimal judgeScoreA2, BigDecimal judgeScoreB2, BigDecimal judgeScoreC2, BigDecimal judgeScoreD2, BigDecimal judgeScoreE2, BigDecimal judgeOverallScore2, Disqualification dsq2, BigDecimal roundTotalScore2, int gate3, BigDecimal gatePoints3, BigDecimal speed3, BigDecimal distance3, BigDecimal distancePoints3, BigDecimal wind3, BigDecimal windPoints3, BigDecimal judgeScoreA3, BigDecimal judgeScoreB3, BigDecimal judgeScoreC3, BigDecimal judgeScoreD3, BigDecimal judgeScoreE3, BigDecimal judgeOverallScore3, Disqualification dsq3, BigDecimal roundTotalScore3, int gate4, BigDecimal gatePoints4, BigDecimal speed4, BigDecimal distance4, BigDecimal distancePoints4, BigDecimal wind4, BigDecimal windPoints4, BigDecimal judgeScoreA4, BigDecimal judgeScoreB4, BigDecimal judgeScoreC4, BigDecimal judgeScoreD4, BigDecimal judgeScoreE4, BigDecimal judgeOverallScore4, Disqualification dsq4, BigDecimal roundTotalScore4, BigDecimal overallScore, EventCom eventCom, SkiJumper skiJumper) {
        this.gate1 = gate1;
        this.gatePoints1 = gatePoints1;
        this.speed1 = speed1;
        this.distance1 = distance1;
        this.distancePoints1 = distancePoints1;
        this.wind1 = wind1;
        this.windPoints1 = windPoints1;
        this.judgeScoreA1 = judgeScoreA1;
        this.judgeScoreB1 = judgeScoreB1;
        this.judgeScoreC1 = judgeScoreC1;
        this.judgeScoreD1 = judgeScoreD1;
        this.judgeScoreE1 = judgeScoreE1;
        this.judgeOverallScore1 = judgeOverallScore1;
        this.dsq1 = dsq1;
        this.roundTotalScore1 = roundTotalScore1;
        this.gate2 = gate2;
        this.gatePoints2 = gatePoints2;
        this.speed2 = speed2;
        this.distance2 = distance2;
        this.distancePoints2 = distancePoints2;
        this.wind2 = wind2;
        this.windPoints2 = windPoints2;
        this.judgeScoreA2 = judgeScoreA2;
        this.judgeScoreB2 = judgeScoreB2;
        this.judgeScoreC2 = judgeScoreC2;
        this.judgeScoreD2 = judgeScoreD2;
        this.judgeScoreE2 = judgeScoreE2;
        this.judgeOverallScore2 = judgeOverallScore2;
        this.dsq2 = dsq2;
        this.roundTotalScore2 = roundTotalScore2;
        this.gate3 = gate3;
        this.gatePoints3 = gatePoints3;
        this.speed3 = speed3;
        this.distance3 = distance3;
        this.distancePoints3 = distancePoints3;
        this.wind3 = wind3;
        this.windPoints3 = windPoints3;
        this.judgeScoreA3 = judgeScoreA3;
        this.judgeScoreB3 = judgeScoreB3;
        this.judgeScoreC3 = judgeScoreC3;
        this.judgeScoreD3 = judgeScoreD3;
        this.judgeScoreE3 = judgeScoreE3;
        this.judgeOverallScore3 = judgeOverallScore3;
        this.dsq3 = dsq3;
        this.roundTotalScore3 = roundTotalScore3;
        this.gate4 = gate4;
        this.gatePoints4 = gatePoints4;
        this.speed4 = speed4;
        this.distance4 = distance4;
        this.distancePoints4 = distancePoints4;
        this.wind4 = wind4;
        this.windPoints4 = windPoints4;
        this.judgeScoreA4 = judgeScoreA4;
        this.judgeScoreB4 = judgeScoreB4;
        this.judgeScoreC4 = judgeScoreC4;
        this.judgeScoreD4 = judgeScoreD4;
        this.judgeScoreE4 = judgeScoreE4;
        this.judgeOverallScore4 = judgeOverallScore4;
        this.dsq4 = dsq4;
        this.roundTotalScore4 = roundTotalScore4;
        this.overallScore = overallScore;
        this.eventCom = eventCom;
        this.skiJumper = skiJumper;
    }

    public int getIdResult() {
        return idResult;
    }

    public void setIdResult(int idResult) {
        this.idResult = idResult;
    }

    public int getGate1() {
        return gate1;
    }

    public void setGate1(int gate1) {
        this.gate1 = gate1;
    }

    public BigDecimal getGatePoints1() {
        return gatePoints1;
    }

    public void setGatePoints1(BigDecimal gatePoints1) {
        this.gatePoints1 = gatePoints1;
    }

    public BigDecimal getSpeed1() {
        return speed1;
    }

    public void setSpeed1(BigDecimal speed1) {
        this.speed1 = speed1;
    }

    public BigDecimal getDistance1() {
        return distance1;
    }

    public void setDistance1(BigDecimal distance1) {
        this.distance1 = distance1;
    }

    public BigDecimal getDistancePoints1() {
        return distancePoints1;
    }

    public void setDistancePoints1(BigDecimal distancePoints1) {
        this.distancePoints1 = distancePoints1;
    }

    public BigDecimal getWind1() {
        return wind1;
    }

    public void setWind1(BigDecimal wind1) {
        this.wind1 = wind1;
    }

    public BigDecimal getWindPoints1() {
        return windPoints1;
    }

    public void setWindPoints1(BigDecimal windPoints1) {
        this.windPoints1 = windPoints1;
    }

    public BigDecimal getJudgeScoreA1() {
        return judgeScoreA1;
    }

    public void setJudgeScoreA1(BigDecimal judgeScoreA1) {
        this.judgeScoreA1 = judgeScoreA1;
    }

    public BigDecimal getJudgeScoreB1() {
        return judgeScoreB1;
    }

    public void setJudgeScoreB1(BigDecimal judgeScoreB1) {
        this.judgeScoreB1 = judgeScoreB1;
    }

    public BigDecimal getJudgeScoreC1() {
        return judgeScoreC1;
    }

    public void setJudgeScoreC1(BigDecimal judgeScoreC1) {
        this.judgeScoreC1 = judgeScoreC1;
    }

    public BigDecimal getJudgeScoreD1() {
        return judgeScoreD1;
    }

    public void setJudgeScoreD1(BigDecimal judgeScoreD1) {
        this.judgeScoreD1 = judgeScoreD1;
    }

    public BigDecimal getJudgeScoreE1() {
        return judgeScoreE1;
    }

    public void setJudgeScoreE1(BigDecimal judgeScoreE1) {
        this.judgeScoreE1 = judgeScoreE1;
    }

    public BigDecimal getJudgeOverallScore1() {
        return judgeOverallScore1;
    }

    public void setJudgeOverallScore1(BigDecimal judgeOverallScore1) {
        this.judgeOverallScore1 = judgeOverallScore1;
    }

    public Disqualification getDsq1() {
        return dsq1;
    }

    public void setDsq1(Disqualification dsq1) {
        this.dsq1 = dsq1;
    }

    public BigDecimal getRoundTotalScore1() {
        return roundTotalScore1;
    }

    public void setRoundTotalScore1(BigDecimal roundTotalScore1) {
        this.roundTotalScore1 = roundTotalScore1;
    }

    public int getGate2() {
        return gate2;
    }

    public void setGate2(int gate2) {
        this.gate2 = gate2;
    }

    public BigDecimal getGatePoints2() {
        return gatePoints2;
    }

    public void setGatePoints2(BigDecimal gatePoints2) {
        this.gatePoints2 = gatePoints2;
    }

    public BigDecimal getSpeed2() {
        return speed2;
    }

    public void setSpeed2(BigDecimal speed2) {
        this.speed2 = speed2;
    }

    public BigDecimal getDistance2() {
        return distance2;
    }

    public void setDistance2(BigDecimal distance2) {
        this.distance2 = distance2;
    }

    public BigDecimal getDistancePoints2() {
        return distancePoints2;
    }

    public void setDistancePoints2(BigDecimal distancePoints2) {
        this.distancePoints2 = distancePoints2;
    }

    public BigDecimal getWind2() {
        return wind2;
    }

    public void setWind2(BigDecimal wind2) {
        this.wind2 = wind2;
    }

    public BigDecimal getWindPoints2() {
        return windPoints2;
    }

    public void setWindPoints2(BigDecimal windPoints2) {
        this.windPoints2 = windPoints2;
    }

    public BigDecimal getJudgeScoreA2() {
        return judgeScoreA2;
    }

    public void setJudgeScoreA2(BigDecimal judgeScoreA2) {
        this.judgeScoreA2 = judgeScoreA2;
    }

    public BigDecimal getJudgeScoreB2() {
        return judgeScoreB2;
    }

    public void setJudgeScoreB2(BigDecimal judgeScoreB2) {
        this.judgeScoreB2 = judgeScoreB2;
    }

    public BigDecimal getJudgeScoreC2() {
        return judgeScoreC2;
    }

    public void setJudgeScoreC2(BigDecimal judgeScoreC2) {
        this.judgeScoreC2 = judgeScoreC2;
    }

    public BigDecimal getJudgeScoreD2() {
        return judgeScoreD2;
    }

    public void setJudgeScoreD2(BigDecimal judgeScoreD2) {
        this.judgeScoreD2 = judgeScoreD2;
    }

    public BigDecimal getJudgeScoreE2() {
        return judgeScoreE2;
    }

    public void setJudgeScoreE2(BigDecimal judgeScoreE2) {
        this.judgeScoreE2 = judgeScoreE2;
    }

    public BigDecimal getJudgeOverallScore2() {
        return judgeOverallScore2;
    }

    public void setJudgeOverallScore2(BigDecimal judgeOverallScore2) {
        this.judgeOverallScore2 = judgeOverallScore2;
    }

    public Disqualification getDsq2() {
        return dsq2;
    }

    public void setDsq2(Disqualification dsq2) {
        this.dsq2 = dsq2;
    }

    public BigDecimal getRoundTotalScore2() {
        return roundTotalScore2;
    }

    public void setRoundTotalScore2(BigDecimal roundTotalScore2) {
        this.roundTotalScore2 = roundTotalScore2;
    }

    public int getGate3() {
        return gate3;
    }

    public void setGate3(int gate3) {
        this.gate3 = gate3;
    }

    public BigDecimal getGatePoints3() {
        return gatePoints3;
    }

    public void setGatePoints3(BigDecimal gatePoints3) {
        this.gatePoints3 = gatePoints3;
    }

    public BigDecimal getSpeed3() {
        return speed3;
    }

    public void setSpeed3(BigDecimal speed3) {
        this.speed3 = speed3;
    }

    public BigDecimal getDistance3() {
        return distance3;
    }

    public void setDistance3(BigDecimal distance3) {
        this.distance3 = distance3;
    }

    public BigDecimal getDistancePoints3() {
        return distancePoints3;
    }

    public void setDistancePoints3(BigDecimal distancePoints3) {
        this.distancePoints3 = distancePoints3;
    }

    public BigDecimal getWind3() {
        return wind3;
    }

    public void setWind3(BigDecimal wind3) {
        this.wind3 = wind3;
    }

    public BigDecimal getWindPoints3() {
        return windPoints3;
    }

    public void setWindPoints3(BigDecimal windPoints3) {
        this.windPoints3 = windPoints3;
    }

    public BigDecimal getJudgeScoreA3() {
        return judgeScoreA3;
    }

    public void setJudgeScoreA3(BigDecimal judgeScoreA3) {
        this.judgeScoreA3 = judgeScoreA3;
    }

    public BigDecimal getJudgeScoreB3() {
        return judgeScoreB3;
    }

    public void setJudgeScoreB3(BigDecimal judgeScoreB3) {
        this.judgeScoreB3 = judgeScoreB3;
    }

    public BigDecimal getJudgeScoreC3() {
        return judgeScoreC3;
    }

    public void setJudgeScoreC3(BigDecimal judgeScoreC3) {
        this.judgeScoreC3 = judgeScoreC3;
    }

    public BigDecimal getJudgeScoreD3() {
        return judgeScoreD3;
    }

    public void setJudgeScoreD3(BigDecimal judgeScoreD3) {
        this.judgeScoreD3 = judgeScoreD3;
    }

    public BigDecimal getJudgeScoreE3() {
        return judgeScoreE3;
    }

    public void setJudgeScoreE3(BigDecimal judgeScoreE3) {
        this.judgeScoreE3 = judgeScoreE3;
    }

    public BigDecimal getJudgeOverallScore3() {
        return judgeOverallScore3;
    }

    public void setJudgeOverallScore3(BigDecimal judgeOverallScore3) {
        this.judgeOverallScore3 = judgeOverallScore3;
    }

    public Disqualification getDsq3() {
        return dsq3;
    }

    public void setDsq3(Disqualification dsq3) {
        this.dsq3 = dsq3;
    }

    public BigDecimal getRoundTotalScore3() {
        return roundTotalScore3;
    }

    public void setRoundTotalScore3(BigDecimal roundTotalScore3) {
        this.roundTotalScore3 = roundTotalScore3;
    }

    public int getGate4() {
        return gate4;
    }

    public void setGate4(int gate4) {
        this.gate4 = gate4;
    }

    public BigDecimal getGatePoints4() {
        return gatePoints4;
    }

    public void setGatePoints4(BigDecimal gatePoints4) {
        this.gatePoints4 = gatePoints4;
    }

    public BigDecimal getSpeed4() {
        return speed4;
    }

    public void setSpeed4(BigDecimal speed4) {
        this.speed4 = speed4;
    }

    public BigDecimal getDistance4() {
        return distance4;
    }

    public void setDistance4(BigDecimal distance4) {
        this.distance4 = distance4;
    }

    public BigDecimal getDistancePoints4() {
        return distancePoints4;
    }

    public void setDistancePoints4(BigDecimal distancePoints4) {
        this.distancePoints4 = distancePoints4;
    }

    public BigDecimal getWind4() {
        return wind4;
    }

    public void setWind4(BigDecimal wind4) {
        this.wind4 = wind4;
    }

    public BigDecimal getWindPoints4() {
        return windPoints4;
    }

    public void setWindPoints4(BigDecimal windPoints4) {
        this.windPoints4 = windPoints4;
    }

    public BigDecimal getJudgeScoreA4() {
        return judgeScoreA4;
    }

    public void setJudgeScoreA4(BigDecimal judgeScoreA4) {
        this.judgeScoreA4 = judgeScoreA4;
    }

    public BigDecimal getJudgeScoreB4() {
        return judgeScoreB4;
    }

    public void setJudgeScoreB4(BigDecimal judgeScoreB4) {
        this.judgeScoreB4 = judgeScoreB4;
    }

    public BigDecimal getJudgeScoreC4() {
        return judgeScoreC4;
    }

    public void setJudgeScoreC4(BigDecimal judgeScoreC4) {
        this.judgeScoreC4 = judgeScoreC4;
    }

    public BigDecimal getJudgeScoreD4() {
        return judgeScoreD4;
    }

    public void setJudgeScoreD4(BigDecimal judgeScoreD4) {
        this.judgeScoreD4 = judgeScoreD4;
    }

    public BigDecimal getJudgeScoreE4() {
        return judgeScoreE4;
    }

    public void setJudgeScoreE4(BigDecimal judgeScoreE4) {
        this.judgeScoreE4 = judgeScoreE4;
    }

    public BigDecimal getJudgeOverallScore4() {
        return judgeOverallScore4;
    }

    public void setJudgeOverallScore4(BigDecimal judgeOverallScore4) {
        this.judgeOverallScore4 = judgeOverallScore4;
    }

    public Disqualification getDsq4() {
        return dsq4;
    }

    public void setDsq4(Disqualification dsq4) {
        this.dsq4 = dsq4;
    }

    public BigDecimal getRoundTotalScore4() {
        return roundTotalScore4;
    }

    public void setRoundTotalScore4(BigDecimal roundTotalScore4) {
        this.roundTotalScore4 = roundTotalScore4;
    }

    public BigDecimal getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(BigDecimal overallScore) {
        this.overallScore = overallScore;
    }

    public EventCom getEventCom() {
        return eventCom;
    }

    public void setEventCom(EventCom eventCom) {
        this.eventCom = eventCom;
    }

    public SkiJumper getSkiJumper() {
        return skiJumper;
    }

    public void setSkiJumper(SkiJumper skiJumper) {
        this.skiJumper = skiJumper;
    }

    @Override
    public String toString() {
        return "Result{" +
                "idResult=" + idResult +
                ", gate1=" + gate1 +
                ", gatePoints1=" + gatePoints1 +
                ", speed1=" + speed1 +
                ", distance1=" + distance1 +
                ", distancePoints1=" + distancePoints1 +
                ", wind1=" + wind1 +
                ", windPoints1=" + windPoints1 +
                ", judgeScoreA1=" + judgeScoreA1 +
                ", judgeScoreB1=" + judgeScoreB1 +
                ", judgeScoreC1=" + judgeScoreC1 +
                ", judgeScoreD1=" + judgeScoreD1 +
                ", judgeScoreE1=" + judgeScoreE1 +
                ", judgeOverallScore1=" + judgeOverallScore1 +
                ", dsq1=" + dsq1 +
                ", roundTotalScore1=" + roundTotalScore1 +
                ", gate2=" + gate2 +
                ", gatePoints2=" + gatePoints2 +
                ", speed2=" + speed2 +
                ", distance2=" + distance2 +
                ", distancePoints2=" + distancePoints2 +
                ", wind2=" + wind2 +
                ", windPoints2=" + windPoints2 +
                ", judgeScoreA2=" + judgeScoreA2 +
                ", judgeScoreB2=" + judgeScoreB2 +
                ", judgeScoreC2=" + judgeScoreC2 +
                ", judgeScoreD2=" + judgeScoreD2 +
                ", judgeScoreE2=" + judgeScoreE2 +
                ", judgeOverallScore2=" + judgeOverallScore2 +
                ", dsq2=" + dsq2 +
                ", roundTotalScore2=" + roundTotalScore2 +
                ", gate3=" + gate3 +
                ", gatePoints3=" + gatePoints3 +
                ", speed3=" + speed3 +
                ", distance3=" + distance3 +
                ", distancePoints3=" + distancePoints3 +
                ", wind3=" + wind3 +
                ", windPoints3=" + windPoints3 +
                ", judgeScoreA3=" + judgeScoreA3 +
                ", judgeScoreB3=" + judgeScoreB3 +
                ", judgeScoreC3=" + judgeScoreC3 +
                ", judgeScoreD3=" + judgeScoreD3 +
                ", judgeScoreE3=" + judgeScoreE3 +
                ", judgeOverallScore3=" + judgeOverallScore3 +
                ", dsq3=" + dsq3 +
                ", roundTotalScore3=" + roundTotalScore3 +
                ", gate4=" + gate4 +
                ", gatePoints4=" + gatePoints4 +
                ", speed4=" + speed4 +
                ", distance4=" + distance4 +
                ", distancePoints4=" + distancePoints4 +
                ", wind4=" + wind4 +
                ", windPoints4=" + windPoints4 +
                ", judgeScoreA4=" + judgeScoreA4 +
                ", judgeScoreB4=" + judgeScoreB4 +
                ", judgeScoreC4=" + judgeScoreC4 +
                ", judgeScoreD4=" + judgeScoreD4 +
                ", judgeScoreE4=" + judgeScoreE4 +
                ", judgeOverallScore4=" + judgeOverallScore4 +
                ", dsq4=" + dsq4 +
                ", roundTotalScore4=" + roundTotalScore4 +
                ", overallScore=" + overallScore +
                ", eventCom=" + eventCom +
                ", skiJumper=" + skiJumper +
                '}';
    }
}
