
package com.bartech.pss.sa.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DatumBranch implements Serializable
{

    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("NameAr")
    @Expose
    private String nameAr;
    @SerializedName("NameEn")
    @Expose
    private String nameEn;
    private final static long serialVersionUID = -1299720947267512593L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameAr() {
        return nameAr;
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    @Override
    public String toString() {
        return nameAr.toString();
    }
}
