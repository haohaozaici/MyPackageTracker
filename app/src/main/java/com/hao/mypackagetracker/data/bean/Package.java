package com.hao.mypackagetracker.data.bean;

import java.util.List;

/**
 * Created by haohao on 2017/3/10.
 */

public class Package {

    /**
     * message : ok
     * nu : 70388432404380
     * ischeck : 1
     * condition : F00
     * com : huitongkuaidi
     * status : 200
     * state : 3
     * data : [{"time":"2017-02-18 13:44:03","ftime":"2017-02-18 13:44:03","context":"武汉市|签收|武汉市【卓刀泉分部】，华大驿站9号楼地下仓库代收
     * 已签收","location":""},{"time":"2017-02-18 12:07:34","ftime":"2017-02-18
     * 12:07:34","context":"武汉市|派件|武汉市【卓刀泉分部】，【华大驿站/02767863299】正在派件","location":""},{"time":"2017-02-17
     * 22:56:24","ftime":"2017-02-17 22:56:24","context":"武汉市|发件|武汉市【武汉武昌转运中心】，正发往【卓刀泉分部】","location":""},{"time":"2017-02-17
     * 22:49:36","ftime":"2017-02-17 22:49:36","context":"武汉市|到件|到武汉市【武汉武昌转运中心】","location":""},{"time":"2017-02-17
     * 19:58:06","ftime":"2017-02-17 19:58:06","context":"武汉市|发件|武汉市【武汉转运中心】，正发往【武汉武昌转运中心】","location":""},{"time":"2017-02-17
     * 19:45:33","ftime":"2017-02-17 19:45:33","context":"武汉市|到件|到武汉市【武汉转运中心】","location":""},{"time":"2017-02-16
     * 23:05:24","ftime":"2017-02-16 23:05:24","context":"金华市|发件|金华市【金华转运中心】，正发往【武汉转运中心】","location":""},{"time":"2017-02-16
     * 22:05:51","ftime":"2017-02-16 22:05:51","context":"金华市|到件|到金华市【金华转运中心】","location":""},{"time":"2017-02-16
     * 19:30:37","ftime":"2017-02-16 19:30:37","context":"金华市|收件|金华市【东阳南马镇】，【胡旭/15314965009】已揽收","location":""}]
     */

    private String message;
    private String nu;
    private String ischeck;
    private String condition;
    private String com;
    private String status;
    private int state;
    private List<Data> data;

    public static final int STATUS_FAILED = 2, STATUS_NORMAL = 0, STATUS_ON_THE_WAY = 5,
        STATUS_DELIVERED = 3, STATUS_RETURNED = 4, STATUS_RETURNING = 6, STATUS_OTHER = 1;


    public String getMessage() { return message;}


    public void setMessage(String message) { this.message = message;}


    public String getNu() { return nu;}


    public void setNu(String nu) { this.nu = nu;}


    public String getIscheck() { return ischeck;}


    public void setIscheck(String ischeck) { this.ischeck = ischeck;}


    public String getCondition() { return condition;}


    public void setCondition(String condition) { this.condition = condition;}


    public String getCom() { return com;}


    public void setCom(String com) { this.com = com;}


    public String getStatus() { return status;}


    public void setStatus(String status) { this.status = status;}


    public int getState() { return state;}


    public void setState(int state) { this.state = state;}


    public List<Data> getData() { return data;}


    public void setData(List<Data> data) { this.data = data;}


    public static class Data {
        /**
         * time : 2017-02-18 13:44:03
         * ftime : 2017-02-18 13:44:03
         * context : 武汉市|签收|武汉市【卓刀泉分部】，华大驿站9号楼地下仓库代收 已签收
         * location :
         */

        private String time;
        private String ftime;
        private String context;
        private String location;


        public String getTime() { return time;}


        public void setTime(String time) { this.time = time;}


        public String getFtime() { return ftime;}


        public void setFtime(String ftime) { this.ftime = ftime;}


        public String getContext() { return context;}


        public void setContext(String context) { this.context = context;}


        public String getLocation() { return location;}


        public void setLocation(String location) { this.location = location;}
    }
}
