package com.mycompany.mavenproject1;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorRifas {
    private List<Rifas> rifas;
    private Rifas rifaActual;

    public GestorRifas() {
        this.rifas = new ArrayList<>();
    }

    public void crearRifa(int tamaño, String loteria, String fecha) {
        Rifas nuevaRifa = new Rifas(tamaño, loteria, fecha);
        rifas.add(nuevaRifa);
        rifaActual = nuevaRifa;
        System.out.println("Rifa creada exitosamente.");
    }

    public boolean seleccionarRifa(int indice) {
        if (indice > 0 && indice <= rifas.size()) {
            rifaActual = rifas.get(indice - 1);
            System.out.println("Rifa seleccionada correctamente.");
            return true;
        }
        return false;
    }

    public void mostrarRifas() {
        for (int i = 0; i < rifas.size(); i++) {
            System.out.println((i + 1) + ". " + rifas.get(i).getLoteria() + " - " + rifas.get(i).getFecha());
        }
    }

    public boolean hayRifas() {
        return !rifas.isEmpty();
    }

    public void venderBoleta(int numero, String nombre, String telefono, String correo, String direccion, String estadoPago) {
        if (rifaActual != null) {
            rifaActual.venderBoleta(numero, nombre, telefono, correo, direccion, estadoPago);
        } else {
            System.out.println("No hay rifa seleccionada.");
        }
    }

    public void actualizarEstadoPago(int numero, String nuevoEstado) {
        if (rifaActual != null) {
            rifaActual.actualizarEstadoPago(numero, nuevoEstado);
        } else {
            System.out.println("No hay rifa seleccionada.");
        }
    }

    public void mostrarInformacionRifa() {
        if (rifaActual != null) {
            rifaActual.mostrarInformacion();
        } else {
            System.out.println("No hay rifa seleccionada.");
        }
    }

    public void mostrarEstadoBoletas() {
        if (rifaActual != null) {
            rifaActual.mostrarEstadoBoletas();
        } else {
            System.out.println("No hay rifa seleccionada.");
        }
    }

    public void buscarBoleta(int numero) {
        if (rifaActual != null) {
            rifaActual.buscarBoleta(numero);
        } else {
            System.out.println("No hay rifa seleccionada.");
        }
    }

    public void eliminarBoleta(int numero) {
        if (rifaActual != null) {
            rifaActual.eliminarBoleta(numero);
        } else {
            System.out.println("No hay rifa seleccionada.");
        }
    }

    public void guardarDatosRifas() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("rifas.dat"))) {
            oos.writeObject(rifas);
            System.out.println("Datos guardados exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar datos: " + e.getMessage());
        }
    }

    public void cargarDatosRifas() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("rifas.dat"))) {
            rifas = (List<Rifas>) ois.readObject();
            System.out.println("Datos cargados exitosamente.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar datos: " + e.getMessage());
        }
    }
    
}
