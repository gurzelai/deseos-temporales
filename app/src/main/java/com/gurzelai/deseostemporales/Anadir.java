package com.gurzelai.deseostemporales;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class Anadir extends AppCompatActivity {

    ListaDeseos lista;
    EditText nombre, descripcion, diaAviso, precio;
    Button aceptar, volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir);

        lista = (ListaDeseos) getIntent().getSerializableExtra("lista");
        nombre = (EditText) findViewById(R.id.etnombre);
        descripcion = (EditText) findViewById(R.id.etdescripcion);
        diaAviso = (EditText) findViewById(R.id.etDiaAviso);
        diaAviso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirDialogoFecha();
            }
        });
        precio = (EditText) findViewById(R.id.etPrecio);
        volver = (Button) findViewById(R.id.btnvolver);
        aceptar = (Button)findViewById(R.id.btnañadir);
        volver.setOnClickListener(view -> finish());
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Deseo d = new Deseo(nombre.getText().toString(), descripcion.getText().toString(), diaAviso.getText().toString(), (precio.getText().toString().equals(""))? 0 : Double.valueOf(precio.getText().toString()));
                Intent resultIntent = new Intent(String.valueOf(getApplicationContext()));
                resultIntent.putExtra("nuevoDeseo", d);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });

    }
    private void abrirDialogoFecha() {
        DialogoCalendario newFragment = DialogoCalendario.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 because January is zero
                final String selectedDate = day + " / " + (month+1) + " / " + year;
                diaAviso.setText(selectedDate);
            }
        });
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
}