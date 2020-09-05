package com.example.vocabulary.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Tu implements Serializable {

    @SerializedName("IdTu")
    @Expose
    private String idTu;
    @SerializedName("Tu")
    @Expose
    private String tu;
    @SerializedName("NghiaTu")
    @Expose
    private String nghiaTu;
    @SerializedName("PhatAm")
    @Expose
    private String phatAm;
    @SerializedName("HinhTu")
    @Expose
    private String hinhTu;
    @SerializedName("IdChuDeTu")
    @Expose
    private String idChuDeTu;

    public String getIdTu() {
        return idTu;
    }

    public void setIdTu(String idTu) {
        this.idTu = idTu;
    }

    public String getTu() {
        return tu;
    }

    public void setTu(String tu) {
        this.tu = tu;
    }

    public String getNghiaTu() {
        return nghiaTu;
    }

    public void setNghiaTu(String nghiaTu) {
        this.nghiaTu = nghiaTu;
    }

    public String getPhatAm() {
        return phatAm;
    }

    public void setPhatAm(String phatAm) {
        this.phatAm = phatAm;
    }

    public String getHinhTu() {
        return hinhTu;
    }

    public void setHinhTu(String hinhTu) {
        this.hinhTu = hinhTu;
    }

    public String getIdChuDeTu() {
        return idChuDeTu;
    }

    public void setIdChuDeTu(String idChuDeTu) {
        this.idChuDeTu = idChuDeTu;
    }

}