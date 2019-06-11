package com.example.apipokemon.Model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.apipokemon.R;

import java.util.ArrayList;
import java.util.concurrent.RecursiveAction;

public class ListaPokemonAdapter  extends RecyclerView.Adapter<ListaPokemonAdapter.ViewHolder> {
    private ArrayList<Pokemon> dataset;
    private Context context;
    private Pokemon p;


    public ListaPokemonAdapter(Context context){
        this.context = context;
        dataset = new ArrayList<>();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
            p = dataset.get(i);
            viewHolder.nombreTextView.setText(p.getName());
        Glide.with(context)
                .load("http://pokeapi.co/media/sprites/pokemon/"+p.getNum()+".png")
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(viewHolder.fotoImageView);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView fotoImageView;
        private TextView nombreTextView;
        private CardView tarjetas;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            fotoImageView = (ImageView) itemView.findViewById(R.id.fotoImageView);
            nombreTextView = (TextView) itemView.findViewById(R.id.nombreTextView);
            tarjetas = (CardView) itemView.findViewById(R.id.tarjetas);
        }

    }
}

