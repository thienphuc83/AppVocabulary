package com.example.vocabulary.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ChuDeTu implements Serializable {

    @SerializedName("IdChuDeTu")
    @Expose
    private String idChuDeTu;
    @SerializedName("TenChuDeTu")
    @Expose
    private String tenChuDeTu;
    @SerializedName("HinhChuDeTu")
    @Expose
    private String hinhChuDeTu;

    public String getIdChuDeTu() {
        return idChuDeTu;
    }

    public void setIdChuDeTu(String idChuDeTu) {
        this.idChuDeTu = idChuDeTu;
    }

    public String getTenChuDeTu() {
        return tenChuDeTu;
    }

    public void setTenChuDeTu(String tenChuDeTu) {
        this.tenChuDeTu = tenChuDeTu;
    }

    public String getHinhChuDeTu() {
        return hinhChuDeTu;
    }

    public void setHinhChuDeTu(String hinhChuDeTu) {
        this.hinhChuDeTu = hinhChuDeTu;
    }

}