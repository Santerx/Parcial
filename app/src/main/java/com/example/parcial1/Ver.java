package com.example.parcial1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.parcial1.adaptadores.ListaContactosAdapter;
import com.example.parcial1.db.DbContactos;
import com.example.parcial1.entidades.Contactos;

import java.util.ArrayList;

public class Ver extends AppCompatActivity {

    RecyclerView listaContactos;
    ArrayList<Contactos> listaArrayContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver);

        listaContactos = findViewById(R.id.listaContactos);

        listaContactos.setLayoutManager(new LinearLayoutManager(this));

        DbContactos dbContactos = new DbContactos(Ver.this);

        listaArrayContactos = new ArrayList<>();

        ListaContactosAdapter adapter = new ListaContactosAdapter(dbContactos.mostrarContactos());
        listaContactos.setAdapter(adapter);
    }
}