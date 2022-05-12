package com.cb.apiandroid;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.cb.apiandroid.modelo.MyApiRetrofit;
import com.cb.apiandroid.modelo.Pokemon;
import com.cb.apiandroid.modelo.ResultPokemon;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    TextView nomre_pokemon;
    ArrayList<Pokemon> pokemonArrayList = new ArrayList<Pokemon>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomre_pokemon = (TextView) findViewById(R.id.nomre_pokemon);

        getPokemon();
    }

    public void getPokemon() {
        final Call<ResultPokemon> obj = MyApiRetrofit.getApiService().getPokemon();

        obj.enqueue(new Callback<ResultPokemon>() {
            @Override
            public void onResponse(Call<ResultPokemon> call, Response<ResultPokemon> response) {


                Log.v("array", "size" + response);

                pokemonArrayList = response.body().getResults();

                nomre_pokemon.setText(pokemonArrayList.get(0).getName());

            }

            @Override
            public void onFailure(Call<ResultPokemon> call, Throwable t) {
                Log.v("error", t.getMessage() + "");


            }
        });

    }
}