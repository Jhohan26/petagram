package com.dfuentes.petgram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascotas> mascotas;
    private RecyclerView ListaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miappbar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ListaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        ListaMascotas.setLayoutManager(llm);

        inicializaMascotas();
        inicializaAdaptador();
    }

    public void inicializaAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        ListaMascotas.setAdapter(adaptador);
    }

    public void inicializaMascotas(){
        mascotas  = new ArrayList<Mascotas>();

        mascotas.add(new Mascotas("putin", R.drawable.recurso_1, "1"));
        mascotas.add(new Mascotas("machoman", R.drawable.recurso_2, "0"));
        mascotas.add(new Mascotas("rasputio", R.drawable.recurso_3, "2"));
        mascotas.add(new Mascotas("Aurelio", R.drawable.recurso_4, "5"));
        mascotas.add(new Mascotas("Gordi", R.drawable.recurso_5, "5"));
    }

    public void irFavoritos(View v){
        Intent intent = new Intent(this, Favorites.class);
        startActivity(intent);
    }
}
