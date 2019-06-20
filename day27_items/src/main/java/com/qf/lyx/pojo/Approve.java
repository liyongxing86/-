package com.qf.lyx.pojo;

/**
 * Created by Administrator on 2019/5/29 0029.
 */
public class Approve {
    private int id;
    private String account;//用户账号
    private String name;//用户真实姓名
    private String ID_card;//用户身份证号
    private String phone_code;//电话号码
    private String ID_photo;//手持身份证照片
    private String email;//邮箱
    private String rate;//认证类型
    private String audit;//认证状态

    public Approve() {
    }

    public Approve(String account, String name, String ID_card, String phone_code, String ID_photo, String email, String rate, String audit) {
        this.account = account;
        this.name = name;
        this.ID_card = ID_card;
        this.phone_code = phone_code;
        this.ID_photo = ID_photo;
        this.email = email;
        this.rate = rate;
        this.audit = audit;
    }

    public Approve(int id, String account, String name, String ID_card, String phone_code, String ID_photo, String email, String rate, String audit) {
        this.id = id;
        this.account = account;
        this.name = name;
        this.ID_card = ID_card;
        this.phone_code = phone_code;
        this.ID_photo = ID_photo;
        this.email = email;
        this.rate = rate;
        this.audit = audit;
    }

    @Override
    public String toString() {
        return "Approve{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", ID_card='" + ID_card + '\'' +
                ", phone_code='" + phone_code + '\'' +
                ", ID_photo='" + ID_photo + '\'' +
                ", email='" + email + '\'' +
                ", rate='" + rate + '\'' +
                ", audit='" + audit + '\'' +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID_card() {
        return ID_card;
    }

    public void setID_card(String ID_card) {
        this.ID_card = ID_card;
    }

    public String getPhone_code() {
        return phone_code;
    }

    public void setPhone_code(String phone_code) {
        this.phone_code = phone_code;
    }

    public String getID_photo() {
        return ID_photo;
    }

    public void setID_photo(String ID_photo) {
        this.ID_photo = ID_photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getAudit() {
        return audit;
    }

    public void setAudit(String audit) {
        this.audit = audit;
    }
}
