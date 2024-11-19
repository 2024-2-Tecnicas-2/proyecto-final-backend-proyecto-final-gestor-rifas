
package com.mycompany.mavenproject1;


import java.io.Serializable;

public class Boleta implements Serializable {

    private int numero;
    private String nombreComprador;
    private String telefonoComprador;
    private String correoComprador;
    private String direccionComprador;
    private String estadoPago; 
    private boolean vendida;

    public Boleta(int numero) {
        this.numero = numero;
        this.vendida = false;
        this.estadoPago = "Pendiente";
    }

    public int getNumero() {
        return numero;
    }

    public boolean isVendida() {
        return vendida;
    }

    public void vender(String nombre, String telefono, String correo, String direccion, String estadoPago) {
        if (vendida) {
            System.out.println("La boleta ya está vendida. No se puede vender nuevamente.");
            return;
        }
        this.nombreComprador = nombre;
        this.telefonoComprador = telefono;
        this.correoComprador = correo;
        this.direccionComprador = direccion;
        this.estadoPago = estadoPago;
        this.vendida = true;
        System.out.println("Boleta vendida exitosamente.");
    }

    public void actualizarEstadoPago(String nuevoEstadoPago) {
        if (!vendida) {
            System.out.println("La boleta no ha sido vendida. No se puede actualizar el estado de pago.");
            return;
        }
        this.estadoPago = nuevoEstadoPago;
        System.out.println("Estado de pago actualizado correctamente.");
    }

    public void mostrarInformacion() {
        if (vendida) {
            System.out.println("Número de boleta: " + numero);
            System.out.println("Nombre del comprador: " + nombreComprador);
            System.out.println("Teléfono del comprador: " + telefonoComprador);
            System.out.println("Correo del comprador: " + correoComprador);
            System.out.println("Dirección del comprador: " + direccionComprador);
            System.out.println("Estado de pago: " + estadoPago);
        } else {
            System.out.println("Número de boleta: " + numero + " (No vendida)");
        }
    }

    public void eliminarVenta() {
        if (!vendida) {
            System.out.println("La boleta no ha sido vendida. No se puede eliminar.");
            return;
        }
        this.nombreComprador = null;
        this.telefonoComprador = null;
        this.correoComprador = null;
        this.direccionComprador = null;
        this.estadoPago = "Pendiente";
        this.vendida = false;
        System.out.println("La venta de la boleta ha sido eliminada.");
    }

    public String getEstado() {
        return vendida ? "O" : "X"; 
    }
}

