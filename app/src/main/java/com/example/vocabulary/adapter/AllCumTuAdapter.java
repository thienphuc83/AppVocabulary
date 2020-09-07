package com.example.vocabulary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vocabulary.R;
import com.example.vocabulary.model.CumTu;

import java.util.ArrayList;

public class AllCumTuAdapter extends RecyclerView.Adapter<AllCumTuAdapter.ViewHolder> {

    Context context;
    ArrayList<CumTu> cumTuArrayList;

    public AllCumTuAdapter(Context context, ArrayList<CumTu> cumTuArrayList) {
        this.context = context;
        this.cumTuArrayList = cumTuArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.dong_cumtu,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CumTu cumTu = cumTuArrayList.get(position);
        holder.tvCumtu.setText(cumTu.getCumTu());
        holder.tvNghiacumtu.setText(cumTu.getNghiaCumTu());
    }

    @Override
    public int getItemCount() {
        return cumTuArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvCumtu, tvNghiacumtu,tvstt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCumtu =itemView.findViewById(R.id.tvcumtu);
            tvNghiacumtu = itemView.findViewById(R.id.tvnghiacumtu);
        }
    }

}
