package com.example.vocabulary.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vocabulary.R;
import com.example.vocabulary.activity.CumTuTheoChuDeActivity;
import com.example.vocabulary.model.ChuDeCumTu;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AllChuDeCumTuAdapter extends RecyclerView.Adapter<AllChuDeCumTuAdapter.ViewHolder> {

    Context context;
    ArrayList<ChuDeCumTu> chuDeCumTuArrayList;

    public AllChuDeCumTuAdapter(Context context, ArrayList<ChuDeCumTu> chuDeCumTuArrayList) {
        this.context = context;
        this.chuDeCumTuArrayList = chuDeCumTuArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.dong_chudecumtu,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ChuDeCumTu chuDeCumTu = chuDeCumTuArrayList.get(position);
        holder.tvTenchudecumtu.setText(chuDeCumTu.getTenChuDeCumTu());
        Picasso.with(context).load(chuDeCumTu.getHinhChuDeCumTu()).into(holder.imgChudecumtu);
    }

    @Override
    public int getItemCount() {
        return chuDeCumTuArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvTenchudecumtu;
        ImageView imgChudecumtu;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTenchudecumtu = itemView.findViewById(R.id.tvtenchudecumtu);
            imgChudecumtu = itemView.findViewById(R.id.imgchudecumtu);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =new Intent(context, CumTuTheoChuDeActivity.class);
                    intent.putExtra("idchudecumtu", chuDeCumTuArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
