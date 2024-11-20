
package com.mycompany.mavenproject1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Rifas implements Serializable {

    private List<Boleta> boletas;
    private String loteria;
    private String fecha;
    private String nombre;

    public Rifas(int tamaño, String loteria, String fecha) {
        this.boletas = new ArrayList<>();
        for (int i = 1; i <= tamaño; i++) {
            boletas.add(new Boleta(i));
        }
        this.loteria = loteria;
        this.fecha = fecha;
    }
    public Rifas(String nombre) {
    this.nombre = nombre;
    this.boletas = new ArrayList<>(); // Inicializa la lista de boletas
}

    public String getLoteria() {
        return loteria;
    }

    public String getFecha() {
        return fecha;
    }

    public void venderBoleta(int numero, String nombre, String telefono, String correo, String direccion, String estadoPago) {
    Boleta boleta = buscarBoletaPorNumero(numero);
    if (boleta != null) {
        if (!boleta.isVendida()) {
            boleta.vender(nombre, telefono, correo, direccion, estadoPago);
            System.out.println("La boleta número " + numero + " se vendió con éxito.");
        } else {
            System.out.println("La boleta número " + numero + " ya está vendida. No se puede realizar la compra.");
        }
    } else {
        System.out.println("La boleta número " + numero + " no existe en esta rifa.");
    }
}


    public void actualizarEstadoPago(int numero, String nuevoEstadoPago) {
        Boleta boleta = buscarBoletaPorNumero(numero);
        if (boleta != null) {
            boleta.actualizarEstadoPago(nuevoEstadoPago);
        } else {
            System.out.println("Boleta no encontrada.");
        }
    }

    public void mostrarInformacion() {
        System.out.println("Lotería: " + loteria);
        System.out.println("Fecha de la rifa: " + fecha);
        System.out.println("Total de boletas: " + boletas.size());
        long boletasVendidas = boletas.stream().filter(Boleta::isVendida).count();
        System.out.println("Boletas vendidas: " + boletasVendidas);
        System.out.println("Boletas no vendidas: " + (boletas.size() - boletasVendidas));
    }

    public void mostrarEstadoBoletas() {
        System.out.println("Estado de las boletas:");
        for (int i = 0; i < boletas.size(); i++) {
            if (i % 10 == 0 && i != 0) {
                System.out.println(); 
            }
            Boleta boleta = boletas.get(i);
            System.out.print("[" + boleta.getEstado() + boleta.getNumero() + "] ");
        }
        System.out.println();
    }

    public void buscarBoleta(int numero) {
        Boleta boleta = buscarBoletaPorNumero(numero);
        if (boleta != null) {
            boleta.mostrarInformacion();
        } else {
            System.out.println("Boleta no encontrada.");
        }
    }

    public void eliminarBoleta(int numero) {
        Boleta boleta = buscarBoletaPorNumero(numero);
        if (boleta != null) {
            boleta.eliminarVenta();
        } else {
            System.out.println("Boleta no encontrada.");
        }
    }
    public List<Boleta> getBoletas() {
    return boletas;
}
    public String getNombre() {
        
    return nombre; 
}


    private Boleta buscarBoletaPorNumero(int numero) {
        return boletas.stream().filter(b -> b.getNumero() == numero).findFirst().orElse(null);
    }
    
    @Override
    public String toString() {
        return "Rifa: " + nombre + "\nBoletas disponibles: " + boletas.size();
    }
   
}
