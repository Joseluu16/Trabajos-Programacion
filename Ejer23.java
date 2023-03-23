/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author jolun
 */
public class Ejer23 {
    public static void main(String[] args) {
        try {
            File archivo = new File("ejercicio.txt");
            Scanner scanner = new Scanner(archivo);
            double suma = 0;
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                double numero = Double.parseDouble(linea);
                suma += numero;
            }
            scanner.close();
            System.out.println("La suma de los números es: " + suma);
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe.");
        }
    }
}


