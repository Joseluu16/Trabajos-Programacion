/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema7.Ikea;

/**
 *
 * @author jolun
 */
public class Tienda {
    private Producto[] productos;

    public Tienda() {
        this.productos = new Producto[0];
    }

    public void agregarProducto(Producto producto) {
        Producto[] nuevosProductos = new Producto[this.productos.length + 1];
        for (int i = 0; i < this.productos.length; i++) {
            nuevosProductos[i] = this.productos[i];
        }
        nuevosProductos[this.productos.length] = producto;
        this.productos = nuevosProductos;
    }

    public void mostrarProductos() {
        for (Producto producto : this.productos) {
            System.out.println(producto.toString());
        }
    }
}
