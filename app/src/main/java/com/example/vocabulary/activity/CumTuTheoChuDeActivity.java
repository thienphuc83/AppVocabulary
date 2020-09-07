package com.example.vocabulary.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vocabulary.R;
import com.example.vocabulary.adapter.AllChuDeCumTuAdapter;
import com.example.vocabulary.adapter.AllCumTuAdapter;
import com.example.vocabulary.model.ChuDeCumTu;
import com.example.vocabulary.model.CumTu;
import com.example.vocabulary.server.APIService;
import com.example.vocabulary.server.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CumTuTheoChuDeActivity extends AppCompatActivity {

    TextView tvtenchude;
    ImageView imgback;
    RecyclerView rv;
    AllCumTuAdapter allCumTuAdapter;
    ArrayList<CumTu> mangcumtu;
    ChuDeCumTu chuDeCumTu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cum_tu_theo_chu_de);
        AnhXa();
        GetIntent();
        GetData();

    }

    private void GetData() {
        DataService dataService = APIService.getService();
        Call<List<CumTu>> call = dataService.GetAllCumTuTheoChuDe(chuDeCumTu.getIdChuDeCumTu());
        call.enqueue(new Callback<List<CumTu>>() {
            @Override
            public void onResponse(Call<List<CumTu>> call, Response<List<CumTu>> response) {
                mangcumtu = (ArrayList<CumTu>) response.body();
//                Log.d("VVV", mangcumtu.get(0).getCumTu());
                allCumTuAdapter = new AllCumTuAdapter(CumTuTheoChuDeActivity.this, mangcumtu);
                LinearLayoutManager layoutManager =new LinearLayoutManager(CumTuTheoChuDeActivity.this);
                layoutManager.setOrientation(RecyclerView.VERTICAL);
                rv.setLayoutManager(layoutManager);
                rv.setAdapter(allCumTuAdapter);
            }

            @Override
            public void onFailure(Call<List<CumTu>> call, Throwable t) {

            }
        });
    }

    private void GetIntent() {
        Intent intent = getIntent();
        if (intent.hasExtra("idchudecumtu")){
            chuDeCumTu = (ChuDeCumTu) intent.getSerializableExtra("idchudecumtu");

        }
        tvtenchude.setText(chuDeCumTu.getTenChuDeCumTu());

    }

    private void AnhXa() {
        tvtenchude = findViewById(R.id.tvtenchudecumtu);
        imgback = findViewById(R.id.imgbacktenchudecumtu);
        rv = findViewById(R.id.rvallcumtutheochude);

        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}