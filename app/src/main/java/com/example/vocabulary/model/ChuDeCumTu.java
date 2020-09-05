package com.example.vocabulary.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ChuDeCumTu implements Serializable {

    @SerializedName("IdChuDeCumTu")
    @Expose
    private String idChuDeCumTu;
    @SerializedName("TenChuDeCumTu")
    @Expose
    private String tenChuDeCumTu;
    @SerializedName("HinhChuDeCumTu")
    @Expose
    private String hinhChuDeCumTu;

    public String getIdChuDeCumTu() {
        return idChuDeCumTu;
    }

    public void setIdChuDeCumTu(String idChuDeCumTu) {
        this.idChuDeCumTu = idChuDeCumTu;
    }

    public String getTenChuDeCumTu() {
        return tenChuDeCumTu;
    }

    public void setTenChuDeCumTu(String tenChuDeCumTu) {
        this.tenChuDeCumTu = tenChuDeCumTu;
    }

    public String getHinhChuDeCumTu() {
        return hinhChuDeCumTu;
    }

    public void setHinhChuDeCumTu(String hinhChuDeCumTu) {
        this.hinhChuDeCumTu = hinhChuDeCumTu;
    }

}