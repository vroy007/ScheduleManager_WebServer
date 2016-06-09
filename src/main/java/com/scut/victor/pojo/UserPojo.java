package com.scut.victor.pojo;

/**
 * Created by shimn on 2016/6/8.
 */
public class UserPojo {

    private String id;

    private String userId;

    private String lastTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    @Override
    public String toString() {
        return "UserPojo{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", lastTime='" + lastTime + '\'' +
                '}';
    }
}
