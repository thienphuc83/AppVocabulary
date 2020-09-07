package com.example.vocabulary.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.vocabulary.R;
import com.example.vocabulary.adapter.AllChuDeTuAdapter;
import com.example.vocabulary.adapter.AllTuAdapter;
import com.example.vocabulary.model.ChuDeTu;
import com.example.vocabulary.model.Tu;
import com.example.vocabulary.server.APIService;
import com.example.vocabulary.server.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    Button btnCumtu;
    RecyclerView rvDSChudetu;
    ArrayList<ChuDeTu> mangchudetu;
    AllChuDeTuAdapter allChuDeTuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        GetDataAllChuDeTu();
        OnClick();

    }

    private void OnClick() {
        btnCumtu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ChuDeCumTuActivity.class));
            }
        });
    }

    private void GetDataAllChuDeTu() {
        DataService dataService = APIService.getService();
        Call<List<ChuDeTu>> callback = dataService.GetAllChuDeTu();
        callback.enqueue(new Callback<List<ChuDeTu>>() {
            @Override
            public void onResponse(Call<List<ChuDeTu>> call, Response<List<ChuDeTu>> response) {
                mangchudetu = (ArrayList<ChuDeTu>) response.body();
//                Log.d("AAA", mangchudetu.get(0).getTenChuDeTu());
                allChuDeTuAdapter = new AllChuDeTuAdapter(MainActivity.this, mangchudetu);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
                linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
                rvDSChudetu.setLayoutManager(linearLayoutManager);
                rvDSChudetu.setAdapter(allChuDeTuAdapter);

            }

            @Override
            public void onFailure(Call<List<ChuDeTu>> call, Throwable t) {

            }
        });
    }

    private void AnhXa() {
        rvDSChudetu = findViewById(R.id.rvallchudetu);
//        rvDSTu = findViewById(R.id.rvalltu);
        btnCumtu = findViewById(R.id.btncumtu);
    }
}