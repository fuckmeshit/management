package com.example.management.entity;

import javax.persistence.*;

/**
 * @author 25097
 * 设置了movie的id，电影名，电影信息，电影类别等这几个信息，实际数据库后期需要更换
 * @Date 2022/2/1今天尝试完成一些后台的数据返回的工作
 */
@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mo_id")
    int id;
    @Column(name = "mo_name")
    String mvname;
    @Column(name = "mo_information")
    String mvinformation;
    @Column(name = "mo_type")
    String mvtype;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMvname() {
        return mvname;
    }

    public void setMvname(String mvname) {
        this.mvname = mvname;
    }

    public String getMvinformation() {
        return mvinformation;
    }

    public void setMvinformation(String mvinformation) {
        this.mvinformation = mvinformation;
    }

    public String getMvtype() {
        return mvtype;
    }

    public void setMvtype(String mvtype) {
        this.mvtype = mvtype;
    }
}
