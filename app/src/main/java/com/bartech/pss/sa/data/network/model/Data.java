
package com.bartech.pss.sa.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Data implements Serializable
{

    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("Company")
    @Expose
    private Integer company;
    @SerializedName("Branch")
    @Expose
    private Integer branch;
    @SerializedName("Code")
    @Expose
    private Object code;
    @SerializedName("ArabicDescription")
    @Expose
    private String arabicDescription;
    @SerializedName("EnglishDescription")
    @Expose
    private String englishDescription;
    private final static long serialVersionUID = -4322484203834877415L;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public Integer getCompany() {
        return company;
    }

    public void setCompany(Integer company) {
        this.company = company;
    }

    public Integer getBranch() {
        return branch;
    }

    public void setBranch(Integer branch) {
        this.branch = branch;
    }

    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
        this.code = code;
    }

    public String getArabicDescription() {
        return arabicDescription;
    }

    public void setArabicDescription(String arabicDescription) {
        this.arabicDescription = arabicDescription;
    }

    public String getEnglishDescription() {
        return englishDescription;
    }

    public void setEnglishDescription(String englishDescription) {
        this.englishDescription = englishDescription;
    }

}
