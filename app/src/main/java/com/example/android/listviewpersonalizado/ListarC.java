package com.example.android.listviewpersonalizado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListarC extends AppCompatActivity {
    private ListView listac;
    private ArrayList<Carro> carros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_c);

        listac=(ListView)findViewById(R.id.lvListarCarros);
        carros=Datos.getCarros();

        AdaptadorCarro adapter = new AdaptadorCarro(this, carros);
        listac.setAdapter(adapter);


    }
}
