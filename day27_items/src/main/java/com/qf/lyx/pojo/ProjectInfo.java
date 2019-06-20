package com.qf.lyx.pojo;

/**
 * Created by Administrator on 2019/6/1 0001.
 */
/*众筹项目详情信息*/
public class ProjectInfo {
    private int id;//主键自增
    private String account;//用户账号
    private String sortBey;//分类信息
    private String labeTag;//标签
    private String projectName;//项目名称
    private String brief;//一句话简介
    private String amount;//众筹金额
    private String fdays;//众筹时间
    private String phFigure;//项目头图
    private String projectDetaits;//项目详情
    private String selfInfo;//自我介绍
    private String minuteInfo;//详细自我介绍
    private String contactNumber;//联系电话
    private String cerviceTel;//客服电话\

    public ProjectInfo() {
    }

    public ProjectInfo(String account, String sortBey, String labeTag, String projectName, String brief, String amount, String fdays, String phFigure, String projectDetaits, String selfInfo, String minuteInfo, String contactNumber, String cerviceTel) {
        this.account = account;
        this.sortBey = sortBey;
        this.labeTag = labeTag;
        this.projectName = projectName;
        this.brief = brief;
        this.amount = amount;
        this.fdays = fdays;
        this.phFigure = phFigure;
        this.projectDetaits = projectDetaits;
        this.selfInfo = selfInfo;
        this.minuteInfo = minuteInfo;
        this.contactNumber = contactNumber;
        this.cerviceTel = cerviceTel;
    }

    public ProjectInfo(int id, String account, String sortBey, String labeTag, String projectName, String brief, String amount, String fdays, String phFigure, String projectDetaits, String selfInfo, String minuteInfo, String contactNumber, String cerviceTel) {
        this.id = id;
        this.account = account;
        this.sortBey = sortBey;
        this.labeTag = labeTag;
        this.projectName = projectName;
        this.brief = brief;
        this.amount = amount;
        this.fdays = fdays;
        this.phFigure = phFigure;
        this.projectDetaits = projectDetaits;
        this.selfInfo = selfInfo;
        this.minuteInfo = minuteInfo;
        this.contactNumber = contactNumber;
        this.cerviceTel = cerviceTel;
    }

    @Override
    public String toString() {
        return "ProjectInfo{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", sortBey='" + sortBey + '\'' +
                ", labeTag='" + labeTag + '\'' +
                ", projectName='" + projectName + '\'' +
                ", brief='" + brief + '\'' +
                ", amount='" + amount + '\'' +
                ", fdays='" + fdays + '\'' +
                ", phFigure='" + phFigure + '\'' +
                ", projectDetaits='" + projectDetaits + '\'' +
                ", selfInfo='" + selfInfo + '\'' +
                ", minuteInfo='" + minuteInfo + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", cerviceTel='" + cerviceTel + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSortBey() {
        return sortBey;
    }

    public void setSortBey(String sortBey) {
        this.sortBey = sortBey;
    }

    public String getLabeTag() {
        return labeTag;
    }

    public void setLabeTag(String labeTag) {
        this.labeTag = labeTag;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getFdays() {
        return fdays;
    }

    public void setFdays(String fdays) {
        this.fdays = fdays;
    }

    public String getPhFigure() {
        return phFigure;
    }

    public void setPhFigure(String phFigure) {
        this.phFigure = phFigure;
    }

    public String getProjectDetaits() {
        return projectDetaits;
    }

    public void setProjectDetaits(String projectDetaits) {
        this.projectDetaits = projectDetaits;
    }

    public String getSelfInfo() {
        return selfInfo;
    }

    public void setSelfInfo(String selfInfo) {
        this.selfInfo = selfInfo;
    }

    public String getMinuteInfo() {
        return minuteInfo;
    }

    public void setMinuteInfo(String minuteInfo) {
        this.minuteInfo = minuteInfo;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getCerviceTel() {
        return cerviceTel;
    }

    public void setCerviceTel(String cerviceTel) {
        this.cerviceTel = cerviceTel;
    }
}
