package com.sbsromero.simpson.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sbsromero.simpson.R;
import com.sbsromero.simpson.fragments.DetalleDePersonajeFragment;
import com.sbsromero.simpson.vo.Personaje;

public class DetalleDePersonajeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_de_personaje);

        DetalleDePersonajeFragment detallePersonaje = (DetalleDePersonajeFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_personaje
                );
        Personaje personaje = (Personaje) getIntent().getExtras().get("personaje");
        detallePersonaje.mostrarPersonaje(personaje);
    }
}
