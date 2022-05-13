package com.cb.apiandroid;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cb.apiandroid.modelo.MyApiRetrofit;
import com.cb.apiandroid.modelo.Pokemon;
import com.cb.apiandroid.modelo.PokemonAdapter;
import com.cb.apiandroid.modelo.ResultPokemon;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    PokemonAdapter pokemonAdapter;
    ArrayList<Pokemon> pokemonArrayList = new ArrayList<Pokemon>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        getPokemon();
    }

    public void getPokemon() {
        final Call<ResultPokemon> obj = MyApiRetrofit.getApiService().getPokemon();

        obj.enqueue(new Callback<ResultPokemon>() {
            @Override
            public void onResponse(Call<ResultPokemon> call, Response<ResultPokemon> response) {


                Log.v("array", "size" + response);


                pokemonArrayList = response.body().getResults();

                if (pokemonArrayList.size() > 0) {
                    mostarDatos(pokemonArrayList);
                }

            }

            @Override
            public void onFailure(Call<ResultPokemon> call, Throwable t) {
                Log.v("error", t.getMessage() + "");


            }
        });

    }


    private void mostarDatos(ArrayList<Pokemon> pokemonArrayList) {

        pokemonAdapter = new PokemonAdapter(getApplicationContext(), pokemonArrayList);
        pokemonAdapter.notifyDataSetChanged();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(pokemonAdapter);
        pokemonAdapter.notifyDataSetChanged();

    }
}