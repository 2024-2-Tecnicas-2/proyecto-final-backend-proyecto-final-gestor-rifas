

package com.mycompany.mavenproject1;

import java.util.Scanner;


public class ProyectoFinal {

    public static void main(String[] args) {
         public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Seleccione el tamaño de la rifa (número de boletas): ");
        int tamano = scanner.nextInt();
        scanner.nextLine(); 

        Rifas rifa = new Rifas(tamano);

        System.out.print("Ingrese la lotería con la que va a jugar la rifa: ");
        rifa.setLoteria(scanner.nextLine());

        System.out.print("Ingrese la fecha de la rifa: ");
        rifa.setFecha(scanner.nextLine());

        int opcionMenu = 0;
        while (opcionMenu != 7) {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Vender boleta");
            System.out.println("2. Actualizar estado de pago");
            System.out.println("3. Mostrar información de la rifa");
            System.out.println("4. Mostrar estado de boletas");
            System.out.println("5. Buscar boleta");
            System.out.println("6. Eliminar boleta");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcionMenu = scanner.nextInt();
             

            switch (opcionMenu) {
                case 1: 
                    System.out.print("Ingrese el número de boleta a vender: ");
                    int numeroBoletaVender = scanner.nextInt();
                    scanner.nextLine(); 

                    Boleta boletaVender = rifa.obtenerBoleta(numeroBoletaVender);
                    if (boletaVender != null && !boletaVender.estaVendida()) {
                        System.out.print("Ingrese el nombre del participante: ");
                        boletaVender.setNombreParticipante(scanner.nextLine());

                        System.out.print("Ingrese el número de teléfono: ");
                        boletaVender.setTelefono(scanner.nextLine());

                        System.out.print("Ingrese el correo electrónico: ");
                        boletaVender.setCorreo(scanner.nextLine());

                        System.out.print("Ingrese la dirección: ");
                        boletaVender.setDireccion(scanner.nextLine());

                        System.out.print("¿La boleta está paga o pendiente? (paga/pendiente): ");
                        boletaVender.setEstadoPago(scanner.nextLine().toLowerCase());
                        System.out.println("Boleta vendida exitosamente.");
                    } else {
                        System.out.println("Boleta no válida o ya vendida.");
                    }
                    break;

                case 2: 
                    System.out.print("Ingrese el número de boleta a actualizar: ");
                    int numeroBoletaActualizar = scanner.nextInt();
                    scanner.nextLine(); 
                    Boleta boletaActualizar = rifa.obtenerBoleta(numeroBoletaActualizar);
                    if (boletaActualizar != null && boletaActualizar.estaVendida()) {
                        System.out.print("¿La boleta está paga o pendiente? (paga/pendiente): ");
                        boletaActualizar.setEstadoPago(scanner.nextLine().toLowerCase());
                        System.out.println("Estado de pago actualizado.");
                    } else {
                        System.out.println("Boleta no vendida o no válida.");
                    }
                    break;

                case 3: 
                    rifa.mostrarInfo();
                    break;

                case 4: 
                    rifa.mostrarEstadoBoletasMatriz();
                    break;

                case 5: 
                    System.out.print("Ingrese el número de boleta a buscar: ");
                    int numeroBoletaBuscar = scanner.nextInt();
                    scanner.nextLine(); 
                    rifa.buscarBoleta(numeroBoletaBuscar);
                    break;

                case 6: 
                    System.out.print("Ingrese el número de boleta a eliminar: ");
                    int numeroBoletaEliminar = scanner.nextInt();
                    scanner.nextLine(); 
                    rifa.eliminarBoleta(numeroBoletaEliminar);
                    break;

                case 7: 
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }

        scanner.close();
        System.out.println("Programa finalizado.");
    }
}
