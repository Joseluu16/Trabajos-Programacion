/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema7.Hospital;

/**
 *
 * @author jolun
 */
public class Trabajadores {
    protected String nombre;
    protected int id;
    protected double sueldo;

    public Trabajadores(String nombre, int id, double sueldo) {
        this.nombre = nombre;
        this.id = id;
        this.sueldo = sueldo;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public double getSueldo() {
        return sueldo;
    }
     public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Trabajadores{" + "nombre=" + nombre + ", id=" + id + ", sueldo=" + sueldo + '}';
    }
     
}


