package sample;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "hill_version")
public class HillVersion implements Comparable<HillVersion> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idhill_version")
    private int idHillVersion;

    @Column(name = "first_year")
    private int firstYear = 0;

    @Column(name = "last_year")
    private int lastYear = 0;

    @Column(name = "inrun_length")
    private BigDecimal inrunLength;

    @Column(name = "inrun_angle")
    private BigDecimal inrunAngle;

    @Column(name = "take_off_length")
    private BigDecimal takeOffLength;

    @Column(name = "take_off_angle")
    private BigDecimal takeOffAngle;

    @Column(name = "take_off_height")
    private BigDecimal takeOffHeight;

    @Column(name = "k_point")
    private BigDecimal kPoint;

    @Column(name = "hill_size")
    private BigDecimal hillSize;

    @Column(name = "hill_version_record")
    private BigDecimal hillVersionRecord;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "fkhill")
    private Hill hill;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "fktype_of_hill")
    private TypeOfHill typeOfHill;

    public HillVersion() {
    }

    public HillVersion(int firstYear, int lastYear, BigDecimal inrunLength, BigDecimal inrunAngle, BigDecimal takeOffLength, BigDecimal takeOffAngle, BigDecimal takeOffHeight, BigDecimal kPoint, BigDecimal hillSize, BigDecimal hillVersionRecord, Hill hill, TypeOfHill typeOfHill) {
        this.firstYear = firstYear;
        this.lastYear = lastYear;
        this.inrunLength = inrunLength;
        this.inrunAngle = inrunAngle;
        this.takeOffLength = takeOffLength;
        this.takeOffAngle = takeOffAngle;
        this.takeOffHeight = takeOffHeight;
        this.kPoint = kPoint;
        this.hillSize = hillSize;
        this.hillVersionRecord = hillVersionRecord;
        this.hill = hill;
        this.typeOfHill = typeOfHill;
    }

    public int getIdHillVersion() {
        return idHillVersion;
    }

    public void setIdHillVersion(int idHillVersion) {
        this.idHillVersion = idHillVersion;
    }

    public int getFirstYear() {
        return firstYear;
    }

    public void setFirstYear(int firstYear) {
        this.firstYear = firstYear;
    }

    public int getLastYear() {
        return lastYear;
    }

    public void setLastYear(int lastYear) {
        this.lastYear = lastYear;
    }

    public BigDecimal getInrunLength() {
        return inrunLength;
    }

    public void setInrunLength(BigDecimal inrunLength) {
        this.inrunLength = inrunLength;
    }

    public BigDecimal getInrunAngle() {
        return inrunAngle;
    }

    public void setInrunAngle(BigDecimal inrunAngle) {
        this.inrunAngle = inrunAngle;
    }

    public BigDecimal getTakeOffLength() {
        return takeOffLength;
    }

    public void setTakeOffLength(BigDecimal takeOffLength) {
        this.takeOffLength = takeOffLength;
    }

    public BigDecimal getTakeOffAngle() {
        return takeOffAngle;
    }

    public void setTakeOffAngle(BigDecimal takeOffAngle) {
        this.takeOffAngle = takeOffAngle;
    }

    public BigDecimal getTakeOffHeight() {
        return takeOffHeight;
    }

    public void setTakeOffHeight(BigDecimal takeOffHeight) {
        this.takeOffHeight = takeOffHeight;
    }

    public BigDecimal getkPoint() {
        return kPoint;
    }

    public void setkPoint(BigDecimal kPoint) {
        this.kPoint = kPoint;
    }

    public BigDecimal getHillSize() {
        return hillSize;
    }

    public void setHillSize(BigDecimal hillSize) {
        this.hillSize = hillSize;
    }

    public BigDecimal getHillVersionRecord() {
        return hillVersionRecord;
    }

    public void setHillVersionRecord(BigDecimal hillVersionRecord) {
        this.hillVersionRecord = hillVersionRecord;
    }

    public Hill getHill() {
        return hill;
    }

    public void setHill(Hill hill) {
        this.hill = hill;
    }

    public TypeOfHill getTypeOfHill() {
        return typeOfHill;
    }

    public void setTypeOfHill(TypeOfHill typeOfHill) {
        this.typeOfHill = typeOfHill;
    }

    @Override
    public int compareTo(HillVersion hillVersion) {
        return this.firstYear < hillVersion.firstYear ? 1 : 0;
    }

    @Override
    public String toString() {
        String hs = hillSize.toString();

        if (hs.equals("0.0")) {
            hs = "";
        }

        if (lastYear == 0) {
            return firstYear + "- now" + " K: " + kPoint + " HS: " + hs;
        } else
            return firstYear + "-" + lastYear + " K: " + kPoint + " HS: " + hs;

    }
}
