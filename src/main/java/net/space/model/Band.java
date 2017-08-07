package net.space.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author A.Albert
 * @Data 8/3/17
 * @Time 9:53 AM
 * @Version 1.0
 * @Info Simple javaBean object.
 */

@Entity
@Table(name = "band")
public class Band {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "DATE_BAND")
    @Temporal(TemporalType.DATE)
    private Date dataBand;

    @Column(name = "NAME_BAND")
    private String nameBand;

    @Column(name = "START_TIME")
    private String startTime;

    @Column(name = "END_TIME")
    private String endTime;

    @Column(name = "COUNT_HOURS")
    private int countHours;

    @Column(name = "COMMENT")
    private String comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataBand() {
        return dataBand;
    }

    public void setDataBand(Date dataBand) {
        this.dataBand = dataBand;
    }

    public String getNameBand() {
        return nameBand;
    }

    public void setNameBand(String nameBand) {
        this.nameBand = nameBand;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getCountHours() {
        return countHours;
    }

    public void setCountHours(int countHours) {
        this.countHours = countHours;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Band{" +
                "id=" + id +
                ", dataBand=" + dataBand +
                ", nameBand='" + nameBand + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", countHours=" + countHours +
                ", comment='" + comment + '\'' +
                '}';
    }
}
