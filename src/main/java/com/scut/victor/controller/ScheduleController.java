package com.scut.victor.controller;

import com.alibaba.fastjson.JSON;
import com.scut.victor.model.Schedule;
import com.scut.victor.pojo.SchedulePojo;
import com.scut.victor.service.ScheduleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shimn on 2016/6/8.
 */
@Controller
@RequestMapping("/schedule")
public class ScheduleController {

    @Resource
    private ScheduleService scheduleService;

    @ResponseBody
    @RequestMapping(value = "/backup", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    public String backUp(Schedule scheduleModel) {
        try {
            scheduleService.backupSchedule(scheduleModel);
            return JSON.toJSONString(scheduleModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "fail";
    }

    @ResponseBody
    @RequestMapping(value = "/backupAll", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    public String backupAll(List<Schedule> list) {
        return scheduleService.backupScheduleLists(list);
    }

    @ResponseBody
    @RequestMapping(value = "/getSchedules", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
    public String getSchedules(String userId) {
        if (userId == null || userId.equals("")) return null;
        List<Schedule> list = scheduleService.getSchedulesByUserId(userId);
        List<SchedulePojo> listPojo = new ArrayList<SchedulePojo>();
        for (Schedule model : list) {
            SchedulePojo pojo = new SchedulePojo();
            pojo.setId(model.getId());
            pojo.setScheduleID(model.getScheduleID());
            pojo.setIsTips(model.getIsTips());
            pojo.setBeginTime(model.getBeginTime());
            pojo.setContents(model.getContents());
            pojo.setEndTime(model.getEndTime());
            pojo.setIsDone(model.getIsDone());
            pojo.setIsGroup(model.getIsGroup());
            pojo.setTipTime(model.getTipTime());
            listPojo.add(pojo);
        }
        return JSON.toJSONString(listPojo);
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
    public String delete(String scheduleID) {
        if (scheduleID == null) return "fail";
        scheduleService.deleteByScheduleId(scheduleID);
        return "success";
    }
}
