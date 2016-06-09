package com.scut.victor.pojo;

/**
 * Created by shimn on 2016/6/8.
 */
public class SchedulePojo {

    private String id;

    private int scheduleID;

    private int isTips = -1;

    private String contents;

    private String beginTime;

    private String endTime;

    private String tipTime;

    private int isDone = -1;

    private int isGroup = -1;

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

    @Override
    public String toString() {
        return "SchedulePojo{" +
                "id='" + id + '\'' +
                ", scheduleID=" + scheduleID +
                ", isTips=" + isTips +
                ", contents='" + contents + '\'' +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", tipTime='" + tipTime + '\'' +
                ", isDone=" + isDone +
                ", isGroup=" + isGroup +
                '}';
    }
}
