package com.example.vocabulary.server;

import com.example.vocabulary.model.ChuDeTu;
import com.example.vocabulary.model.Tu;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataService {

    @GET("getallchudetu.php")
    Call<List<ChuDeTu>> GetAllChuDeTu();

    @GET("getalltu.php")
    Call<List<Tu>> GetAllTu();

//    getallchudecumtu.php
//    getallcumtu.php
//    getalltu.php
//    getallchudetu.php
}
