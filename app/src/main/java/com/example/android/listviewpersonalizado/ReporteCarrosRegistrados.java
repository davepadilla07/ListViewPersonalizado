package com.example.android.listviewpersonalizado;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class ReporteCarrosRegistrados extends AppCompatActivity {
    private TextView cajaResultado;
    private String aux;
    private Resources res;
    private ArrayList<Carro> carros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte_carros_registrados);

        cajaResultado=(TextView) findViewById(R.id.txtResultado);
        res=this.getResources();

    }

    public void reporte(View v){
        int contc=0;

        carros=Datos.getCarros();
        for (int i = 0; i < carros.size(); i++) {
            contc=contc+1;
        }
        aux=getResources().getString(R.string.report1)+" "+contc;
        cajaResultado.setText(aux);
    }
}
