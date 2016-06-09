package com.scut.victor.service;

import com.scut.victor.model.Schedule;

import java.util.List;

/**
 * Created by shimn on 2016/6/8.
 */
public interface ScheduleService {

    Schedule get(String id);

    String save(Schedule entity);

    void delete(String id);

    Schedule load(String id);

    List<Schedule> findAll();

    void persist(Schedule entity);

    void saveOrUpdate(Schedule entity);

    void flush();

    List<Schedule> getSchedulesByUserId(String id);

    //批量备份
    String backupScheduleLists(List<Schedule> list);

    //单个日程备份
    String backupSchedule(Schedule model);

    void deleteByScheduleId(String scheduleId);
}
