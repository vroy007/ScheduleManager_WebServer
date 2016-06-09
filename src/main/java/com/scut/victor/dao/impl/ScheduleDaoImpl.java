package com.scut.victor.dao.impl;

import com.scut.victor.dao.ScheduleDao;
import com.scut.victor.model.Schedule;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by shimn on 2016/6/8.
 */
@Repository("scheduleDao")
public class ScheduleDaoImpl implements ScheduleDao {

    @Resource
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Schedule> getSchedulesByUserId(String id) {
        String hql = "from Schedule where userId = ?";
        Query query = this.getSession().createQuery(hql);
        query.setString(0, id);
        return query.list();
    }

    @Override
    public String backupScheduleLists(List<Schedule> list) {
        if (list == null || list.size() == 0) return null;
        for (Schedule model : list)
            backupSchedule(model);
        return "success";
    }

    @Override
    public String backupSchedule(Schedule model) {
        String hql = "from Schedule where scheduleID = ?";
        Query query = this.getSession().createQuery(hql);
        query.setInteger(0, model.getScheduleID());
        Schedule entity = (Schedule) query.uniqueResult();
        if (entity == null)
            save(model);
        else {
            model.setId(entity.getId());
            saveOrUpdate(model);
        }
        return "success";
    }

    @Override
    public void deleteByScheduleId(String scheduleId) {
        String hql = "from Schedule where scheduleID = ?";
        Query query = this.getSession().createQuery(hql);
        query.setString(0, scheduleId);
        Schedule model = (Schedule) query.uniqueResult();
        if(model != null) {
            delete(model.getId());
        }
    }

    @Override
    public Schedule getScheduleByScheduleID(String scheduleId) {
        String hql = "from Schedule where scheduleID = ?";
        Query query = this.getSession().createQuery(hql);
        query.setString(0, scheduleId);
        return (Schedule) query.uniqueResult();
    }

    @Override
    public Schedule get(String id) {
        return (Schedule) this.getSession().get(Schedule.class, id);
    }

    @Override
    public String save(Schedule entity) {
        return (String) this.getSession().save(entity);
    }

    @Override
    public void delete(String id) {
        Schedule model = this.load(id);
        this.getSession().delete(model);
    }

    @Override
    public Schedule load(String id) {
        return (Schedule) this.getSession().load(Schedule.class, id);
    }

    @Override
    public List<Schedule> findAll() {
        return this.getSession().createQuery("from Schedule").list();
    }

    @Override
    public void persist(Schedule entity) {

    }

    @Override
    public void saveOrUpdate(Schedule entity) {
        this.getSession().clear();
        this.getSession().saveOrUpdate(entity);
    }

    @Override
    public void flush() {
    }
}
