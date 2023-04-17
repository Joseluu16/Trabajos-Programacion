/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema10.Socio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author jolun
 */
public class GestionSocios {
    private static ArrayList<Socio> socios = new ArrayList<>();
    private static final String Socio = "Socio.dat";
    
    public static void main(String[] args) {
        leerSocios();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n1. Alta");
            System.out.println("2. Baja");
            System.out.println("3. Modificación");
            System.out.println("4. Listado por DNI");
            System.out.println("5. Listado por antigüedad");
            System.out.println("6. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine();
            
             switch (opcion) {
                case 1:
                    altaSocio();
                    break;
                case 2:
                    bajaSocio();
                    break;
                case 3:
                    modificarSocio();
                    break;
                case 4:
                    listarPorDni();
                    break;
                case 5:
                    listarPorAntiguedad();
                    break;
                case 6:
                   salir();
                    break;
                default:
                    System.out.println("Opción no válida");
            }
               } while (opcion != 6);
    }
    private static void leerSocios() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Socio.dat"))) {
            socios = (ArrayList<Socio>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
        }
    }
    
    private static void altaSocio() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el DNI del socio: ");
        String dni = scanner.nextLine();
        System.out.print("Introduce el nombre del socio: ");
        String nombre = scanner.nextLine();
        LocalDate fechaAlta = LocalDate.now();
        Socio s1 = new Socio(dni, nombre, fechaAlta);
        if (socios.contains(s1)) {
            System.out.println("El socio con ese DNI ya existe");
        } else {
            socios.add(s1);
            System.out.println("Socio añadido correctamente");
        }
    }
    private static void bajaSocio() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el DNI del socio que quieres dar de baja: ");
        String dni = scanner.nextLine();
        Socio s2 = new Socio(dni, null, null);
        if (socios.contains(s2)) {
            socios.remove(s2);
            System.out.println("Socio dado de baja correctamente");
        } else {
            System.out.println("No existe ningún socio con ese DNI");
        }
    }
    private static void modificarSocio() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el DNI del socio que quieres modificar: ");
        String dni = scanner.nextLine();
        Socio s3 = new Socio(dni, null, null);
        int indice = socios.indexOf(s3);
        if (indice != -1) {
            Socio socioModificado = solicitarDatosSocio();
            socios.set(indice, socioModificado);
            System.out.println("Socio modificado correctamente");
        } else {
            System.out.println("No existe ningún socio con ese DNI");
        }
    }
    private static Socio solicitarDatosSocio() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el nuevo nombre del socio: ");
        String nombre = scanner.nextLine();
        LocalDate fechaAlta = LocalDate.now();
        return new Socio(null, nombre, fechaAlta);
    }
    private static void listarPorDni() {
        Collections.sort(socios);
        System.out.println("Listado de socios por DNI:");
        for (Socio socio : socios) {
            System.out.println(socio.getDni() + " - " + socio.getNombre() + " - " + socio.getFechaAlta());
        }
    }

    private static void listarPorAntiguedad() {
        Comparator<Socio> comparadorPorAntiguedad = new Comparator<Socio>() {
            @Override
            public int compare(Socio s1, Socio s2) {
                return s2.antiguedad() - s1.antiguedad();
            }
        };
        Collections.sort(socios, comparadorPorAntiguedad);
        System.out.println("Listado de socios por antigüedad:");
        for (Socio socio : socios) {
            System.out.println(socio.getDni() + " - " + socio.getNombre() + " - " + socio.getFechaAlta() + " - " + socio.antiguedad() + " años");
        }
    }
        private static void salir() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Socio.dat"));
            out.writeObject("Socio.dat");
            out.close();
            System.out.println("Datos guardados en socios.dat. ¡Hasta luego!");
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }
}
