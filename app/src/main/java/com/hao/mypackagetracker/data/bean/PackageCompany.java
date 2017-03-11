package com.hao.mypackagetracker.data.bean;

import java.util.List;

/**
 * Created by haohao on 2017/3/10.
 */

public class PackageCompany {

    /**
     * comCode :
     * num : 70388432404380
     * auto : [{"comCode":"huitongkuaidi","id":"","noCount":37945,"noPre":"703884","startTime":""},{"comCode":"baishiwuliu","id":"","noCount":383,"noPre":"703884","startTime":""}]
     */

    private String comCode;
    private String num;
    private List<Auto> auto;


    public String getComCode() { return comCode;}


    public void setComCode(String comCode) { this.comCode = comCode;}


    public String getNum() { return num;}


    public void setNum(String num) { this.num = num;}


    public List<Auto> getAuto() { return auto;}


    public void setAuto(List<Auto> auto) { this.auto = auto;}


    public static class Auto {
        /**
         * comCode : huitongkuaidi
         * id :
         * noCount : 37945
         * noPre : 703884
         * startTime :
         */

        private String comCode;
        private String id;
        private String noCount;
        private String noPre;
        private String startTime;


        public String getComCode() { return comCode;}


        public void setComCode(String comCode) { this.comCode = comCode;}


        public String getId() { return id;}


        public void setId(String id) { this.id = id;}


        public String getNoCount() { return noCount;}


        public void setNoCount(String noCount) { this.noCount = noCount;}


        public String getNoPre() { return noPre;}


        public void setNoPre(String noPre) { this.noPre = noPre;}


        public String getStartTime() { return startTime;}


        public void setStartTime(String startTime) { this.startTime = startTime;}
    }
}
