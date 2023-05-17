/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package USCAJA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jolun
 */
public class TitularesCuentasDAO {
    private ConexionBD conexion;

    public TitularesCuentasDAO() {
        conexion = new ConexionBD();
    }
    
    // FUNCIONES 
    
     public void añadirTitular() throws SQLException {
        Scanner sc = new Scanner(System.in);
        ConexionBD gc = new ConexionBD();
        Connection con = gc.getConexion();
        
        System.out.println("Escriba su NIF:");
        String nif = sc.next();
        System.out.println("Inserte el numero de cuenta:");
        String numeroCuenta = sc.next();
        
        String sql = "INSERT INTO titulares_cuentas VALUES ('"+ nif + "', '" + numeroCuenta  + "')";
        
        try{
            Statement sentencia = con.createStatement();
            sentencia.executeUpdate(sql);
             int filasAfectadas = sentencia.executeUpdate(sql);
        if (filasAfectadas > 0) {
            System.out.println("Se ha añadido el titular correctamente.");
        } else {
            System.out.println("ERROR: No se ha podido añadir el titular.");
        }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioPotencialDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR: Los datos son incorrectos");
        }
     }
     
     public void eliminarTitular() throws SQLException {
      Scanner sc = new Scanner(System.in);
      ConexionBD gc = new ConexionBD();
      Connection con = gc.getConexion();

        System.out.println("Escriba su NIF:");
        String nif = sc.next();
        System.out.println("Inserte el numero de cuenta:");
        String numeroCuenta = sc.next();

        String sql = "DELETE FROM titulares_cuentas WHERE NIF = ? AND numero_cuenta = ?";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, nif);
            preparedStatement.setString(2, numeroCuenta);
            preparedStatement.executeUpdate();
              int filasAfectadas = preparedStatement.executeUpdate();
        if (filasAfectadas > 0) {
            System.out.println("Se ha eliminado correctamente.");
        } else {
            System.out.println("ERROR: No se encontró el titular para eliminar.");
        }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioPotencialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
       

    

