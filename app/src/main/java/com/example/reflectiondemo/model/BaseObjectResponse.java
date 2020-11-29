package com.example.reflectiondemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class BaseObjectResponse implements Serializable {

    @SerializedName("rows")
    @Expose
    public List<BusinessCardEntity> rows = null;
    @SerializedName("statusCode")
    @Expose
    private String statusCode;
    @SerializedName("totalRecords")
    @Expose
    private Integer totalRecords;
    @SerializedName("totalDisplayRecords")
    @Expose
    private Integer totalDisplayRecords;

    public List<BusinessCardEntity> getRows() {
        return rows;
    }

    public void setRows(List<BusinessCardEntity> rows) {
        this.rows = rows;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

    public Integer getTotalDisplayRecords() {
        return totalDisplayRecords;
    }

    public void setTotalDisplayRecords(Integer totalDisplayRecords) {
        this.totalDisplayRecords = totalDisplayRecords;
    }
}
