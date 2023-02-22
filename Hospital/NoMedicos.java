/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema7.Hospital;

/**
 *
 * @author jolun
 */
public class NoMedicos extends Trabajadores {
    private String area;
    private Especialidad2 especialidad;

    public NoMedicos(String nombre, int id, double sueldo, String area, Especialidad2 especialidad) {
        super(nombre, id, sueldo);
        this.area = area;
        this.especialidad = especialidad;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "NoMedicos{" + "area=" + area + ", especialidad=" + especialidad.toString() + '}';
    }
    
}

