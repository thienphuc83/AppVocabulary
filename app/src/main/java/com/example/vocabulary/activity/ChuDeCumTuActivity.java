package com.example.vocabulary.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.vocabulary.R;
import com.example.vocabulary.adapter.AllChuDeCumTuAdapter;
import com.example.vocabulary.model.ChuDeCumTu;
import com.example.vocabulary.server.APIService;
import com.example.vocabulary.server.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChuDeCumTuActivity extends AppCompatActivity {

    ImageView imgback;
    RecyclerView rvAllchude;
    ArrayList<ChuDeCumTu> mangchudecumtu;
    AllChuDeCumTuAdapter allChuDeCumTuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chu_de_cum_tu);
        AnhXa();
        GetData();

    }

    private void GetData() {
        DataService dataService = APIService.getService();
        Call<List<ChuDeCumTu>> call = dataService.GetAllChuDeCumTu();
        call.enqueue(new Callback<List<ChuDeCumTu>>() {
            @Override
            public void onResponse(Call<List<ChuDeCumTu>> call, Response<List<ChuDeCumTu>> response) {
                mangchudecumtu = (ArrayList<ChuDeCumTu>) response.body();
//                Log.d("CCC", mangchudecumtu.get(0).getTenChuDeCumTu());
                allChuDeCumTuAdapter = new AllChuDeCumTuAdapter(ChuDeCumTuActivity.this, mangchudecumtu);
                LinearLayoutManager layoutManager = new LinearLayoutManager(ChuDeCumTuActivity.this);
                layoutManager.setOrientation(RecyclerView.VERTICAL);
                rvAllchude.setLayoutManager(layoutManager);
                rvAllchude.setAdapter(allChuDeCumTuAdapter);

            }

            @Override
            public void onFailure(Call<List<ChuDeCumTu>> call, Throwable t) {

            }
        });

    }

    private void AnhXa() {
        imgback = findViewById(R.id.imgbackchudecumtu);
        rvAllchude = findViewById(R.id.rvallchudecumtu);

        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}