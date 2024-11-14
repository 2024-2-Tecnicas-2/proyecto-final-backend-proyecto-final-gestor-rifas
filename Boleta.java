/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avanceproyecto;

public class Boleta {
    private int numero;
    private String estadoPago;
    private String nombreParticipante;
    private String telefono;
    private String correo;
    private String direccion;

    public Boleta(int numero) {
        this.numero = numero;
        this.estadoPago = "pendiente";
    }

    public int getNumero() {
        return numero;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

    public boolean estaVendida() {
        return nombreParticipante != null;
    }

    public void setNombreParticipante(String nombre) {
        this.nombreParticipante = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getInfoCliente() {
        if (estaVendida()) {
            return "Nombre: " + nombreParticipante + ", Teléfono: " + telefono +
                   ", Correo: " + correo + ", Dirección: " + direccion +
                   ", Estado de Pago: " + estadoPago;
        }
        return "Boleta no vendida";
    }
}

