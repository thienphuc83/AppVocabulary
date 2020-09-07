package com.example.vocabulary.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vocabulary.R;
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

public class TuTheoChuDeActivity extends AppCompatActivity {


    RecyclerView rvDSTutheochude;
    ImageView imgback;
    TextView tvtenchude, tvsotu;
    ArrayList<Tu> mangtu;
    ChuDeTu chuDeTu;

    AllTuAdapter allTuAdapter;
    public static int sotu = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tu_theo_chu_de);
        AnhXa();
        GetIntent();
        GetDataAllTu();

    }

    private void AnhXa() {
        rvDSTutheochude = findViewById(R.id.rvalltutheochude);
        imgback = findViewById(R.id.imgback);
        tvtenchude = findViewById(R.id.tvtenchude);
        tvsotu = findViewById(R.id.tvsotu);

        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void GetIntent() {
        Intent intent = getIntent();
        if (intent.hasExtra("idchudetu")) {
            chuDeTu = (ChuDeTu) intent.getSerializableExtra("idchudetu");
        }
        tvtenchude.setText(chuDeTu.getTenChuDeTu());
    }

    private void GetDataAllTu() {
        DataService dataService = APIService.getService();
        Call<List<Tu>> call = dataService.GetAllTuTheoChuDe(chuDeTu.getIdChuDeTu());
        call.enqueue(new Callback<List<Tu>>() {
            @Override
            public void onResponse(Call<List<Tu>> call, Response<List<Tu>> response) {
                mangtu = (ArrayList<Tu>) response.body();
//                Log.d("BBB", mangtu.get(0).getTu());
                allTuAdapter = new AllTuAdapter(TuTheoChuDeActivity.this,mangtu);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(TuTheoChuDeActivity.this);
                linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
                rvDSTutheochude.setLayoutManager(linearLayoutManager);
                rvDSTutheochude.setAdapter(allTuAdapter);
                sotu = mangtu.size();
                tvsotu.setText(sotu+" từ");

            }

            @Override
            public void onFailure(Call<List<Tu>> call, Throwable t) {

            }
        });
    }


}