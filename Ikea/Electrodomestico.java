/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema7.Ikea;

/**
 *
 * @author jolun
 */
public class Electrodomestico extends ProductoHogar{
    private eficienciaEnergetica eficienciaEnergetica;

    public Electrodomestico(String nombre, String descripcion, double precio,tipoMaterial tipoMaterial, eficienciaEnergetica eficienciaEnergetica) {
        super(nombre, descripcion, precio, tipoMaterial);
        this.eficienciaEnergetica = eficienciaEnergetica;
    }
    @Override
    public void mostrarInformacion() {
        System.out.println("Electrodoméstico: " + nombre);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Precio: $" + precio);
        System.out.println("Eficiencia energética: " + eficienciaEnergetica);
    }
}
