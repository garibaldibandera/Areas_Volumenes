package com.example.areasvolumenes;

import java.util.ArrayList;

public class Datos {
    private static ArrayList<Operaciones> operaciones = new ArrayList();

    public static void guardar(Operaciones p){
        operaciones.add(p);
    }
    public static ArrayList<Operaciones> obtener(){
        return operaciones;
    }
}
