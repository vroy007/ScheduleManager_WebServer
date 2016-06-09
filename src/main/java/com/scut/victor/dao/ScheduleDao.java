package com.scut.victor.dao;

import com.scut.victor.model.Schedule;

import java.util.List;

/**
 * Created by shimn on 2016/6/8.
 */
public interface ScheduleDao extends GenericDao<Schedule, String> {

    //id:user表中主键id，非userId
    List<Schedule> getSchedulesByUserId(String id);

    //批量备份
    String backupScheduleLists(List<Schedule> list);

    //单个日程备份
    String backupSchedule(Schedule model);

    void deleteByScheduleId(String scheduleId);

    Schedule getScheduleByScheduleID(String scheduleId);

}
