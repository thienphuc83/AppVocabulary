package com.example.vocabulary.server;

import com.example.vocabulary.model.ChuDeCumTu;
import com.example.vocabulary.model.ChuDeTu;
import com.example.vocabulary.model.CumTu;
import com.example.vocabulary.model.Tu;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DataService {

    @GET("getallchudetu.php")
    Call<List<ChuDeTu>> GetAllChuDeTu();

    @GET("getallchudecumtu.php")
    Call<List<ChuDeCumTu>> GetAllChuDeCumTu();

    @FormUrlEncoded
    @POST("getalltu.php")
    Call<List<Tu>> GetAllTuTheoChuDe(@Field("idchudetu") String idchudetu);

    @FormUrlEncoded
    @POST("getallcumtu.php")
    Call<List<CumTu>> GetAllCumTuTheoChuDe(@Field("idchudecumtu") String idchudecumtu);

//    getallchudecumtu.php
//    getallcumtu.php
//    getalltu.php
//    getallchudetu.php
}
