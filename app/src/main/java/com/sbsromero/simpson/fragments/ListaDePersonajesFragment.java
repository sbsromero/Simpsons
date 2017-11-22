package com.sbsromero.simpson.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.sbsromero.simpson.R;
import com.sbsromero.simpson.utils.AdaptadorDePersonaje;
import com.sbsromero.simpson.vo.Personaje;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaDePersonajesFragment extends Fragment implements AdaptadorDePersonaje.OnClickAdaptadorDePersonaje{

    public AdaptadorDePersonaje adaptador;
    public RecyclerView listadoPersonajes;
    private OnPersonajeSeleccionadoListener listener;
    private List<Personaje> personajes;

    public ListaDePersonajesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity;
        if (context instanceof Activity){
            activity = (Activity) context;
            try {
                listener = (OnPersonajeSeleccionadoListener) activity;
            } catch (ClassCastException e) {
                throw new ClassCastException(activity.toString() + " debe implementar la interfaz OnPersonajeSeleccionadoListener");
            }
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listadoPersonajes = (RecyclerView) getView().findViewById(R.id.listaPersonajes);

        adaptador = new AdaptadorDePersonaje(personajes,this);
        listadoPersonajes.setAdapter(adaptador);
        listadoPersonajes.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lista_de_personajes, container, false);
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_agregar) {
            personajes.add(0, new Personaje("Nuevo personaje", new
                    Date()));
            adaptador.notifyItemInserted(0);
        }
        if (id == R.id.menu_eliminar) {
            personajes.remove(0);
            adaptador.notifyItemRemoved(0);
        }
        if (id == R.id.menu_modificar) {
            Personaje aux = personajes.get(1);
            personajes.set(1,personajes.get(2));
            personajes.set(2, aux);
            adaptador.notifyItemMoved(1, 2);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClickPosition(int pos) {
        listener.onPersonajeSeleccionado(pos);
    }

    public interface OnPersonajeSeleccionadoListener {
        void onPersonajeSeleccionado(int position);
    }

    public void setPersonajes(List<Personaje> personajes) {
        this.personajes = personajes;
    }
}
