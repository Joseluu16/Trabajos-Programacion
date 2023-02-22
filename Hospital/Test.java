/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema7.Hospital;

/**
 *
 * @author jolun
 */
public class Test {
     public static void main(String[] args) {
       Trabajadores t1 = new Trabajadores ("Selu", 2, 1000);
       Medicos m1 = new Medicos ("Selu", 2, 3000, 10, 50, Especialidad.pediatras);
       NoMedicos nm1 = new NoMedicos ("Selu", 4, 3330, "Quirurjica", Especialidad2.recepcionista);
        
       System.out.println(t1);
       System.out.println(m1);
       System.out.println(nm1);
     }
}
