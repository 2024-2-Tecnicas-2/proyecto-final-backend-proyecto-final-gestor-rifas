/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avanceproyecto;

import java.util.ArrayList;
import java.util.List;

public class GestorRifas {
    private List<Rifas> rifas;

    // Constructor
    public GestorRifas() {
        this.rifas = new ArrayList<>();
    }

    // Método para agregar una rifa
    public void agregarRifa(Rifas rifa) {
        rifas.add(rifa);
    }

    // Método para mostrar información de todas las rifas
    public void mostrarInfoRifas() {
        for (Rifas rifa : rifas) {
            rifa.mostrarInfo();
            System.out.println();
        }
    }
}

