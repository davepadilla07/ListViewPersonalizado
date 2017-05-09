package com.example.android.listviewpersonalizado;

import java.util.ArrayList;

/**
 * Created by DAVID on 9/05/2017.
 */

public class Datos {
    private static ArrayList<Carro> carros = new ArrayList<>();

    public static void guardar (Carro c){carros.add(c);}

    public static ArrayList<Carro> getCarros(){return carros;}

}
