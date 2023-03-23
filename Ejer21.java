/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema9;

import java.util.Scanner;

/**
 *
 * @author jolun
 */
public class Ejer21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el nombre, edad y estatura (en metros) del deportista, separados por espacios: ");
        String nombre = scanner.next();
        int edad = scanner.nextInt();
        double estatura = scanner.nextDouble();

        
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Estatura: " + estatura + " metros");
    }
}


