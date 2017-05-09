package com.example.android.listviewpersonalizado;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class RegistrarC extends AppCompatActivity {
    private EditText cajaPlaca;
    private EditText cajaPrecio;
    private Intent i;
    private Spinner comboMarca;
    private Spinner comboModelo;
    private Spinner comboColor;
    private ArrayAdapter<String> adapter,adapter1,adapter2;
    private String[] opc;
    private String[] opc1;
    private String[] opc2;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_c);

        cajaPlaca=(EditText)findViewById(R.id.txtPlaca);
        cajaPrecio=(EditText)findViewById(R.id.txtPrecio);

        comboMarca=(Spinner)findViewById(R.id.cmbMarca);
        comboModelo=(Spinner)findViewById(R.id.cmbModelo);
        comboColor=(Spinner)findViewById(R.id.cmbColor);

        opc=this.getResources().getStringArray(R.array.opcion);
        opc1=this.getResources().getStringArray(R.array.opcion1);
        opc2=this.getResources().getStringArray(R.array.opcion2);

        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,opc);
        adapter1=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,opc1);
        adapter2=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,opc2);

        comboMarca.setAdapter(adapter);
        comboModelo.setAdapter(adapter1);
        comboColor.setAdapter(adapter2);

    }

    public void Registrar (View v){
        String foto;
        String placa,marca,color;
        int modelo;
        double precio;
        String aux="";
        if (validar()) {

            placa = cajaPlaca.getText().toString();
            marca = comboMarca.getSelectedItem().toString();
            modelo = Integer.parseInt(comboModelo.getSelectedItem().toString());
            color = comboColor.getSelectedItem().toString();
            precio = Double.parseDouble(cajaPrecio.getText().toString());

            foto=String.valueOf(fotoAleatoria());
            Carro c=new Carro(foto, placa, marca, modelo, color, precio);

        }
    }

    public boolean validar(){
        if (cajaPlaca.getText().toString().isEmpty()){
            cajaPlaca.setError(getResources().getString(R.string.error1));
            cajaPlaca.requestFocus();
            return false;
        }
        if (cajaPrecio.getText().toString().isEmpty()){
            cajaPrecio.setError(getResources().getString(R.string.error2));
            cajaPrecio.requestFocus();
            return false;
        }
        return true;
    }

    public void limpiar(){
        cajaPlaca.setText("");
        cajaPlaca.requestFocus();
        comboMarca.setSelection(0);
        comboModelo.setSelection(0);
        comboColor.setSelection(0);
        cajaPrecio.setText("");
    }

    public void borrar(View v){ limpiar();}

    public int fotoAleatoria(){
        int fotos[]={R.drawable.foto1,R.drawable.foto2,R.drawable.foto3,R.drawable.foto4,R.drawable.foto5,R.drawable.foto6,R.drawable.foto7,R.drawable.foto8,R.drawable.foto9};
        int numero=(int)(Math.random()*9);
        return fotos[numero];
    }


}
