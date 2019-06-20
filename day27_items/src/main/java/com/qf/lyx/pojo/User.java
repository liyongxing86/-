package com.qf.lyx.pojo;

/**
 * Created by Administrator on 2019/5/27 0027.
 */
public class User {
    private int id;//用户id
    private String name;//用户账号
    private String account;//用户名
    private String pw;//用户密码
    private String email;//用户email
    private String rank;//用户身份

    public User() {
    }

    public User(String name, String pw, String email, String rank) {
        this.name = name;
        this.pw = pw;
        this.email = email;
        this.rank = rank;
    }

    public User(String account, String name,  String pw, String email, String rank) {
        this.name = name;
        this.account = account;
        this.pw = pw;
        this.email = email;
        this.rank = rank;
    }

    public User(int id, String account, String name, String pw, String email, String rank) {
        this.id = id;
        this.name = name;
        this.account = account;
        this.pw = pw;
        this.email = email;
        this.rank = rank;
    }


}
