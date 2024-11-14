/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avanceproyecto;

public class Rifas {
    private Boleta[] boletas;
    private String loteria;
    private String fecha;

    public Rifas(int tamano) {
        boletas = new Boleta[tamano];
        for (int i = 0; i < tamano; i++) {
            boletas[i] = new Boleta(i);
        }
    }

    public void setLoteria(String loteria) {
        this.loteria = loteria;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Boleta obtenerBoleta(int numero) {
        if (numero >= 0 && numero < boletas.length) {
            return boletas[numero];
        }
        return null;
    }

    public void mostrarInfo() {
        System.out.println("Rifa de tamaño: " + boletas.length + " boletas");
        System.out.println("Lotería: " + loteria);
        System.out.println("Fecha de la rifa: " + fecha);
    }

    public void mostrarEstadoBoletasMatriz() {
        System.out.println("\nEstado de las Boletas:");
        int columnas = 10;
        for (int i = 0; i < boletas.length; i++) {
            Boleta boleta = boletas[i];
            String estado = boleta.estaVendida() ? "O" : "X";
            System.out.printf("[%s%02d] ", estado, boleta.getNumero());

            if ((i + 1) % columnas == 0) {
                System.out.println();
            }
        }
    }

    public void buscarBoleta(int numero) {
        Boleta boleta = obtenerBoleta(numero);
        if (boleta != null) {
            System.out.println(boleta.getInfoCliente());
        } else {
            System.out.println("Boleta no válida.");
        }
    }

    public void eliminarBoleta(int numero) {
        Boleta boleta = obtenerBoleta(numero);
        if (boleta != null && boleta.estaVendida()) {
            boleta.setNombreParticipante(null);
            boleta.setTelefono(null);
            boleta.setCorreo(null);
            boleta.setDireccion(null);
            boleta.setEstadoPago("pendiente");
            System.out.println("Boleta eliminada correctamente.");
        } else {
            System.out.println("Boleta no vendida o no válida.");
        }
    }
}
