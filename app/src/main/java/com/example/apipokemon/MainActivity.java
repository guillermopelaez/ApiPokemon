package com.example.apipokemon;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.apipokemon.Model.ListaPokemonAdapter;
import com.example.apipokemon.Model.Pokemon;
import com.example.apipokemon.Model.PokemonRespuesta;
import com.example.apipokemon.Model.PokemonService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    private Retrofit retrofit;
    private static final String TAG = "Pokedex";
    private RecyclerView recyclerView;
    private ListaPokemonAdapter listaPokemonAdapter;

    private int offset;
    private boolean aptoParaCargar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        listaPokemonAdapter = new ListaPokemonAdapter(this);
        recyclerView.setAdapter(listaPokemonAdapter);
        recyclerView.setHasFixedSize(true);


        final GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy > 0){
                    int visibleItemCount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();
                    int pastVisibleItems = layoutManager.findFirstCompletelyVisibleItemPosition();


                }
            }
        });

        retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        obtenerDatos();



    }

    private void obtenerDatos() {
        PokemonService service = retrofit.create(PokemonService.class);
        Call<PokemonRespuesta> pokemonRespuestaCall = service.obtenerListaPokemon(20);


pokemonRespuestaCall.enqueue(new Callback<PokemonRespuesta>() {
    @Override
    public void onResponse(Call<PokemonRespuesta> call, Response<PokemonRespuesta> response) {
        PokemonRespuesta pokemonRespuesta = response.body();
        ArrayList<Pokemon> listaPokemon = pokemonRespuesta.getResults();
    }

    @Override
    public void onFailure(Call<PokemonRespuesta> call, Throwable t) {

    }
});
    }
}
