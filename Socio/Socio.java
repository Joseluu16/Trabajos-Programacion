/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema10.Socio;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author jolun
 */
    public class Socio implements Serializable, Comparable<Socio> {
    private String dni;
    private String nombre;
    private LocalDate fechaAlta;

    public Socio(String dni, String nombre, LocalDate fechaAlta) {
        this.dni = dni;
        this.nombre = nombre;
        this.fechaAlta = fechaAlta;
    }
     public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int antiguedad() {
        return LocalDate.now().getYear() - fechaAlta.getYear();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Socio) {
            Socio otro = (Socio) obj;
            return dni.equals(otro.dni);
        }
        return false;
    }

    @Override
    public int compareTo(Socio otro) {
        return dni.compareTo(otro.dni);
    }

}
