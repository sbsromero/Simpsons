package com.sbsromero.simpson.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.sbsromero.simpson.R;
import com.sbsromero.simpson.fragments.DetalleDePersonajeFragment;
import com.sbsromero.simpson.fragments.ListaDePersonajesFragment;
import com.sbsromero.simpson.utils.AdaptadorDePersonaje;
import com.sbsromero.simpson.utils.Util;
import com.sbsromero.simpson.vo.Personaje;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SimpsonActivity extends AppCompatActivity implements ListaDePersonajesFragment.OnPersonajeSeleccionadoListener{


    public List<Personaje> personajes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Util.obtenerLenguaje(this);
        setContentView(R.layout.activity_simpson);
        personajes = new ArrayList();
        personajes.add(new Personaje("Sebas",new Date()));
        personajes.add(new Personaje("Simpson1",new Date()));
        personajes.add(new Personaje("Simpson2",new Date()));
        personajes.add(new Personaje("Simpson3",new Date()));
        ListaDePersonajesFragment listaDePersonajesFragment = (ListaDePersonajesFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragmento_lista_personajes);
        listaDePersonajesFragment.setPersonajes(personajes);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPersonajeSeleccionado(int position) {
        Intent intent = new Intent(this, DetalleDePersonajeActivity.class);
        intent.putExtra("personaje",personajes.get(position));
        startActivity(intent);
    }
}
