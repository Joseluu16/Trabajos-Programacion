/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema7.Ikea;

/**
 *
 * @author jolun
 */
public class ArticuloDecoracion extends ProductoHogar{
  
     public ArticuloDecoracion(String nombre, String descripcion, double precio, tipoMaterial tipoDeMaterial) {
        super(nombre, descripcion, precio, tipoDeMaterial);
    }
      @Override
    public void mostrarInformacion() {
        System.out.println("Artículo de decoración: " + nombre);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Precio: $" + precio);
        System.out.println("Material: " + tipoMaterial);
    }
}
