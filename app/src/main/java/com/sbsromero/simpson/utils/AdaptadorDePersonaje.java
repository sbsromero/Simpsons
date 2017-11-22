package com.sbsromero.simpson.utils;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.sbsromero.simpson.R;
import com.sbsromero.simpson.fragments.ListaDePersonajesFragment;
import com.sbsromero.simpson.vo.Personaje;

import java.util.List;

/**
 * Created by sumset on 22/11/17.
 */

public class AdaptadorDePersonaje extends RecyclerView.Adapter<AdaptadorDePersonaje.PersonajeViewHolder> {

    public static List<Personaje> personajes;
    private static OnClickAdaptadorDePersonaje listener;

    public AdaptadorDePersonaje(List<Personaje> personajes, ListaDePersonajesFragment listaDePersonajesFragment) {
        this.personajes = personajes;
        listener = (OnClickAdaptadorDePersonaje) listaDePersonajesFragment;
    }


    @Override
    public PersonajeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.resument_personaje, parent, false);
        PersonajeViewHolder peliculaVH = new
                PersonajeViewHolder(itemView);
        return peliculaVH;
    }

    @Override
    public void onBindViewHolder(PersonajeViewHolder holder, int position) {
        Personaje personaje = personajes.get(position);
        holder.binPersonaje(personaje);
    }

    @Override
    public int getItemCount() {
        return personajes.size();
    }

    public static class PersonajeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView txtNombrePresonaje;
        private TextView txtFechaNacimiento;

        public PersonajeViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtNombrePresonaje = (TextView)
                    itemView.findViewById(R.id.nombre);
            txtFechaNacimiento = (TextView)
                    itemView.findViewById(R.id.fecha_nacimiento);
        }

        public void binPersonaje(Personaje personaje) {
            txtNombrePresonaje.setText(personaje.getNombre());

            txtFechaNacimiento.setText(personaje.getFecha().toString());
        }

        @Override
        public void onClick(View view) {
            listener.onClickPosition(getAdapterPosition());
        }
    }

    public interface OnClickAdaptadorDePersonaje{
        void onClickPosition(int pos);
    }
}
