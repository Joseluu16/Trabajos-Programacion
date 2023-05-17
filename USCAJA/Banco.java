/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package USCAJA;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jolun
 */
public class Banco {
  private static  Scanner sc = new Scanner(System.in);
  private static  UsuarioPotencialDAO u1 = new UsuarioPotencialDAO();
  private static  CuentaBancariaDAO c1 = new CuentaBancariaDAO();
  private static  TitularesCuentasDAO t1 = new TitularesCuentasDAO();
  private static  OperacionBancariaDAO o1 = new OperacionBancariaDAO();
  
   
 public static void main(String[] args) throws SQLException {
          int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();
            ejecutarOpcion(opcion);
        } while (opcion != 0);
    }
 
 private static void mostrarMenu() {
        System.out.println("----- MENÚ -----");
        System.out.println("1. Operaciones");
        System.out.println("2. Listar operaciones");
        System.out.println("3. Listar usuarios");
        System.out.println("4. Listar cuentas bancarias");
        System.out.println("5. Modificar usuario");
        System.out.println("6. Crear cuentas");
        System.out.println("7. Crear usuario");
        System.out.println("8. Añadir titular a cuenta");
        System.out.println("9. Eliminar titular de cuenta");
        System.out.println("10. Eliminar usuario potencial");
        System.out.println("0. Salir");
    }
       private static int leerOpcion() {
        System.out.print("Ingrese una opción: ");
        return sc.nextInt();
    }
   
        private static void ejecutarOpcion(int opcion) throws SQLException {
        switch (opcion) {
            case 1:
                ejecutarOperaciones();
                break;
            case 2:
                listarOperaciones();
                break;
            case 3:
                listarUsuarios();
                break;
            case 4:
                listarCuentas();
                break;
            case 5:
                modificarUsuario();
                break;
            case 6:
                c1.crearCuentas();
                break;
            case 7:
                u1.crearUsuario();
                break;
            case 8:
                t1.añadirTitular();
              break;
            case 9:
                t1.eliminarTitular();
                break;
            case 10:
                u1.eliminarUsuarioPotencial();
                break;
            case 0:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opción inválida. Intente nuevamente.");
                break;
        }
    }
           private static void ejecutarOperaciones() throws SQLException {
        int opcion;
        do {
            mostrarMenuOperaciones();
            opcion = leerOpcion();
            ejecutarOperacion(opcion);
        } while (opcion != 0);
    }
           
       private static void mostrarMenuOperaciones() {
        System.out.println("----- OPERACIONES -----");
        System.out.println("1. Retirar");
        System.out.println("2. Ingresar");
        System.out.println("3. Transferir");
        System.out.println("0. Volver al menú principal");
    }
     
      private static void ejecutarOperacion(int opcion) throws SQLException {
    switch (opcion) {
        case 1:
            o1.retirar();
            break;
        case 2:
            o1.ingresar();
            break;
        case 3:
            o1.transferir();
            break;
        case 0:
            System.out.println("Volviendo al menú principal...");
            break;
        default:
            System.out.println("Opción inválida. Intente nuevamente.");
            break;
    }
}

       
       private static void listarOperaciones() {
            List operacion1 = o1.listarOperaciones();
           for (Object operacion : operacion1){
               System.out.println(operacion.toString());
           }
       }
       
       private static void listarUsuarios() {
           List usuario1 = u1.listarUsuarios();
       for (Object usuario: usuario1){
           System.out.println(usuario.toString());
       }
      }
       
       private static void listarCuentas() {
           List cuentas1 = c1.listarCuentas();
          for (Object cuenta : cuentas1){
              System.out.println(cuenta.toString());
          }
       }
       
   private static void modificarUsuario() {
    int opcion;
    do {
        mostrarMenuModificacionUsuario();
        opcion = leerOpcion();
        ejecutarModificacionUsuario(opcion);
    } while (opcion != 0);
}
   
   private static void mostrarMenuModificacionUsuario() {
    System.out.println("----- MODIFICACIÓN DE USUARIO -----");
    System.out.println("1. Actualizar nombre de usuario");
    System.out.println("2. Actualizar apellido de usuario");
    System.out.println("3. Actualizar dirección de usuario");
    System.out.println("4. Actualizar email de usuario");
    System.out.println("5. Actualizar teléfono de usuario");
    System.out.println("0. Volver al menú principal");
}
   
   private static void ejecutarModificacionUsuario(int opcion) {
    switch (opcion) {
        case 1:
            u1.actualizarNombre();
            break;
        case 2:
            u1.actualizarApellido();
            break;
        case 3:
            u1.actualizarDireccion();
            break;
        case 4:
            u1.actualizarEmail();
            break;
        case 5:
            u1.actualizarTelefono();
            break;
             case 0:
            System.out.println("Volviendo al menú principal...");
            break;
        default:
            System.out.println("Opción inválida. Intente nuevamente.");
            break;
      } 
    }
  } 



