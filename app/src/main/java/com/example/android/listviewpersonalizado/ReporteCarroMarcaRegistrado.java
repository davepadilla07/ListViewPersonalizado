package com.example.android.listviewpersonalizado;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class ReporteCarroMarcaRegistrado extends AppCompatActivity {
    private TextView cajaResultado;
    private String aux;
    private Resources res;
    private ArrayList<Carro> carros;
    private Spinner comboMarca;
    private ArrayAdapter<String> adapter;
    private String[]opc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte_carro_marca_registrado);

        cajaResultado=(TextView)findViewById(R.id.txtResultado2);

        comboMarca=(Spinner)findViewById(R.id.cmbMarca2);

        opc=this.getResources().getStringArray(R.array.opcion);

        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,opc);

        comboMarca.setAdapter(adapter);

        res=this.getResources();

    }

    public void reporteMarca(View v){
        int contc=0;
        String marca;
        String aux2;

        marca=comboMarca.getSelectedItem().toString();

        for (int i = 0; i < carros.size(); i++) {

            aux2 = carros.get(i).getMarca();
            if(aux2==marca){
                contc=contc+1;
            }else{
                i++;
            }

            /*if ((carros.get(i).getMarca().equalsIgnoreCase(marca))){
                contc=contc +1;
            }else{
                i++;
            }*/

            aux=getResources().getString(R.string.report2)+" "+contc;
            cajaResultado.setText(aux);
        }

    }


}
