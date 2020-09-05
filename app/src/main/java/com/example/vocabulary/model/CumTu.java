package com.example.vocabulary.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CumTu implements Serializable {

    @SerializedName("IdCumTu")
    @Expose
    private String idCumTu;
    @SerializedName("CumTu")
    @Expose
    private String cumTu;
    @SerializedName("NghiaCumTu")
    @Expose
    private String nghiaCumTu;
    @SerializedName("IdChuDeCumTu")
    @Expose
    private String idChuDeCumTu;

    public String getIdCumTu() {
        return idCumTu;
    }

    public void setIdCumTu(String idCumTu) {
        this.idCumTu = idCumTu;
    }

    public String getCumTu() {
        return cumTu;
    }

    public void setCumTu(String cumTu) {
        this.cumTu = cumTu;
    }

    public String getNghiaCumTu() {
        return nghiaCumTu;
    }

    public void setNghiaCumTu(String nghiaCumTu) {
        this.nghiaCumTu = nghiaCumTu;
    }

    public String getIdChuDeCumTu() {
        return idChuDeCumTu;
    }

    public void setIdChuDeCumTu(String idChuDeCumTu) {
        this.idChuDeCumTu = idChuDeCumTu;
    }

}