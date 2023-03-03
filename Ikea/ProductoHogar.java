/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema7.Ikea;

/**
 *
 * @author jolun
 */

public abstract class ProductoHogar extends Producto {
    protected tipoMaterial tipoMaterial;

    public ProductoHogar(String nombre, String descripcion, double precio, tipoMaterial tipoDeMaterial) {
        super(nombre, descripcion, precio);
        this.tipoMaterial = tipoDeMaterial;
    }

    public tipoMaterial getTipoDeMaterial() {
        return tipoMaterial;
    }

    public void setTipoDeMaterial(tipoMaterial tipoDeMaterial) {
        this.tipoMaterial = tipoDeMaterial;
    }
    @Override
    public void mostrarInformacion() {
        System.out.println("Mueble: " + nombre);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Precio: $" + precio);
        System.out.println("Material: " + tipoMaterial);
        System.out.println("Tipo de mueble: " + tipoDeMueble);
    }
}
    