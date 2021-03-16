package com.gurzelai.deseostemporales;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final int CODE_AÑADIR = 1;
    ListView lvDeseos;
    FloatingActionButton btnañadir;
    ListaDeseos listaDeseos;
    AdaptadorDeseo adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();
        lvDeseos = (ListView) findViewById(R.id.lvDeseos);
        lvDeseos.setAdapter(adaptador = new AdaptadorDeseo(getApplicationContext(),R.layout.activity_adaptador_deseo, (ArrayList<Deseo>) listaDeseos.getLista()));
        btnañadir = (FloatingActionButton) findViewById(R.id.btnañadir);
        btnañadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Anadir.class);
                intent.putExtra("lista", listaDeseos);
                startActivityForResult(intent, CODE_AÑADIR);
            }
        });

    }

    private void inicializar() {
        listaDeseos = new ListaDeseos();
        listaDeseos.add(new Deseo("Parapente", "", "03/05/2021", 3.5));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case (CODE_AÑADIR): {
                if (resultCode == Activity.RESULT_OK) {
                    Deseo nuevoDeseo = (Deseo) data.getSerializableExtra("nuevoDeseo");
                    listaDeseos.add(nuevoDeseo);
                    adaptador.notifyDataSetChanged();
                    break;
                }
            }
        }
    }
}