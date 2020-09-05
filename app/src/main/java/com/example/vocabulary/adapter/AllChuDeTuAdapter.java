package com.example.vocabulary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vocabulary.R;
import com.example.vocabulary.model.ChuDeTu;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AllChuDeTuAdapter extends RecyclerView.Adapter<AllChuDeTuAdapter.ViewHolder> {

    Context context;
    ArrayList<ChuDeTu> chuDeTuArrayList;

    public AllChuDeTuAdapter(Context context, ArrayList<ChuDeTu> chuDeTuArrayList) {
        this.context = context;
        this.chuDeTuArrayList = chuDeTuArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view =layoutInflater.inflate(R.layout.dong_chudetu,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ChuDeTu chuDeTu = chuDeTuArrayList.get(position);
        holder.tvTenchudetu.setText(chuDeTu.getTenChuDeTu());
        Picasso.with(context).load(chuDeTu.getHinhChuDeTu()).into(holder.imgChudetu);
    }

    @Override
    public int getItemCount() {
        return chuDeTuArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvTenchudetu;
        ImageView imgChudetu;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTenchudetu = itemView.findViewById(R.id.tvtenchudetu);
            imgChudetu = itemView.findViewById(R.id.imgchudetu);
        }
    }
}
