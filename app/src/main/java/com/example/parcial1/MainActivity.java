package com.example.parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.parcial1.db.DbContactos;
import com.example.parcial1.db.DbHelper;

public class MainActivity extends AppCompatActivity {

    Button btn_bd;
    Button btn_continuar;
    EditText user, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_continuar = findViewById(R.id.btn_continuar);
        btn_bd = findViewById(R.id.btn_bd);

        btn_continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Frutas.class);
                startActivity(intent);
            }
        });



        btn_bd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbHelper dbHelper = new DbHelper(MainActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                if (db != null){
                    Toast.makeText(MainActivity.this, "BASE DE DATOS CREADA", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this, "ERROR AL CREAR BASE DE DATOS", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}