/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema7.Hospital;

/**
 *
 * @author jolun
 */
    public class Medicos extends Trabajadores {
     private int numColegiado;
     private int numPacientes;
     private Especialidad especialidad;

    public Medicos(String nombre, int id, double sueldo, int numColegiado, int numPacientes,Especialidad especialidad) {
        super(nombre, id, sueldo);
        this.numColegiado = numColegiado;
        this.numPacientes = numPacientes;
        this.especialidad = especialidad;
    }
      public int getNumColegiado() {
        return numColegiado;
    }

    public int getNumPacientes() {
        return numPacientes;
    }

    public void setNumColegiado(int numColegiado) {
        this.numColegiado = numColegiado;
    }

    public void setNumPacientes(int numPacientes) {
        this.numPacientes = numPacientes;
    }

    @Override
    public String toString() {
        return "Medicos{" + "numColegiado=" + numColegiado + ", numPacientes=" + numPacientes + ", especialidad=" + especialidad.toString() + '}';
    }
    
}
