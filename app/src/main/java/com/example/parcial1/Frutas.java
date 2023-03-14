package com.example.parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.parcial1.db.DbContactos;

public class Frutas extends AppCompatActivity {

    TextView user;
    EditText producto, precio;
    Button btn_guardar;
    Button btn_ver;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frutas);

        user = findViewById(R.id.user);
        producto = findViewById(R.id.producto);
        precio = findViewById(R.id.precio);
        btn_guardar = findViewById(R.id.btn_guardar);
        btn_ver = findViewById(R.id.btn_verr);

        btn_ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Frutas.this, Ver.class);
                startActivity(intent);
            }
        });

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbContactos dbContactos = new DbContactos(Frutas.this);
                long id = dbContactos.insetarContacto(user.getText().toString(), producto.getText().toString(), Double.parseDouble(precio.getText().toString()));
                if (id > 0) {
                    Toast.makeText(Frutas.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                    limpiar();
                } else {
                    Toast.makeText(Frutas.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
        private void limpiar(){
            user.setText("");
            precio.setText("");
            producto.setText("");
        }
    }
