package com.sbsromero.simpson.fragments;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sbsromero.simpson.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AgregarPersonajeFragment extends DialogFragment {


    public AgregarPersonajeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getDialog().setTitle("Agregar Personaje");
        return inflater.inflate(R.layout.fragment_agregar_personaje, container, false);
    }

}
