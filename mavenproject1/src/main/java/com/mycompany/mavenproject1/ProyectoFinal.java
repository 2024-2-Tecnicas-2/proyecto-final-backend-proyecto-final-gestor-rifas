package com.mycompany.mavenproject1;

import java.util.Scanner;

public class ProyectoFinal {

    private static GestorRifas gestorRifas = new GestorRifas();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        gestorRifas.cargarDatosRifas();

        System.out.println("¡Bienvenido al sistema de gestión de rifas!");

        seleccionarRifa();

        int opcionMenu;
        do {
            System.out.println("\nMenu de opciones:");
            System.out.println("1. Vender boleta");
            System.out.println("2. Actualizar estado de pago");
            System.out.println("3. Mostrar información de la rifa");
            System.out.println("4. Mostrar estado de boletas");
            System.out.println("5. Buscar boleta");
            System.out.println("6. Eliminar boleta");
            System.out.println("7. Guardar y cargar datos");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opcion: ");
            opcionMenu = scanner.nextInt();
            scanner.nextLine();

            switch (opcionMenu) {
                case 1:
                    venderBoleta();
                    break;
                case 2:
                    actualizarEstadoPago();
                    break;
                case 3:
                    gestorRifas.mostrarInformacionRifa();
                    break;
                case 4:
                    gestorRifas.mostrarEstadoBoletas();
                    break;
                case 5:
                    buscarBoleta();
                    break;
                case 6:
                    eliminarBoleta();
                    break;
                case 7:
                    guardarYCargarDatos();
                    break;
                case 8:
                    System.out.println("¡Gracias por usar el sistema de rifas!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcionMenu != 8);
    }

    private static void seleccionarRifa() {
        System.out.println("seleccione una opcion");
        System.out.println("1. seleccionar o crear rifa");
        System.out.println("2. Eliminar rifa");
        int opcionUno = scanner.nextInt();
        if (opcionUno == 1) {
            if (gestorRifas.hayRifas()) {
                System.out.println("\nRifas disponibles:");
                gestorRifas.mostrarRifas();
                System.out.print("Seleccione el número de la rifa con la que desea trabajar o 0 para crear una nueva: ");
                int opcionDos = scanner.nextInt();
                scanner.nextLine();
                if (opcionDos == 0) {
                    crearRifa();
                } else if (!gestorRifas.seleccionarRifa(opcionDos)) {
                    System.out.println("Opción inválida. Se creará una nueva rifa.");
                    crearRifa();
                }
            } else {
                System.out.println("No hay rifas disponibles. Crearemos una nueva.");
                crearRifa();
            }

        }
        if (gestorRifas.hayRifas()) {
            System.out.println("\nRifas disponibles:");
            gestorRifas.mostrarRifas();

            System.out.print("Seleccione el número de la rifa que desea eliminar: ");
            int opcionTres = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            if (gestorRifas.existeRifa(opcionTres)) {
                gestorRifas.eliminarRifa(opcionTres);
                System.out.println("Rifa eliminada con éxito.");
            } else {
                System.out.println("Opción inválida. No existe una rifa con ese número.");
            }
        } else {
            System.out.println("No hay rifas disponibles.");
        }

    }

    private static void crearRifa() {
        System.out.print("Ingrese el tamaño de la rifa (cantidad de boletas): ");
        int tamaño = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese la loteria con la que jugara la rifa: ");
        String loteria = scanner.nextLine();
        System.out.print("Ingrese la fecha de la rifa (formato DD/MM/AAAA): ");
        String fecha = scanner.nextLine();
        gestorRifas.crearRifa(tamaño, loteria, fecha);
    }

    private static void venderBoleta() {
        System.out.print("Ingrese el numero de la boleta a vender: ");
        int numero = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre del comprador: ");
        String nombre = scanner.nextLine();
        System.out.print("Telefono del comprador: ");
        String telefono = scanner.nextLine();
        System.out.print("Correo del comprador: ");
        String correo = scanner.nextLine();
        System.out.print("Dirección del comprador: ");
        String direccion = scanner.nextLine();
        System.out.print("Estado de pago (Pago/Pendiente): ");
        String estadoPago = scanner.nextLine();
        gestorRifas.venderBoleta(numero, nombre, telefono, correo, direccion, estadoPago);
    }

    private static void actualizarEstadoPago() {
        System.out.print("Ingrese el numero de la boleta: ");
        int numero = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nuevo estado de pago (Pago/Pendiente): ");
        String estadoPago = scanner.nextLine();
        gestorRifas.actualizarEstadoPago(numero, estadoPago);
    }

    private static void buscarBoleta() {
        System.out.print("Ingrese el numero de la boleta que desea buscar: ");
        int numero = scanner.nextInt();
        scanner.nextLine();
        gestorRifas.buscarBoleta(numero);
    }

    private static void eliminarBoleta() {
        System.out.print("Ingrese el numero de la boleta que desea eliminar: ");
        int numero = scanner.nextInt();
        scanner.nextLine();
        gestorRifas.eliminarBoleta(numero);
    }

    private static void guardarYCargarDatos() {
        System.out.println("\nQuire guardar y almacenar los datos");
        System.out.println("1. si");
        System.out.println("2. no");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        if (opcion == 1) {
            gestorRifas.guardarDatosRifas();
            gestorRifas.cargarDatosRifas();
        } else if (opcion == 2) {

            System.out.println("Los datos no han sido guardados");

        } else {
            System.out.println("Opción no válida.");
        }
    }
}
