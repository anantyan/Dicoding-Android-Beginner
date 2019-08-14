package com.google.myrecyclerview.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.myrecyclerview.Components.HeroComponent;
import com.google.myrecyclerview.R;

import java.util.ArrayList;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.ViewHolder> {

    private ArrayList<HeroComponent> records;

    public HeroAdapter(ArrayList<HeroComponent> records){
        this.records = records;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView photoHero;
        TextView txtNameHero;
        TextView txtDeskripsiHero;
        Button btnDetailMain;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            photoHero = itemView.findViewById(R.id.photo_hero);
            txtNameHero = itemView.findViewById(R.id.txt_name_hero);
            txtDeskripsiHero = itemView.findViewById(R.id.txt_deskripsi_hero);
            btnDetailMain = itemView.findViewById(R.id.btn_detail_main);
        }
    }

    @NonNull
    @Override
    public HeroAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_main, viewGroup, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final HeroAdapter.ViewHolder viewHolder, int i) {
        HeroComponent heroComponent = records.get(i);
        Glide.with(viewHolder.itemView.getContext())
                .load(heroComponent.getPhoto())
                .apply(new RequestOptions().override(56, 56))
                .into(viewHolder.photoHero);

        viewHolder.txtNameHero.setText(heroComponent.getName());
        viewHolder.txtDeskripsiHero.setText(heroComponent.getDeskripsi());
        viewHolder.btnDetailMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = records.get(viewHolder.getAdapterPosition()).getName();
                Toast.makeText(viewHolder.itemView.getContext(), name, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return records.size();
    }
}
