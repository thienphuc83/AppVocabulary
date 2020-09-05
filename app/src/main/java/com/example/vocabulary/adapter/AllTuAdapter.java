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
import com.example.vocabulary.model.Tu;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AllTuAdapter extends RecyclerView.Adapter<AllTuAdapter.ViewHolder> {

    Context context;
    ArrayList<Tu> tuArrayList;

    public AllTuAdapter(Context context, ArrayList<Tu> tuArrayList) {
        this.context = context;
        this.tuArrayList = tuArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.dong_tu, parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tu tu = tuArrayList.get(position);
        holder.tvtu.setText(tu.getTu());
        holder.tvphatam.setText(tu.getPhatAm());
        holder.tvnghia.setText(tu.getNghiaTu());
        Picasso.with(context).load(tu.getHinhTu()).into(holder.imgtu);
    }

    @Override
    public int getItemCount() {
        return tuArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgtu;
        TextView tvtu, tvphatam, tvnghia;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgtu = itemView.findViewById(R.id.imgtu);
            tvtu = itemView.findViewById(R.id.tvtu);
            tvphatam = itemView.findViewById(R.id.tvphatam);
            tvnghia = itemView.findViewById(R.id.tvnghiatu);
        }
    }
}
