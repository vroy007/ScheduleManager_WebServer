package com.scut.victor.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by shimn on 2016/6/8.
 */
@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid",strategy = "uuid")
    @Column(name = "id")
    private String id;

    @Column(name = "scheduleID")
    private int scheduleID;

    @Column(name = "isTips")
    private int isTips = -1;

    @Column(name = "contents")
    private String contents;

    @Column(name = "beginTime")
    private String beginTime;

    @Column(name = "endTime")
    private String endTime;

    @Column(name = "tipTime")
    private String tipTime;

    @Column(name = "isDone")
    private int isDone = -1;

    @Column(name = "isGroup")
    private int isGroup = -1;

    @Column(name = "userId")
    private String userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(int scheduleID) {
        this.scheduleID = scheduleID;
    }

    public int getIsTips() {
        return isTips;
    }

    public void setIsTips(int isTips) {
        this.isTips = isTips;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTipTime() {
        return tipTime;
    }

    public void setTipTime(String tipTime) {
        this.tipTime = tipTime;
    }

    public int getIsDone() {
        return isDone;
    }

    public void setIsDone(int isDone) {
        this.isDone = isDone;
    }

    public int getIsGroup() {
        return isGroup;
    }

    public void setIsGroup(int isGroup) {
        this.isGroup = isGroup;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id='" + id + '\'' +
                ", scheduleID=" + scheduleID +
                ", isTips=" + isTips +
                ", contents='" + contents + '\'' +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", tipTime='" + tipTime + '\'' +
                ", isDone=" + isDone +
                ", isGroup=" + isGroup +
                ", userId='" + userId + '\'' +
                '}';
    }
}
