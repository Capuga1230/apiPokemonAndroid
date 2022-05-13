package com.cb.apiandroid.modelo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cb.apiandroid.R;
import com.squareup.picasso.Picasso;

import java.util.List;


public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {

    private Context context;
    private List<Pokemon> PokemonList;


    public PokemonAdapter(Context context, List<Pokemon> nameList) {
        super();
        this.context = context;
        this.PokemonList = nameList;


    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list, viewGroup, false);
        return new PokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        String nombre = "" + PokemonList.get(position).getName();
        String url = "" + PokemonList.get(position).getUrl();

        String[] urlPartes = url.split("/");
        int numPokemon = Integer.parseInt(urlPartes[urlPartes.length - 1]);


        String urlPokemon = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/" + numPokemon + ".png";

        Picasso.with(context)
                .load(urlPokemon)
                .placeholder(R.drawable.pokeball)
                .error(R.drawable.pokeball)
                .into(holder.img);


        holder.name.setText("Pokemon: " + nombre);


    }

    @Override
    public int getItemCount() {
        return PokemonList.size();
    }


    class PokemonViewHolder extends RecyclerView.ViewHolder {


        private ImageView img;
        private TextView name;

        PokemonViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
        }
    }


}