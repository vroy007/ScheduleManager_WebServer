package com.scut.victor.service.impl;

import com.scut.victor.dao.ScheduleDao;
import com.scut.victor.model.Schedule;
import com.scut.victor.service.ScheduleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by shimn on 2016/6/8.
 */
@Transactional
@Service("scheduleService")
public class ScheduleServiceImpl implements ScheduleService {

    @Resource
    private ScheduleDao scheduleDao;

    @Override
    public Schedule get(String id) {
        return scheduleDao.get(id);
    }

    @Override
    public String save(Schedule entity) {
        return scheduleDao.save(entity);
    }

    @Override
    public void delete(String id) {
        scheduleDao.delete(id);
    }

    @Override
    public Schedule load(String id) {
        return scheduleDao.load(id);
    }

    @Override
    public List<Schedule> findAll() {
        return scheduleDao.findAll();
    }

    @Override
    public void persist(Schedule entity) {
        scheduleDao.persist(entity);
    }

    @Override
    public void saveOrUpdate(Schedule entity) {
        scheduleDao.saveOrUpdate(entity);
    }

    @Override
    public void flush() {
        scheduleDao.flush();
    }

    @Override
    public List<Schedule> getSchedulesByUserId(String id) {
        return scheduleDao.getSchedulesByUserId(id);
    }

    @Override
    public String backupScheduleLists(List<Schedule> list) {
        return scheduleDao.backupScheduleLists(list);
    }

    @Override
    public String backupSchedule(Schedule model) {
        Schedule entity = scheduleDao.getScheduleByScheduleID(String.valueOf(model.getScheduleID()));
        if (entity != null) {
            try {
                entity.setTipTime(model.getTipTime());
                entity.setIsDone(model.getIsDone());
                entity.setContents(model.getContents());
                entity.setBeginTime(model.getBeginTime());
                entity.setEndTime(model.getEndTime());
                entity.setIsGroup(model.getIsGroup());
                entity.setIsTips(model.getIsTips());
                entity.setUserId(model.getUserId());
                scheduleDao.saveOrUpdate(entity);
                return "success";
            } catch (Exception e) {
                e.printStackTrace();
                return "fail";
            }
        }
        else {
            try {
                scheduleDao.save(model);
                return "success";
            } catch (Exception e) {
                e.printStackTrace();
                return "fail";
            }
        }
    }

    @Override
    public void deleteByScheduleId(String scheduleId) {
        scheduleDao.deleteByScheduleId(scheduleId);
    }
}
