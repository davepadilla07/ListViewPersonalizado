package com.example.android.listviewpersonalizado;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class ReporteCarroColorRegistrado extends AppCompatActivity {
    private TextView cajaResultado;
    private String aux;
    private Resources res;
    private ArrayList<Carro> carros;
    private Spinner comboColor;
    private ArrayAdapter<String> adapter;
    private String[]opc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte_carro_color_registrado);

        cajaResultado=(TextView)findViewById(R.id.txtResultado3);

        comboColor=(Spinner)findViewById(R.id.cmdColor2);

        opc=this.getResources().getStringArray(R.array.opcion2);

        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,opc);

        comboColor.setAdapter(adapter);

        res=this.getResources();
    }

    public void reporteColor(View v){
        int contc=0;
        String color;


        color=comboColor.getSelectedItem().toString();

        carros=Datos.getCarros();
        for (int i = 0; i < carros.size(); i++) {


            if(carros.get(i).getColor().equals(color)){
                contc=contc+1;
            }


            aux=getResources().getString(R.string.report3)+" "+contc;
            cajaResultado.setText(aux);
        }

    }

}
