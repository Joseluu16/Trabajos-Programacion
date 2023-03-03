/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema7.Ikea;

/**
 *
 * @author jolun
 */
public class Mueble extends ProductoHogar{
    private String tipoDeMueble;

   public Mueble(String nombre, String descripcion, double precio, tipoMaterial tipoDeMaterial, String tipoDeMueble) {
        super(nombre, descripcion, precio, tipoDeMaterial);
        this.tipoDeMueble = tipoDeMueble;
    }

    public String getTipoDeMueble() {
        return tipoDeMueble;
    }

    public void setTipoDeMueble(String tipoDeMueble) {
        this.tipoDeMueble = tipoDeMueble;
    }
   
}
