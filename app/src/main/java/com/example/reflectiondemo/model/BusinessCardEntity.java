package com.example.reflectiondemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class BusinessCardEntity implements Serializable {

    @SerializedName("pid")
    @Expose
    public String pid;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("className")
    @Expose
    public String className;
    @SerializedName("tittle")
    @Expose
    public String tittle;
    @SerializedName("tittleColor")
    @Expose
    public String tittleColor;

    @SerializedName("user_details")
    @Expose
    public UserDetails userDetails;

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getTittleColor() {
        return tittleColor;
    }

    public void setTittleColor(String tittleColor) {
        this.tittleColor = tittleColor;
    }
}